package com.ncode.htcexercise;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Objects;

/*
+------------------------------------------------------------+
 | Module Name: Project	                                     |
 | Module Purpose: Create project details                    |
 | Inputs:                                                   |
 | Outputs: 					                             |
 | Throws: 	                                                 |
 | Created:	03/24/2018                                       |
 | Author: 	                                                 |
 | Revisions:                                                |
+------------------------------------------------------------+
*/

public class Project implements Serializable {


	private static final long serialVersionUID = 3084894280628663868L;
	private String projectId;
	private String projectName;
	private String projectHead;
	private int noOfResources;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectHead() {
		return projectHead;
	}

	public void setProjectHead(String projectHead) {
		this.projectHead = projectHead;
	}

	public int getNoOfResources() {
		return noOfResources;
	}

	public void setNoOfResources(int noOfResources) {
		this.noOfResources = noOfResources;
	}

	@Override
	public int hashCode() {

		return Objects.hash(projectId, projectName, projectHead, noOfResources);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;

		return Objects.equals(projectId, other.projectId) && Objects.equals(projectName, other.projectName)
				&& Objects.equals(projectHead, other.projectHead) && Objects.equals(noOfResources, other.noOfResources);
	}

	// print Project instance's fields.
	public void printProject(Project proIns)
			throws IllegalArgumentException, IllegalAccessException, NullPointerException {

		for (Field field : proIns.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			String name = field.getName();
			Object value = field.get(proIns);
			System.out.printf("%s: %s%n", name, value);
		}
	}

	
	public static void main(String[] args) {
		
		Project projectOne = new Project();
		
		projectOne.setProjectId("DIS2001");
		projectOne.setProjectName("FSDDataMart");
		projectOne.setProjectHead("Ron");
		projectOne.setNoOfResources(4);
		
		try {
		projectOne.printProject(projectOne);
		}
		catch(IllegalArgumentException | IllegalAccessException | NullPointerException e){
			System.out.println("Inside specific exception handling part. \n");
			System.out.println(e);
		}
	}
}
