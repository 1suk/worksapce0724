package com.kh.example.poly1;

public class AnimalManager {
    public static void main(String[] args) {
        Animal[] ani = new Animal[5];

        ani[0] = new Dog("바둑이", 3, "진돗개");
        ani[1] = new Cat("나비", 2, "검은색");
        ani[2] = new Dog("멍멍이", 1, "시바");
        ani[3] = new Cat("철수", 4, "흰색");
        ani[4] = new Dog("만두", 5, "치와와");

        for (Animal a : ani) {
            a.speak(); 

            if (a instanceof Dog) {
                Dog d = (Dog) a;
                System.out.printf("이 개의 견종은 %s입니다.%n", d.getBreed());
            } else if (a instanceof Cat) {
                Cat c = (Cat) a;
                System.out.printf("이 고양이의 색상은 %s입니다.%n", c.getColor());
            }
        }
    }
}
