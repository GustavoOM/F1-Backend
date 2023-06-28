package SCC0541.F1Backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "log_table")
public class LogModel {

    @Id
    @Column(name = "userid")
    private Integer userId;

    @Column(name = "idoriginal")
    private Integer idOriginal;

    @Column(name = "timestamp")
    private String timestamp;

    public LogModel(Integer userId, Integer idOriginal) {
        this.userId = userId;
        this.idOriginal = idOriginal;
    }
}
