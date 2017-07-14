package com.hanbit.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hanbit.member.domain.MemberBean;
import com.hanbit.member.service.MemberService;

public class MemberServiceImpl implements MemberService{

	MemberBean member;
	Map<String,MemberBean> map, nameList;
	
	public MemberServiceImpl(){
		member = new MemberBean();
		map = new HashMap<>();
	}
	
	@Override
	public void addMember(MemberBean member) {		
		map.put(member.getId(), member);
	}

	@Override
	public List<MemberBean> getMembers() {
		List<MemberBean> list = new ArrayList<>();
		Set<String> keys = map.keySet(); 	//key값만 모여 set을 만들어줌
		
		for(String s:keys){
			list.add(map.get(s));
		}
		return list;
	}

	@Override
	public int countMembers() {
		return map.size();
	}

	@Override
	public MemberBean findByID(String id) {
		return map.get(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> nameRes = new ArrayList<MemberBean>();
		Set<String> keys = map.keySet();
		
		for(String s:keys){
			if(name.equals(map.get(s).getName())){
				nameRes.add(map.get(s));
			}
		}
	    return nameRes;
	}


	@Override
	public void upadtePw(MemberBean bean) {	
		//pw
		if(!bean.getPw().equals(" ")){
			map.get(bean.getId()).setPw(bean.getPw());
		}
		//name
		if(!bean.getName().equals(" ")){
			map.get(bean.getId()).setName(bean.getName());
		}
		//ssn
		if(!bean.getSSN().equals(" ")){
			map.get(bean.getId()).setSSN(bean.getSSN());
		}
		//(!bean.getSSN().equals(" ")) ? map.get(s).setSSN(bean.getSSN()) : break;	
	}

	@Override
	public void delMember(String id) {
		map.remove(id);
	}
}
