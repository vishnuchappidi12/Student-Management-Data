package project;

import java.sql.*;

public class StudentDAO {

    Connection conn = DBUtil.getDBConnection();

    public int addDetails(Student student) {
        int count = 0;
        String addQuery = "insert into students values(?,?,?,?) ";
        try {
            PreparedStatement pstmt = conn.prepareStatement(addQuery);
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());
            pstmt.setString(4, student.getAddress());
            count = pstmt.executeUpdate();
        } catch (Exception e) {

        }
        return count;
    }

    public int updateDetails(Student student) {
        int count = 0;
        try {
            String updateQuery = "update students set name=? , age=? , address=? where id=?";
            PreparedStatement pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, student.getName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getAddress());
            pstmt.setInt(4, student.getId());
            count = pstmt.executeUpdate();
        } catch (Exception e) {

        }
        return count;
    }

    public int deleteDetails(int id) {
        int count = 0;
        try {
            String deleteQuery = "delete from students where id=?";
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, id);
            count = pstmt.executeUpdate();
        } catch (Exception e) {

        }
        return count;
    }
    public void viewAllStudents() {
        try {
            String query = "SELECT * FROM students";
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("ID | Name | Age | Address");
            System.out.println("------------------------------");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getString("address")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
