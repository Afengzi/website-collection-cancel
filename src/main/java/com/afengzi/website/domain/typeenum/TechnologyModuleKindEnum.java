package com.afengzi.website.domain.typeenum;

/**
 *
 * <project>website-collection</project>
 *
 * <date>2014年6月9日 下午10:00:06</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public enum TechnologyModuleKindEnum {

	JAVA(1,"JAVA"),PYTHON(2,"PYTHON");

	private int value ;
	private String name ;
	private TechnologyModuleKindEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
