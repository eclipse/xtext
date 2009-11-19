package org.eclipse.xtext.builder.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.IResourceIndexer;
import org.eclipse.xtext.builder.builderState.BuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.BuilderStateManager;
import org.eclipse.xtext.builder.builderState.Container;
import org.eclipse.xtext.builder.builderState.ResourceDescriptor;
import org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IExportedEObjectsProvider;
import org.eclipse.xtext.resource.IImportedNamesProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public class ResourceIndexer implements IResourceIndexer {

	@Inject
	private BuilderStateManager builderStateManager;

	@Inject
	private IExportedEObjectsProvider.Registry exportedEObjectsProviderRegistry;

	@Inject
	private IImportedNamesProvider.Registry importedNamesProviderRegistry;

	@Inject
	private StorageUtil storageUtil;

	@Inject
	private ResourceProvider resourceProvider;

	public void setBuilderStateManager(BuilderStateManager builderStateManager) {
		this.builderStateManager = builderStateManager;
	}

	public void setExportedEObjectsProviderRegistry(
			IExportedEObjectsProvider.Registry exportedEObjectsProviderRegistry) {
		this.exportedEObjectsProviderRegistry = exportedEObjectsProviderRegistry;
	}

	public void setImportedNamesProviderRegistry(
			IImportedNamesProvider.Registry importedNamesProviderRegistry) {
		this.importedNamesProviderRegistry = importedNamesProviderRegistry;
	}

	public void setResourceProvider(ResourceProvider resourceProvider) {
		this.resourceProvider = resourceProvider;
	}

	public void setStorageUtil(StorageUtil storageUtil) {
		this.storageUtil = storageUtil;
	}

	public Set<String> delete(final IStorage storage) {
		final URI uri = resourceProvider.getURI(storage);
		if (uri == null)
			return Collections.emptySet();

		return builderStateManager
				.modify(new IUnitOfWork<Set<String>, BuilderState>() {
					public Set<String> exec(BuilderState state)
							throws Exception {
						ResourceDescriptor res = findResource(state, uri);
						if (res == null)
							return Collections.emptySet();
						Set<String> exportedNames = getExportedNames(res);
						res.setContainer(null);
						return exportedNames;
					}
				});
	}

	/**
	 * @param storage
	 * @return whether children of the given storage shall be asked
	 */
	public Set<String> addOrUpdate(final IStorage storage) {
		final Resource resource = resourceProvider.getResource(storage);
		if (resource == null)
			return Collections.emptySet();
		return builderStateManager
				.modify(new IUnitOfWork<Set<String>, BuilderState>() {
					public Set<String> exec(BuilderState state)
							throws Exception {
						ResourceDescriptor res = getResourceDescriptor(
								resource, storage, state);
						Set<String> exportedNames = getExportedNames(res);
						cleanAndUpdate(res, resource, storage);
						addExportedEObjects(resource, res);
						exportedNames.addAll(getExportedNames(res));
						addImportedNames(resource, res);
						return exportedNames;
					}

				});
	}

	protected Set<String> getExportedNames(ResourceDescriptor res) {
		HashSet<String> set = new HashSet<String>();
		for (IEObjectDescription desc : res.getEObjectDescriptions()) {
			set.add(desc.getName());
		}
		return set;
	}

	protected void addExportedEObjects(final Resource resource,
			ResourceDescriptor res) {
		IExportedEObjectsProvider provider = exportedEObjectsProviderRegistry
				.getExportedEObjectsProvider(resource);
		Iterable<IEObjectDescription> objects = provider
				.getExportedObjects(resource);

		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();
		for (IEObjectDescription ieObjectDescription : objects) {
			IEObjectDescription copy = createPersistableCopy(ieObjectDescription);
			descriptions.add(copy);
		}
		sortByName(descriptions);
		res.getEObjectDescriptions().addAll(descriptions);
	}

	protected void cleanAndUpdate(ResourceDescriptor res, Resource resource,
			IStorage storage) {
		res.getImportedNames().clear();
		res.getEObjectDescriptions().clear();
		res.setPathToStorage(storageUtil.toExternalString(storage));
		res.setURI(resource.getURI());
	}

	protected void sortByName(List<IEObjectDescription> eObjectDescriptions) {
		Collections.sort(eObjectDescriptions,
				new Comparator<IEObjectDescription>() {
					public int compare(IEObjectDescription o1,
							IEObjectDescription o2) {
						return o1.getName().compareTo(o2.getName());
					}
				});
	}

	protected IEObjectDescription createPersistableCopy(
			IEObjectDescription ieObjectDescription) {
		EObjectDescriptionImpl desc = (EObjectDescriptionImpl) BuilderStateFactory.eINSTANCE
				.createEObjectDescription();
		desc.setEClass(ieObjectDescription.getEClass());
		desc.setFragment(ieObjectDescription.getEObjectURI().fragment());
		desc.setName(ieObjectDescription.getName());
		for (String key : ieObjectDescription.getUserDataKeys()) {
			desc.getUserData().put(key, ieObjectDescription.getUserData(key));
		}
		return desc;
	}

	protected ResourceDescriptor createResourceDescriptor(Container container,
			Resource resource, IStorage storage) {
		ResourceDescriptor descriptor = BuilderStateFactory.eINSTANCE
				.createResourceDescriptor();
		descriptor.setContainer(container);
		cleanAndUpdate(descriptor, resource, storage);
		return descriptor;
	}

	protected Container findOrCreateResponsibleContainer(BuilderState state,
			IStorage storage) {
		EList<Container> containers = state.getContainers();
		String projectName = getProjectName(storage);
		String containerName = getContainerName(storage);
		for (Container container : containers) {
			if (container.getProject().equals(projectName)
					&& container.getName().equals(containerName))
				return container;
		}
		Container container = BuilderStateFactory.eINSTANCE.createContainer();
		container.setName(containerName);
		container.setProject(projectName);
		state.getContainers().add(container);
		return container;
	}

	protected String getProjectName(IStorage storage) {
		if (storage instanceof IResource) {
			return ((IResource) storage).getProject().getName();
		}
		throw new UnsupportedOperationException("Couldn't handle storage "
				+ storage);
	}

	protected String getContainerName(IStorage storage) {
		if (storage instanceof IResource) {
			return ((IResource) storage).getProject().getName();
		}
		throw new UnsupportedOperationException("Couldn't handle storage "
				+ storage);
	}

	protected ResourceDescriptor findResource(BuilderState state, URI resUri) {
		EList<Container> containers = state.getContainers();
		for (Container container : containers) {
			ResourceDescriptor descriptor = container
					.getResourceDescriptor(resUri);
			if (descriptor != null)
				return descriptor;
		}
		return null;
	}

	protected ResourceDescriptor getResourceDescriptor(final Resource resource,
			final IStorage storage, BuilderState state) {
		ResourceDescriptor res = findResource(state, resource.getURI());
		if (res == null) {
			Container container = findOrCreateResponsibleContainer(state,
					storage);
			res = createResourceDescriptor(container, resource, storage);
		}
		return res;
	}

	protected void addImportedNames(final Resource resource,
			ResourceDescriptor res) {
		IImportedNamesProvider namesProvider = importedNamesProviderRegistry
				.getImportedNamesProvider(resource);
		Iterable<String> names = namesProvider.getImportedNames(resource);
		for (String string : names) {
			res.getImportedNames().add(string);
		}
	}
}
