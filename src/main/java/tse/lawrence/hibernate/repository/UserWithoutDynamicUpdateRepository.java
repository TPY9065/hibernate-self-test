package tse.lawrence.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tse.lawrence.hibernate.entity.dynamicinsert.UserWithDynamicUpdate;
import tse.lawrence.hibernate.entity.dynamicinsert.UserWithoutDynamicUpdate;


@Repository
public interface UserWithoutDynamicUpdateRepository extends JpaRepository<UserWithoutDynamicUpdate, Long>
{
}
