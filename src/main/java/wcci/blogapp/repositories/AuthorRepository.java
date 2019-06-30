package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.blogapp.models.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
