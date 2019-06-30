package wcci.blogapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wcci.blogapp.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {

}
