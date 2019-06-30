package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.blogapp.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
