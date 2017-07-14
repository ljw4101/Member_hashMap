package com.hanbit.member.domain;

public class MemberBean {
	//DB에 저장되는 값만 정의해야 함
	private String id, pw, ssn, name;
	
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return id;
	}
	public void setPw(String pw){
		this.pw = pw;
	}
	public String getPw(){
		return pw;
	}
	public void setSSN(String ssn){
		this.ssn = ssn;
	}
	public String getSSN(){
		return ssn;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}

	public String toString(){
		return String.format("%s %s %s %s", id, pw, name, ssn);
		//return "Welcome "+id;
	}
	
}
