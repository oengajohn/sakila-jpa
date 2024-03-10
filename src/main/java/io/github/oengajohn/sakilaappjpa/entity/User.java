package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_username", columnNames = "username")
        },
        indexes = {
        @Index(name = "idx_fk_user_group",columnList = "group_id")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Column(name = "user_password", length = 100, nullable = false)
    private String userPassword;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "picture", length = 100)
    private String picture;

    @JoinColumn(name = "group_id", nullable = false, foreignKey = @ForeignKey(
            name = "fk_user_group"
    ))
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Group group;


}
