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
		return "/article/addForm";
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
		Article article = articleDao.getArticle(articleId);
		model.addAttribute("article",article);
	}
	
	@GetMapping("/article/list")
	public void articleList(
			@RequestParam(value = "page", defaultValue = "1") int page,
			Model model) {

		// 페이지당 행의 수와 페이지의 시작점
		final int COUNT = 100;
		int offset = (page - 1) * COUNT;

		List<Article> articleList = articleDao.selectAll(offset, COUNT);
		int totalCount = articleDao.countAll();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articleList", articleList);
}
	
	/**
	 * 글 수정 화면
	 */
	@GetMapping("/article/updateForm")
	public void updateForm(@RequestParam("articleId") String articleId,
			@SessionAttribute("MEMBER") Member member, Model model) {
		Article article = articleDao.getArticle(articleId);
		logger.debug("member.getMemberId()={}, article.getUserId()={}", member.getMemberId(), article.getUserId());
		// 권한 체크 : 세션의 memberId와 글의 userId를 비교
		if (!member.getMemberId().equals(article.getUserId()))
			// 자신의 글이 아니면
			throw new RuntimeException("No Authority!");

		model.addAttribute("article", article);
	}

	/**
	 * 글 수정
	 */
	@PostMapping("/article/update")
	public String update(Article article,
			@SessionAttribute("MEMBER") Member member) {
		article.setUserId(member.getMemberId());
		int updatedRows = articleDao.updateArticle(article);
		
		// 권한 체크 : 글이 수정되었는지 확인
		if (updatedRows == 0)
			// 글이 수정되지 않음. 자신이 쓴 글이 아님
			throw new RuntimeException("No Authority!");

		return "redirect:/app/article/view?articleId=" + article.getArticleId();
	}

	/**
	 * 글 삭제
	 */
	@GetMapping("/article/delete")
	public String delete(@RequestParam("articleId") String articleId,
			@SessionAttribute("MEMBER") Member member) {
		int updatedRows = articleDao.deleteArticle(articleId,
				member.getMemberId());

		// 권한 체크 : 글이 삭제되었는지 확인
		if (updatedRows == 0)
			// 글이 삭제되지 않음. 자신이 쓴 글이 아님
			throw new RuntimeException("No Authority!");

		logger.debug("글을 삭제했습니다. articleId={}", articleId);
		return "redirect:/app/article/list";
	}
}