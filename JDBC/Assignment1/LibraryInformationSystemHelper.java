import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.text.ParseException;
import java.util.List;

import java.sql.PreparedStatement;

public class LibraryInformationSystemHelper {
	
	/* returns list of titles of books written by given author */
	public List<Title> booksPublishedByAuthor(String authorName)
			throws ParseException {
		/* list to store titles of books by given author */
		List<Title> titleList = new ArrayList<Title>();
		Title t = null;
		/* selects all titles of books written by given author */
		String query = "SELECT t.* FROM titles t "
				+ "INNER JOIN title_author ta ON ta.title_id=t.title_id "
				+ "INNER JOIN authors a ON a.author_id=ta.author_id "
				+ "WHERE a.author_name='"
				+ authorName + "'";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* get connection object */
		con = conUtil.getConnection();
		try {
			stmt = con.createStatement();
			/* execute query using statement */
			rs = stmt.executeQuery(query);
			if (rs.next() == false);   /* If no book found for given author then return false */
			else {
				/* set values in title object */
				t = new Title();
				t.setTitleId(rs.getInt(1));
				t.setTitleName(rs.getString(2));
				t.setPublisherId(rs.getInt(3));
				t.setSubjectId(rs.getInt(4));
				titleList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		/* returns list of titles of books written by given author */
		return titleList;
	}

	
	/* Finds if given book exists in library or not */
	public int bookAvailable(String bookName) {
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* create connection */
		con = conUtil.getConnection();
		ResultSet rs = null;
		int accessionNumber = 0;
		/* selects accession_number of given book */
		String query = "SELECT accession_number FROM books WHERE title_id = (SELECT title_id FROM titles WHERE title_name ='"
				+ bookName + "')";
		try {
			stmt = con.createStatement();
			/* execute query using statement */
			rs = stmt.executeQuery(query);
			/* If book does not exist then return 0 */
			if (rs.next() == false);
			else 
				accessionNumber = rs.getInt("accession_number");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return accessionNumber;
	}
	

	/* finds if book is issued to member or not */
	public boolean bookIssuedOrNot(String memberName, int accessionNumber) {
		boolean flag = false;
		Connection con = null;
		Statement stmt = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* create connection */
		con = conUtil.getConnection();
		ResultSet rs = null;
		int id = 0;
		/* selects member id of given member */
		String query2 = "SELECT member_id FROM Members WHERE member_name = '"
				+ memberName + "'";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query2);
			/* if given person is not an already existing member then return false & book would not be issued to him */
			if (rs.next() == false);
			else
			{
				/* if given person is an already existing member then issue book to him & return true */
				id = rs.getInt("member_id");
				String query3 = "INSERT INTO book_issue(accession_number,member_id) VALUES ( "
						+ accessionNumber + "," + id + ")";
				stmt = null;
				con = null;
				conUtil = new ConnectionUtil();
				con = conUtil.getConnection();
				stmt = con.createStatement();
				int num = stmt.executeUpdate(query3);
				if (num > 0)
					flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}

	
	/* deletes books not issued since last one year & returns their count  */
	public int deleteBooksNotIssuedSinceOneYear() {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ConnectionUtil conUtil = new ConnectionUtil();
		/* creates connection to db */
		con = conUtil.getConnection();
		ResultSet rs = null;
		int count = 0;
		/* selects accession number of books which have not been issued since last one year. 
		 * they should have been purchased before 1 year & they should be available. 
		 * There can be 2 conditions one that book has never been issued since 1 year 
		 * second that it has been issued & returned before one year*/
		String query = "SELECT DISTINCT b.accession_number FROM book_issue bi "
				+ "INNER JOIN books b "
				+ "WHERE (b.accession_number NOT IN (SELECT accession_number FROM book_issue) "
				+ "AND DATEDIFF( NOW(), b.purchase_date)>=365 AND b.status != 'Not Available' )"
				+ "OR DATEDIFF( NOW(), DATE(bi.issue_date))>=365 "
				+ "AND b.accession_number=bi.accession_number";
		
		/* delete all books not issued since last one year */
		String query1 = "DELETE FROM books WHERE accession_number=?";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ps = (PreparedStatement) con.prepareStatement(query1);
				/* set variable in prepared statement */
				ps.setInt(1, rs.getInt("accession_number"));
				// ps.setString(1,name);
				ps.executeUpdate();
				/* increase count per deleted book */
				count += 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (stmt != null) {
					stmt.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/* return number of deleted books */
		return count;
	}
}
