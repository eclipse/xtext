/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import static com.google.common.collect.Iterables.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.OnChangeEvictingCacheAdapter;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescription extends AbstractResourceDescription implements OnChangeEvictingCacheAdapter.Listener {

	private final static Logger log = Logger.getLogger(DefaultResourceDescription.class);

	private final Resource resource;
	
	private final URI uri;

	private final IQualifiedNameProvider nameProvider;

	private List<IReferenceDescription> referenceDescriptions;

	public DefaultResourceDescription(Resource resource, IQualifiedNameProvider nameProvider) {
		this.resource = resource;
		this.nameProvider = nameProvider;
		if (resource.getResourceSet() != null)
			this.uri = resource.getResourceSet().getURIConverter().normalize(resource.getURI());
		else
			this.uri = resource.getURI();
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		OnChangeEvictingCacheAdapter adapter = OnChangeEvictingCacheAdapter.getOrCreate(getResource());
		if (adapter.get(getClass().getName()) == null) {
			if (!getResource().isLoaded()) {
				try {
					getResource().load(null);
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					return Collections.<IEObjectDescription>emptyList();
				}
			}
			Iterable<EObject> contents = new Iterable<EObject>() {
				public Iterator<EObject> iterator() {
					return EcoreUtil.getAllProperContents(getResource(), true);
				}
			};
			Iterable<IEObjectDescription> result = transform(contents, new Function<EObject, IEObjectDescription>() {
				public IEObjectDescription apply(EObject from) {
					return createIEObjectDescription(from);
				}
			});
			Iterable<IEObjectDescription> filter = Iterables.filter(result, Predicates.notNull());
			adapter.set(getClass().getName(), Lists.newArrayList(filter));
			adapter.addCacheListener(this);
		}
		return adapter.get(getClass().getName());
	}
	
	public void onEvict(OnChangeEvictingCacheAdapter cache) {
		invalidateCache();
	}
	
	protected IEObjectDescription createIEObjectDescription(EObject from) {
		if (nameProvider == null)
			return null;
		String qualifiedName = nameProvider.getQualifiedName(from);
		if (qualifiedName != null) {
			return EObjectDescription.create(qualifiedName, from);
		}
		return null;
	}

	public Iterable<String> getImportedNames() {
		EcoreUtil.resolveAll(resource);
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(getResource());
		if (adapter != null) {
			ImmutableSet<String> result = ImmutableSet.copyOf(adapter.getImportedNames());
			return result;
		}
		return Collections.emptySet();
	}

	public Resource getResource() {
		return resource;
	}

	public URI getURI() {
		return uri;
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}

	@Override
	public void invalidateCache() {
		super.invalidateCache();
		referenceDescriptions = null;
	}
	
	@SuppressWarnings("unchecked")
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		if (referenceDescriptions == null) {
			Iterable<IEObjectDescription> exportedObjects = getExportedObjects();
			this.referenceDescriptions = Lists.newArrayList();
			TreeIterator<EObject> contents = EcoreUtil.getAllProperContents(this.resource, true);
			while (contents.hasNext()) {
				EObject eObject = contents.next();
				EList<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference eReference : references) {
					if (!eReference.isContainment()) {
						Object val = eObject.eGet(eReference);
						if (val!=null) {
							if (eReference.isMany()) {
								List<EObject> list = (List<EObject>) val;
								for(int i = 0;i<list.size();i++) {
									EObject to = list.get(i);
									if (isResolved(to)) {
										referenceDescriptions.add(new DefaultReferenceDescription(eObject,to,eReference,i, findContainerEObjectURI(eObject, exportedObjects)));
									}
								}
							} else {
								EObject to = (EObject) val;
								if (isResolved(to)) {
									referenceDescriptions.add(new DefaultReferenceDescription(eObject,to,eReference,-1,findContainerEObjectURI(eObject, exportedObjects)));
								}
							}
						}
					}
				}
			}
		}
		return referenceDescriptions;
	}
	
	private boolean isResolved(EObject to) {
		return !((InternalEObject)to).eIsProxy();
	}

}
