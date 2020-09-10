package com.furd.socialnetwork.dao;

import com.furd.socialnetwork.entities.Message;

public interface MessageDAO extends AbstractDAO<Message> {

    Message findBySenderAndReceiver(long sender, long receiver);
}
