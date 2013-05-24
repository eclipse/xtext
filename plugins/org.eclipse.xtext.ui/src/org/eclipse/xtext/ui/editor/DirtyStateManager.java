/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IExternalContentSupport.IExternalContentProvider;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.impl.AbstractResourceDescriptionChangeEventSource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionChangeEvent;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
// TODO: batch events according to the contract of IDirtyStateManager
public class DirtyStateManager extends AbstractResourceDescriptionChangeEventSource implements IDirtyStateManager {

	protected static class Event extends ResourceDescriptionChangeEvent {

		public Event(Collection<Delta> delta, Source sender) {
			super(delta, sender);
		}

		@Override
		public IDirtyStateManager getSender() {
			return (IDirtyStateManager) super.getSender();
		}

	}
	
	private ConcurrentMap<URI, IDirtyResource> managedResources;
	
	public DirtyStateManager() {
		managedResources = new MapMaker().makeMap();
	}
	
	public void announceDirtyStateChanged(IDirtyResource dirtyResource) {
		managedResources.put(dirtyResource.getURI(), dirtyResource);
		notifyListeners(dirtyResource, true);
	}

	public void discardDirtyState(IDirtyResource dirtyResource) {
		if (managedResources.remove(dirtyResource.getURI(), dirtyResource)) {
			notifyListeners(dirtyResource, false);
		}
	}

	protected void notifyListeners(final IDirtyResource dirtyResource, boolean managed) {
		if (managed) {
			IResourceDescription.Delta delta = new IResourceDescription.Delta() {
				public boolean haveEObjectDescriptionsChanged() {
					return true;
				}
				
				public IResourceDescription getOld() {
					return null;
				}
				
				public IResourceDescription getNew() {
					return dirtyResource.getDescription();
				}

				public URI getUri() {
					return dirtyResource.getURI();
				}
			};
			notifyListeners(new Event(Collections.singletonList(delta), this));
		} else {
			IResourceDescription.Delta delta = new IResourceDescription.Delta() {
				public boolean haveEObjectDescriptionsChanged() {
					return true;
				}
				
				public IResourceDescription getOld() {
					return dirtyResource.getDescription();
				}
				
				public IResourceDescription getNew() {
					return null;
				}
				public URI getUri() {
					return dirtyResource.getURI();
				}
			};
			notifyListeners(new Event(Collections.singletonList(delta), this));
		}
	}

	public boolean manageDirtyState(IDirtyResource dirtyResource) {
		IDirtyResource prevValue = managedResources.putIfAbsent(dirtyResource.getURI(), dirtyResource);
		return prevValue == null || prevValue == dirtyResource;
	}
	
	public IDirtyResource getDirtyResource(URI uri) {
		return managedResources.get(uri);
	}
	
	public IResourceDescription getDirtyResourceDescription(URI uri) {
		IDirtyResource dirtyResource = getDirtyResource(uri);
		if (dirtyResource != null)
			return dirtyResource.getDescription();
		return null;
	}

	public String getContent(URI uri) {
		IDirtyResource dirtyResource = findDirtyResourcebyURIorNormalizedURI(uri);
		if (dirtyResource != null)
			return dirtyResource.getContents();
		return null;
	}

	/**
	 * @since 2.4
	 */
	protected IDirtyResource findDirtyResourcebyURIorNormalizedURI(URI uri) {
		IDirtyResource dirtyResource = managedResources.get(uri);
		if (dirtyResource == null) {
			Iterator<IDirtyResource> iterator = managedResources.values().iterator();
			while (dirtyResource == null && iterator.hasNext()) {
				IDirtyResource res = iterator.next();
				if (res instanceof IDirtyResource.NormalizedURISupportExtension) {
					URI normalizedURI = ((IDirtyResource.NormalizedURISupportExtension) res).getNormalizedURI();
					if (normalizedURI.equals(uri)) {
						dirtyResource = res;
					}
				}
			}
		}
		return dirtyResource;
	}
	
	public IExternalContentProvider getActualContentProvider() {
		return new IExternalContentProvider() {
			
			public boolean hasContent(URI uri) {
				return DirtyStateManager.this.hasContent(uri);
			}
			
			public String getContent(URI uri) {
				IDirtyResource dirtyResource = DirtyStateManager.this.findDirtyResourcebyURIorNormalizedURI(uri);
				if (dirtyResource != null)
					return dirtyResource.getActualContents();
				return null;
			}
			
			public IExternalContentProvider getActualContentProvider() {
				return this;
			}
		};
	}

	public boolean hasContent(URI uri) {
		return findDirtyResourcebyURIorNormalizedURI(uri) != null;
	}

	public boolean isEmpty() {
		return managedResources.isEmpty();
	}
	
	public Iterable<IEObjectDescription> getExportedObjects() {
		return Iterables.concat(Iterables.transform(managedResources.values(), new Function<IDirtyResource, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IDirtyResource from) {
				if (from != null)
					return from.getDescription().getExportedObjects();
				return Collections.emptyList();
			}
		}));
	}
	
	public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName name, final boolean ignoreCase) {
		return Iterables.concat(Iterables.transform(managedResources.values(), new Function<IDirtyResource, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IDirtyResource from) {
				if (from != null)
					return from.getDescription().getExportedObjects(type, name, ignoreCase);
				return Collections.emptyList();
			}
		}));
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		URI resourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(object).trimFragment();
		IDirtyResource dirtyResource = getDirtyResource(resourceURI);
		if (dirtyResource != null) {
			return dirtyResource.getDescription().getExportedObjectsByObject(object);
		}
		return Collections.emptyList();
	}
	
	public Iterable<IEObjectDescription> getExportedObjectsByType(final EClass type) {
		return Iterables.concat(Iterables.transform(managedResources.values(), new Function<IDirtyResource, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IDirtyResource from) {
				if (from != null)
					return from.getDescription().getExportedObjectsByType(type);
				return Collections.emptyList();
			}
		}));
	}
	
}
