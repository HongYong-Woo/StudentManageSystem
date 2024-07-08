package student;

import java.util.ArrayList;

public class StudentManager extends StudentDBIO{

  //싱글톤으로 1. 객체를 생성
  private static final StudentManager instance = new StudentManager();

  //2.생성자 접근 제한
  private StudentManager() {
  }

  //3. get 메서드 생성
  public static StudentManager getInstance() {
    return instance;
  }

  public boolean insertStudent(Student student) {

    //System.out.println("studentManager insertStudent() 동작");
    return super.insertStudent(student);
  }

  public ArrayList<Student> getSortedStudent() {//학생 석차 처리기능
    return new ArrayList<>();
  }


  public ArrayList<Student> getStudentList() {
    return super.getStudentList();
  }


  public ArrayList<Student> searchStudent(String sno) { //학번으로 학생 검색
    return super.searchStudent(sno);//
  }

  @Override
  public boolean deleteStudent(String sno) {
    return super.deleteStudent(sno);
  }


}
