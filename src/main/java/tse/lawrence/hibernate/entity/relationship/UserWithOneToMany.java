package tse.lawrence.hibernate.entity.relationship;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import tse.lawrence.hibernate.entity.User;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "user_with_one_to_many")
public class UserWithOneToMany extends User
{
	@OneToMany(mappedBy = "user")
	private Set<UserWithManyToOne> users = new HashSet<>();

	public Set<UserWithManyToOne> getUsers()
	{
		return users;
	}

	public void setUsers(Set<UserWithManyToOne> users)
	{
		this.users = users;
	}

	public void addUsers(UserWithManyToOne user)
	{
		this.users.add(user);
		user.setUser(this);
	}
}
