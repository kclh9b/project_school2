package com.hk.jsp.vo;

public class ProReviewVo {

	private int revno;
	private int pno;
	private String content;
	private String id;
	private String regdate;
	private int hit;
	private int score;
	private String attach1;
	private String attach2;
	private String available;
	
	public int getRevno() {
		return revno;
	}
	public void setRevno(int revno) {
		this.revno = revno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getAttach1() {
		return attach1;
	}
	public void setAttach1(String attach1) {
		this.attach1 = attach1;
	}
	public String getAttach2() {
		return attach2;
	}
	public void setAttach2(String attach2) {
		this.attach2 = attach2;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
}
