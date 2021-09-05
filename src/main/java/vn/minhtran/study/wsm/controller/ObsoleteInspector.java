package vn.minhtran.study.wsm.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObsoleteInspector extends AbstractInspector
        implements FileInspector {

	public ObsoleteInspector(ValidationContext context,
	        FileInspector nextInspector) {
		super(context, nextInspector);
	}

	@Override
	protected void actualValidate() {
		log.info("Obsolete inspector is working...");
	}

}
