package com.lg.dao;

import java.util.List;

import com.lg.entity.Comment;

public interface ICommentDAO {
    boolean addComment(Comment comment);
    List<Comment> findAllComment(int gId);        
}
