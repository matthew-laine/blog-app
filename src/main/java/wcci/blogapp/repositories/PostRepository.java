package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.blogapp.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

}
