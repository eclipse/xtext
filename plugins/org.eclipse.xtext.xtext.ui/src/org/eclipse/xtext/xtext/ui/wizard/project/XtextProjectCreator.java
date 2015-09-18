/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.project;

import static com.google.common.collect.Sets.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;
import org.eclipse.xtext.ui.util.JavaProjectFactory;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.ui.util.ProjectFactory;
import org.eclipse.xtext.ui.wizard.IProjectCreator;
import org.eclipse.xtext.ui.wizard.IProjectInfo;
import org.eclipse.xtext.xtext.wizard.Outlet;
import org.eclipse.xtext.xtext.wizard.ProjectDescriptor;
import org.eclipse.xtext.xtext.wizard.TextFile;
import org.eclipse.xtext.xtext.wizard.WizardConfiguration;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class XtextProjectCreator extends WorkspaceModifyOperation implements IProjectCreator {
	
	@Inject
	private Provider<PluginProjectFactory> pluginProjectProvider;
	@Inject
	private Provider<JavaProjectFactory> javaProjectProvider;
	@Inject
	private Provider<ProjectFactory> plainProjectProvider;
	
	private XtextProjectInfo projectInfo;
	Map<ProjectDescriptor, IProject> createdProjects = Maps.newHashMap();
	private IFile result;

	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, getCreateModelProjectMessage(), getMonitorTicks());
		for (ProjectDescriptor descriptor : projectInfo.getEnabledProjects()) {
			IProject project = createProject(descriptor, SubMonitor.convert(subMonitor, 1));
			createdProjects.put(descriptor, project);
		}
		
		IProject runtimeProject = createdProjects.get(projectInfo.getRuntimeProject());
		IFile dslGrammarFile = runtimeProject.getFile(getModelFolderName() + "/" + projectInfo.getRuntimeProject().getGrammarFilePath());
		BasicNewResourceWizard.selectAndReveal(dslGrammarFile, PlatformUI.getWorkbench().getActiveWorkbenchWindow());
		result = dslGrammarFile;
	}

	private IProject createProject(ProjectDescriptor descriptor, SubMonitor monitor) {
		if (isPluginProject(descriptor)) {
			return createPluginProject(descriptor, monitor);
		} else if (isJavaProject(descriptor)) {
			return createJavaProject(descriptor, monitor);
		} else {
			return createPlainProject(descriptor, monitor);
		}
	}

	private IProject createPluginProject(ProjectDescriptor descriptor, SubMonitor monitor) {
		PluginProjectFactory factory = pluginProjectProvider.get();
		configureJavaProject(descriptor, factory);
		factory.addProjectNatures("org.eclipse.pde.PluginNature");
		factory.addBuilderIds("org.eclipse.pde.ManifestBuilder", "org.eclipse.pde.SchemaBuilder");
		factory.addDevelopmentTimeBundles(Lists.newArrayList(descriptor.getDevelopmentBundles()));
		factory.addImportedPackages(Lists.newArrayList(descriptor.getImportedPackages()));
		factory.addRequiredBundles(Lists.newArrayList(descriptor.getRequiredBundles()));
		factory.setBreeToUse(descriptor.getBree());
		return factory.createProject(monitor, null);
	}

	private IProject createJavaProject(ProjectDescriptor descriptor, SubMonitor monitor) {
		JavaProjectFactory factory = javaProjectProvider.get();
		configureJavaProject(descriptor, factory);
		return factory.createProject(monitor, null);
	}

	private void configureJavaProject(ProjectDescriptor descritpor, JavaProjectFactory factory) {
		configurePlainProject(descritpor, factory);
		factory.addProjectNatures(XtextProjectHelper.NATURE_ID);
		factory.addBuilderIds(XtextProjectHelper.BUILDER_ID);
		factory.addProjectNatures(JavaCore.NATURE_ID);
		factory.addBuilderIds(JavaCore.BUILDER_ID);
		factory.addFolders(Lists.newArrayList(descritpor.getSourceFolders()));
	}
	
	private IProject createPlainProject(ProjectDescriptor descriptor, SubMonitor monitor) {
		ProjectFactory factory = plainProjectProvider.get();
		configurePlainProject(descriptor, factory);
		return factory.createProject(monitor, null);
	}

	private void configurePlainProject(ProjectDescriptor descriptor, ProjectFactory factory) {
		factory.setProjectName(descriptor.getName());
		factory.setLocation(new Path(descriptor.getLocation()));
		factory.setProjectDefaultCharset(projectInfo.getEncoding().toString());
		factory.addWorkingSets(Lists.newArrayList(projectInfo.getWorkingSets()));
		factory.addContributor(new DescriptorBasedContributor(descriptor));
	}
	
	private class DescriptorBasedContributor implements IProjectFactoryContributor {
		private ProjectDescriptor descriptor;
		
		public DescriptorBasedContributor(ProjectDescriptor descriptor) {
			this.descriptor = descriptor;
		}

		@Override
		public void contributeFiles(IProject project, IFileCreator fileWriter) {
			for (TextFile file : descriptor.getFiles()) {
				if (!isFiltered(file)) {
					WizardConfiguration config = descriptor.getConfig();
					String path = config.getSourceLayout().getPathFor(file.getOutlet()) + "/" + file.getRelativePath();
					fileWriter.writeToFile(file.getContent(), path);
				}
			}
		}
		
		private boolean isFiltered(TextFile file) {
			if (isPluginProject(descriptor)) {
				return newHashSet("plugin.xml", "MANIFEST.MF").contains(file.getRelativePath());
			}
			return false;
		}
	}
	
	private boolean isPluginProject(ProjectDescriptor descriptor) {
		return descriptor.isEclipsePluginProject();
	}
	
	private boolean isJavaProject(ProjectDescriptor descriptor) {
		return !descriptor.getSourceFolders().isEmpty();
	}
	
	private int getMonitorTicks() {
		return projectInfo.getEnabledProjects().size();
	}

	private String getCreateModelProjectMessage() {
		return Messages.XtextProjectCreator_CreatingProjectsMessage2 + projectInfo.getProjectName();
	}

	protected String getModelFolderName() {
		return projectInfo.getSourceLayout().getPathFor(Outlet.MAIN_RESOURCES);
	}

	@Override
	public void setProjectInfo(IProjectInfo projectInfo) {
		this.projectInfo = (XtextProjectInfo) projectInfo;
	}

	@Override
	public IFile getResult() {
		return result;
	}

}