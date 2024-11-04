package com.koreait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void run() {
        Scanner sc = new Scanner(System.in);
        Map<Long, String> myList = new HashMap<>();
        ArrayList<Todo> todos = new ArrayList<>();
        long id = 0;

        label:
        while (true) {
            System.out.print("명령) ");
            String cmd = sc.next().trim();

            switch (cmd) {
                case "exit":
                    System.out.println("앱 종료 명령이 입력되었습니다.");
                    System.out.println("프로그램이 곧 종료합니다.");
                    break label;
                case "list":
                    System.out.println("번호 / 내용");
                    for (long i = 1; i <= id; i++) {
                        if (myList.get(i) != null) {
                            System.out.println((i) + " / " + myList.get(i));
                        }
                    }
                    break;
                case "add":
                    System.out.print("할일 : ");
                    String content = sc.next().trim();
                    ;
                    id++;
                    myList.put(id, content);
                    System.out.println(id + "번 할일이 생성되었습니다");
                    break;
                case "del": {
                    System.out.print("삭제할 할일의 번호 : ");
                    long num = sc.nextLong();
                    if (myList.get(num) == null) {
                        System.out.println(num + "번 할일은 존재하지 않습니다.");
                    } else {
                        myList.remove(num);
                        System.out.println(num + "번 할일이 삭제되었습니다.");
                    }
                    break;
                }
                case "modify": {
                    System.out.print("수정할 할일의 번호 : ");
                    long num = sc.nextLong();
                    if (myList.get(num) == null) {
                        System.out.println(num + "번 할일은 존재하지 않습니다.");
                    } else {
                        System.out.println("기존 할일 : " + myList.get(num));
                        System.out.print("새 할일 : ");
                        String newContent = sc.next().trim();
                        myList.put(num, newContent);
                        System.out.println(num + "번 할일이 수정되었습니다.");
                    }
                    break;
                }
            }
        }
    }
}
