package advanced.todo.com.todoadvanced.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Tiany
 * @desc
 * @date 2017/3/9
 */
public class PersonBean implements Parcelable {

	int id;
	String name;
	boolean isMale;

	public PersonBean(int id, String name, boolean isMale) {
		this.id = id;
		this.name = name;
		this.isMale = isMale;
	}

	private PersonBean(Parcel in) {
		id = in.readInt();
		name = in.readString();
		isMale = in.readByte() != 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(name);
		dest.writeByte((byte) (isMale ? 1 : 0));
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<PersonBean> CREATOR = new Creator<PersonBean>() {
		@Override
		public PersonBean createFromParcel(Parcel in) {
			return new PersonBean(in);
		}

		@Override
		public PersonBean[] newArray(int size) {
			return new PersonBean[size];
		}
	};

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

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean male) {
		isMale = male;
	}

	@Override
	public String toString() {
		return "PersonBean{" +
				"id=" + id +
				", name='" + name + '\'' +
				", isMale=" + isMale +
				'}';
	}
}
