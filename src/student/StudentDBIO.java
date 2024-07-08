package student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lib.ObjectDBIO;

public abstract class StudentDBIO extends ObjectDBIO implements StudentIO {

  //query가 동작하도록 메소드를 만들자.

  /** 학생 전체 보기 */
  public ArrayList<Student> getStudentList() {
    ArrayList<Student> stulist = new ArrayList<Student>();
    String query = "SELECT * FROM STUDENT";
    ResultSet rs = null;

    try {
      rs = super.execute(query, rs);
      while (rs.next()) {
        int sno = rs.getInt(1);
        String name = rs.getString(2);
        int korean = rs.getInt(3);
        int english = rs.getInt(4);
        int math = rs.getInt(5);
        int science = rs.getInt(6);
        int total = rs.getInt("total");
        double average = rs.getDouble("average");
        String grade = rs.getString("grade");

        Student student = new Student(sno, name, korean, english, math, science, total, average, grade);
        stulist.add(student);
      }
      rs.close();
      super.close();
    } catch (SQLException e) {
      System.err.println(e.toString());
      //e.printStackTrace();
    }
    return stulist;
  }

  /** 학생 검색 */
  public ArrayList<Student> searchStudent(String sno) {
    ArrayList<Student> searchStudent = new ArrayList<Student>();
    String query = "SELECT * FROM student WHERE sno = ?";
    ResultSet rs= null;

    try {
      rs = super.execute(query, rs, sno);

      while (rs.next()) {
        int s_no = rs.getInt(1);
        String name = rs.getString(2);
        int korean = rs.getInt(3);
        int english = rs.getInt(4);
        int math = rs.getInt(5);
        int science = rs.getInt(6);
        int total = rs.getInt("total");
        double average = rs.getDouble("average");
        String grade = rs.getString("grade");
        Student student = new Student(s_no, name, korean, english, math, science, total, average, grade);
        searchStudent.add(student);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return searchStudent;
  }

  public ArrayList<Student> getSortedStudent() {
    ArrayList<Student> sortStudent = new ArrayList<Student>();
    return sortStudent;
  }


  /** 학생 정보 추가 */
  public boolean insertStudent(Student student) {
    String name = student.getName();
    int kor = student.getRecord()[0];
    int eng = student.getRecord()[1];
    int math = student.getRecord()[2];
    int sci = student.getRecord()[3];
    int total = student.getTotal();
    double average = student.getAverage();
    String grade = student.getGrade();

    String query = "INSERT INTO student(name, kor, eng, math, sci, total, average, grade) VALUES ('" +
        name + "', " +
        kor + ", " +
        eng + ", " +
        math + ", " +
        sci + ", " +
        total + ", " +
        average + ", '" +
        grade + "')";

    super.execute(query);
    super.close();
    return true;
  }

  @Override
  public boolean deleteStudent(String sno) {
    String query = "DELETE FROM student WHERE sno = '" + sno + "'";
    super.execute(query);
    super.close();
    return true;
  }

  public void printStudent(ArrayList<Student> students) {
    for (Student s : students) {
      System.out.printf("%d번 이름 : %s  국어: %d  영어: %d  수학: %d  과학: %d  총점: %d  평균: %.1f  등급: %s\n",
          s.getSno(), s.getName(),
          s.getRecord()[0], s.getRecord()[1], s.getRecord()[2], s.getRecord()[3],
          s.getTotal(), s.getAverage(), s.getGrade());
    }
  }
}
