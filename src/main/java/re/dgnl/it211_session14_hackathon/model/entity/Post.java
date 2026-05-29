package re.dgnl.it211_session14_hackathon.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Integer likes = 0;

    @Enumerated(EnumType.STRING)
    private StatusEnum status = StatusEnum.PUBLIC;

    private Boolean isDeleted = false;
}