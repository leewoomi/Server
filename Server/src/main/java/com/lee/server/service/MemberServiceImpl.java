package com.lee.server.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.server.dao.MemberDao;
import com.lee.server.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao memberDao;

	@Override
	public Member login(HttpServletRequest request) {
		// 파라미터 읽기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		// 필요한 작업 수행

		// DAO의 파라미터 만들기
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);

		
		
		//DAO 메소드를 호출하고 결과를 Controller 한테 보내주기 
		//selectOne은 데이터가 없으면 null을 리턴 
		
		return memberDao.login(member);
	}

	@Override
	public String idCheck(String id) {

		Member member = new Member();
		member.setId(id);
		return memberDao.idCheck(id);
	}

}
