package tse.lawrence.hibernate.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tse.lawrence.hibernate.service.UserService;


@Component
public class ApplicationRunner implements CommandLineRunner
{
	private final UserService userService;

	public ApplicationRunner(UserService userService)
	{
		this.userService = userService;
	}

	@Override
	public void run(String... args) throws Exception
	{
		System.out.println("=================================================== Runner ===================================================");

		userService.updateWithTransactional(1L, "withTransactional");
		System.out.println();
		userService.updateWithoutTransactional(1L, "withoutTransactional");
		System.out.println();
		userService.updateWithDynamicUpdate(1L, "withDynamicUpdate");
		System.out.println();
		userService.updateWithoutDynamicUpdate(1L, "withoutDynamicUpdate");
		System.out.println();
		userService.publicGetWithEagerFetch(1L);
		System.out.println();
		userService.publicGetWithLazyFetch(1L);
		System.out.println();
		userService.privateGetWithEagerFetch(1L);
		System.out.println();
		userService.privateGetWithLazyFetch(1L);

		System.out.println("=================================================== Runner ===================================================");
	}
}
