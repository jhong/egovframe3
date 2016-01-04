package egovframework.sample.emp.service.impl;

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

import egovframework.sample.emp.service.EmpVO;

/**
 * EmpMapper Test
 * @author jhong
 * @since 2016.01.04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EmpMapperTest {

	/**
	* logger
	*/
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	EmpMapper mapper;
	
	/**
	 * retrieveEmpList() test
	 * @throws Exception
	 */
	@Test
	public void retrieveEmpList() throws Exception {
		// parameters
		EmpVO empVO = new EmpVO();
//		empVO.setSearchCondition("1");
//		empVO.setSearchKeyword("COM");
		
		List result = mapper.retrieveEmpList(empVO);
		logger.debug("retrieveEmpList() result={}", result);
		assertThat(result, is(notNullValue()));
	}

	/**
	 * retrieveEmp() test
	 * @throws Exception
	 */
	@Test
	public void retrieveEmp() throws Exception {
		// parameters
		EmpVO empVO = new EmpVO();
		empVO.setEmpNo("EMPLOYEE-00000001");
		
		EmpVO result = mapper.retrieveEmp(empVO);
		logger.debug("retrieveEmp() result={}", result);
		assertThat(result, is(notNullValue()));
	}
}
