package com.sample.texteditapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.texteditapp.dto.Command;
import com.sample.texteditapp.dto.Output;
import com.sample.texteditapp.service.AppService;

@Controller
@RequestMapping("/web/v1/texteditapp")
public class WebController {

	private static final Logger LOGGER = LogManager.getLogger(WebController.class);

	@Autowired
	AppService appservice;

	@GetMapping("/home")
	public ModelAndView home() {

		ModelAndView mv = new ModelAndView();

		Output output = null;
		try {

			mv.addObject("output", "  ");

			// template name
			mv.setViewName("chat");

			return mv;
		} finally {
			LOGGER.info("return: {} ", mv);
		}

	}

	@PostMapping("/edits")
	public ModelAndView createEdits(@RequestBody Command command) {
		LOGGER.info("Parameters: {} ", command);
		ModelAndView mv = new ModelAndView();

		Output output = null;
		try {
			if (command != null && command.getInput() != null) {
				output = appservice.processEdits(command);

				mv.addObject("output", output.getText());
			} else {
				mv.addObject("output", " Hi ");
			}

			// template name
			mv.setViewName("chat");

			return mv;
		} finally {
			LOGGER.info("return: {} ", output);
		}

	}

}
