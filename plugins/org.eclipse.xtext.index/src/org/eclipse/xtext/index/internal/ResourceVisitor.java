package org.eclipse.xtext.index.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
final class ResourceVisitor implements IResourceVisitor {

	private final WorkspaceModelIndexer workspaceModelIndex;
	private List<IResource> ignoredResources;
	private int containerID;
	
	public ResourceVisitor(WorkspaceModelIndexer workspaceModelIndex, int containerID) {
		this.workspaceModelIndex = workspaceModelIndex;
		ignoredResources = new ArrayList<IResource>();
		this.containerID = containerID;
	}

	public void addIgnoredResource(IResource ignoredResource) {
		ignoredResources.add(ignoredResource);
	}

	public boolean visit(IResource resource) throws CoreException {
		if (resource.isDerived() || ignoredResources.contains(resource)) {
			return false;
		}
		if (resource instanceof IFile) {
			IFile file = (IFile) resource;
			String fileExtension = file.getFileExtension();
			if (WorkspaceModelIndexer.REGISTERED_EXTENSIONS.contains(fileExtension)) {
				workspaceModelIndex.indexModelFile(file, containerID);
			}
			return false;
		}
		return true;
	}
}