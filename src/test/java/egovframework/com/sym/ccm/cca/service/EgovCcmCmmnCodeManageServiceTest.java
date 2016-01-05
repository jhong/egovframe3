package egovframework.com.sym.ccm.cca.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * EgovCcmCmmnCodeManageService Test
 * @author jhong
 * @since 2016.01.05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EgovCcmCmmnCodeManageServiceTest {

	/**
	* logger
	*/
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	EgovCcmCmmnCodeManageService service;

	/**
	 * deleteCmmnCode() test
	 * @throws Exception
	 */
	@Test
	public void deleteCmmnCode() throws Exception {
		// parameters
		CmmnCode cmmnCode = new CmmnCode();
		cmmnCode.setCodeId("XXX");
		
		service.deleteCmmnCode(cmmnCode);
	}

	/**
	 * insertCmmnCode() test
	 * @throws Exception
	 */
	@Test
	public void insertCmmnCode() throws Exception {
		// parameters
		CmmnCode cmmnCode = new CmmnCode();
		cmmnCode.setCodeId("XXX");
//		cmmnCode.setCodeIdNm("");
//		cmmnCode.setCodeIdDc("");
		
		service.insertCmmnCode(cmmnCode);
	}

	/**
	 * selectCmmnCodeDetail() test
	 * @throws Exception
	 */
	@Test
	public void selectCmmnCodeDetail() throws Exception {
		// parameters
		CmmnCode cmmnCode = new CmmnCode();
		cmmnCode.setCodeId("COM002");
//		cmmnCode.setCodeIdNm("");
//		cmmnCode.setCodeIdDc("");
		
		CmmnCode result = service.selectCmmnCodeDetail(cmmnCode);
		logger.debug("selectCmmnCodeDetail() result={}", ToStringBuilder.reflectionToString(result));
	}

	/**
	 * selectCmmnCodeList() test
	 * @throws Exception
	 */
	@Test
	public void selectCmmnCodeList() throws Exception {
		// parameters
		CmmnCodeVO searchVO = new CmmnCodeVO();
		searchVO.setSearchCondition("1");
		searchVO.setSearchKeyword("COM");
		
		List result = service.selectCmmnCodeList(searchVO);
		logger.debug("selectCmmnCodeList() result={}", result);
		assertThat(result, is(notNullValue()));
	}

	/**
	 * selectCmmnCodeListTotCnt() test
	 * @throws Exception
	 */
	@Test
	public void selectCmmnCodeListTotCnt() throws Exception {
		// parameters
		CmmnCodeVO searchVO = new CmmnCodeVO();
		searchVO.setSearchCondition("2");
		searchVO.setSearchKeyword("구분");
		
		int result = service.selectCmmnCodeListTotCnt(searchVO);
		logger.debug("selectCmmnCodeListTotCnt() result={}", result);
		assertThat(result, greaterThan(0));
	}

	/**
	 * updateCmmnCode() test
	 * @throws Exception
	 */
	@Test
	public void updateCmmnCode() throws Exception {
		// parameters
		CmmnCode cmmnCode = new CmmnCode();
		cmmnCode.setCodeId("XXX");
//		cmmnCode.setCodeIdNm("");
//		cmmnCode.setCodeIdDc("");
		
		service.updateCmmnCode(cmmnCode);
	}

}
