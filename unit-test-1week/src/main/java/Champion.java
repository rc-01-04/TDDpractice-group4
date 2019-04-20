import lombok.Data;

@Data
public class Champion {
    private String name;
    private String position;

    Champion(String setName, String setPosition){
        name = setName;
        position = setPosition;
    }

}