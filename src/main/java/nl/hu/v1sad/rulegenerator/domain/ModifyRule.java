package nl.hu.v1sad.rulegenerator.domain;

public class ModifyRule extends BusinessRuleType {
	private String customCode;
	
	public ModifyRule(String customCode) {
		super("ModifyRule", "MODI", "Modify Rule Description.", null);
		this.customCode = customCode;
	}
	
	public ModifyRule() {
		this(null);
	}
	
	public String getCustomCode() {
		return customCode;
	}
	
	public void setCustomCode(String customCode) {
		this.customCode = customCode;
	}

	@Override
	public String fillTemplate(String template, BusinessRule br) {
		template = template.replaceAll("<code>", br.getRuleType().getCode());
		template = template.replaceAll("<error>", br.getErrorMessage());
		template = template.replaceAll("<target_table>", br.getRuleType().getCode());
		template = template.replaceAll("<code>", br.getRuleType().getCode());

		return template;
	}


}
