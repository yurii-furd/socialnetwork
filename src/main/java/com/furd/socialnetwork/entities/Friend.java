package com.furd.socialnetwork.entities;

import java.util.Objects;

public class Friend {
    private long userId;
    private long frendId;

    public long getUserId() {
        return userId;
    }

    public Friend setUserId(long userId) {
        this.userId = userId;
        return this;
    }

    public long getFrendId() {
        return frendId;
    }

    public Friend setFrendId(long frendId) {
        this.frendId = frendId;
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Friend friend = (Friend) obj;
        return this.frendId == friend.frendId &&
                this.userId == friend.userId;
    }
    @Override
    public int hashCode(){
        return Objects.hash(frendId,userId);
    }
}
