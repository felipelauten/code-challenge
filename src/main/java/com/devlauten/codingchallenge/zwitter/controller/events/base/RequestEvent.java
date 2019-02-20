package com.devlauten.codingchallenge.zwitter.controller.events.base;

import java.util.Date;
import java.util.Objects;

/**
 * Generic request event class for the Zwitter API.
 * Contains a generic payload and a creation date.
 *
 * @param <Payload> - The type of payload this object carries
 */
public abstract class RequestEvent<Payload> {

    private Date createdOn;
    private Payload payload;

    public RequestEvent(Payload payload) {
        this.createdOn = new Date();
        this.payload = payload;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequestEvent)) return false;
        RequestEvent<?> that = (RequestEvent<?>) o;
        return createdOn.equals(that.createdOn) &&
                payload.equals(that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdOn, payload);
    }

    @Override
    public String toString() {
        return "RequestEvent{" +
                "createdOn=" + createdOn +
                ", payload=" + payload +
                '}';
    }
}
