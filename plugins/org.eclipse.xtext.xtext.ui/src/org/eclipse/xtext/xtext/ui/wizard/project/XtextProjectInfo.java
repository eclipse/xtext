/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import java.util.StringTokenizer;

import org.eclipse.xtext.ui.core.wizard.IProjectInfo;
import org.eclipse.xtext.util.Strings;

/**
 * Simple value object class containing all relevant attributes necessary for the
 * creation of new Xtext projects.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class XtextProjectInfo implements IProjectInfo{

	private String projectName;
	private String languageName;
	private String fileExtension;
	private String encoding;
	private boolean createGeneratorProject = false;

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	
	public String getEncoding() {
		return encoding;
	}
	
	public boolean isCreateGeneratorProject() {
		return createGeneratorProject;
	}

	public void setCreateGeneratorProject(boolean createGeneratorProject) {
		this.createGeneratorProject = createGeneratorProject;
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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getGeneratorProjectName() {
		return getProjectName() + ".generator";
	}
	
	public String getUiProjectName() {
		return getProjectName() + ".ui";
	}

//	public String getGrammarName() {
//		return getLanguageName().replaceAll("\\s", "_") + ".xtxt";
//	}

	public String getBasePackagePath() {
		return getBasePackage().replaceAll("\\.", "/");
	}
	
	public String getBasePackage() {
		int lastIndexOf = getLanguageName().lastIndexOf(".");
		String result = getLanguageName().substring(0,(lastIndexOf==-1?getLanguageName().length():lastIndexOf));
		return result.toLowerCase();
	}

	public String getLanguageNameAbbreviation() {
		String[] packageNames = languageName.split("\\.");
		return Strings.toFirstUpper(packageNames[packageNames.length - 1]);
	}
	
	public String getNsURI() {
		String[] strings = languageName.split("\\.");
		if (strings.length<2) {
			return "http://www."+languageName;
		}
		String s = "http://www."+strings[1]+"."+strings[0];
		for (int i=2;i<strings.length;i++) {
			s+="/"+strings[i];
		}
		return s;
	}

	/**
	 * @return the firstFileExtension
	 */
	public String getFirstFileExtension() {
		String delim = ",";
		if (getFileExtension() != null && getFileExtension().contains(delim)) {
			StringTokenizer tokenizer = new StringTokenizer(getFileExtension(), delim, false);
			if (tokenizer.hasMoreTokens())
				return tokenizer.nextToken().trim();
		}
		return fileExtension;
	}

	
}
