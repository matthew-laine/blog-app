package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;

import wcci.blogapp.units.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {

}
