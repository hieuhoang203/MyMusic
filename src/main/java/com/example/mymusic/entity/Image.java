package com.example.mymusic.entity;

import com.example.mymusic.entity.commonProperties.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "image")
@Setter
@Getter
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    private String name;

    private Date date_create;

    private Date date_update;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne(mappedBy = "image")
    private User user;

    public Image() {
        this.date_create = new Date(new java.util.Date().getTime());
        this.status = Status.DANG_HOAT_DONG;
    }

}
