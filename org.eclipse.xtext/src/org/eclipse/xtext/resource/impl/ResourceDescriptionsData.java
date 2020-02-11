/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * Instances of {@link ResourceDescriptionsData} provide indexed access to
 * resource descriptions that export elements with a certain name.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.5
 * 
 */
@Beta public class ResourceDescriptionsData extends AbstractCompoundSelectable implements IResourceDescriptions {
	
	public static class ResourceSetAdapter extends AdapterImpl {
		
		public ResourceSetAdapter(ResourceDescriptionsData data) {
			super();
			this.data = data;
		}

		public static ResourceDescriptionsData findResourceDescriptionsData(ResourceSet resourceSet) {
			if (resourceSet != null) {
				for (Adapter a : resourceSet.eAdapters()) {
					if (a instanceof ResourceSetAdapter) {
						return ((ResourceSetAdapter) a).getResourceDescriptionsData();
					}
				}
			}
			return null;
		}
		
		public static void installResourceDescriptionsData(ResourceSet resourceSet, ResourceDescriptionsData data) {
			if (findResourceDescriptionsData(resourceSet) != null) {
				throw new IllegalStateException("Resource description data is already installed.");
			}
			ResourceSetAdapter resourceSetAdapter = new ResourceSetAdapter(data);
			resourceSet.eAdapters().add(resourceSetAdapter);
		}
		
		@Override
		public boolean isAdapterForType(Object type) {
			return type == ResourceDescriptionsData.class;
		}
		
		private ResourceDescriptionsData data;
		public ResourceDescriptionsData getResourceDescriptionsData() {
			return data;
		}
	}

	private final Map<URI, IResourceDescription> resourceDescriptionMap;
	/**
	 * The lookup map contains either a single {@link IResourceDescription} or a 
	 * {@link Set Set&lt;IResourceDescription&gt;} as values. It is maintained by 
	 * {@link #removeDescription(URI)} and {@link #addDescription(URI, IResourceDescription)} 
	 * which take care of creating the {@link Set Sets} and discarding them if the number
	 * of elements becomes small enough.  
	 */
	private final Map<QualifiedName, Object> lookupMap;

	public ResourceDescriptionsData(Iterable<IResourceDescription> descriptions) {
		int expectedSize = 500; // magic number in case it's not a Collection
		if (descriptions instanceof Collection) {
			expectedSize = ((Collection<?>) descriptions).size();
		}
		resourceDescriptionMap = new LinkedHashMap<>(expectedSize);
		for (IResourceDescription desc : descriptions) {
			resourceDescriptionMap.put(desc.getURI(), desc);
		}
		// magic number - it is assumend that we export at least 2 entries per resource description
		lookupMap = new LinkedHashMap<>(resourceDescriptionMap.size() * 2);
	    for (IResourceDescription description: descriptions) {
	    	registerDescription(description, lookupMap);
	    }
	}

	protected ResourceDescriptionsData(Map<URI, IResourceDescription> resourceDescriptionMap, Map<QualifiedName, Object> lookupMap) {
		this.resourceDescriptionMap = resourceDescriptionMap;
		this.lookupMap = lookupMap;
	}
	
	public ResourceDescriptionsData copy() {
		return new ResourceDescriptionsData(
				Maps.newLinkedHashMap(resourceDescriptionMap),
				copyLookupMap());
	}
	
	protected Map<QualifiedName, Object> copyLookupMap() {
		Map<QualifiedName, Object> result = Maps.newLinkedHashMap(lookupMap);
		for(Map.Entry<QualifiedName, Object> entry: result.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof Set<?>) {
				@SuppressWarnings("unchecked")
				Set<IResourceDescription> copiedValue = new LinkedHashSet<IResourceDescription>((Set<? extends IResourceDescription>) value);
				if (copiedValue.size() <= 1)
					throw new IllegalStateException("Unexpected number of elements in the value set: " + copiedValue.size() + " for " + entry.getKey());
				entry.setValue(copiedValue);
			}
		}
		return result;
	}

	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return resourceDescriptionMap.values();
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		return resourceDescriptionMap.get(uri);
	}

	public void removeDescription(URI uri) {
		IResourceDescription oldDescription = resourceDescriptionMap.remove(uri);
		if (oldDescription != null) {
			for(IEObjectDescription object: oldDescription.getExportedObjects()) {
				QualifiedName objectName = object.getName().toLowerCase();
				Object existing = lookupMap.get(objectName);
				if (existing == oldDescription) {
					lookupMap.remove(objectName);
				} else if (existing instanceof Set<?>) {
					Set<?> casted = (Set<?>) existing;
					if (casted.remove(oldDescription)) {
						if (casted.size() == 1) {
							lookupMap.put(objectName, casted.iterator().next());
						} else if (casted.isEmpty()) {
							lookupMap.remove(objectName);
						}
					}
				}
			}
		}
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName qualifiedName, final boolean ignoreCase) {
		Object existing = lookupMap.get(qualifiedName.toLowerCase());
		if (existing instanceof IResourceDescription) {
			return ((IResourceDescription) existing).getExportedObjects(type, qualifiedName, ignoreCase);
		} else if (existing instanceof Set<?>) {
			@SuppressWarnings("unchecked")
			Set<IResourceDescription> casted = (Set<IResourceDescription>) existing;
			return Iterables.concat(Iterables.transform(casted, new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
				@Override
				public Iterable<IEObjectDescription> apply(IResourceDescription from) {
					if (from != null) {
						return from.getExportedObjects(type, qualifiedName, ignoreCase);
					}
					return Collections.emptyList();
				}
			}));
		}
		return Collections.emptyList();
	}
	
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		URI resourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(object).trimFragment();
		IResourceDescription description = getResourceDescription(resourceURI);
		if (description == null)
			return Collections.emptyList();
		return description.getExportedObjectsByObject(object);
	}
	
	@Override
	protected Iterable<IResourceDescription> getSelectables() {
		return resourceDescriptionMap.values();
	}

	public Set<URI> getAllURIs() {
		return resourceDescriptionMap.keySet();
	}

	public void addDescription(URI uri, IResourceDescription newDescription) {
		removeDescription(uri);
		if (newDescription != null) {
			resourceDescriptionMap.put(uri, newDescription);
			registerDescription(newDescription, lookupMap);
		}
	}

	@SuppressWarnings("unchecked")
	protected void registerDescription(IResourceDescription description, Map<QualifiedName, Object> target) {
		for(IEObjectDescription object: description.getExportedObjects()) {
			QualifiedName lowerCase = object.getName().toLowerCase();
			Object existing = target.put(lowerCase, description);
			if (existing != null && existing != description) {
				Set<IResourceDescription> set = null;
				if (existing instanceof IResourceDescription) {
					set = Sets.newLinkedHashSetWithExpectedSize(2);
					set.add((IResourceDescription)existing);
				} else {
					set = (Set<IResourceDescription>) existing;
				}
				set.add(description);
				target.put(lowerCase, set);
			}
		}
	}

	/**
	 * Put a new resource description into the index, or remove one if the delta has no new description. A delta for a
	 * particular URI may be registered more than once; overwriting any earlier registration.
	 * 
	 * @param delta
	 *            The resource change.
	 * @since 2.9
	 */
	public void register(Delta delta) {
		final IResourceDescription newDesc = delta.getNew();
		if (newDesc == null) {
			removeDescription(delta.getUri());
		} else {
			addDescription(delta.getUri(), newDesc);
		}
	}
}
