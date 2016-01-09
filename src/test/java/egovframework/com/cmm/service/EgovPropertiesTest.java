package egovframework.com.cmm.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * EgovProperties Test
 * @author jhong
 * @since 2016.01.09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EgovPropertiesTest {

	/**
	* logger
	*/
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * getProperty() test
	 * @throws Exception
	 */
	@Test
	public void getProperty() throws Exception {
		logger.debug("EgovProperties.GLOBALS_PROPERTIES_FILE={}", EgovProperties.GLOBALS_PROPERTIES_FILE);
		logger.debug("EgovProperties.RELATIVE_PATH_PREFIX={}", EgovProperties.RELATIVE_PATH_PREFIX);
		
		String uploadDir = EgovProperties.getProperty("Globals.fileStorePath");
		logger.debug("getProperty() uploadDir={}", uploadDir);
	}
}
