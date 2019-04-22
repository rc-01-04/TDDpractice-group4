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
}
