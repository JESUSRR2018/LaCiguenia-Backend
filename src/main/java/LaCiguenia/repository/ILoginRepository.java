package LaCiguenia.repository;

import LaCiguenia.commons.domains.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILoginRepository extends JpaRepository<LoginEntity, Integer> {
    @Override
    Optional<LoginEntity> findById(Integer integer);
}