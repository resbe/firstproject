package com.yedam.consumer;

import com.yedam.common.DAO;

public class ConsumerDAO extends DAO{
private static ConsumerDAO consumerDao = new ConsumerDAO();
	
	private ConsumerDAO() {
		
	}
	
	public static ConsumerDAO getInstance() {
		if(consumerDao == null) {
			consumerDao = new ConsumerDAO();
		}
		return consumerDao;
	}
	
	//로그인
	
	public Consumer login(String id) {
		Consumer consumer = null;
		try {
			conn();
			String sql = "SELECT * FROM consumer WHERE consumerId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				consumer = new Consumer();
				consumer.setConsumerId(rs.getString("consumerId"));
				consumer.setConsumerPw(rs.getString("consumerPw"));
				consumer.setConsumerPw2(rs.getString("consumerPw2"));
				consumer.setConsumerName(rs.getString("consumerName"));
				consumer.setConsumerNickName(rs.getString("consumerNickName"));
				consumer.setConsumerTell(rs.getString("consumerTel"));
				consumer.setUserGrade(rs.getString("userGrade"));
					
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return consumer;
		}
	
	//
	
	
	
	//회원가입
	
	public int consumerAdd(Consumer consumer) {
		int result = 0;
		try {
			conn();
			String sql = "insert into consumer values (?,?,?,?,?,?,?,?,'C')";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, consumer.getConsumerName());
			pstmt.setString(2, consumer.getConsumerId());
			pstmt.setString(3, consumer.getConsumerPw());
			pstmt.setString(4, consumer.getConsumerPw2());
			pstmt.setString(5, consumer.getConsumerNickName());
			pstmt.setString(6, consumer.getConsumerTell());
			pstmt.setString(7, consumer.getConsumerEmail());
			pstmt.setString(8, consumer.getConsumerAddress());
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				System.out.println(consumer.getConsumerNickName() +"님을 환영합니다" );
			}else {
				System.out.println("회원가입 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
		
	}
	
	public int consumerDelete() {
		int result = 0;
		try {
			conn();
			String sql = "delete from consumer where consumerId = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ConsumerService.ConsumerInfo.getConsumerId());
			
			result = pstmt.executeUpdate();
			
			if(result == 1) {
				String sql2 = "delete from buyingHistory where consumerId =?";
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, ConsumerService.ConsumerInfo.getConsumerId());
				int result2 = pstmt.executeUpdate();
				System.out.println("회원탈퇴하셨습니다.");
			}else{
				System.out.println("시스템 오류");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//로그인 된 사람의 내정보보기
	
	public Consumer getselfInfo() {
		Consumer consumer = null;
		try {
			conn();
			
			String sql = "SELECT * FROM consumer WHERE consumerId = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ConsumerService.ConsumerInfo.getConsumerId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				consumer =new Consumer();
				
				consumer.setConsumerName(rs.getString("consumerName"));
				consumer.setConsumerId(rs.getString("consumerId"));
				consumer.setConsumerPw(rs.getString("consumerPw"));
				consumer.setConsumerNickName(rs.getString("consumerNickname"));
				consumer.setConsumerTell(rs.getString("consumerTel"));
				consumer.setConsumerEmail(rs.getString("consumerEmail"));
				consumer.setConsumerAddress(rs.getString("consumerAddress"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
			}
			return consumer;
		}
	
	//로그인된 사람의 자기 정보 수정
	//1.이름 수정 | 2. 닉네임 수정 | 3.아이디 수정 | 4. 비밀번호 수정 | 5.이메일 수정 | 6.전화번호 수정 | 7.주소 수정 |
	
	//1.이름
	public int consumerUpdate1(Consumer consumer) {
		int result = 0;
		try {
			conn();
			String sql ="update consumer set consumerName = ? where consumerId = ?";
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,consumer.getConsumerName());
			pstmt.setString(2,ConsumerService.ConsumerInfo.getConsumerId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//2.닉네임
	public int consumerUpdate2(Consumer consumer) {
		int result = 0;
		try {
			conn();
			String sql ="update consumer set consumerNickname = ? where consumerId = ?";
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,consumer.getConsumerNickName());
			pstmt.setString(2,ConsumerService.ConsumerInfo.getConsumerId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//3.아이디
	public int consumerUpdate3(Consumer consumer) {
		int result = 0;
		try {
			conn();
			String sql ="update consumer set consumerId = ? where consumerId = ?";
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,consumer.getConsumerId());
			pstmt.setString(2,ConsumerService.ConsumerInfo.getConsumerId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//4.비밀번호 변경
	public int consumerUpdate4(Consumer consumer) {
		int result = 0;
		try {
			conn();
		String sql ="update consumer set consumerPw = ? where consumerId = ?";
		pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1,consumer.getConsumerPw());
		pstmt.setString(2,ConsumerService.ConsumerInfo.getConsumerId());
		result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//5.이메일
	public int consumerUpdate5(Consumer consumer) {
		int result = 0;
		try {
			conn();
		String sql ="update consumer set consumerEmail = ? where consumerId = ?";
		pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1,consumer.getConsumerEmail());
		pstmt.setString(2,ConsumerService.ConsumerInfo.getConsumerId());
		result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	
	//6.전화번호
	public int consumerUpdate6(Consumer consumer) {
		int result = 0;
		try {
			conn();
			String sql ="update consumer set consumerTel = ? where consumerid = ?";
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,consumer.getConsumerTell());
			pstmt.setString(2,ConsumerService.ConsumerInfo.getConsumerId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	//7.주소
	public int consumerUpdate7(Consumer consumer) {
		int result = 0;
		try {
			conn();
		String sql ="update consumer set consumerAddress = ? where consumerId = ?";
		pstmt =  conn.prepareStatement(sql);
		pstmt.setString(1,consumer.getConsumerAddress());
		pstmt.setString(2,ConsumerService.ConsumerInfo.getConsumerId());
		result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			disconn();
		}
		return result;
	}
	}