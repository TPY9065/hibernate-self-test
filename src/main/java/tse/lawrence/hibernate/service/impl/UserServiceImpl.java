package tse.lawrence.hibernate.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tse.lawrence.hibernate.repository.UserWithDynamicUpdateRepository;
import tse.lawrence.hibernate.repository.UserWithEagerFetchRepository;
import tse.lawrence.hibernate.repository.UserWithLazyFetchRepository;
import tse.lawrence.hibernate.repository.UserWithoutDynamicUpdateRepository;
import tse.lawrence.hibernate.service.UserService;


@Service
public class UserServiceImpl implements UserService
{
	private final UserWithDynamicUpdateRepository userWithDynamicUpdateRepository;
	private final UserWithoutDynamicUpdateRepository userWithoutDynamicUpdateRepository;
	private final UserWithEagerFetchRepository userWithEagerFetchRepository;
	private final UserWithLazyFetchRepository userWithLazyFetchRepository;

	public UserServiceImpl(UserWithDynamicUpdateRepository userWithDynamicUpdateRepository,
			UserWithoutDynamicUpdateRepository userWithoutDynamicUpdateRepository,
			UserWithEagerFetchRepository userWithEagerFetchRepository,
			UserWithLazyFetchRepository userWithLazyFetchRepository)
	{
		this.userWithDynamicUpdateRepository = userWithDynamicUpdateRepository;
		this.userWithoutDynamicUpdateRepository = userWithoutDynamicUpdateRepository;
		this.userWithEagerFetchRepository = userWithEagerFetchRepository;
		this.userWithLazyFetchRepository = userWithLazyFetchRepository;
	}

	@Override
	@Transactional
	public void updateWithTransactional(Long id, String name)
	{
		System.out.println("With Transactional...");
		userWithoutDynamicUpdateRepository.findById(id).ifPresent(user -> user.setName(name));
		System.out.println("With Transactional...");
	}

	@Override
	public void updateWithoutTransactional(Long id, String name)
	{
		System.out.println("Without Transactional...");
		userWithoutDynamicUpdateRepository.findById(id).ifPresent(user -> user.setName(name));
		System.out.println("Without Transactional...");
	}

	@Override
	@Transactional
	public void updateWithDynamicUpdate(Long id, String name)
	{
		System.out.println("With Dynamic Update...");
		userWithDynamicUpdateRepository.findById(id).ifPresent(user -> {
			user.setName(name);
			userWithDynamicUpdateRepository.save(user);
		});
		System.out.println("With Dynamic Update...");
	}

	@Override
	@Transactional
	public void updateWithoutDynamicUpdate(Long id, String name)
	{
		System.out.println("Without Dynamic Update...");
		userWithoutDynamicUpdateRepository.findById(id).ifPresent(user -> {
			user.setName(name);
			userWithoutDynamicUpdateRepository.save(user);
		});
		System.out.println("Without Dynamic Update...");
	}

	@Override
	@Transactional(readOnly = true)
	public void publicGetWithEagerFetch(Long id)
	{
		System.out.println("Public Get With Eager Fetch...");
		userWithEagerFetchRepository.findById(id).ifPresent(user -> System.out.println(user.getChildren().size()));
		System.out.println("Public Get With Eager Fetch...");
	}

	@Override
	@Transactional(readOnly = true)
	public void publicGetWithLazyFetch(Long id)
	{
		System.out.println("Public Get With Lazy Fetch...");
		userWithLazyFetchRepository.findById(id).ifPresent(user -> System.out.println(user.getChildren().size()));
		System.out.println("Public Get With Lazy Fetch...");
	}

	@Override
	@Transactional(readOnly = true)
	public void privateGetWithEagerFetch(Long id)
	{
		System.out.println("Private Get With Eager Fetch...");
		getWithEagerFetch(id);
		System.out.println("Private Get With Eager Fetch...");
	}

	@Override
	@Transactional(readOnly = true)
	public void privateGetWithLazyFetch(Long id)
	{
		System.out.println("Private Get With Lazy Fetch...");
		getWithLazyFetch(id);
		System.out.println("Private Get With Lazy Fetch...");
	}

	private void getWithEagerFetch(Long id)
	{
		userWithEagerFetchRepository.findById(id).ifPresent(user -> System.out.println(user.getChildren().size()));
	}

	private void getWithLazyFetch(Long id)
	{
		userWithLazyFetchRepository.findById(id).ifPresent(user -> System.out.println(user.getChildren().size()));
	}
}
