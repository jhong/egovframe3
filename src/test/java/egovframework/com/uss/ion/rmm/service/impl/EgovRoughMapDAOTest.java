package egovframework.com.uss.ion.rmm.service.impl;

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

import egovframework.com.uss.ion.rmm.service.RoughMapDefaultVO;

/**
 * EgovRoughMapDAO Test
 * @author jhong
 * @since 2015.12.30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EgovRoughMapDAOTest {

	/**
	* logger
	*/
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	EgovRoughMapDAO dao;

	/**
	 * selectCmmnCodeList() test
	 * @throws Exception
	 */
	@Test
	public void selectRoughMapList() throws Exception {
		// parameters
		RoughMapDefaultVO searchVO = new RoughMapDefaultVO();
		
		List result = dao.selectRoughMapList(searchVO);
		logger.debug("selectCmmnCodeList() result={}", result);
		assertThat(result, is(notNullValue()));
	}

}
