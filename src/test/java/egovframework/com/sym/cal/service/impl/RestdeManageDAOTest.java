package egovframework.com.sym.cal.service.impl;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import egovframework.com.sym.cal.service.RestdeVO;

/**
 * RestdeManageDAO Test
 * @author jhong
 * @since 2016.01.09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class RestdeManageDAOTest {

	/**
	* logger
	*/
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	RestdeManageDAO dao;

	/**
	 * selectRestdeList() test
	 * @throws Exception
	 */
	@Test
	public void selectRestdeList() throws Exception {
		// parameters
		RestdeVO searchVO = new RestdeVO();
//		searchVO.setSearchCondition("1");
//		searchVO.setSearchKeyword("COM");
		
		List result = dao.selectRestdeList(searchVO);
		logger.debug("selectRestdeList() result={}", result);
		assertThat(result, is(notNullValue()));
	}

}
