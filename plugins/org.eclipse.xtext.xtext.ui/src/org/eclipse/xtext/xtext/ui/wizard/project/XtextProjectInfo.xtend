/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project

import java.util.StringTokenizer
import org.eclipse.core.runtime.IPath
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.IWorkingSet
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ui.wizard.IProjectInfo
import org.eclipse.xtext.util.Strings

/**
 * Simple value object class containing all relevant attributes necessary for the creation of new Xtext projects.
 * 
 * @author Michael Clay - Initial contribution and API
 */
@Accessors
class XtextProjectInfo implements IProjectInfo {

	public static final String GENERATOR = 'generator'
	public static final String TESTS = 'tests'
	public static final String IDE = 'ide'
	public static final String SDK = 'sdk'
	public static final String UI = 'ui'
	public static final String WEB = 'web'
	public static final String INTELLIJ = 'idea'

	String projectName
	String languageName
	String fileExtension

	String encoding
	Iterable<IWorkingSet> workingSets
	IWorkbench workbench
	IPath projectsRootLocation

	boolean createTestProject = false
	boolean createUiProject
	boolean createIdeProject
	boolean createIntellijProject
	boolean createWebProject
	boolean createEclipseRuntimeLaunchConfig

	def String getGeneratorProjectName() {
		GENERATOR.asProjectName
	}

	def String getTestProjectName() {
		TESTS.asProjectName
	}

	def String getIdeProjectName() {
		IDE.asProjectName
	}

	def String getFeatureProjectName() {
		SDK.asProjectName
	}

	def String getUiProjectName() {
		UI.asProjectName
	}

	def String getIntellijProjectName() {
		INTELLIJ.asProjectName
	}

	def String getWebProjectName() {
		WEB.asProjectName
	}

	def private String asProjectName(String string) {
		'''�getProjectName�.�string�'''
	}

	def String getBasePackagePath() {
		return getBasePackage().replaceAll("\\.", "/") // $NON-NLS-1$ //$NON-NLS-2$
	}

	def String getBasePackage() {
		var int lastIndexOf = getLanguageName().lastIndexOf(".") // $NON-NLS-1$
		return getLanguageName().substring(0, (if(lastIndexOf === -1) getLanguageName().length() else lastIndexOf ))
	}

	def String getLanguageNameAbbreviation() {
		var String[] packageNames = languageName.split("\\.") // $NON-NLS-1$
		return Strings.toFirstUpper(packageNames.last)
	}

	def String getNsURI() {
		var String[] strings = languageName.split("\\.") // $NON-NLS-1$
		if (strings.length < 2) {
			return '''http://www.�languageName�''' // $NON-NLS-1$
		}
		var String s = '''http://www.�strings.get(1)�.�strings.get(0)�''' // $NON-NLS-1$ //$NON-NLS-2$
		for (var int i = 2; i < strings.length; i++) {
			s += '''/�strings.get(i)�''' // $NON-NLS-1$
		}
		return s
	}

	def String getFirstFileExtension() {
		var String delim = ","
		// $NON-NLS-1$
		if (getFileExtension() !== null && getFileExtension().contains(delim)) {
			var StringTokenizer tokenizer = new StringTokenizer(getFileExtension(), delim, false)
			if(tokenizer.hasMoreTokens()) return tokenizer.nextToken().trim()
		}
		return fileExtension
	}

	def IPath getDslProjectLocation() {
		return projectName.asLocation
	}

	def IPath getUiProjectLocation() {
		return uiProjectName.asLocation
	}

	def IPath getIdeProjectLocation() {
		return ideProjectName.asLocation
	}

	def IPath getTestProjectLocation() {
		return testProjectName.asLocation
	}

	def IPath getFeatureProjectLocation() {
		return featureProjectName.asLocation
	}

	def IPath getIntellijProjectLocation() {
		return intellijProjectName.asLocation
	}

	def IPath getWebProjectLocation() {
		return webProjectName.asLocation
	}

	def asLocation(String projName) {
		projectsRootLocation.append(projName)
	}

	def String getGrammarFilePath() {
		return '''�basePackagePath�/�languageNameAbbreviation�.xtext'''
	}
	
	def String getXtextVersion() {
		'2.9.0.beta2'
	}

}
