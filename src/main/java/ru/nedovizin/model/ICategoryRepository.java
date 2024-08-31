package ru.nedovizin.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  ICategoryRepository extends CrudRepository<CategoryDTO, Long> {
    @Query("FROM Category WHERE categoryId.token = :token")
    List<CategoryDTO> findAllByToken(@Param("token") String token);
}
