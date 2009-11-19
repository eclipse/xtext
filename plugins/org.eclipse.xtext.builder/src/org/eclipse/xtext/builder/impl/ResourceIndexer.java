package org.eclipse.xtext.builder.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
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

public class ResourceIndexer {
	
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
	
	/**
	 * @param storage
	 * @return whether children of the given storage shall be asked
	 */
	public void updateExportedElements(IStorage storage) {
		Resource resource = resourceProvider.getResource(storage);
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
			String projectName = project.getName();
			for (Container container : containers) {
				if (container.getProject().equals(projectName) && container.getName().equals(projectName))
					return container;
			}
			
			Container container = BuilderStateFactory.eINSTANCE.createContainer();
			container.setName(projectName);
			container.setProject(projectName);
			state.getContainers().add(container);
			return container;
		}
		throw new UnsupportedOperationException("Couldn't handle storage "+storage);
	}

	protected ResourceDescriptor findResource(BuilderState state, Resource res) {
		EList<Container> containers = state.getContainers();
		for (Container container : containers) {
			ResourceDescriptor descriptor = container.getResourceDescriptor(res.getURI());
			if (descriptor!=null)
				return descriptor;
		}
		return null;
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
