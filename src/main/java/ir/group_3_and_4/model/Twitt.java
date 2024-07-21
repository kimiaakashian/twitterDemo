package ir.group_3_and_4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SoftDelete;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "`user_twitt`")
@SoftDelete

public class Twitt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "`twitt`")
    @Size(max = 280)
    private String twitt;

    private LocalDateTime twittDateTime;
    @Column(name = "`like`")
    private long like;
    private long disLike;
    @OneToMany(mappedBy = "twitt")
    private List<UserComment> userComment;
    @ManyToOne
    private User user;


}
