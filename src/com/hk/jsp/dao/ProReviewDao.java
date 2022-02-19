package com.hk.jsp.dao;

import java.util.ArrayList;
import java.util.List;

import com.hk.jsp.vo.ProReviewVo;

public class ProReviewDao extends DBDao{
	
	private ProReviewDao() {}
	
	private static ProReviewDao instance = new ProReviewDao();
	
	public static ProReviewDao getInstance() {
		return instance;
	}
	
	//작성 수정 삭제 리스트
	
	private int getNext() {
		int next = 1;
		try {
			connectDB();
			String sql = "select revno from pro_review where order by revno desc limit 1";
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				next = (rs.getInt(1)) + 1;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			closeDB();
		}
		return next;
	}
	
	public int saveReview(ProReviewVo revo) {
		int result = 0;
		try {
			connectDB();
			String sql = "insert into pro_review (pno, content, id, regdate, score, attach1, attach2) valeus(?, ?, ?, now(), ?, ?, ?, ?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, getNext());
			pstmt.setString(2, revo.getContent());
			pstmt.setString(3, revo.getId());
			pstmt.setInt(4, revo.getScore());
			pstmt.setInt(5, revo.getScore());
			pstmt.setString(6, revo.getAttach1());
			pstmt.setString(7, revo.getAttach1());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			result = -1;
		}finally {
			closeDB();
		}
		return result;
	}
	
	public List<ProReviewVo> getReviewList(String pno) {
		List<ProReviewVo> result = new ArrayList<>();
		ProReviewVo revo = new ProReviewVo();
		try {
			connectDB();
			String sql = String.format("select * from pro_review where pno=%s and available='y' order by revno desc", pno);
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				revo.setRevno(rs.getInt("revno"));
				revo.setPno(rs.getInt("pno"));
				revo.setContent(rs.getString("content"));
				revo.setId(rs.getString("id"));
				revo.setRegdate(rs.getString("regdate"));
				revo.setHit(rs.getInt("hit"));
				revo.setAttach1(rs.getString("attach1"));
				revo.setAttach2(rs.getString("attach2"));
				result.add(revo);
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			closeDB();
		}
		return result;
	}
	
	// 일단
	public int removeReview(String id, String pno) {
		int result = 0;
		try {
			connectDB();
			String sql = String.format("update pro_review set available='n' where id='%s' and pno=%s", id, pno);
			result = stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			result = -1;
		}finally {
			closeDB();
		}
		return result;
	}
	
	/*
	public int updateReview(ProReviewVo revo) {
		int result = 0;
		try {
			connectDB();
			StringBuffer sb = new StringBuffer("");
			sb.append("update into pro_review");
			sb.append("\n set content=?, regdate=now(), score=?, attach1=?, attach2=?");
			String sql = sb.toString();
			pstmt = conn.prepareStatement(sql);
			
			while(rs.next()) {
				revo.setRevno(rs.getInt("revno"));
				revo.setPno(rs.getInt("pno"));
				revo.setContent(rs.getString("content"));
				revo.setId(rs.getString("id"));
				revo.setRegdate(rs.getString("regdate"));
				revo.setHit(rs.getInt("hit"));
				revo.setAttach1(rs.getString("attach1"));
				revo.setAttach2(rs.getString("attach2"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			result = -1;
		}finally {
			closeDB();
		}
		return result;
	}
	*/
	
}
