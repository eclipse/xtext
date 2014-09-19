package org.eclipse.xtext.ui.generator.trace;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.generator.IDerivedResourceMarkers;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class OpenGeneratedFileHandler extends AbstractOpenOppositeFileHandler {

	private final static Logger LOG = Logger.getLogger(OpenGeneratedFileHandler.class);

	@Inject
	private IDerivedResourceMarkers derivedResourceMarkers;

	@Inject
	private ITraceForStorageProvider traceForStorageProvider;

	@Override
	protected Collection<StorageWithRegion> findDestinations(IEditorPart editor) {
		IStorage storage = getStorage(editor);
		ITextRegion region = getSelectedRegion(editor);
		if (storage != null) {
			ITrace trace = traceForStorageProvider.getTraceToTarget(storage);
			if (((ITrace.Internal) trace).getRootTraceRegion() != null)
				return findDestinationsUsingTrace(trace, region);
			if (storage instanceof IResource) {
				return findDestinationsUsingDerivedResourceMarkers((IResource) storage);
			}
		}
		return Collections.emptyList();
	}

	protected Collection<StorageWithRegion> findDestinationsUsingDerivedResourceMarkers(IResource resource) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		try {
			List<IFile> resources = derivedResourceMarkers.findDerivedResources(root, uri.toString());
			List<StorageWithRegion> result = Lists.newArrayList();
			for (IFile file : resources)
				result.add(new StorageWithRegion(file));
			return result;
		} catch (CoreException e) {
			LOG.error(e.getMessage(), e);
			return Collections.emptyList();
		}
	}

	public IDerivedResourceMarkers getDerivedResourceMarkers() {
		return derivedResourceMarkers;
	}

	public ITraceForStorageProvider getTraceForStorageProvider() {
		return traceForStorageProvider;
	}

}
