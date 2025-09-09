package com.kh.example.oop6;

public class StudentController {
	private Student[] sArr = new Student[5];
	public static final int CUT_LINE = 60;

	
	public StudentController(){
		sArr[0] = new Student("김길동", "자바", 100);
		sArr[1] = new Student("박길동", "DB", 50);
		sArr[2] = new Student("이길동", "화면", 85);
		sArr[3] = new Student("장길동", "서버", 60);
		sArr[4] = new Student("홍길동", "자바", 20);
	}
	
	public Student[] printStudent() {
		return sArr;
	}
	
	public int sumScore() {
        int sum = 0;
        for (int i = 0; i < sArr.length; i++) {
        	if(sArr[i] == null) break; //int는 0으로 초기화, array([])는 null로 초기화 -> 배열에 값이 있을경우만  
            sum += sArr[i].getScore();
        }
        return sum;
        
//        for(Student st : sArr) {
//        	if(st == null) break;
//        	sum += st.getScore();
//        }
//        return sum;
    }
	
	  public double[] avgScore() {
	        double[] result = new double[2];
	        int sum = sumScore();
	        double avg = (double) sum / sArr.length;

	        result[0] = sum;  // 합계
	        result[1] = avg;  // 평균

	        return result;
	    }
}
