package org.eclipse.xtext.ui.core.index;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.emfindex.ContainerDescriptor;
import org.eclipse.emf.emfindex.EObjectDescriptor;
import org.eclipse.emf.emfindex.ResourceDescriptor;
import org.eclipse.emf.emfindex.query.ContainerDescriptorQuery;
import org.eclipse.emf.emfindex.query.QueryExecutor;
import org.eclipse.emf.emfindex.query.QueryResult;
import org.eclipse.emf.emfindex.query.ResourceDescriptorQuery;
import org.eclipse.emf.emfindex.store.IndexUpdater;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class WrappedUpdater implements IndexUpdater {
	
	private IndexUpdater delegate;
	private QueryExecutor queryExecutor;
	private Set<String> changedNames;
	
	public WrappedUpdater(IndexUpdater indexUpdater,QueryExecutor queryExecutor, Set<String> changedNames) {
		this.delegate = indexUpdater;
		this.changedNames = changedNames;
		this.queryExecutor = queryExecutor;
	}

	public void createOrUpdateEObject(URI resourceURI, String fragment, String name, EClass type,
			Map<String, String> userData) {
		changedNames.add(name);
		delegate.createOrUpdateEObject(resourceURI, fragment, name, type, userData);
	}

	public void deleteContainer(String containerName) {
		ContainerDescriptorQuery query = new ContainerDescriptorQuery();
		query.setName(containerName);
		QueryResult<ContainerDescriptor> result = queryExecutor.execute(query);
		for (ContainerDescriptor desc : result) {
			deletedContainerDescriptor(desc);
		}
		delegate.deleteContainer(containerName);
	}

	public void deleteResource(URI resourceURI) {
		ResourceDescriptorQuery query = new ResourceDescriptorQuery();
		query.setURI(resourceURI);
		QueryResult<ResourceDescriptor> result = queryExecutor.execute(query);
		for (ResourceDescriptor resourceDescriptor : result) {
			deletedResourceDescriptor(resourceDescriptor);
		}
		delegate.deleteResource(resourceURI);
	}
	
	private void deletedContainerDescriptor(ContainerDescriptor desc) {
		List<ResourceDescriptor> list = desc.getResourceDescriptors();
		for (ResourceDescriptor rd : list) {
			deletedResourceDescriptor(rd);
		}
	}

	private void deletedResourceDescriptor(ResourceDescriptor rd) {
		List<EObjectDescriptor> descriptors = rd.getEObjectDescriptors();
		for (EObjectDescriptor eObjectDescriptor : descriptors) {
			changedNames.add(eObjectDescriptor.getName());
		}
	}

	public void createContainer(String containerName, Map<String, String> userData) {
		delegate.createContainer(containerName, userData);
	}
	
	public void createOrUpdateEReference(URI sourceResourceURI, String sourceFragment, URI targetEObjectURI,
			EReference reference, Map<String, String> userData) {
		delegate.createOrUpdateEReference(sourceResourceURI, sourceFragment, targetEObjectURI, reference, userData);
	}
	
	public void createOrUpdateResource(String containerName, URI resourceURI, long version,
			Map<String, String> userData) {
		delegate.createOrUpdateResource(containerName, resourceURI, version, userData);
	}

	public void deleteEObject(URI resourceURI, String fragment) {
		delegate.deleteEObject(resourceURI, fragment);
	}
	
	public void deleteEReference(URI sourceResourceURI, String sourceFragment, URI targetEObjectURI,
			EReference reference) {
		delegate.deleteEReference(sourceResourceURI, sourceFragment, targetEObjectURI, reference);
	}

}