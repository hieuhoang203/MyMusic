package com.example.mymusic.entity;

import com.example.mymusic.entity.commonProperties.Status;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "account")
@Setter
@Getter
@AllArgsConstructor
public class Account {

    @Id
    private String user_name;

    private String pass_word;

    private Date date_create;

    private Date date_update;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne(mappedBy = "account")
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "position",
            joinColumns = @JoinColumn(name = "user_name"),
            inverseJoinColumns = @JoinColumn(name = "id_role")
    )
    private Set<Role> roles;

    public Account() {
        this.date_create = new Date(new java.util.Date().getTime());
        this.status = Status.DANG_HOAT_DONG;
    }

}
