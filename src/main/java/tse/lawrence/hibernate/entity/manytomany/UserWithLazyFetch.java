package tse.lawrence.hibernate.entity.manytomany;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.DynamicUpdate;
import tse.lawrence.hibernate.entity.User;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "user_with_lazy_fetch")
@DynamicUpdate
public class UserWithLazyFetch extends User
{
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "parent_child_lazy",
			joinColumns = { @JoinColumn(name = "parent_id") }, inverseJoinColumns = { @JoinColumn(name = "child_id") })
	private final List<UserWithLazyFetch> children = new ArrayList<>();

	public List<UserWithLazyFetch> getChildren()
	{
		return children;
	}
}
