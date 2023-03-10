/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor.IFileCreator;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Sebastian Zarnekow
 * @author Arne Deutsch - Added getters for better usability from Xtend
 */
public class ProjectFactory {

	private static final Logger logger = Logger.getLogger(ProjectFactory.class);

	@Inject(optional = true)
	protected IWorkbench workbench;

	@Inject
	protected IWorkspace workspace;

	protected String projectName;
	protected IPath location;
	protected List<String> folders;
	protected List<IProject> referencedProjects;
	protected List<String> projectNatures;
	protected List<String> builderIds;
	protected List<IWorkingSet> workingSets;
	/**
	 * @since 2.4
	 */
	protected String defaultCharset;

	private List<IProjectFactoryContributor> contributors;

	private List<IProjectFactoryContributor> earlyContributors;

	public void setWorkbench(IWorkbench workbench) {
		this.workbench = workbench;
	}
	
	public void setWorkspace(IWorkspace workspace) {
		this.workspace = workspace;
	}
	
	public ProjectFactory addBuilderIds(String... builderIds) {
		this.getBuilderIds().addAll(Arrays.asList(builderIds));
		return this;
	}
	
	/**
	 * @since 2.14
	 */
	public List<String> getBuilderIds() {
		if (this.builderIds == null)
			this.builderIds = Lists.newArrayList();
		return builderIds;
	}

	public ProjectFactory addProjectNatures(String... projectNatures) {
		getProjectNatures().addAll(Arrays.asList(projectNatures));
		return this;
	}
	
	/**
	 * @since 2.14
	 */
	public List<String> getProjectNatures() {
		if (this.projectNatures == null)
			this.projectNatures = Lists.newArrayList();
		return projectNatures;
	}

	public ProjectFactory setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}

	public ProjectFactory setLocation(IPath location) {
		this.location = location;
		return this;
	}

	public ProjectFactory addFolders(List<String> folders) {
		this.getFolders().addAll(folders);
		return this;
	}
	
	/**
	 * @since 2.14
	 */
	public List<String> getFolders() {
		if (this.folders == null)
			this.folders = Lists.newArrayList();
		return folders;
	}

	public ProjectFactory addReferencedProjects(List<IProject> referencedProjects) {
		this.getReferencedProjects().addAll(referencedProjects);
		return this;
	}
	
	/**
	 * @since 2.14
	 */
	public List<IProject> getReferencedProjects() {
		if (this.referencedProjects == null)
			this.referencedProjects = Lists.newArrayList();
		return referencedProjects;
	}

	public ProjectFactory addWorkingSets(List<IWorkingSet> workingSets) {
		this.getWorkingSets().addAll(workingSets);
		return this;
	}
	
	/**
	 * @since 2.14
	 */
	public List<IWorkingSet> getWorkingSets() {
		if (this.workingSets == null)
			this.workingSets = Lists.newArrayList();
		return workingSets;
	}

	/**
	 * @since 2.3
	 */
	public void addContributor(IProjectFactoryContributor projectFactoryContributor) {
		if (this.contributors == null) {
			contributors = Lists.newArrayList();
		}
		contributors.add(projectFactoryContributor);
	}

	/**
	 * These contributors will be executed before enhancing the project.
	 * 
	 * @since 2.10
	 */
	public void addEarlyContributor(IProjectFactoryContributor projectFactoryContributor) {
		if (this.earlyContributors == null) {
			earlyContributors = Lists.newArrayList();
		}
		earlyContributors.add(projectFactoryContributor);
	}

	/**
	 * @since 2.4
	 */
	public void setProjectDefaultCharset(String encoding) {
		this.defaultCharset = encoding;
	}

	public IProject createProject(IProgressMonitor monitor, Shell shell) {
		final SubMonitor subMonitor = SubMonitor.convert(monitor, 10);
		try {
			final IProjectDescription description = createProjectDescription();
			subMonitor.subTask(Messages.ProjectFactory_0 + description.getName());
			final IProject project = workspace.getRoot().getProject(projectName);
			if (!deleteExistingProject(project, shell, subMonitor)) {
				return null;
			}

			project.create(description, subMonitor.newChild(1));
			project.open(subMonitor.newChild(1));
			project.setDescription(description, subMonitor.newChild(1));
			project.setDefaultCharset(defaultCharset, subMonitor.newChild(1));
			createFolders(project, subMonitor, shell);

			IFileCreator fileCreator = new IFileCreator() {
				@Override
				public IFile writeToFile(CharSequence chars, String fileName) {
					return ProjectFactory.this.writeToFile(chars, fileName, project, subMonitor);
				}
			};

			runContributors(earlyContributors, project, fileCreator);
			enhanceProject(project, subMonitor, shell);
			runContributors(contributors, project, fileCreator);

			return project;
		} catch (final CoreException exception) {
			logger.error(exception.getMessage(), exception);
			return null;
		} finally {
			subMonitor.done();
		}
	}

	/**
	 * @since 2.10
	 */
	protected void runContributors(List<IProjectFactoryContributor> contribs, final IProject project, IFileCreator fileCreator) {
		if (contribs != null) {
			for (IProjectFactoryContributor contributor : contribs) {
				contributor.contributeFiles(project, fileCreator);
			}
		}
	}

	protected void createFolders(IProject project, SubMonitor subMonitor, Shell shell) throws CoreException {
		if (folders != null) {
			for (final String folderName : folders) {
				final IFolder folder = project.getFolder(folderName);
				if (!folder.exists()) {
					createRecursive(folder);
				}
			}
		}
	}

	protected void enhanceProject(final IProject project, final SubMonitor subMonitor, Shell shell)
			throws CoreException {
		if (workbench != null && workingSets != null) {
			workbench.getWorkingSetManager().addToWorkingSets(project,
					workingSets.toArray(new IWorkingSet[workingSets.size()]));
		}

	}

	protected boolean deleteExistingProject(IProject project, final Shell theShell, SubMonitor subMonitor)
			throws CoreException {
		// Clean up any old project information.
		if (project.exists()) {
			final boolean[] result = new boolean[1];
			if (workbench != null && theShell != null) {
				workbench.getDisplay().syncExec(new Runnable() {
					@Override
					public void run() {
						result[0] = MessageDialog.openQuestion(theShell, Messages.ProjectFactory_1 + projectName,
								Messages.ProjectFactory_2 + projectName + Messages.ProjectFactory_3);
					}
				});
			} else {
				result[0] = true;
			}
			if (result[0]) {
				project.delete(true, true, subMonitor.newChild(1));
			} else {
				return false;
			}
		}
		return true;
	}

	protected IProjectDescription createProjectDescription() {
		final IProjectDescription projectDescription = workspace.newProjectDescription(projectName);
		if (location != null && !Platform.getLocation().equals(location.removeLastSegments(1))) {
			projectDescription.setLocation(location);
		}

		if (referencedProjects != null && referencedProjects.size() != 0) {
			projectDescription
					.setReferencedProjects(referencedProjects.toArray(new IProject[referencedProjects.size()]));
		}
		if (projectNatures != null)
			projectDescription.setNatureIds(projectNatures.toArray(new String[projectNatures.size()]));
		if (builderIds != null)
			setBuilder(projectDescription, builderIds.toArray(new String[builderIds.size()]));
		return projectDescription;
	}

	protected void setBuilder(final IProjectDescription projectDescription, final String[] builders) {
		List<ICommand> commands = Lists.newArrayList();
		for (int i = 0; i < builders.length; i++) {
			ICommand command = projectDescription.newCommand();
			command.setBuilderName(builders[i]);
			commands.add(command);
		}
		projectDescription.setBuildSpec(commands.toArray(new ICommand[commands.size()]));
	}

	protected IFile createFile(final String name, final IContainer container, final String content,
			final IProgressMonitor progressMonitor) {
		final IFile file = container.getFile(new Path(name));
		createRecursive(file.getParent());
		SubMonitor subMonitor = SubMonitor.convert(progressMonitor, 1);
		try {
			final InputStream stream = new ByteArrayInputStream(content.getBytes(file.getCharset()));
			if (file.exists()) {
				logger.debug("Overwriting content of '" + file.getFullPath() + "'");
				file.setContents(stream, true, true, subMonitor.newChild(1));
			} else {
				file.create(stream, true, subMonitor.newChild(1));
			}
			stream.close();
		} catch (final Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			subMonitor.done();
		}
		return file;
	}

	/**
	 * 
	 * Shortcut method to be used with Xtend rich strings
	 * 
	 * @since 2.3
	 */
	protected IFile writeToFile(CharSequence chrSeq, String fileName, IProject project, IProgressMonitor progrMonitor) {
		return createFile(fileName, project, chrSeq.toString(), progrMonitor);
	}

	protected void createRecursive(final IContainer resource) {
		if (!resource.exists()) {
			if (!resource.getParent().exists()) {
				createRecursive(resource.getParent());
			}
			if (resource instanceof IFolder) {
				try {
					((IFolder) resource).create(false, true, new NullProgressMonitor());
				} catch (CoreException e) {
					logger.error(e.getMessage(), e);
				}
			}
		}
	}
}
