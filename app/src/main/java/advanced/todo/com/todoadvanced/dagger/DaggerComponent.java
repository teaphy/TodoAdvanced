package advanced.todo.com.todoadvanced.dagger;

import dagger.Component;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/14
 */
@Component(modules = {DaggerModule.class})
public interface DaggerComponent {
	void inject(DaggerActivity daggerActivity);
}
