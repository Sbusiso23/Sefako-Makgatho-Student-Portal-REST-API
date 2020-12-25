package org.sefako.makgatho.demo.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@Column(unique = true)
	private String code;
	private int duration;
	
	@ManyToOne()
	@JoinColumn(name = "qualification_id")
	private Qualification qualification;
	
	@ManyToOne()
	@JoinColumn(name = "school_id")
	private School school;
	
	@ManyToMany()
	@JoinTable(name="course_modules", 
		joinColumns = { @JoinColumn(name="course_id")},
		inverseJoinColumns = {@JoinColumn(name="module_id")}	
	)
	private Set<Module> modules;
	
	@OneToMany(mappedBy = "course")
	private Set<StudentCourse> studentCourses;
	
	@ManyToMany(mappedBy = "courses")
	private Set<Lecturer> lecturers;

	public Set<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(Set<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
}