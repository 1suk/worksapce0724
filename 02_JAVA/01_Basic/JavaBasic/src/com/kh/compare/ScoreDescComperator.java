package com.kh.compare;

import java.util.Comparator;

//점수 내림차순
public class ScoreDescComperator implements Comparator<Student> {
	public int compare(Student o1, Student o2) {
		//내림차순은 o2 vs o1
		return o2.score - o1.score;
	}
}
