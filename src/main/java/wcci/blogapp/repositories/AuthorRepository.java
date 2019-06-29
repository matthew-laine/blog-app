package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.blogapp.units.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
