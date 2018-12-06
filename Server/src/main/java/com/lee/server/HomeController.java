package com.lee.server;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title","메모입니다.");
		map.put("contents","메모의 내용입니다.");
		map.put("regdate", "2018-12-04 17:30:45");
		map.put("image_path", "sample.png");
		System.out.println(sqlSession.delete("memo.memodelete", 5));
	//System.out.println("sqlSession : " + sqlSession.toString());
		return "home";
	}

}
