package com.hybrid.mapper;

import java.util.List;
import java.util.Map;

import com.hybrid.model.Member;

public interface MemberMapper {
	
	
	List<Member> selectAll() ; // control 을 누른 상테에서 마우스를 selectAll 등에 가져가면 원코드로 이동가능 , 연결된 것을 확인 가능
	
	//
	Member selectByEmailAndPassword(Map<String, Object> emailAndPassword);
	
	void insert(Member m);
	void update(Member m); 
	void delete(Member m); 
	
	
}
