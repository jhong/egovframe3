package egovframework.com.sym.ccm.cca.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * EgovCcmCmmnCodeManageService Test
 * @author jhong
 * @since 2016.01.05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//@ContextConfiguration( locations = { "classpath*:egovframeworktest/spring/com/**/context-*.xml" } )
//@ContextConfiguration( locations = { "file:src/main/webapp/WEB-INF/config/egovframework/springmvc/egov-com-servlet.xml" } )
@ContextConfiguration( locations = { "classpath:egovframeworktest/springmvc/egov-com-servlet.xml" } )
//@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
//@Transactional
public class EgovCcmCmmnCodeManageControllerTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	private MockHttpServletRequest request; 
//	private MockHttpServletResponse response; 
	
//	@Mock
//	private BindingResult mockBindingResult;
	
//	@Autowired
//	private RequestMappingHandlerAdapter handlerAdapter;
//	
//	@Autowired
//	private RequestMappingHandlerMapping handlerMapping;
	
//	@Autowired
//	private EgovCcmCmmnCodeManageController controller;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//		assertThat(controller, is(notNullValue()));
	}

	/**
	 * selectCmmnCodeList() test
	 * @throws Exception
	 */
	@Test
	public void selectCmmnCodeList() throws Exception{
		 this.mockMvc.perform(get("/"))
		 .andDo(print())
		 .andExpect(status().isOk());
//		 .andExpect(model().attributeExists("egovframework/com/sym/ccm/cca/EgovCcmCmmnCodeList"));
	}	
//	@Before
//	public void setUp() throws Exception {
////		request = new MockHttpServletRequest();
////		response = new MockHttpServletResponse();
//		
//		assertThat(controller, is(notNullValue()));
//	}

//	/**
//	 * selectCmmnCodeList() test
//	 * @throws Exception
//	 */
//	@Test
//	public void selectCmmnCodeList() throws Exception {
//		
//		// parameters
////		request.setRequestURI("/sym/ccm/cca/EgovCcmCmmnCodeList.do");
//		
////		ModelAndView mav = new AnnotationMethodHandlerAdapter().handle(request, response, controller);
////		assertThat(mav.getViewName(), is("egovframework/com/sym/ccm/cca/EgovCcmCmmnCodeList"));
//		
//		
//	}

}
