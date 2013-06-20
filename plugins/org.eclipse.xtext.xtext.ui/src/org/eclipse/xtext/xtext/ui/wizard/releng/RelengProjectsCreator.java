/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.releng;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.xtext.ui.util.FeatureProjectFactory;
import org.eclipse.xtext.ui.wizard.AbstractProjectCreator;
import org.eclipse.xtext.xtext.ui.wizard.releng.templates.SiteSpexCreator;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Creates two projects:<br>
 * - namespace.buckminster (buckminster)<br>
 * - namespace.site (feature)<br>
 * 
 * @author Dennis Huebner - Initial contribution and API
 */
public class RelengProjectsCreator extends AbstractProjectCreator {
	@Inject
	private Provider<FeatureProjectFactory> featureProjFactoryProvider;

	@Inject
	private Provider<RelengProjectFactory> relengProjFactoryProvider;

	@Override
	protected RelengProjectInfo getProjectInfo() {
		return (RelengProjectInfo) super.getProjectInfo();
	}

	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, getCreateModelProjectMessage(), 2);

		IProject project = createRelengProject(subMonitor.newChild(1));

		createSiteFeatureProject(subMonitor.newChild(1));

		IFile antBuildScript = project.getFile(new Path(RelengProjectFactory.BUILD_FILE_NAME)); //$NON-NLS-1$
		BasicNewResourceWizard.selectAndReveal(antBuildScript, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		setResult(antBuildScript);
	}

	private IProject createRelengProject(SubMonitor monitor) {
		RelengProjectFactory factory = createProjectFactory();
		factory.setRelengProjectInfo(getProjectInfo());
		return factory.createProject(monitor, null);
	}

	private IProject createSiteFeatureProject(SubMonitor monitor) {
		FeatureProjectFactory factory = createFeatureFactory();
		configureFeatureProjectFactory(factory);
		String nameSpaceAbbreviation = getProjectInfo().calculateNameSpaceAbbreviation();
		return factory.withCategoryFile(nameSpaceAbbreviation).createProject(monitor, null);
	}

	private void configureFeatureProjectFactory(FeatureProjectFactory factory) {
		factory.setProjectName(getProjectInfo().getSiteFeatureProjectName());
		factory.addProjectNatures("org.eclipse.pde.FeatureNature");
		factory.addBuilderIds("org.eclipse.pde.FeatureBuilder");
		factory.addFeature(getProjectInfo().getBuildFeatureName());
		factory.addContributor(new SiteSpexCreator(getProjectInfo()));
	}

	@Override
	protected RelengProjectFactory createProjectFactory() {
		return relengProjFactoryProvider.get();
	}

	private FeatureProjectFactory createFeatureFactory() {
		return featureProjFactoryProvider.get();
	}

	@Override
	protected String getModelFolderName() {
		return null;
	}

	@Override
	protected List<String> getAllFolders() {
		return null;
	}

}
