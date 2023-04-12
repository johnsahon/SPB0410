package com.spb.spb0410.VO;

public class PersonVO {
    
    private Long id;
    private String name;
    private int age;
    
    public PersonVO(long long1, String string, int int1) {
    }
    
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
 
}

