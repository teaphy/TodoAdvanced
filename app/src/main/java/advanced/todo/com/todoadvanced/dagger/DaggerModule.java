package advanced.todo.com.todoadvanced.dagger;

import com.google.gson.Gson;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import dagger.Module;
import dagger.Provides;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/14
 */
@Module
public class DaggerModule {

	public DaggerModule() {
	}

	@Provides
	public Gson provideGlide() {
		return new Gson();
	}

	@Provides
	public ToBean provideDaggerBean(int id, String name) {
		return new ToBean(id, name);
	}
}
