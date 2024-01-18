package ru.dnevnik.pohebeyy.dnevnik.repositiry;

import org.springframework.data.repository.CrudRepository;
import ru.dnevnik.pohebeyy.dnevnik.models.Post;

public interface PostGrade extends CrudRepository<Post,Long> {

}
