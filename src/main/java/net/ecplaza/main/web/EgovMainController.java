package net.ecplaza.main.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.ecplaza.cmm.MenuNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cop.bbs.service.BoardVO;
import egovframework.com.cop.bbs.service.EgovBBSManageService;
import egovframework.com.sym.mnu.mpm.service.EgovMenuManageService;
import egovframework.com.sym.mnu.mpm.service.MenuManageVO;
import egovframework.com.uss.olh.faq.service.EgovFaqManageService;
import egovframework.com.uss.olh.faq.service.FaqManageDefaultVO;
import egovframework.rte.fdl.security.userdetails.util.EgovUserDetailsHelper;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * 템플릿 메인 페이지 컨트롤러 클래스(Sample 소스)
 * @author 실행환경 개발팀 JJY
 * @since 2011.08.31
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.31  JJY            최초 생성
 *
 * </pre>
 */
@Controller@SessionAttributes(types = ComDefaultVO.class)
public class EgovMainController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovMainController.class);
	
	/**
	 * EgovBBSManageService
	 */
	@Resource(name = "EgovBBSManageService")
    private EgovBBSManageService bbsMngService;

	/** EgovMenuManageService */
	@Resource(name = "meunManageService")
    private EgovMenuManageService menuManageService;

	/** FaqManageService */
	@Resource(name = "FaqManageService")
    private EgovFaqManageService faqManageService;

//	/** egovQustnrRespondInfoService */
//	@Resource(name = "egovQustnrRespondInfoService")
//	private EgovQustnrRespondInfoService egovQustnrRespondInfoService;

	/**
	 * 메인 페이지에서 각 업무 화면으로 연계하는 기능을 제공한다.
	 *
	 * @param request
	 * @param commandMap
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/cmm/forwardPage.do")
	public String forwardPageWithMenuNo(HttpServletRequest request, @RequestParam Map<String, Object> commandMap)
	  throws Exception{
		return "";
	}

	/**
	 * 템플릿 메인 페이지 조회
	 * @return 메인페이지 정보 Map [key : 항목명]
	 *
	 * @param request
	 * @param model
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/cmm/main/mainPage.do")
//	@RequestMapping(value = "/index.do")
	public String getMgtMainPage(HttpServletRequest request, ModelMap model)
	  throws Exception{

		// 공지사항 메인 컨텐츠 조회 시작 ---------------------------------
		BoardVO boardVO = new BoardVO();
		boardVO.setPageUnit(5);
		boardVO.setPageSize(10);
		boardVO.setBbsId("BBSMSTR_AAAAAAAAAAAA");

		PaginationInfo paginationInfo = new PaginationInfo();

		paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
		paginationInfo.setPageSize(boardVO.getPageSize());

		boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
		boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		Map<String, Object> map = bbsMngService.selectBoardArticles(boardVO, "BBSA02");
		model.addAttribute("notiList", map.get("resultList"));


		// 공지사항 메인컨텐츠 조회 끝 -----------------------------------

		// 자유게시판 메인 컨텐츠 조회 시작 ---------------------------------
		boardVO.setPageUnit(9);
		boardVO.setPageSize(10);
		boardVO.setBbsId("BBSMSTR_BBBBBBBBBBBB");

		paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
		paginationInfo.setPageSize(boardVO.getPageSize());

		boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
		boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		model.addAttribute("bbsList", bbsMngService.selectBoardArticles(boardVO, "BBSA02").get("resultList"));

		// 자유게시판 메인컨텐츠 조회 끝 -----------------------------------



		// FAQ 메인 컨텐츠 조회 시작 ---------------------------------
		/** EgovPropertyService.SiteList */
		FaqManageDefaultVO searchVO = new FaqManageDefaultVO();
		searchVO.setPageUnit(3);
    	searchVO.setPageSize(10);

    	/** pageing */
    	paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        model.addAttribute("faqList", faqManageService.selectFaqList(searchVO));

		// FAQ 메인 컨텐츠 조회 끝 -----------------------------------
//
//        // 설문참여 메인 컨텐츠 조회 시작 -----------------------------------
//        ComDefaultVO qVO = new ComDefaultVO();
//    	qVO.setPageUnit(1);
//    	qVO.setPageSize(10);
//
//    	/** pageing */
//		paginationInfo.setCurrentPageNo(qVO.getPageIndex());
//		paginationInfo.setRecordCountPerPage(qVO.getPageUnit());
//		paginationInfo.setPageSize(qVO.getPageSize());
//
//		qVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
//		qVO.setLastIndex(paginationInfo.getLastRecordIndex());
//		qVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
//
//        model.addAttribute("qriList", egovQustnrRespondInfoService.selectQustnrRespondInfoManageList(qVO));
//
//     // 설문참여 메인 컨텐츠 조회 끝 -----------------------------------


		return "main/EgovMainView";
//		return "egovframework/com/EgovMainView";
	}

	/**
     * Head메뉴를 조회한다.
     * @param menuManageVO MenuManageVO
     * @return 출력페이지정보 "main_headG", "main_head"
     * @exception Exception
     */
    @RequestMapping(value="/sym/mms/EgovMainMenuHead.do")
    public String selectMainMenuHead(
    		@ModelAttribute("menuManageVO") MenuManageVO menuManageVO,
    		@RequestParam(value="flag", required=false) String flag,
    		ModelMap model)
            throws Exception {

    	LoginVO user =
    		EgovUserDetailsHelper.isAuthenticated()? (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser():null;
    	LOGGER.debug("selectMainMenuHead() user={}", user);
    		
    	if(EgovUserDetailsHelper.isAuthenticated() && user!=null){
    		menuManageVO.setTmpId(user.getId());
        	menuManageVO.setTmpPassword(user.getPassword());
        	menuManageVO.setTmpUserSe(user.getUserSe());
        	menuManageVO.setTmpName(user.getName());
        	menuManageVO.setTmpEmail(user.getEmail());
        	menuManageVO.setTmpOrgnztId(user.getOrgnztId());
        	menuManageVO.setTmpUniqId(user.getUniqId());
    		model.addAttribute("list_headmenu", menuManageService.selectMainMenuHead(menuManageVO));
    		model.addAttribute("list_menulist", menuManageService.selectMainMenuLeft(menuManageVO));
    	}else{
    		menuManageVO.setAuthorCode("ROLE_ANONYMOUS");
    		model.addAttribute("list_headmenu", menuManageService.selectMainMenuHeadByAuthor(menuManageVO));
    		model.addAttribute("list_menulist", menuManageService.selectMainMenuLeftByAuthor(menuManageVO));
    	}

    	if(flag==null){
    		return "main/inc/EgovIncSubHeader"; // 업무화면의 상단메뉴 화면
    	}else if(flag.equals("MAIN")){
    		return "main/inc/EgovIncHeader"; // 메인화면의 상단메뉴 화면
    	}else{
    		return "main/inc/EgovIncSubHeader"; // 업무화면의 상단메뉴 화면
    	}
    }

    /**
     * 좌측메뉴를 조회한다.
     * @param menuManageVO MenuManageVO
     * @param vStartP      String
     * @return 출력페이지정보 "main_left"
     * @exception Exception
     */
    @RequestMapping(value="/sym/mms/EgovMainMenuLeft.do")
    public String selectMainMenuLeft(
    		@ModelAttribute("menuManageVO") MenuManageVO menuManageVO,
    		ModelMap model)
            throws Exception {

    	//LoginVO user = EgovUserDetailsHelper.isAuthenticated()? (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser():null;
    	//LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	LoginVO user =
        		EgovUserDetailsHelper.isAuthenticated()? (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser():null;
        	LOGGER.debug("selectMainMenuLeft() user={}", user);
        		
        	if(EgovUserDetailsHelper.isAuthenticated() && user!=null){
        		menuManageVO.setTmpId(user.getId());
            	menuManageVO.setTmpPassword(user.getPassword());
            	menuManageVO.setTmpUserSe(user.getUserSe());
            	menuManageVO.setTmpName(user.getName());
            	menuManageVO.setTmpEmail(user.getEmail());
            	menuManageVO.setTmpOrgnztId(user.getOrgnztId());
            	menuManageVO.setTmpUniqId(user.getUniqId());
        	}else{
        		menuManageVO.setAuthorCode("ROLE_ANONYMOUS");
        	}

    		List menuList = menuManageService.selectMainMenuAllByAuthor(menuManageVO);
    		MenuNode menuTree = menuManageService.makeMenuNode(menuList);
    		LOGGER.debug("selectMainMenuLeft() menuTrtee={}", menuTree);
    		model.addAttribute("menuTree", menuTree);

    	if(EgovUserDetailsHelper.isAuthenticated()){
    		//인증된 경우 처리할 사항 추가 ...
    		
//    		model.addAttribute("lastLogoutDateTime", "로그아웃 타임: 2011-11-10 11:30");
    		//최근 로그아웃 시간 등에 대한 확보 후 메인 컨텐츠로 활용
    	}

      	return "main/inc/EgovIncLeftmenu";
    }

}