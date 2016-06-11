package com.codegraphy;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int idx = 0; idx < 100000000; idx++) {

            list.add("가나다라마바사아자차카타파하");
//            Object obj = list.get(idx);
//
//            /**
//             * GC의 대상이 되지 않는다. <br/>
//             * 이 작업은 단지 객체의 주소값을 null로 할당하기 때문이다. <br/>
//             * 여전히 list 객체를 통해 값에 접근이 가능하다.  <br/>
//             * 물론 list와 같이 stack에서 직접적으로 참조되는 객체는 아님. <br/>
//             * 즉, Reachable But not Live 객체이다.
//             */
//            obj = null;
            list = new ArrayList<>();

            System.out.println(idx);
        }
    }
}