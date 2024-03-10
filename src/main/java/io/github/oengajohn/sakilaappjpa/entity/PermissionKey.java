package io.github.oengajohn.sakilaappjpa.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
public class PermissionKey implements Serializable {
    private static final long serialVersionUID = -1468250781515841642L;

    @Column(name = "menu_id")
    private Integer menuId;

    @Column(name = "group_id")
    private Integer groupId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PermissionKey entity = (PermissionKey) o;
        return Objects.equals(this.menuId, entity.menuId) &&
                Objects.equals(this.groupId, entity.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId,groupId);
    }

}