package com.example.mymusic.entity;

import com.example.mymusic.entity.commonProperties.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "album")
@Getter
@Setter
@AllArgsConstructor
public class Album implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image", referencedColumnName = "id")
    private Image image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private User author;

    private Date date_create;

    private Date date_update;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "album")
    @JsonIgnore
    private Set<Song> songs;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "albums")
    @JsonIgnore
    private Set<FavoritesList> favoritesLists;

    public Album() {
        this.date_create = new Date(new java.util.Date().getTime());
        this.status = Status.DANG_HOAT_DONG;
    }

}
