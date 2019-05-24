package com.jjh.article_jjh;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jjh.book.chap11.Member;

@Controller
public class ArticleController {

	@Autowired
	ArticleDao articleDao;

	static final Logger logger = LogManager.getLogger();

	@RequestMapping("/main1")
	public String main() {
		return "main1";
	}
	 
	//글쓰기 단계
	@GetMapping("/article/addForm")
	public String Step1(HttpSession session) {
		return "/article/addFormS";
	}

	@PostMapping("/article/add")
	public String Step2(Article article, 
			@SessionAttribute("MEMBER") Member member) {
		article.setUserId(member.getMemberId());
		article.setName(member.getName());
		articleDao.write(article);
		return "redirect:/app/article/list";
	}
	
	@GetMapping("/article/view")
	public void Step3(
			@RequestParam("articleId") String articleId, Model model) {
		Article article = articleDao.search(articleId);
		model.addAttribute("article",article);
	}
	
	@GetMapping("/article/list")
	public String articles(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {
		// 페이지 당 가져오는 행의 수 (내림차순 100개)
		final int COUNT = 100;
		// 시작점
		int offset = (page - 1) * COUNT;
		List<Article> articleList = articleDao.selectAll(offset, COUNT);
		int totalCount = articleDao.countAll();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articles", articleList);
		return "/article/list";
	}
	
	@PostMapping("/article/update")
	public String update(Article article, 
			@SessionAttribute("MEMBER") Member member) {
		article.setUserId(member.getMemberId());
		article.setName(member.getName());
		articleDao.write(article);
		return "redirect:/app/article/update";
	}
	
	@GetMapping("/article/delete")
	public void delete(
			@RequestParam("articleId") String articleId, Model model) {
		Article article = articleDao.search(articleId);
		model.addAttribute("article",article);
	}
}