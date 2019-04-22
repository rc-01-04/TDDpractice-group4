package domain;

import lombok.Data;

@Data
public class Member {
    private String name;
    private String gender;
    private String cellphoneNumber;
    private int age;

    public Member(){
    }
    public void setAge(int age) {
        if(age<0 || age>200)
            throw new IllegalArgumentException();
        else this.age = age;
    }
    public void addAge() {
        this.age++;
    }
}
