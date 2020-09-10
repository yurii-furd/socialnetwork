package com.furd.socialnetwork.dao.impl;

import com.furd.socialnetwork.dao.MessageDAO;
import com.furd.socialnetwork.entities.Message;

public class H2MessageDAO implements MessageDAO {
    @Override
    public Message findBySenderAndReceiver(long sender, long receiver) {
        return null;
    }

    @Override
    public Message create(Message entity) {
        return null;
    }

    @Override
    public Message findById(long id) {
        return null;
    }
}
