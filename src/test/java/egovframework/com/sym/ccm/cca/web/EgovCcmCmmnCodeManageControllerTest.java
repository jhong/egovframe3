package egovframework.com.sym.ccm.cca.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
 * EgovCcmCmmnCodeManageService Test
 * @author jhong
 * @since 2016.01.05
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration( locations = { "classpath*:egovframeworktest/springmvc/egov-com-servlet.xml",
									"classpath*:egovframeworktest/spring/com/**/context-*.xml"} )
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EgovCcmCmmnCodeManageControllerTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).dispatchOptions(true).build();
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).alwaysExpect(forwardedUrl(null)).build();
	}

	/**
	 * deleteCmmnCode() test
	 * @throws Exception
	 */
	@Test
	public void deleteCmmnCode() throws Exception{
		 this.mockMvc.perform(post("/sym/ccm/cca/EgovCcmCmmnCodeRemove.do")
				 .param("codeId", "TST002"))
		 .andDo(print())
		 .andExpect(status().isOk())
		 .andExpect(model().attributeExists("cmmnCode"))
		 .andExpect(view().name("forward:/sym/ccm/cca/EgovCcmCmmnCodeList.do"))
		 .andExpect(forwardedUrl("/sym/ccm/cca/EgovCcmCmmnCodeList.do"));
	}	

	/**
	 * insertCmmnCode() test
	 * @throws Exception
	 */
	@Test
	public void insertCmmnCode() throws Exception{
		 this.mockMvc.perform(post("/sym/ccm/cca/EgovCcmCmmnCodeRegist.do")
				 .param("codeId", "TST002")
				 .param("codeIdNm", "이력구분 TEST")
				 .param("codeIdDc", "시스템이력등록구분 TEST")
				 .param("clCode", "EFC")
				 .param("useAt", "Y")
				 .param("lastUpdusrId", "tester"))
		 .andDo(print())
		 .andExpect(status().isOk())
		 .andExpect(model().attributeExists("cmmnCode"))
		 .andExpect(view().name("forward:/sym/ccm/cca/EgovCcmCmmnCodeList.do"))
		 .andExpect(forwardedUrl("/sym/ccm/cca/EgovCcmCmmnCodeList.do"));
	}	

	/**
	 * selectCmmnCodeDetail() test
	 * @throws Exception
	 */
	@Test
	public void selectCmmnCodeDetail() throws Exception{
		 this.mockMvc.perform(get("/sym/ccm/cca/EgovCcmCmmnCodeDetail.do").param("codeId", "COM002"))
		 .andDo(print())
		 .andExpect(status().isOk())
		 .andExpect(model().attributeExists("result"))
		 .andExpect(view().name("egovframework/com/sym/ccm/cca/EgovCcmCmmnCodeDetail"))
		 .andExpect(forwardedUrl("/WEB-INF/jsp/egovframework/com/sym/ccm/cca/EgovCcmCmmnCodeDetail.jsp"));
	}	

	/**
	 * selectCmmnCodeList() test
	 * @throws Exception
	 */
	@Test
	public void selectCmmnCodeList() throws Exception{
		 this.mockMvc.perform(get("/sym/ccm/cca/EgovCcmCmmnCodeList.do"))
		 .andDo(print())
		 .andExpect(status().isOk())
		 .andExpect(model().attributeExists("resultList"))
		 .andExpect(view().name("egovframework/com/sym/ccm/cca/EgovCcmCmmnCodeList"))
		 .andExpect(forwardedUrl("/WEB-INF/jsp/egovframework/com/sym/ccm/cca/EgovCcmCmmnCodeList.jsp"));
	}	

	/**
	 * updateCmmnCode() test
	 * @throws Exception
	 */
	@Test
	public void updateCmmnCode() throws Exception{
		 this.mockMvc.perform(post("/sym/ccm/cca/EgovCcmCmmnCodeModify.do")
				 .param("cmd", "Modify")
				 .param("codeId", "COM002")
				 .param("codeIdNm", "이력구분 A")
				 .param("codeIdDc", "시스템이력등록구분 B")
				 .param("clCode", "EFC")
				 .param("useAt", "Y")
				 .param("lastUpdusrId", "tester"))
		 .andDo(print())
		 .andExpect(status().isOk())
		 .andExpect(model().attributeExists("cmmnCode"))
		 .andExpect(view().name("forward:/sym/ccm/cca/EgovCcmCmmnCodeList.do"))
		 .andExpect(forwardedUrl("/sym/ccm/cca/EgovCcmCmmnCodeList.do"));
	}	

}
