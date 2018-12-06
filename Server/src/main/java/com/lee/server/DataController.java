package com.lee.server;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lee.server.domain.Member;
import com.lee.server.service.MemberService;

@RestController
public class DataController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "member/login", method = RequestMethod.GET)
	public Map<String, Object> login(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		// 결과 받아오기
		Member member = memberService.login(request);
		// 로그인 실패
		if (member == null) {
 
			member = new Member();
			member.setId("NULL");
			
		}
		//결과를 저장 
		map.put("result", member);
		
		return map;
	}
	
	
	@RequestMapping(value = "member/idCheck", method = RequestMethod.GET)
	public String idCheck(HttpServletRequest request,String id) {
	String str= "";
		// 결과 받아오기
		id = memberService.idCheck(id);
	
		if (id == null) {
 
	str = "사용 가능한 아이디";
			
		}else {
			str="중복된 아이디입니다.";
		}
		
		return str;
	}
	
	
	
}
