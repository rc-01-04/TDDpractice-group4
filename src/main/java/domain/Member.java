package domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Member {
    private String name;
    private String gender;
    private String cellphoneNumber;
    private int age;

    public Member(){

    }
}
