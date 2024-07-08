package student;

public class Student {

  private int sno;
  private String name;
  private int[] record = new int[4];//학생 점수 모음
  private int total;
  private double average;
  private String grade;
  private int rank = -1;

  static enum GRADE {A, B, C, D, F}

  ;

  public Student() {
  }

  public Student(String name, int kor, int eng, int marh, int sci) {
   //inset용
    this.name = name;
    this.record[0] = kor;
    this.record[1] = eng;
    this.record[2] = marh;
    this.record[3] = sci;

    this.makeScore();
  }


  public Student(int sno, String name, int kor, int eng, int marh, int sci, int total, double average, String grade) {
    //데이터 받아오기용
    this.sno = sno;
    this.name = name;
    this.record[0] = kor;
    this.record[1] = eng;
    this.record[2] = marh;
    this.record[3] = sci;
    this.total = total;
    this.average = average;

    this.grade = grade;
  }

  private void makeScore() {
    for (Integer score : this.record) {
      this.total += score;
    }
    this.average = (double) this.total / this.record.length;

    this.makeGrade();
  }

  private void makeGrade() {
    int num = (int) this.average / 10;
    switch (num) {
      case 10, 9 -> this.grade = GRADE.A.toString();
      case 8 -> this.grade = GRADE.B.toString();
      case 7 -> this.grade = GRADE.C.toString();
      case 6 -> this.grade = GRADE.D.toString();
      default -> this.grade = GRADE.F.toString();
    }
   /* if (this.average >= 90) {
      this.grade = GRADE.A.toString();
    } else if (this.average >= 80) {
      this.grade = GRADE.B.toString();
    } else if (this.average >= 70) {
      this.grade = GRADE.C.toString();
    } else if (this.average >= 60) {
      this.grade = GRADE.D.toString();
    } else {
      this.grade = GRADE.F.toString();
    }*/
  }

  public int getSno() {
    return sno;
  }

  public String getName() {
    return name;
  }

  public int[] getRecord() {
    return record;
  }

  public int getTotal() {
    return total;
  }

  public double getAverage() {
    return average;
  }

  public String getGrade() {
    return grade;
  }

  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }
}
