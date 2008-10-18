/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

/**
 * Simple valueobject class containing all relevant attributes necessary for the
 * creation of new Xtext projects.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class XtextProjectInfo {

	private String projectName;
	private String languageName;
	private String fileExtension;
	private String nsURI;
	private String basePackage;
	private boolean createGeneratorProject = false;

	public boolean isCreateGeneratorProject() {
		return createGeneratorProject;
	}

	public void setCreateGeneratorProject(boolean createGeneratorProject) {
		this.createGeneratorProject = createGeneratorProject;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getNsURI() {
		return nsURI;
	}

	public void setNsURI(String nsURI) {
		this.nsURI = nsURI;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getGrammarName() {
		return getLanguageName().replaceAll("\\s", "_") + ".xtxt";
	}

	public String getBasePath() {
		return getBasePackage().replaceAll("\\.", "/");
	}

	public String getLanguageNameAbbreviation() {
		String[] packageNames = languageName.split("\\.");
		return packageNames[packageNames.length - 1];
	}

}
