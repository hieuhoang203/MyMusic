package com.example.mymusic.entity;

import com.example.mymusic.entity.commonProperties.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "favoritesList")
@Getter
@Setter
@AllArgsConstructor
public class FavoritesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private User user;

    private Date date_create;

    private Date date_update;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "favoritesAlbum",
            joinColumns = @JoinColumn(name = "id_favoritesList"),
            inverseJoinColumns = @JoinColumn(name = "id_song")
    )
    private Set<Song> songs;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "favoritesSong",
            joinColumns = @JoinColumn(name = "id_favoritesList"),
            inverseJoinColumns = @JoinColumn(name = "id_album")
    )
    private Set<Album> albums;

    public FavoritesList() {
        this.date_create = new Date(new java.util.Date().getTime());
        this.status = Status.DANG_HOAT_DONG;
    }

}
