package com.meta.project.operationcenter.domain.permissionmng.group;

import com.meta.project.operationcenter.domain.permissionmng.user.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "group_has_user")
@Data
public class GroupHasUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_id", nullable = false)
    private int groupId;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Group group;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}
