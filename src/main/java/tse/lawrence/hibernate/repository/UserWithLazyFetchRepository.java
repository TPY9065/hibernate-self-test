package tse.lawrence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tse.lawrence.hibernate.entity.manytomany.UserWithLazyFetch;


@Repository
public interface UserWithLazyFetchRepository extends JpaRepository<UserWithLazyFetch, Long>
{
}
