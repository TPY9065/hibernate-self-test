package tse.lawrence.hibernate.service;

import org.springframework.stereotype.Service;


@Service
public interface UserService
{
	void updateWithTransactional(Long id, String name);
	void updateWithoutTransactional(Long id, String name);

	void updateWithDynamicUpdate(Long id, String name);
	void updateWithoutDynamicUpdate(Long id, String name);

	void publicGetWithEagerFetch(Long id);
	void publicGetWithLazyFetch(Long id);

	void privateGetWithEagerFetch(Long id);
	void privateGetWithLazyFetch(Long id);
}
