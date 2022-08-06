package com.andreidodu.qm.console.commands;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.andreidodu.qm.console.constants.ConsoleConstants;
import com.andreidodu.qm.console.util.ConsoleUtil;
import com.andreidodu.qm.dto.input.QuestionnaireInsert;
import com.andreidodu.qm.service.QuestionnaireService;

@Component
public class CommandQuestionnaireList implements CommandQuestionnaire {

	private static final String COMMAND = "list";

	@Autowired
	private QuestionnaireService questionnaireService;

	@Override
	public String getCommand() {
		return COMMAND;
	}

	@Override
	public void execute(Map<Integer, String> commands) {
		System.out.println("==> Questionnaire list all");
		String languageCode = ConsoleUtil.processArgument(commands.get(ConsoleConstants.ARG0_COMMAND));
		List<QuestionnaireInsert> list = this.questionnaireService.getAll(languageCode);
		list.forEach(item -> {
			System.out.println(item);
		});
	}

}