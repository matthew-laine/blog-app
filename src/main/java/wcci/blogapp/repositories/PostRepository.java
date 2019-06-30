package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.blogapp.units.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
