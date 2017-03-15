package advanced.todo.com.todoadvanced.dagger;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/14
 */
public class ToBean {
	int id;
	String name;

	public ToBean(int id, String name) {
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
		return "ToBean{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
