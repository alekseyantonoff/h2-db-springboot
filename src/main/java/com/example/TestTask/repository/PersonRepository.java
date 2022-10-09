package com.example.TestTask.repository;

import com.example.TestTask.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Основное понятие в Spring Data — это репозиторий. Это несколько интерфейсов которые
 * используют JPA Entity для взаимодействия с ней. Так например интерфейс
 * public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID>
 * обеспечивает основные операции по поиску, сохранения, удалению данных (CRUD операции)
 */

//@Repository — компонент, который предназначен для хранения, извлечения и поиска. Как правило, используется для работы с базами данных.
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

}
