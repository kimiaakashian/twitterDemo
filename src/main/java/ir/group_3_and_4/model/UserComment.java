package ir.group_3_and_4.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SoftDelete;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "user_comment")
@SoftDelete
public class UserComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String comment;

    @ManyToOne
    private Twitt twitt;
    @ManyToOne
    private User user;
}
