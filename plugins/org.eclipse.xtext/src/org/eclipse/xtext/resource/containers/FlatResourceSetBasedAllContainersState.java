package org.eclipse.xtext.resource.containers;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.common.collect.Lists;

/**
 * This implementation of {@link IAllContainersState} puts all resources from a {@link ResourceSet} into one single
 * container. Resource that are loaded after this class has been created are also considered.
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.3
 */
public class FlatResourceSetBasedAllContainersState extends AdapterImpl implements IAllContainersState {

	private final static String HANDLE = "all";

	public static String getHandle() {
		return HANDLE;
	}

	private ResourceSet resourceSet;

	public FlatResourceSetBasedAllContainersState(ResourceSet rs) {
		super();
		this.resourceSet = rs;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 == null || arg0.getClass() != getClass())
			return false;
		FlatResourceSetBasedAllContainersState other = (FlatResourceSetBasedAllContainersState) arg0;
		return other.resourceSet == resourceSet;
	}

	public Collection<URI> getContainedURIs(String containerHandle) {
		if (!HANDLE.equals(containerHandle))
			return Collections.emptySet();
		if (resourceSet instanceof XtextResourceSet) {
			XtextResourceSet xtextResourceSet = (XtextResourceSet) resourceSet;
			return xtextResourceSet.getNormalizationMap().values();
		}
		List<URI> uris = Lists.newArrayListWithCapacity(resourceSet.getResources().size());
		URIConverter uriConverter = resourceSet.getURIConverter();
		for (Resource r : resourceSet.getResources())
			uris.add(uriConverter.normalize(r.getURI()));
		return uris;
	}

	public String getContainerHandle(URI uri) {
		return HANDLE;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public List<String> getVisibleContainerHandles(String handle) {
		return Collections.singletonList(HANDLE);
	}

	@Override
	public int hashCode() {
		return resourceSet == null ? 0 : resourceSet.hashCode();
	}

	@Override
	public boolean isAdapterForType(Object type) {
		return IAllContainersState.class == type || FlatResourceSetBasedAllContainersState.class == type;
	}

	public boolean isEmpty(String containerHandle) {
		return !HANDLE.equals(containerHandle);
	}

}