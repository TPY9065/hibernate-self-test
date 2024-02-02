package tse.lawrence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tse.lawrence.hibernate.entity.dynamicinsert.UserWithDynamicUpdate;


@Repository
public interface UserWithDynamicUpdateRepository extends JpaRepository<UserWithDynamicUpdate, Long>
{
}
