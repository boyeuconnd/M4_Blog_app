package cg.blog.services;

import cg.blog.models.Blog;
import cg.blog.models.Comment;
import cg.blog.repositories.BlogRepository;
import cg.blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public Blog findOne(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Comment addComment(Comment comment, Long blogId) {
        return null;
    }

    @Override
    public Blog addLike(Long blogId) {
        Blog blog = blogRepository.findOne(blogId);
        int likes = blog.getLikes() + 1;
        blog.setLikes( likes  );
        return blogRepository.save(blog);
    }
}
