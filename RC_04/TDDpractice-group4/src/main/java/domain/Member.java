package domain;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
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

    public void setGender(String gender){
        if(!gender.equals("male") || !gender.equals("female")){
            throw new IllegalArgumentException();
        }
        else this.gender = gender;
    }

    public String setGender(){
        return gender;
    }
}
