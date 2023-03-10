/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.ProjectFactory;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public abstract class AbstractProjectCreator extends WorkspaceModifyOperation implements IProjectCreator {
	
	private IFile result;
	private IProjectInfo projectInfo;
	
	@Inject
	@Named("file.extensions")
	private String fileExtension;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IFile getResult() {
		return result;
	}
	
	protected void setResult(IFile result) {
		this.result = result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProjectInfo(IProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}
	
	protected IProjectInfo getProjectInfo() {
		return projectInfo;
	}
	
	protected String getEncoding() throws CoreException {
		return ResourcesPlugin.getWorkspace().getRoot().getDefaultCharset();
	}
	
	@Override
	protected void execute(final IProgressMonitor monitor)
			throws CoreException, InvocationTargetException, InterruptedException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 
				getCreateModelProjectMessage(), 
				2);
		try {
			final IProject project = createProject(subMonitor.newChild(1));
			if (project == null)
				return;
			enhanceProject(project, subMonitor.newChild(1));
			IFile modelFile = getModelFile(project);
			setResult(modelFile);
		} finally {
			subMonitor.done();
		}
	}

	protected String getCreateModelProjectMessage() {
		return Messages.AbstractProjectCreator_0 + getProjectInfo().getProjectName();
	}
	
	protected IFile getModelFile(IProject project) throws CoreException {
		IFolder srcFolder = project.getFolder(getModelFolderName());
		final String expectedExtension = getPrimaryModelFileExtension();
		final IFile[] result = new IFile[1];
		srcFolder.accept(new IResourceVisitor() {
			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (IResource.FILE == resource.getType() && expectedExtension.equals(resource.getFileExtension())) {
					result[0] = (IFile) resource;
					return false;
				}
				return IResource.FOLDER == resource.getType();
			}
		});
		return result[0];
	}
	
	protected IProject createProject(IProgressMonitor monitor) {
		ProjectFactory factory = createProjectFactory();
		configureProjectBuilder(factory);
		return factory.createProject(monitor, null);
	}
	
	/**
	 * @deprecated use {@link #configureProjectFactory(ProjectFactory)} instead.
	 */
	@Deprecated
	protected ProjectFactory configureProjectBuilder(ProjectFactory factory) {
		return configureProjectFactory(factory);
	}

	protected ProjectFactory configureProjectFactory(ProjectFactory factory) {
		factory.setProjectName(getProjectInfo().getProjectName());
		if (projectInfo instanceof IExtendedProjectInfo) {
			IExtendedProjectInfo extendedProjectInfo = (IExtendedProjectInfo) projectInfo;
			factory.setLocation(extendedProjectInfo.getLocationPath());
		}
		factory.addFolders(getAllFolders());
		factory.addReferencedProjects(getReferencedProjects());
		factory.addProjectNatures(getProjectNatures());
		factory.addBuilderIds(getBuilders());
		return factory;
	}
	
	protected abstract ProjectFactory createProjectFactory();
	
	protected void enhanceProject(final IProject project, final IProgressMonitor monitor) throws CoreException {
	}

	protected String getPrimaryModelFileExtension() {
		String result = fileExtension;
		int idx = result.indexOf(',');
		if (idx > 0) {
			return result.substring(0, idx).trim();
		}
		return result;
	}
	
	protected abstract String getModelFolderName();
		
	protected abstract List<String> getAllFolders();
	
	protected List<IProject> getReferencedProjects() {
        return Collections.emptyList();
    }

	protected String[] getProjectNatures() {
		return new String[] {
			XtextProjectHelper.NATURE_ID
		};
	}

	protected String[] getBuilders() {
		return new String[]{
			XtextProjectHelper.BUILDER_ID
		};
	}

}
