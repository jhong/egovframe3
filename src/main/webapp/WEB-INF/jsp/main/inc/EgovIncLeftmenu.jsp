<%--
  Class Name : EgovIncLeftmenu.jsp
  Description : 좌메뉴 화면(include)
  Modification Information
 
      수정일         수정자                   수정내용
    -------    --------    ---------------------------
     2011.08.31   JJY       경량환경 버전 생성
 
    author   : 실행환경개발팀 JJY
    since    : 2011.08.31 
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="java.util.Enumeration" %>
<%@ page import ="net.ecplaza.cmm.MenuNode" %>
<%@ page import ="net.ecplaza.cmm.SiteVO" %>

<script type="text/javascript" src="<c:url value="/js/EgovMainMenu.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery-1.11.1.js"/>"></script>
<script type="text/javascript">
<!--
/* ********************************************************
 * 상세내역조회 함수
 ******************************************************** */
function fn_MovePage(nodeNum) {
    //var nodeValues = treeNodes[nodeNum].split("|");
    var nodeValues;
    $(treeNodes).each(function(idx, elmt){
    	console.log("fn_MovePage() treeNodes... idx="+idx+", elmt="+elmt);
    	var elmtArr = elmt.split("|");
    	if (nodeNum === elmtArr[0]) {
    		nodeValues = elmtArr;
    		return;
    	}
    });
    console.log("fn_MovePage() nodeValues="+nodeValues);

    //parent.main_right.location.href = nodeValues[5];
    document.menuListForm.action = "${pageContext.request.contextPath}"+nodeValues[5];
    document.menuListForm.menuNo.value = nodeValues[0];
    //alert(document.menuListForm.action);
    document.menuListForm.submit();
}
//-->
</script>
<%!

/**
 * node 하위에 현재 메뉴가 있는지 조사
 */
boolean hasCurrentMenu(MenuNode node, String currentMenuNo) throws Exception {
	boolean  includeCurrentMenuNo = false;
	if (currentMenuNo == null) return includeCurrentMenuNo;
	
	// 1 depth
	if ((node.getMenuNo()+"").equals(currentMenuNo)) {
		includeCurrentMenuNo = true;
		return includeCurrentMenuNo;
	}
	
	// 2 depth
	Enumeration children = node.children();
	while (children.hasMoreElements()) {
		MenuNode child = (MenuNode)children.nextElement();
		if ((child.getMenuNo()+"").equals(currentMenuNo)) {
			includeCurrentMenuNo = true;
			break;
		}
		
		// 3 depth
		if (!child.isLeaf()) {
			Enumeration subnodes = child.children();
			while (subnodes.hasMoreElements()) {
				MenuNode subnode = (MenuNode)subnodes.nextElement();
				if ((subnode.getMenuNo()+"").equals(currentMenuNo)) {
					includeCurrentMenuNo = true;
					break;
				}
			}
		}
	}
	
	return includeCurrentMenuNo;
}


/**
 * 좌측메뉴 생성
 */
void renderLeftMenu(MenuNode node, StringBuffer sb, String currentMenuNo) throws Exception {
	//LOGGER.debug("renderLeftMenu() start... node={}", node);
	
	Enumeration children = node.children();
	while (children.hasMoreElements()) {
		MenuNode child = (MenuNode)children.nextElement();
		//sb.append("<br/>renderLeftMenu()... child="+child.getMenuNm()+", level="+child.getLevel()+", isLeaf="+child.isLeaf());
		if (child.getLevel() == 1 && !hasCurrentMenu(child, currentMenuNo)) continue;
		
		boolean isCurrentMenu = false;
		if (currentMenuNo != null && (child.getMenuNo()+"").equals(currentMenuNo)) isCurrentMenu = true;
		String currentBullet = isCurrentMenu ? ">> " : "";
		
		int level = child.getLevel();
		if (level == 1) {
			//sb.append("<div>"+child.getMenuNm()+"</div>");
			
		} else if (level == 2) {
			if (child.isLeaf())
				sb.append("<li class='leftmenu_dept01'><a href=\"javascript:fn_MovePage('"+child.getMenuNo()+"');\">"+currentBullet+child.getMenuNm()+"</a></li>");
			else
				sb.append("<li class='leftmenu_dept01'><a href='#'>"+child.getMenuNm()+"</a></li>");
			
		} else if (level == 3) {
			//sb.append("<div id=''>");
			sb.append("<li class='dept02'><a href=\"javascript:fn_MovePage('"+child.getMenuNo()+"');\">"+currentBullet+child.getMenuNm()+"</a></li>");
			//sb.append("</div>");
		}
		
		if (!child.isLeaf()) this.renderLeftMenu(child, sb, currentMenuNo);
	}
}

%>
<div class="left_wrap">
	<div class="top"><img src="<c:url value='/'/>images/title_image/img_menu_title01.gif" alt="서브메뉴" /></div>             
	<div class="nav_style" >
		<script type="text/javascript">
         var Tree = new Array;
         if(document.menuListForm.tmp_menuNm != null){
	         for (var j = 0; j < document.menuListForm.tmp_menuNm.length; j++) {
	             Tree[j] = document.menuListForm.tmp_menuNm[j].value;
	         }
         }
         var leftStartMenuValue = document.getElementById("menuNo").value;
         if (leftStartMenuValue==null || leftStartMenuValue=="" || leftStartMenuValue=="null") leftStartMenuValue = '1000000';
         createTree(Tree, true, leftStartMenuValue);
         </script>

<%
SiteVO siteVO = (SiteVO)request.getAttribute("siteVO");
String currentMenuNo = siteVO == null ? null : siteVO.getMenuNo();

MenuNode menuTree = (MenuNode)request.getAttribute("menuTree");
StringBuffer menuTreeStr = new StringBuffer();
renderLeftMenu(menuTree, menuTreeStr, currentMenuNo);
out.print(menuTreeStr.toString());
%>
	</div>	
</div>
