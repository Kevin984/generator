package nl.hu.v1sad.rulegenerator.domain;

public class Operator {
	private String name;
	private String sign;
	
	public Operator(String name, String sign) {
		this.name = name;
		this.sign = sign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
}
