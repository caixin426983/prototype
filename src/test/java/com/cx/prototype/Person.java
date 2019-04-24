package com.cx.prototype;

/**
 * @Description TODO
 * @Author cx
 * @Date 2019/3/7 15:48
 **/
 class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }

    public Person() {
    }
}

class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
        super("");
        empID = id;
    }
}

 class Test {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}