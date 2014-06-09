package com.afengzi.website.domain.typeenum;

/**
 * @author klov
 * ��վ����
 */
public enum SiteTypeEnum {

	TECHNOLOGY(1, "����"), LIFE(2, "����");
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
