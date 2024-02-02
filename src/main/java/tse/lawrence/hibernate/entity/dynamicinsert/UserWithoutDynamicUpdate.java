package tse.lawrence.hibernate.entity.dynamicinsert;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import tse.lawrence.hibernate.entity.User;


@Entity
@Table(name = "user_without_dynamic_update")
public class UserWithoutDynamicUpdate extends User
{
}
