package vn.minhtran.study.wsm.controller;

public abstract class AbstractInspector implements FileInspector {

	protected ValidationContext context;
	private FileInspector nextInspector;

	public boolean validate() {
		boolean valid = context.isValid();
		if (!valid) {
			return valid;
		}
		actualValidate();
		return nextInspector == null ? context.isValid()
		        : nextInspector.validate();
	}

	protected abstract void actualValidate();

	public AbstractInspector(ValidationContext context,
	        FileInspector nextInspector) {
		super();
		this.context = context;
		this.nextInspector = nextInspector;
	}

}
