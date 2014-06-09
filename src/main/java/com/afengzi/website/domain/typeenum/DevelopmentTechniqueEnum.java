package com.afengzi.website.domain.typeenum;

/**
 * <title>DevelopmentTechniqueEnum</title>
 *
 * <project>website-collection</project>
 *
 * <package>com.afengzi.website.domain.typeenum</package>
 *
 * <file>DevelopmentTechniqueEnum.java</file>
 *
 * <date>2014��6��9�� ����10:00:06</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public enum DevelopmentTechniqueEnum {

	JAVA(1,"JAVA"),PYTHON(2,"PYTHON") ;
	private int value ;
	private String name ;
	private DevelopmentTechniqueEnum(int value, String name) {
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
