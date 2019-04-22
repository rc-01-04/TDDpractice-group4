package domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Member {
    private String name;
    private String gender;
    private String cellphoneNumber;
    private int age;

    public void setAge(int age) {
        if(age<0 || age>200)
            throw new IllegalArgumentException();
        else this.age = age;
    }
    public void addAge() {
        this.age++;
    }
}
