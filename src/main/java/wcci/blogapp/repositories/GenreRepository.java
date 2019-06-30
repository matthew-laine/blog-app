package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.blogapp.models.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

}
