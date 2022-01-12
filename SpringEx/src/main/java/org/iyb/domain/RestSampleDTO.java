package org.iyb.domain;

public class RestSampleDTO {
	private int mno;
	private String firstName;
	private String lastName;
	
	public RestSampleDTO() {}//기본생성자
	
	public RestSampleDTO(int mno, String firstName, String lastName) {
		this.mno=mno;
		this.firstName=firstName;
		this.lastName=lastName;
	}//매개변수 3개짜리 생성자
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "RestSampleDTO [mno=" + mno + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
