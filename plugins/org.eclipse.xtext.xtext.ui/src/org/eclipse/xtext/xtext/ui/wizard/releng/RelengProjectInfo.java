/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.ui.wizard.DefaultProjectInfo;
import org.eclipse.xtext.util.Strings;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class RelengProjectInfo extends DefaultProjectInfo {

	private String buildFeatureName;
	private String siteFeatureName;
	private String projectNameSpace;
	private String buckyLocation;
	private List<String> preCompileLaunchers = new ArrayList<String>();
	private List<IFile> testLaunchers = new ArrayList<IFile>();
	private String buildFeatureLabel;

	public List<IFile> getTestLaunchers() {
		return testLaunchers;
	}

	public void addTestLauncher(IFile iFile) {
		testLaunchers.add(iFile);
	}

	public void setBuildFeatureName(String featureProjectName) {
		this.buildFeatureName = featureProjectName;
	}

	public String getBuildFeatureName() {
		return buildFeatureName;
	}

	public String getSiteFeatureName() {
		return siteFeatureName;
	}

	public void setSiteFeatureName(String siteFeatureName) {
		this.siteFeatureName = siteFeatureName;
	}

	public String getProjectNameSpace() {
		return projectNameSpace;
	}

	public void setNamespace(String projectNameSpace) {
		this.projectNameSpace = projectNameSpace;

	}

	public String getBuckyLocation() {
		return buckyLocation;
	}

	public void setBuckyLocation(String buckyLocation) {
		this.buckyLocation = buckyLocation;
	}

	public void addPreCompileLauncher(String wsRelativePath) {
		preCompileLaunchers.add(wsRelativePath);
	}

	public List<String> getPreCompileLaunchers() {
		return preCompileLaunchers;
	}

	public void setBuildFeatureLabel(String buildFeatureLabel) {
		this.buildFeatureLabel = buildFeatureLabel;
	}

	public String getBuildFeatureLabel() {
		return buildFeatureLabel;
	}

	public String getNameSpaceAbbreviation() {
		String[] packageNames = getProjectNameSpace().split("\\."); //$NON-NLS-1$
		return Strings.toFirstUpper(packageNames[packageNames.length - 1]);
	}
}
