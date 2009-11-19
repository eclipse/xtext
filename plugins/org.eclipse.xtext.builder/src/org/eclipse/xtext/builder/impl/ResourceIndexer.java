package org.eclipse.xtext.builder.impl;

import java.util.Collections;
import java.util.Comparator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
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
import com.google.inject.Provider;

public class ResourceIndexer {
	
	private static final String DEFAULT_CONTAINER = "DEFAULT_CONTAINER";

	@Inject
	private BuilderStateManager builderStateManager;
	
	@Inject
	private Provider<ResourceSet> resourceSetProvider;
	
	@Inject 
	private IExportedEObjectsProvider.Registry exportedEObjectsProviderRegistry;
	
	@Inject 
	private IImportedNamesProvider.Registry importedNamesProviderRegistry;
	
	@Inject
	private StorageUtil storageUtil;
	
	/**
	 * @param storage
	 * @return whether children of the given storage shall be asked
	 */
	public void updateExportedElements(IStorage storage) {
		URI uri = getURI(storage);
		if (uri!=null)
			return;
		Resource resource = resourceSetProvider.get().getResource(uri, true);
		if (resource==null)
			return;
		updateBuilderState(resource, storage);
	}

	protected void updateBuilderState(final Resource resource, final IStorage storage) {
		builderStateManager.modify(new IUnitOfWork<Void, BuilderState>() {
			public java.lang.Void exec(BuilderState state) throws Exception {
				ResourceDescriptor res = getResourceDescriptor(resource,
						storage, state);
				addExportedEObjects(resource, res);
				addImportedNames(resource, res);
				return null;
			}

		});
	}
	
	protected void addExportedEObjects(final Resource resource,
			ResourceDescriptor res) {
		IExportedEObjectsProvider provider = exportedEObjectsProviderRegistry.getExportedEObjectsProvider(resource);
		Iterable<IEObjectDescription> objects = provider.getExportedObjects(resource);
		
		for (IEObjectDescription ieObjectDescription : objects) {
			IEObjectDescription copy = createPersistableCopy(ieObjectDescription);
			res.getEObjectDescriptions().add(copy);
		}
		sortByName(res.getEObjectDescriptions());
	}

	protected void cleanAndUpdate(ResourceDescriptor res, Resource resource,
			IStorage storage) {
		res.getImportedNames().clear();
		res.getEObjectDescriptions().clear();
		res.setPathToStorage(storageUtil.toExternalString(storage));
		res.setURI(resource.getURI());
	}

	protected void sortByName(EList<IEObjectDescription> eObjectDescriptions) {
		Collections.sort(eObjectDescriptions, new Comparator<IEObjectDescription>() {
			public int compare(IEObjectDescription o1, IEObjectDescription o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	protected IEObjectDescription createPersistableCopy(
			IEObjectDescription ieObjectDescription) {
		EObjectDescriptionImpl desc = (EObjectDescriptionImpl) BuilderStateFactory.eINSTANCE.createEObjectDescription();
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
		ResourceDescriptor descriptor = BuilderStateFactory.eINSTANCE.createResourceDescriptor();
		descriptor.setContainer(container);
		cleanAndUpdate(descriptor, resource, storage);
		return descriptor;
	}

	protected Container findOrCreateResponsibleContainer(BuilderState state, IStorage storage) {
		if (storage instanceof IResource) {
			IResource res = (IResource) storage;
			IProject project = res.getProject();
			EList<Container> containers = state.getContainers();
			for (Container container : containers) {
				if (container.getProject().equals(project.getName()) && container.getName().equals(DEFAULT_CONTAINER))
					return container;
			}
			
			Container container = BuilderStateFactory.eINSTANCE.createContainer();
			container.setName(DEFAULT_CONTAINER);
			container.setProject(project.getName());
			state.getContainers().add(container);
			return container;
		}
		throw new UnsupportedOperationException("Couldn't handle storage "+storage);
	}

	protected ResourceDescriptor findResource(BuilderState state, Resource res) {
		EList<Container> containers = state.getContainers();
		for (Container container : containers) {
			container.getResourceDescriptor(res.getURI());
		}
		return null;
	}

	protected URI getURI(IStorage resource) {
		if (resource == null)
			throw new NullPointerException("resource");
		return URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
	}

	protected ResourceDescriptor getResourceDescriptor(final Resource resource,
			final IStorage storage, BuilderState state) {
		ResourceDescriptor res = findResource(state, resource);
		if (res==null) {
			Container container = findOrCreateResponsibleContainer(state, storage);
			res = createResourceDescriptor(container, resource, storage);
		} else {
			cleanAndUpdate(res, resource, storage);
		}
		return res;
	}

	protected void addImportedNames(final Resource resource,
			ResourceDescriptor res) {
		IImportedNamesProvider namesProvider = importedNamesProviderRegistry.getImportedNamesProvider(resource);
		Iterable<String> names = namesProvider.getImportedNames(resource);
		for (String string : names) {
			res.getImportedNames().add(string);
		}
	}
}
