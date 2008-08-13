package org.eclipse.xtext.index.internal;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
final class ResourceDeltaVisitor implements IResourceDeltaVisitor {

	private static final Logger log = Logger.getLogger(ResourceDeltaVisitor.class);

	private WorkspaceModelIndexer workspaceModelIndexer;
	
	public ResourceDeltaVisitor(WorkspaceModelIndexer workspaceModelIndexer) {
		this.workspaceModelIndexer = workspaceModelIndexer;
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (!resource.isDerived()) {
			int type = resource.getType();
			int kind = delta.getKind();
			switch (type) {
				case IResource.PROJECT:
					return handleProjectChange((IProject) resource, kind);
				case IResource.ROOT:
				case IResource.FOLDER:
					return true;
				case IResource.FILE:
					return handleFileChange((IFile) resource, kind);
				default:
					// do nothing
			}
		}
		return false;
	}

	private boolean handleFileChange(IFile file, int kind) {
		String fileExtension = file.getFileExtension();
		IProject project = file.getProject();
		IJavaProject javaProject = null;
		try {
			javaProject=(project.hasNature(JavaCore.NATURE_ID)) ? JavaCore.create(project) : null;
		}
		catch (CoreException e) {
			log.error("Error getting project nature", e);
		}

		if (javaProject != null && ("classpath".equals(fileExtension) || "MANIFEST.MF".equals(file.getName()))) {
			// Re-index complete java project on classpath changes
			workspaceModelIndexer.indexProject(project, Collections.<Integer> emptyList());
		}
		else if (WorkspaceModelIndexer.REGISTERED_EXTENSIONS.contains(fileExtension)) {
			if (javaProject != null && !javaProject.isOnClasspath(file)) {
				return false;
			}
			switch (kind) {
				case IResourceDelta.ADDED:
				case IResourceDelta.CHANGED:
					workspaceModelIndexer.indexModelFile(file);
					break;
				case IResourceDelta.REMOVED:
					workspaceModelIndexer.removeModelFile(file);
					break;
				default:
					// do nothing
			}
		}
		return false;
	}

	private boolean handleProjectChange(IProject project, int kind) throws CoreException {
		if (project.isOpen()) {
			switch (kind) {
				case IResourceDelta.CHANGED:
					return true;
				case IResourceDelta.ADDED:
					workspaceModelIndexer.indexProject(project, Collections.<Integer> emptyList());
					return false;
				case IResourceDelta.REMOVED:
					workspaceModelIndexer.removeProject(project);
					return false;
				default:
					return true;
			}
		}
		return false;
	}

}