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
	private int resourceContainerID;
	private List<IResource> ignoredResources;

	public ResourceVisitor(WorkspaceModelIndexer workspaceModelIndex, int resourceContainerID) {
		this.workspaceModelIndex = workspaceModelIndex;
		this.resourceContainerID = resourceContainerID;
		ignoredResources = new ArrayList<IResource>();
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
				this.workspaceModelIndex.indexModelFile(resourceContainerID, file);
			}
			return false;
		}
		return true;
	}
}