package egovframework.com.sym.mnu.mpm.service.impl;

import java.util.Enumeration;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

import net.ecplaza.cmm.MenuNode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TreeNode Test
 * @author jhong
 * @since 2016.01.30
 */
public class TreeNodeTest {
	
	/**
	* logger
	*/
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());


	/**
	 * DefaultMutableTreeNode test
	 * @throws Exception
	 */
	@Test
	public void defaultMutableTreeNode() throws Exception {
//		MenuManageVO rootMenu = new MenuManageVO();
//		rootMenu.setMenuNo(0);
		
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("root");
//		rootNode.setUserObject(rootMenu);
		
//		DefaultMutableTreeNode node = new DefaultMutableTreeNode();
//		node.setParent(rootNode);
		
		DefaultMutableTreeNode top1 = new DefaultMutableTreeNode("사이트소개");
		DefaultMutableTreeNode top2 = new DefaultMutableTreeNode("민원광장");
		DefaultMutableTreeNode top3 = new DefaultMutableTreeNode("알림마당");
		DefaultMutableTreeNode top4 = new DefaultMutableTreeNode("정보마당");
		rootNode.add(top1);
		rootNode.add(top2);
		rootNode.add(top3);
		rootNode.add(top4);
		
		DefaultMutableTreeNode menu11 = new DefaultMutableTreeNode("사이트소개page");
		DefaultMutableTreeNode menu12 = new DefaultMutableTreeNode("연혁");
		DefaultMutableTreeNode menu13 = new DefaultMutableTreeNode("조직소개");
		DefaultMutableTreeNode menu14 = new DefaultMutableTreeNode("찾아오시는 길");
		top1.add(menu11);
		top1.add(menu12);
		top1.add(menu13);
		top1.add(menu14);
		
		LOGGER.debug("rootNode.getLeafCount()={}", rootNode.getLeafCount());
		
		TreeNode child0 = rootNode.getChildAt(0);
		LOGGER.debug("rootNode.getChildAt(0)={}", child0+", "+child0.getChildCount());
		LOGGER.debug("rootNode.getChildAfter(child0)={}", rootNode.getChildAfter(child0));

		this.traversal(rootNode);
	}
	
	/**
	 * tree traversal
	 * 
	 * @param node
	 * @throws Exception
	 */
	public void traversal(DefaultMutableTreeNode node) throws Exception {
		LOGGER.debug("traversal() start... node={}", node);
		
		Enumeration children = node.children();
		while (children.hasMoreElements()) {
			DefaultMutableTreeNode child = (DefaultMutableTreeNode)children.nextElement();
			LOGGER.debug("traversal()... child={}", child+", level="+child.getLevel()+", isLeaf="+child.isLeaf());
			
			if (!child.isLeaf()) this.traversal(child);
		}
	}
	
	/**
	 * MenuNode test
	 * @throws Exception
	 */
	@Test
	public void menuNodeTest() throws Exception {
		
		MenuNode rootNode = new MenuNode();
		rootNode.setMenuNm("root");
//		rootNode.setUserObject(rootMenu);
		
//		MenuNode node = new MenuNode();
//		node.setParent(rootNode);
		
		MenuNode top1 = new MenuNode();
		top1.setMenuNm("사이트소개");
		MenuNode top2 = new MenuNode();
		top2.setMenuNm("민원광장");
		MenuNode top3 = new MenuNode();
		top3.setMenuNm("알림마당");
		MenuNode top4 = new MenuNode();
		top4.setMenuNm("정보마당");
		rootNode.add(top1);
		rootNode.add(top2);
		rootNode.add(top3);
		rootNode.add(top4);
		
		MenuNode menu11 = new MenuNode();
		menu11.setMenuNm("사이트소개page");
		MenuNode menu12 = new MenuNode();
		menu12.setMenuNm("연혁");
		MenuNode menu13 = new MenuNode();
		menu13.setMenuNm("조직소개");
		MenuNode menu14 = new MenuNode();
		menu14.setMenuNm("찾아오시는 길");
		top1.add(menu11);
		top1.add(menu12);
		top1.add(menu13);
		top1.add(menu14);
		
		LOGGER.debug("rootNode.getLeafCount()={}", rootNode.getLeafCount());
		
		TreeNode child0 = rootNode.getChildAt(0);
		LOGGER.debug("rootNode.getChildAt(0)={}", child0+", "+child0.getChildCount());
		LOGGER.debug("rootNode.getChildAfter(child0)={}", rootNode.getChildAfter(child0));

		this.traversalMenu(rootNode);
		
		MenuNode result = this.findMenu(rootNode, "사이트소개");
		LOGGER.debug("findMenu() result={}", result);
	}
	
	/**
	 * MenuNode traversal
	 * 
	 * @param node
	 * @throws Exception
	 */
	public void traversalMenu(MenuNode node) throws Exception {
		LOGGER.debug("traversalMenu() start... node={}", node);
		
		Enumeration children = node.children();
		while (children.hasMoreElements()) {
			MenuNode child = (MenuNode)children.nextElement();
			LOGGER.debug("traversalMenu()... child={}", child.getMenuNm()+", level="+child.getLevel()+", isLeaf="+child.isLeaf());
			
			if (!child.isLeaf()) this.traversalMenu(child);
		}
	}

	/**
	 * MenuNode 검색
	 * 
	 * @param node
	 * @throws Exception
	 */
	public MenuNode findMenu(MenuNode node, String menuNm) throws Exception {
		LOGGER.debug("findMenu() start... menuNm={}", menuNm);
		
		MenuNode result = null;
		Enumeration children = node.children();
		while (children.hasMoreElements()) {
			MenuNode child = (MenuNode)children.nextElement();
			LOGGER.debug("findMenu()... child={}", child.getMenuNm()+", level="+child.getLevel()+", isLeaf="+child.isLeaf());
//			if (menuNo == child.getMenuNo()) {
			if (menuNm.equals(child.getMenuNm())) {
				result = child;
				break;
			}
			
			if (!child.isLeaf()) this.findMenu(child, menuNm);
		}
		
		return result;
	}

}
