package com.furd.socialnetwork.entities;

import java.util.Objects;

public class Freund {
    private long userId;
    private long frendId;

    public long getUserId() {
        return userId;
    }

    public Freund setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public long getFrendId() {
        return frendId;
    }

    public Freund setFrendId(long frendId) {
        this.frendId = frendId;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Freund freund = (Freund) obj;
        return this.frendId == freund.frendId &&
                this.userId == freund.userId;
    }
    @Override
    public int hashCode(){
        return Objects.hash(frendId,userId);
    }
}
