package com.afengzi.website.domain.typeenum;


/**
 * <title>SiteTypeEnum</title>
 *
 * <project>website-collection</project>
 *
 * <package>com.afengzi.website.domain.typeenum</package>
 *
 * <file>SiteTypeEnum.java</file>
 *
 * <date>2014��6��9�� ����9:59:53</date>
 *
 * <brief></brief>
 *
 * @author klov
 *
 */
public enum SiteTypeEnum {

	TECHNOLOGY(1, "科技"), LIFE(2, "生活");
	private int value;
	private String name;

	private SiteTypeEnum(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static SiteTypeEnum fromValue(int value) {
		for (SiteTypeEnum type : values()) {
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
