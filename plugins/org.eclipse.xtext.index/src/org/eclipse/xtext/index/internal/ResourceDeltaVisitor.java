package org.eclipse.xtext.index.internal;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
final class ResourceDeltaVisitor implements IResourceDeltaVisitor {

	private WorkspaceModelIndexer workspaceModelIndexer;
	private IProject project;

	public ResourceDeltaVisitor(WorkspaceModelIndexer workspaceModelIndexer) {
		this.workspaceModelIndexer = workspaceModelIndexer;
	}

	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (!resource.isDerived()) {
			int type = resource.getType();
			int kind = delta.getKind();
			if (type == IResource.PROJECT) {
				project = (IProject) resource;
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
							// do nothing
					}
				}
			}
			if (type == IResource.ROOT || type == IResource.FOLDER) {
				return true;
			}
			if (type == IResource.FILE) {
				IFile file = (IFile) delta.getResource();
				String fileExtension = file.getFileExtension();
				if ("classpath".equals(fileExtension) || "MANIFEST.MF".equals(file.getName())) {
					// Re-index project on classpath changes
					workspaceModelIndexer.indexProject(file.getProject(), Collections.<Integer> emptyList());
				}
				else if (WorkspaceModelIndexer.REGISTERED_EXTENSIONS.contains(fileExtension)) {
					switch (kind) {
						case IResourceDelta.ADDED:
						case IResourceDelta.CHANGED:
							workspaceModelIndexer.indexModelFile(file);
							break;
						case IResourceDelta.REMOVED:
							workspaceModelIndexer.removeModelFile(file);
							break;
						default:
					}
				}
			}
		}
		return false;
	}

}