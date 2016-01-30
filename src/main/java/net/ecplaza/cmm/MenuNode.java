package net.ecplaza.cmm;

import javax.swing.tree.DefaultMutableTreeNode;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class MenuNode extends DefaultMutableTreeNode {

	/** 메뉴정보 */
	/** 메뉴번호 */
	private	int		menuNo;
	/** 메뉴순서 */
	private	int		menuOrdr;
	/** 메뉴명 */
	private	String	menuNm;
	/** 상위메뉴번호 */
	private	int		upperMenuNo;
	/** 메뉴설명 */
	private	String	menuDc;
	/** 관련이미지경로 */
	private	String	relateImagePath;
	/** 관련이미지명 */
	private	String	relateImageNm;
	/** 프로그램파일명 */
	private	String	progrmFileNm;

	/** 권한정보설정 */
	/** 권한코드 */
	private	String	authorCode;

	
	/**
	 * menuNo attribute를 리턴한다.
	 * @return int
	 */
	public int getMenuNo() {
		return menuNo;
	}
	/**
	 * menuNo attribute 값을 설정한다.
	 * @param menuNo int
	 */
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	/**
	 * menuOrdr attribute를 리턴한다.
	 * @return int
	 */
	public int getMenuOrdr() {
		return menuOrdr;
	}
	/**
	 * menuOrdr attribute 값을 설정한다.
	 * @param menuOrdr int
	 */
	public void setMenuOrdr(int menuOrdr) {
		this.menuOrdr = menuOrdr;
	}
	/**
	 * menuNm attribute를 리턴한다.
	 * @return String
	 */
	public String getMenuNm() {
		return menuNm;
	}
	/**
	 * menuNm attribute 값을 설정한다.
	 * @param menuNm String
	 */
	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}
	/**
	 * upperMenuNo attribute를 리턴한다.
	 * @return int
	 */
	public int getUpperMenuNo() {
		return upperMenuNo;
	}
	/**
	 * upperMenuNo attribute 값을 설정한다.
	 * @param upperMenuNo int
	 */
	public void setUpperMenuNo(int upperMenuNo) {
		this.upperMenuNo = upperMenuNo;
	}
	/**
	 * menuDc attribute를 리턴한다.
	 * @return String
	 */
	public String getMenuDc() {
		return menuDc;
	}
	/**
	 * menuDc attribute 값을 설정한다.
	 * @param menuDc String
	 */
	public void setMenuDc(String menuDc) {
		this.menuDc = menuDc;
	}
	/**
	 * relateImagePath attribute를 리턴한다.
	 * @return String
	 */
	public String getRelateImagePath() {
		return relateImagePath;
	}
	/**
	 * relateImagePath attribute 값을 설정한다.
	 * @param relateImagePath String
	 */
	public void setRelateImagePath(String relateImagePath) {
		this.relateImagePath = relateImagePath;
	}
	/**
	 * relateImageNm attribute를 리턴한다.
	 * @return String
	 */
	public String getRelateImageNm() {
		return relateImageNm;
	}
	/**
	 * relateImageNm attribute 값을 설정한다.
	 * @param relateImageNm String
	 */
	public void setRelateImageNm(String relateImageNm) {
		this.relateImageNm = relateImageNm;
	}
	/**
	 * progrmFileNm attribute를 리턴한다.
	 * @return String
	 */
	public String getProgrmFileNm() {
		return progrmFileNm;
	}
	/**
	 * progrmFileNm attribute 값을 설정한다.
	 * @param progrmFileNm String
	 */
	public void setProgrmFileNm(String progrmFileNm) {
		this.progrmFileNm = progrmFileNm;
	}
	/**
	 * authorCode attribute를 리턴한다.
	 * @return String
	 */
	public String getAuthorCode() {
		return authorCode;
	}
	/**
	 * authorCode attribute 값을 설정한다.
	 * @param authorCode String
	 */
	public void setAuthorCode(String authorCode) {
		this.authorCode = authorCode;
	}
	
	/**
	 * toString
	 * @return String
	 */
	 public String toString() {
	 	return ToStringBuilder.reflectionToString(this);
	 }

}
