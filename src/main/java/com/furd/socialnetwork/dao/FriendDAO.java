package com.furd.socialnetwork.dao;

import com.furd.socialnetwork.entities.Friend;

public interface FriendDAO extends AbstractDAO<Friend> {
    Friend findFriendForLogin(String name);

    Friend findFriendForFullName(String name);
}
