/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * Instances of {@link ResourceDescriptionsData} provide indexed access to
 * resource descriptions that export elements with a certain name.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceDescriptionsData extends AbstractCompoundSelectable {

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
		resourceDescriptionMap = Maps.uniqueIndex(descriptions, new Function<IResourceDescription, URI>() {
			public URI apply(IResourceDescription from) {
				return from.getURI();
			}
		});
		// magic number - it is assumend that we export at least 2 entries per resource description
		lookupMap = Maps.newHashMapWithExpectedSize(resourceDescriptionMap.size() * 2);
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
				Maps.newHashMap(resourceDescriptionMap),
				copyLookupMap());
	}
	
	protected Map<QualifiedName, Object> copyLookupMap() {
		Map<QualifiedName, Object> result = Maps.newHashMap(lookupMap);
		for(Map.Entry<QualifiedName, Object> entry: result.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof Set<?>) {
				@SuppressWarnings("unchecked")
				Set<IResourceDescription> copiedValue = new HashSet<IResourceDescription>((Set<? extends IResourceDescription>) value);
				if (copiedValue.size() <= 1)
					throw new IllegalStateException("Unexpected number of elements in the value set: " + copiedValue.size() + " for " + entry.getKey());
				entry.setValue(copiedValue);
			}
		}
		return result;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return resourceDescriptionMap.values();
	}

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
		URI resourceURI = EcoreUtil2.getNormalizedResourceURI(object);
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

	protected void registerDescription(IResourceDescription description, Map<QualifiedName, Object> target) {
		for(IEObjectDescription object: description.getExportedObjects()) {
			QualifiedName lowerCase = object.getName().toLowerCase();
			Object existing = target.put(lowerCase, description);
			if (existing != null && existing != description) {
				if (existing instanceof IResourceDescription) {
					Set<IResourceDescription> set = Sets.newHashSetWithExpectedSize(2);
					set.add((IResourceDescription)existing);
					set.add(description);
				} else {
					@SuppressWarnings("unchecked")
					Set<IResourceDescription> set = (Set<IResourceDescription>) existing;
					set.add(description);
				}
			}
		}
	}
}
