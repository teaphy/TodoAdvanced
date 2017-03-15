package advanced.todo.com.todoadvanced.dagger;

import javax.inject.Inject;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/14
 */
public class DaggerBean {

	private int id;
	private String name;

	@Inject
	public DaggerBean() {
	}

	public DaggerBean(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DaggerBean{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
