package com.yedam.book;

import java.util.ArrayList;
import java.util.List;

import com.yedam.common.DAO;
import com.yedam.consumer.ConsumerService;

public class BookDAO extends DAO {

	private static BookDAO bookDao = null;

	private BookDAO() {

	}

	public static BookDAO getInstance() {
		if (bookDao == null) {
			bookDao = new BookDAO();
		}
		return bookDao;
	}

	// 통합검색(배열)
	public List<Book> getBookName(String bookName) {
		List<Book> booklist = new ArrayList<>();
		Book book = null;
		try {
			conn();
			
			String sql = "SELECT * FROM book WHERE bookName Like? OR bookWriter Like? ";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + bookName + "%");
			pstmt.setString(2, "%" + bookName + "%");
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				book = new Book();

				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookId(rs.getInt("bookId"));

				booklist.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return booklist;

	}

	// 책 제목 (선택)
	public Book getsearchBookName(int choice) {
		Book book = null;
		try {
			conn();

			String sql = "SELECT * FROM book WHERE bookId = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, choice);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				book = new Book();

				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookGenre(rs.getString("bookGenre"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookLocation(rs.getString("bookLocation"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return book;
	}

	// 구매 하기 메소드

	// 구매하기 누를시 -> 1. 책 테이블의 선택한 책의 판매량이 1 상승한다.
	// 2.구매내역테이블에 구매내역이 추가된다.

	public int getbookbuying(int choice) {
		int result = 0;
		try {
			conn();
			String sql = "update book set bookSale = bookSale + 1 where bookId = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, choice);

			result = pstmt.executeUpdate();

			if (result == 1) {
				Book book = getsearchBookName(choice);
				
				conn();
				String sql2 = "insert into buyingHistory values (?,?,?,?,?,sysdate)";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, ConsumerService.ConsumerInfo.getConsumerId());
				pstmt.setString(2, book.getBookName());
				pstmt.setString(3, book.getBookWriter());
				pstmt.setInt(4, book.getBookPriced());
				pstmt.setInt(5, choice);

				result = pstmt.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return result;
	}

	
	
	// 로그인된 사람의 구매내역보기

	public List<BuyingHistory> getselfhistory() {
		List<BuyingHistory> buyinglist = new ArrayList<>();
		BuyingHistory history = null;
		try {
			conn();
			String sql = "SELECT * FROM buyingHistory WHERE consumerId = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ConsumerService.ConsumerInfo.getConsumerId());
			
			rs = pstmt.executeQuery();
			
		while(rs.next()) {
			history = new BuyingHistory(); 
			history.setBookName(rs.getString("bookName"));
			history.setBookWriter(rs.getString("bookWriter"));
			history.setBookPriced(rs.getInt("bookPriced"));
			history.setBookId(rs.getInt("bookId"));
			buyinglist.add(history);
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return buyinglist;

	}
	// 책 작가 검색
	public List<Book> getBookWriter(String bookWriter) {
		List<Book> booklist = new ArrayList<>();
		Book book = null;
		try {
			conn();

			String sql = "SELECT * FROM book WHERE bookWriter Like?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + bookWriter + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				book = new Book();

				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookId(rs.getInt("bookId"));

				booklist.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return booklist;

	}

	// 책 장르 검색
	public List<Book> getBookGenre(String bookGenre) {
		List<Book> booklist = new ArrayList<>();
		Book book = null;
		try {
			conn();

			String sql = "SELECT * FROM book WHERE bookGenre Like?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + bookGenre + "%");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				book = new Book();

				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookGenre(rs.getString("bookGenre"));
				book.setBookPriced(rs.getInt("bookPriced"));
				book.setBookLocation(rs.getString("bookId"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return booklist;

	}

	// best도서
	public List<Book> getBestBook() {
		List<Book> booklist = new ArrayList<>();
		Book book = null;
		try {
			conn();

			String sql = "SELECT RANK() OVER(ORDER BY bookSale DESC)AS 랭킹, bookName, bookWriter,bookId FROM book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				book = new Book();
				book.setBookName(rs.getString("bookName"));
				book.setBookWriter(rs.getString("bookWriter"));
				book.setBookId(rs.getInt("bookId"));
				booklist.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return booklist;
	}

}