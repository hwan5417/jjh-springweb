package com.jjh.letter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LetterController {
	
	@Autowired
	LetterDao letterDao;
	
	static final Logger logger = LogManager.getLogger();
}
