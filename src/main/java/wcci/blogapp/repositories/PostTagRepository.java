package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.blogapp.models.PostTag;

public interface PostTagRepository extends CrudRepository<PostTag, Long> {

}
