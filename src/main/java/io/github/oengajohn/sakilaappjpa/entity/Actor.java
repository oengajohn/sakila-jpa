package io.github.oengajohn.sakilaappjpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "actor",indexes = {
        @Index(name = "idx_actor_last_name",columnList = "last_name")
})
public class Actor {
    @Id
    @Column(name = "actor_id", columnDefinition = "smallint UNSIGNED")
    private Integer actorId;

    @Size(max = 45)
    @NotNull
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Size(max = 45)
    @NotNull
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;

    @NotNull
    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @PrePersist
    @PreUpdate
    public void setCreateDate() {
        lastUpdate = Instant.now();
    }


}