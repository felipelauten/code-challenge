package com.devlauten.codingchallenge.zwitter.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ZWITTS")
public class Zwitt {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zwitter_id")
    @JsonIgnore
    public ZwitterUser zwitter;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ZWITT_SEQ")
    @SequenceGenerator(name = "ZWITT_SEQ", sequenceName = "ZWITT_SEQ")
    private long id;
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdOn;

    public Zwitt() {
        this.createdOn = new Date();
    }

    public Zwitt(ZwitterUser zwitter, String text) {
        this.zwitter = zwitter;
        this.text = text;
        this.createdOn = new Date();
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ZwitterUser getZwitter() {
        return zwitter;
    }

    public void setZwitter(ZwitterUser zwitter) {
        this.zwitter = zwitter;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
}
