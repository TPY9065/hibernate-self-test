package tse.lawrence.hibernate.entity.dynamicinsert;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import tse.lawrence.hibernate.entity.User;


@Entity
@Table(name = "user_with_dynamic_update")
@DynamicUpdate
public class UserWithDynamicUpdate extends User
{
}
