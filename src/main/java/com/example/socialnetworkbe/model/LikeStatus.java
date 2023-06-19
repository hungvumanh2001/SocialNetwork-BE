package com.example.socialnetworkbe.model;

import javax.persistence.*;

@Entity
@Table(name = "status_likes")
public class LikeStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Status status;

    @ManyToOne
    @JoinColumn(name = "like_user_id")
    private User userLike;

    public LikeStatus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUserLike() {
        return userLike;
    }

    public void setUserLike(User userLike) {
        this.userLike = userLike;
    }
}
