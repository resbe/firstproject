package com.yedam.book;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;

public class BookDAO extends DAO {
	
	private static BookDAO bookDao = null;
	
	private BookDAO() {
		
	}
	
	public static BookDAO getInstance() {
		if(bookDao == null) {
			bookDao = new BookDAO();
		}
		return bookDao;
	}
	
	
	//책 제목 검색배열
	public List<Book> getBookName(String bookName) {
		List<Book> booklist = new ArrayList<>(); 
		Book book = null;
		try {
			conn();
			
			String sql = "SELECT * FROM book WHERE bookName Like? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bookName+"%");
			
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				book = new Book();
				
				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookId(rs.getInt("bookId"));
				
				booklist.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return booklist;
		
	}
	
	
	
	//배
	public Book getsearchBookName(int choice) {
		Book book = null;
		try {
		conn();
	
		String sql = "SELECT * FROM book WHERE bookId = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, choice);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			book = new Book();
			
			book.setBookName(rs.getString("bookName"));
			book.setBookWriter(rs.getString("bookWriter"));
			book.setBookGenre(rs.getString("bookGenre"));
			book.setBookPriced(rs.getInt("bookPriced"));
			book.setBookId(rs.getInt("bookId"));	
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		disconn();
		}
		return book;
		}
		
	//책 번호 입력
	public Book getBookName(int bookNumber) {
		Book book = null;
		try {
			conn();
			
			String sql = "SELECT * FROM book WHERE bookNumber =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookNumber);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				
				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookGenre(rs.getString("bookGenre"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookLocation(rs.getString("bookLocation"));
				book.setBookId(rs.getInt("bookId"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return book;
		
		}
	
	//책 작가 검색
	public List<Book> getBookWriter(String bookWriter) {
		List<Book> booklist = new ArrayList<>();
		Book book = null;
		try {
			conn();
			
			String sql = "SELECT * FROM book WHERE bookWriter Like?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bookWriter+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book = new Book();
				
				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookId(rs.getInt("bookId"));
				
				booklist.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return booklist;

		}
	
	//책 장르 검색
	public List<Book> getBookGenre(String bookGenre) {
		List<Book> booklist = new ArrayList<>();
		Book book = null;
		try {
			conn();
			
			String sql = "SELECT * FROM book WHERE bookGenre Like?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bookGenre+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				book = new Book();
				
				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookGenre(rs.getString("bookGenre"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookLocation(rs.getString("bookId"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return booklist;

		}
	
	//책 장르 검색
	public Book getBestBookGenre(String bookGenre) {
		Book book = null;
		try {
			conn();
			
			String sql = "SELECT bookName,bookWriter,bookGenre,bookPriced,bookLocation FROM book WHERE bookWriter =?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bookGenre);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				
				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookGenre(rs.getString("bookGenre"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookLocation(rs.getString("bookLocation"));
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return book;

		}
	
	
	
	public int bookBuy(int sale) {
		int result = 0;
		
		
		try {
			conn();
			String sql = "Select bookSale from book where bookId = ?";
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}