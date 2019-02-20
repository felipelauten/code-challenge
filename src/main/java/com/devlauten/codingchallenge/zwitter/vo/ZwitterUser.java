package com.devlauten.codingchallenge.zwitter.vo;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Table(name = "USERS")
public class ZwitterUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ")
    private Long id;
    @NotNull
    private String handle;
    private String fullName;
    private String avatarUrl;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "zwitter")
    private List<Zwitt> zwitts;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ZWITTER_FOLLOWERS",
        joinColumns = {
            @JoinColumn(name = "zwitter_id_1")
        }, inverseJoinColumns = {
            @JoinColumn(name = "zwitter_id_2")
        }
    )
    private Set<ZwitterUser> followers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ZWITTER_FOLLOWING",
            joinColumns = {
                    @JoinColumn(name = "zwitter_id_1")
            }, inverseJoinColumns = {
            @JoinColumn(name = "zwitter_id_2")
    }
    )
    private Set<ZwitterUser> following;

    public ZwitterUser() {
        this.createdOn = new Date();
    }

    public Long getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    /**
     * Retrieve user Zwitts
     */
    public List<Zwitt> getZwitts() {
        return this.zwitts;
    }

    public Set<ZwitterUser> getFollowers() {
        return followers;
    }

    public Set<ZwitterUser> getFollowing() {
        return following;
    }

    /**
     * Adds a new Zwitt to user zwitts collection
     * @param zwitt to be added
     */
    public void addZwitt(Zwitt zwitt) {
        if (this.zwitts == null) {
            this.zwitts = new ArrayList<>();
        }
        this.zwitts.add(zwitt);
    }

    /**
     * Adds a new follower to this ZwitterUser
     * @param follower to be added
     */
    public void addFollower(ZwitterUser follower) {
        if (this.followers == null) {
            this.followers = new HashSet<>();
        }
        this.followers.add(follower);
    }

    public void follow(ZwitterUser toFollow) {
        if (this.following == null) {
            this.following = new HashSet<>();
        }
        this.following.add(toFollow);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZwitterUser that = (ZwitterUser) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ZwitterUser{" +
                "id=" + id +
                ", handle='" + handle + '\'' +
                ", fullName='" + fullName + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
