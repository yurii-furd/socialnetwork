package com.furd.socialnetwork.dao;

import com.furd.socialnetwork.entities.Message;

import java.util.List;

public interface MessageDAO extends AbstractDAO<Message> {

    List<Message> findBySenderAndReceiver(long sender, long receiver);

    List<Message> findByText(String text);
}
