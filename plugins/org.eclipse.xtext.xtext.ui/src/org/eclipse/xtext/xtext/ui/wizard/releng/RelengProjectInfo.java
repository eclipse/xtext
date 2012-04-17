/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.xtext.ui.wizard.DefaultProjectInfo;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class RelengProjectInfo extends DefaultProjectInfo {

	private String buildFeatureName;
	private String projectNameSpace;
	private String buckyLocation;
	private String siteFeatureProjectName;

	private List<IFile> testLaunchers = Lists.newArrayList();
	private List<String> preCompileLaunchers = Lists.newArrayList();

	public String getBuildFeatureName() {
		return buildFeatureName;
	}

	public void setBuildFeatureName(String featureProjectName) {
		this.buildFeatureName = featureProjectName;
		this.projectNameSpace = calculateProjectNamespace(featureProjectName);
	}

	public String getBuckyLocation() {
		return buckyLocation;
	}

	public void setBuckyLocation(String buckyLocation) {
		this.buckyLocation = buckyLocation;
	}

	public String calculateNameSpaceAbbreviation() {
		String[] packageNames = getProjectNameSpace().split("\\."); //$NON-NLS-1$
		return Strings.toFirstUpper(packageNames[packageNames.length - 1]);
	}

	public List<IFile> getTestLaunchers() {
		return testLaunchers;
	}

	public void addTestLauncher(IFile iFile) {
		if (iFile == null) {
			throw new NullPointerException();
		}
		testLaunchers.add(iFile);
	}

	public List<String> getPreCompileLaunchers() {
		return preCompileLaunchers;
	}

	public void addPreCompileLauncher(String wsRelativePath) {
		if (wsRelativePath == null) {
			throw new NullPointerException();
		}
		preCompileLaunchers.add(wsRelativePath);
	}

	public String getProjectNameSpace() {
		return projectNameSpace;
	}

	public String getSiteFeatureProjectName() {
		return siteFeatureProjectName;
	}

	public void setSiteFeatureProjectName(String siteFeatureProjectName) {
		this.siteFeatureProjectName = siteFeatureProjectName;
	}

	private String calculateProjectNamespace(String featureProjectName) {
		return cutLastSegment(featureProjectName);
	}

	private String cutLastSegment(final String fqn) {
		String nameSpace = fqn;
		if (nameSpace != null) {
			int lastIndexOfDot = nameSpace.lastIndexOf('.');
			if (lastIndexOfDot > 0) {
				nameSpace = nameSpace.substring(0, lastIndexOfDot);
			}
		}
		return nameSpace;
	}

}
