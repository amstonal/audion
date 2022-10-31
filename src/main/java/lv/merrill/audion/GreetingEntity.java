package lv.merrill.audion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greeting")
public class GreetingEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "text")
    private String text;

    public String getText() {
        return text;
    }
}
