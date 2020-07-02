package cg.blog.services;

import cg.blog.models.Blog;
import cg.blog.models.Comment;

import java.util.List;

public interface BlogService {

    List<Blog> findAll();
    Blog findOne(Long id);
    Comment addComment(Comment comment, Long blogId);
    Blog addLike(Long blogId);

}
