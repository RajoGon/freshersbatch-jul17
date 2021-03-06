package com.springtest.hibernate.entity.onetomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="EmployeeManager")
public class EmployeeManager {
	
	
	@Id
	@GeneratedValue
	@Column(name="eid")
	private long eid;
	public EmployeeManager(String name) {
		super();
		this.name = name;
	}

	@Column(name="ename")
	private String name;
	
	

	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="mid")
	private EmployeeManager manager;
	
	@OneToMany(mappedBy="manager")
	private Set<EmployeeManager> underManager = new HashSet<>();

	public long getEid() {
		return eid;
	}

	@Override
	public String toString() {
		return "EmployeeManager [eid=" + eid + ", name=" + name + ", manager=" + manager + "]";
	}

	public EmployeeManager() {
		super();
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EmployeeManager getManager() {
		return manager;
	}

	public void setManager(EmployeeManager manager) {
		this.manager = manager;
	}

	public Set<EmployeeManager> getUnderManager() {
		return underManager;
	}

	public void setUnderManager(Set<EmployeeManager> underManager) {
		this.underManager = underManager;
	}

	public EmployeeManager(long eid, String name, EmployeeManager manager, Set<EmployeeManager> underManager) {
		super();
		this.eid = eid;
		this.name = name;
		this.manager = manager;
		this.underManager = underManager;
	}

	public EmployeeManager(String name, EmployeeManager manager, Set<EmployeeManager> underManager) {
		super();
		this.name = name;
		this.manager = manager;
		this.underManager = underManager;
	}

	public EmployeeManager(long eid, String name, EmployeeManager manager) {
		super();
		this.eid = eid;
		this.name = name;
		this.manager = manager;
	}

	public EmployeeManager(String name, EmployeeManager manager) {
		super();
		this.name = name;
		this.manager = manager;
	}
	
}
