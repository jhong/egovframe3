package net.ecplaza.cmm;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class SiteVO {

	private String menuNo;
	private String designType;
	
	public String getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}
	public String getDesignType() {
		return designType;
	}
	public void setDesignType(String designType) {
		this.designType = designType;
	}
	
	/**
	 * toString
	 * @return String
	 */
    public String toString() {
    	return ToStringBuilder.reflectionToString(this);
    }

}
