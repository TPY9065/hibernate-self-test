package tse.lawrence.hibernate.entity.relationship;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tse.lawrence.hibernate.entity.User;


@Entity
@Table(name = "user_with_many_to_one")
public class UserWithManyToOne extends User
{
	@ManyToOne
	private UserWithOneToMany user;

	public UserWithOneToMany getUser()
	{
		return user;
	}

	public void setUser(UserWithOneToMany user)
	{
		this.user = user;
	}
}
