package com.kh.collection.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
	 * Set
	 * 순서가 없고, 중복을 허용하지 않는 자료구조
	 * index개념이 없어서 위치기반 접근(get(index))이 불가
	 * -HashSet : 일반적인 해시알고리즘이 적용된 set
	 * -LinkedHashSet : HashSet + 순서 유지
	 * -TreeSet : 자동정렬 기능 제공
	 * 
	 * */
public class Run {
	
	public static void main(String[] args) {
		//생성
		Set<Human> set = new HashSet<>();
		
		//데이터 추가
		set.add(new Human("장원석", 21));
		set.add(new Human("장원석", 22));
		set.add(new Human("장삼석", 23));
		set.add(new Human("장넷석", 24));
		
		//System.out.println(set);
		//set에 저장해서 사용하는 객체(Human)은 equals와 hashCode를 오버라이딩해줘야함
		//set은 hashCode()로 분류 후 equals()로 비교해서 중복삾을 검사함.
		
		set.add(new Human("장원석", 21));
		set.add(new Human("장투석", 22));
		//System.out.println(set);
		
		Human h1 = new Human("장원석", 21);
		Human h2 = new Human("장원석", 21);
		//동일객체 : (h1.equals(h2) && h1.hashCode() == h2.hashCode())
		//객체마다의 정의된 hashCode와 equals의 결과가 모두 일치하는 객체
		//equals와 hashCode를 오버라이딩하지 않으면 Object의 equals와 hashCode를 사용함
		//Object의 equals -> 주소값 비교
		//Object의 hashCode -> 주소값을 가지고 10진수형태의 해시값을 구한것
		
		//contains() 요소에 포함여부 확인
		System.out.println("장원석 존재? : " + set.contains(h2));
		
		//remove(E e) 요소를 통해 요소제거
		set.remove(h1);
		System.out.println("삭제 후 : " + set);
		System.out.println("size : " + set.size());
		
		//set의 모든 요소에 순차적으로 접근하는 방법
		//set은 index 개념이 없기 때문에 get()을 사용할 수 없음
		
		//1. for each
		for(Human h : set) {
			System.out.println(h);
		}
		System.out.println("------------------------------");
		//2. ArrayList에 담아서 반복 -> add All(Collection e)
		ArrayList list = new ArrayList();
		list.addAll(set);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		//3. Iterator(반복자 인터페이스)를 활용
		//컬렉션에 저장된 요소를 순차적으로 접근하기위한 인터페이스
		//순서가 없는 Set 같은 자료구조를 탐색할 때 반드시 필요
		//hasNext() : 다음 읽을 요소가 있으면 true, 없으면 false
		//next() : 다음 요소를 반환
		System.out.println("------------------------------");
		Iterator<Human> it = set.iterator();
		while(it.hasNext()) {
			Human h = it.next();
			System.out.println(h);
		}
	}	
}
