package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.blogapp.models.PostTag;

@Repository
public interface PostTagRepository extends CrudRepository<PostTag, Long> {

}
