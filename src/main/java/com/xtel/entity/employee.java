package com.xtel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class employee {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "age")
	private int age;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "id_card", unique = true)
	private String id_card;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "date_start_work")
	private String date_start_work;

	@Column(name = "date_do_work_official")
	private String date_do_work_official;

	@Column(name = "date_end_work")
	private String date_end_work;

	@Column(name = "status")
	private String status;

	@Column(name = "position")
	private String position;

	public employee() {
		// TODO Auto-generated constructor stub
	}

	public employee(String id, String name, String phone, int age, String address, String email, String id_card,
			String username, String password, String date_start_work, String date_do_work_official,
			String date_end_work, String status, String position) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.address = address;
		this.email = email;
		this.id_card = id_card;
		this.username = username;
		this.password = password;
		this.date_start_work = date_start_work;
		this.date_do_work_official = date_do_work_official;
		this.date_end_work = date_end_work;
		this.status = status;
		this.position = position;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId_card() {
		return id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDate_start_work() {
		return date_start_work;
	}

	public void setDate_start_work(String date_start_work) {
		this.date_start_work = date_start_work;
	}

	public String getDate_do_work_official() {
		return date_do_work_official;
	}

	public void setDate_do_work_official(String date_do_work_official) {
		this.date_do_work_official = date_do_work_official;
	}

	public String getDate_end_work() {
		return date_end_work;
	}

	public void setDate_end_work(String date_end_work) {
		this.date_end_work = date_end_work;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "employees [id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + ", address=" + address
				+ ", email=" + email + ", id_card=" + id_card + ", username=" + username + ", password=" + password
				+ ", date_start_work=" + date_start_work + ", date_do_work_official=" + date_do_work_official
				+ ", date_end_work=" + date_end_work + ", status=" + status + ", position=" + position + "]";
	}

}
