package cn.starteasy.core.common.utils;


/**
 * 搜索枚举
 * @author xjli
 *
 */
public enum SearchEnum {

	eq("eq", "="), ne("ne", "!="), lt("lt", "<"), le("le", "<="), gt("gt", ">"), ge(
			"ge", ">="),lk("lk","like"),alk("alk","like"),in("in","in");

	private String code;

	private String des;

	private SearchEnum(String code, String des) {
		this.code = code;
		this.des = des;
	}

	/**
	 * 
	 * @param code
	 * @return
	 */

	public static SearchEnum codeOf(String code) {
		for (SearchEnum searchEnum : SearchEnum.values()) {
			if (searchEnum.getCode().equals(code)) {
				return searchEnum;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param name
	 * @return
	 */
	public static SearchEnum nameOf(String name) {
		for (SearchEnum searchEnum : SearchEnum.values()) {
			if (searchEnum.getCode().equals(name)) {
				return searchEnum;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

}
