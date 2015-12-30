package net.ecplaza.sym.ccm.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import net.ecplaza.sym.ccm.service.ComtccmmncodeService;
import net.ecplaza.sym.ccm.service.ComtccmmncodeDefaultVO;
import net.ecplaza.sym.ccm.service.ComtccmmncodeVO;

/**
 * @Class Name : ComtccmmncodeController.java
 * @Description : Comtccmmncode Controller class
 * @Modification Information
 *
 * @author jhong
 * @since 2015.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=ComtccmmncodeVO.class)
public class ComtccmmncodeController {

    @Resource(name = "comtccmmncodeService")
    private ComtccmmncodeService comtccmmncodeService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * COMTCCMMNCODE 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 ComtccmmncodeDefaultVO
	 * @return "/comtccmmncode/ComtccmmncodeList"
	 * @exception Exception
	 */
    @RequestMapping(value="/comtccmmncode/ComtccmmncodeList.do")
    public String selectComtccmmncodeList(@ModelAttribute("searchVO") ComtccmmncodeDefaultVO searchVO, 
    		ModelMap model)
            throws Exception {
    	
    	/** EgovPropertyService.sample */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));
    	
    	/** pageing */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());
		
		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
        List<?> comtccmmncodeList = comtccmmncodeService.selectComtccmmncodeList(searchVO);
        model.addAttribute("resultList", comtccmmncodeList);
        
        int totCnt = comtccmmncodeService.selectComtccmmncodeListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/comtccmmncode/ComtccmmncodeList";
    } 
    
    @RequestMapping("/comtccmmncode/addComtccmmncodeView.do")
    public String addComtccmmncodeView(
            @ModelAttribute("searchVO") ComtccmmncodeDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("comtccmmncodeVO", new ComtccmmncodeVO());
        return "/comtccmmncode/ComtccmmncodeRegister";
    }
    
    @RequestMapping("/comtccmmncode/addComtccmmncode.do")
    public String addComtccmmncode(
            ComtccmmncodeVO comtccmmncodeVO,
            @ModelAttribute("searchVO") ComtccmmncodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        comtccmmncodeService.insertComtccmmncode(comtccmmncodeVO);
        status.setComplete();
        return "forward:/comtccmmncode/ComtccmmncodeList.do";
    }
    
    @RequestMapping("/comtccmmncode/updateComtccmmncodeView.do")
    public String updateComtccmmncodeView(
            @RequestParam("codeId") java.lang.String codeId ,
            @ModelAttribute("searchVO") ComtccmmncodeDefaultVO searchVO, Model model)
            throws Exception {
        ComtccmmncodeVO comtccmmncodeVO = new ComtccmmncodeVO();
        comtccmmncodeVO.setCodeId(codeId);
        // 변수명은 CoC 에 따라 comtccmmncodeVO
        model.addAttribute(selectComtccmmncode(comtccmmncodeVO, searchVO));
        return "/comtccmmncode/ComtccmmncodeRegister";
    }

    @RequestMapping("/comtccmmncode/selectComtccmmncode.do")
    public @ModelAttribute("comtccmmncodeVO")
    ComtccmmncodeVO selectComtccmmncode(
            ComtccmmncodeVO comtccmmncodeVO,
            @ModelAttribute("searchVO") ComtccmmncodeDefaultVO searchVO) throws Exception {
        return comtccmmncodeService.selectComtccmmncode(comtccmmncodeVO);
    }

    @RequestMapping("/comtccmmncode/updateComtccmmncode.do")
    public String updateComtccmmncode(
            ComtccmmncodeVO comtccmmncodeVO,
            @ModelAttribute("searchVO") ComtccmmncodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        comtccmmncodeService.updateComtccmmncode(comtccmmncodeVO);
        status.setComplete();
        return "forward:/comtccmmncode/ComtccmmncodeList.do";
    }
    
    @RequestMapping("/comtccmmncode/deleteComtccmmncode.do")
    public String deleteComtccmmncode(
            ComtccmmncodeVO comtccmmncodeVO,
            @ModelAttribute("searchVO") ComtccmmncodeDefaultVO searchVO, SessionStatus status)
            throws Exception {
        comtccmmncodeService.deleteComtccmmncode(comtccmmncodeVO);
        status.setComplete();
        return "forward:/comtccmmncode/ComtccmmncodeList.do";
    }

}
