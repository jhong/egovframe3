package egovframework.com.sym.mnu.mpm.service.impl;

import java.util.List;

import net.ecplaza.cmm.MenuNode;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.sym.mnu.mpm.service.EgovMenuManageService;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;

/**
 * EgovMenuManageService Test
 * @author jhong
 * @since 2016.01.30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EgovMenuManageServiceTest {

	/**
	* logger
	*/
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	EgovMenuManageService service;

	/**
	 * selectMainMenuHeadByAuthor() test
	 * @throws Exception
	 */
	@Test
	public void selectMainMenuHeadByAuthor() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setAuthorCode("ROLE_ANONYMOUS");
		
		List result = service.selectMainMenuHeadByAuthor(vo);
		LOGGER.debug("selectMainMenuHeadByAuthor() result={}", result);
	}
	
	/**
	 * selectMainMenuHeadByAuthor() test
	 * @throws Exception
	 */
	@Test
	public void selectMainMenuLeftByAuthor() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setAuthorCode("ROLE_ANONYMOUS");
		
		List result = service.selectMainMenuLeftByAuthor(vo);
		LOGGER.debug("selectMainMenuLeftByAuthor() result={}", result);
	}

	/**
	 * selectMainMenuAllByAuthor() test
	 * @throws Exception
	 */
	@Test
	public void selectMainMenuAllByAuthor() throws Exception {
		// parameters
		MenuManageVO vo = new MenuManageVO();
		vo.setAuthorCode("ROLE_ANONYMOUS");
//		vo.setAuthorCode("ROLE_ADMIN");
		
		List menuList = service.selectMainMenuAllByAuthor(vo);
		LOGGER.debug("selectMainMenuAllByAuthor() menuList={}", menuList);
		
		MenuNode menu = service.makeMenuNode(menuList);
		LOGGER.debug("makeMenuNode() menu.getChildCount()={}", menu.getChildCount());
	}
	
}
