
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import student.Student;
import student.StudentManager;

public class IntegrationSystem_study {

  static StudentManager studentManager = StudentManager.getInstance();

  //	 콘솔 입력 버퍼 생성
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    IntegrationSystem_study Instance = new IntegrationSystem_study();
    String buffer = null;

    while (true) {
      System.out.println("====== [ 메뉴를 선택 하세요 ] ======");
      System.out.println("1. 학생 관리 시스템");
      System.out.println("2. 시스템 종료");
      System.out.println("--------------------------------");

      int nSel = System.in.read() - 48;
      System.in.skip(System.in.available());

      switch (nSel) {

        case 1:
          while (true) {
            System.out.println("======= [ 학생 관리 시스템 ] =======");
            System.out.println("1. 학생 추가");
            System.out.println("2. 학생 전체 보기");
            System.out.println("3. 학생 검색");
            System.out.println("4. 학생 석차순으로 보기");
            System.out.println("5. 학생 정보 삭제");
            System.out.println("6. 이전으로");
            System.out.println("--------------------------------");
            nSel = System.in.read() - 48;
            System.in.skip(System.in.available());
            switch (nSel) {
              case 1:
                Instance.insertStudent();
                continue;
              case 2:
                Instance.getStudentList();
                continue;
              case 3:
                Instance.searchStudent();
                continue;
              case 4:
                Instance.sortedStudent();
                continue;
              case 5:
                Instance.deleteStudent();
                break;
              case 6:
                break;
              default:
                continue;
            }
            break;
          }
          continue;
        case 2:
          break;
        default:
          continue;
      }
      break;
    }
  }

  /**
   * 1.학생 추가 하기
   */
  public void insertStudent() throws IOException { //학생정보 입력 기능( 학생 객체 생성(vo)후 학생정보저장)

    String buffer = null;
    String name = null;
    Student student = null;

    while (true) {
      System.out.println("학생 데이터를 순서대로 입력하세요 (이름, 국어, 영어, 수학, 과학)");
      System.out.println("입력종료 : exit");
      System.out.println("============================================");
      if ((buffer = br.readLine()).equals("exit")) {
        break;
      }

      try {
        StringTokenizer st = new StringTokenizer(buffer);
        if ((name = st.nextToken()) != null) {
          int[] record = new int[4];
          for (int n = 0; n < record.length; n++) {
            record[n] = Integer.parseInt(st.nextToken());
          }

          student = new Student(name, record[0], record[1], record[2], record[3]);
          studentManager.insertStudent(student);
        }
      } catch (NoSuchElementException e) {
        System.out.println("입력 형식에 알맞지 않은 입력입니다.");
        continue;
      } catch (NumberFormatException e) {
        System.out.println("성적 입력은 숫자로만 입력 가능합니다.");
        continue;
      }

      System.out.println("학생 정보 입력이 완료되었습니다.\n");
    }
  }


  public void sortedStudent() {//학생 석차 처리기능

  }

  /**
   * 2.학생 전체 보기
   */
  public void getStudentList() {
    ArrayList<Student> students;
    students = studentManager.getStudentList();
    System.out.println("전체 학생 정보 출력");
    studentManager.printStudent(students);
  }

  /**
   * 학번으로 학생 검색
   */
  public void searchStudent() throws IOException { //학번으로 학생 검색
    ArrayList<Student> students;
    String sno;
    while (true) {
      System.out.println("학생 정보 검색");
      System.out.println("찾으실 학생 정보를 입력하세요.");
      System.out.println("입력종료 : 0");
      System.out.println("============================================");
      if ((sno = br.readLine()).equals("0")) {
        break;
      }

      try {
        students = studentManager.searchStudent(sno);

        if (students.size() == 0) {
          System.out.println("잘못된 숫자를 입력하셨습니다.");
        }

      } catch (NumberFormatException e) {
        System.out.println("입력은 숫자로만 입력 가능합니다.");
        continue;
      }
      studentManager.printStudent(students);
    }
  }

  public void deleteStudent() throws IOException {
    String sno;
    while (true) {
      System.out.println("학생 정보 삭제");
      System.out.println("삭제할 학생 번호를 입력하세요.");
      System.out.println("입력종료 : 0");
      System.out.println("============================================");
      if ((sno = br.readLine()).equals("0")) {
        break;
      }

      try {
        studentManager.deleteStudent(sno);
      } catch (NumberFormatException e) {
        System.out.println("입력은 숫자로만 입력 가능합니다.");
        continue;
      }
    }
    System.out.println("학생 정보 삭제가 완료되었습니다.\n");
  }

}