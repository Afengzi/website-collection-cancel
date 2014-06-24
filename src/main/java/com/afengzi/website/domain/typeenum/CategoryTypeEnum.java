package com.afengzi.website.domain.typeenum;


/**
 * <title>CategoryTypeEnum</title>
 *
 * <project>website-collection</project>
 *
 * <package>com.afengzi.website.domain.typeenum</package>
 *
 * <file>CategoryTypeEnum.java</file>
 *
 * <date>2014年6月9日 下午9:59:53</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public enum CategoryTypeEnum {

	TECHNOLOGY(1, "技术"), LIFE(2, "生活");
	private int value;
	private String name;

	private CategoryTypeEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static CategoryTypeEnum fromValue(int value) {
		for (CategoryTypeEnum type : values()) {
			if (type.value == value) {
				return type;
			}
		}
		return null;
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
