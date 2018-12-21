package com.flower.main.mainScreen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.flower.common.command.CommandMap;
import com.flower.common.constants.Constants;
import com.flower.common.controller.CommonController;

/**
 * 
 * @파일명		: MainScreenController.java 
 * @프로젝트	: ITMS
 * @날짜		: 2018. 3. 28. 
 * @작성자		: Cho HeumJun
 * @설명
 * <pre>
 * 	메인화면
 * </pre>
 */
@Controller
public class MainScreenController extends CommonController
{
	
	/**
	 * 
	 * @메소드명 : layoutMainContents
	 * @날짜 : 2018. 3. 14.
	 * @작성자 : Cho HeumJun
	 * @설명
	 * 
	 *     <pre>
	 *		메인 화면에서 필요한 정보를 취득하여 페이지 이동
	 *     </pre>
	 * 
	 * @param commandMap
	 * @return
	 */
	@RequestMapping(value = "mainScreen.do")
	public ModelAndView layoutMainContents(CommandMap commandMap)
	{
		ModelAndView mav = new ModelAndView(Constants.MAINSCREEN_URL);
		mav.addAllObjects(commandMap.getMap());
		
		// TODO 메인에서 사용되어지는 리스트 가져오기. 
		/*mav.addObject("noticeList", noticeMgrService.getMainNoticeList(commandMap));
		mav.addObject("boardList", boardMgrService.getMainBoardList(commandMap));
		mav.addObject("refRoomList", referRoomMgrService.getMainRefRoomList(commandMap));*/
		
		//메인화면의 통계 데이터를 가져온다.
		//mav.addObject("noticeList", noticeMgrService.getMainNoticeList(commandMap));
		return mav;
	}
	
}
