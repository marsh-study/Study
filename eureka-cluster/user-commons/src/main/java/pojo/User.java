package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String username;
    private int age;
    private int port;
    private String message;

    public User(String zhang, int i, int i1) {
        this.username = zhang;
        this.age = i;
        this.port = i1;
    }
}
