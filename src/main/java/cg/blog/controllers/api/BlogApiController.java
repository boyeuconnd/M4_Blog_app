package cg.blog.controllers.api;

import cg.blog.models.Blog;
import cg.blog.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class BlogApiController {

    @Autowired
    private BlogService blogService;

    @PutMapping("/{id}/likes")
    public Blog addLikeBlog(@PathVariable Long id) {
        Blog blog = blogService.addLike(id);
        return blog;
    }
}
