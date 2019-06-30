package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.blogapp.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
