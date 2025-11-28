package model;

import java.util.Date;

public class User {
	String fullname;
	String gender;
	String married;
	Date birthday;
	String country;
	String[] hobbies;
	String avatar;
	String note;

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User(String fullname, String gender, String married, Date birthday, String country, String[] hobbies,
			String avatar, String note) {

		this.fullname = fullname;
		this.gender = gender;
		this.married = married;
		this.birthday = birthday;
		this.country = country;
		this.hobbies = hobbies;
		this.avatar = avatar;
		this.note = note;
	}

	public User() {

	}

}
