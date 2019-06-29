package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.blogapp.units.PostTag;

public interface PostTagRepository extends CrudRepository<PostTag, Long> {

}
