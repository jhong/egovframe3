package egovframework.com.cmm.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * EgovComIndexController Test
 * @author jhong
 * @since 2016.01.09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations = { "classpath*:egovframeworktest/springmvc/egov-com-servlet.xml",
									"classpath*:egovframeworktest/spring/com/**/context-*.xml"} )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EgovComIndexControllerTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	/**
	 * index() test
	 * @throws Exception
	 */
	@Test
	public void index() throws Exception{
		 this.mockMvc.perform(get("/indexDev.do"))
		 .andDo(print())
		 .andExpect(status().isOk())
//		 .andExpect(model().attributeExists("result"))
		 .andExpect(view().name("egovframework/com/cmm/EgovUnitMain"))
		 .andExpect(forwardedUrl("/WEB-INF/jsp/egovframework/com/cmm/EgovUnitMain.jsp"));
	}	

}
