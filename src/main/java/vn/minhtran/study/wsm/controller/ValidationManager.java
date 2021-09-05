package vn.minhtran.study.wsm.controller;

import org.springframework.stereotype.Component;

import vn.minhtran.study.wsm.model.SuspectedFile;

@Component
public class ValidationManager {

	public boolean validate(SuspectedFile sf) {
		ValidationContext context = new ValidationContext();
		context.setSuspectedFile(sf);

		FileInspector oi = new ObsoleteInspector(context, null);
		FileInspector si = new OverSizeInspector(context, oi);
		FileInspector ii = new InitialInspector(context, si);

		return ii.validate();
	}
}
