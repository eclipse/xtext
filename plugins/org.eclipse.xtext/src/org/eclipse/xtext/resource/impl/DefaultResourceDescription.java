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
import java.util.Map;

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

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.internal.Maps;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescription extends AbstractResourceDescription {

	private final static Logger log = Logger.getLogger(DefaultResourceDescription.class);

	private final Resource resource;

	private final URI uri;

	private final IQualifiedNameProvider nameProvider;

	private List<IReferenceDescription> referenceDescriptions;

	public DefaultResourceDescription(Resource resource, IQualifiedNameProvider nameProvider) {
		this.resource = resource;
		this.nameProvider = nameProvider;
		this.uri = getNormalizedURI(resource);
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		if (!getResource().isLoaded()) {
			try {
				getResource().load(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				return Collections.<IEObjectDescription> emptyList();
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
		return Lists.newArrayList(filter);
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

	@SuppressWarnings("unchecked")
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		if (this.referenceDescriptions == null) {
			Map<EObject, IEObjectDescription> eObject2exportedEObjects = createEObject2ExportedEObjectsMap(getExportedObjects());
			List<IReferenceDescription> referenceDescriptions = Lists.newArrayList();
			TreeIterator<EObject> contents = EcoreUtil.getAllProperContents(this.resource, true);
			while (contents.hasNext()) {
				EObject eObject = contents.next();
				EList<EReference> references = eObject.eClass().getEAllReferences();
				for (EReference eReference : references) {
					if (!eReference.isContainment()) {
						Object val = eObject.eGet(eReference);
						if (val != null) {
							if (eReference.isMany()) {
								List<EObject> list = (List<EObject>) val;
								for (int i = 0; i < list.size(); i++) {
									EObject to = list.get(i);
									if (isResolved(to)) {
										referenceDescriptions.add(new DefaultReferenceDescription(eObject, to,
												eReference, i, findExportedContainerURI(eObject,
														eObject2exportedEObjects)));
									}
								}
							} else {
								EObject to = (EObject) val;
								if (isResolved(to)) {
									referenceDescriptions.add(new DefaultReferenceDescription(eObject, to, eReference,
											-1, findExportedContainerURI(eObject, eObject2exportedEObjects)));
								}
							}
						}
					}
				}
			}
			this.referenceDescriptions = referenceDescriptions;
		}
		return referenceDescriptions;
	}

	protected Map<EObject, IEObjectDescription> createEObject2ExportedEObjectsMap(
			Iterable<IEObjectDescription> exportedObjects) {
		Map<EObject, IEObjectDescription> uri2exportedEObjects = Maps.newHashMap();
		for (IEObjectDescription eObjectDescription : exportedObjects) {
			uri2exportedEObjects.put(eObjectDescription.getEObjectOrProxy(), eObjectDescription);
		}
		return uri2exportedEObjects;
	}

	protected URI findExportedContainerURI(EObject referenceOwner,
			Map<EObject, IEObjectDescription> eObject2exportedEObjects) {
		EObject currentContainer = referenceOwner;
		while (currentContainer != null) {
			IEObjectDescription currentContainerEObjectDescription = eObject2exportedEObjects.get(currentContainer);
			if (currentContainerEObjectDescription != null) {
				return currentContainerEObjectDescription.getEObjectURI();
			}
			currentContainer = currentContainer.eContainer();
		}
		return null;
	}

	protected boolean isResolved(EObject to) {
		return !((InternalEObject) to).eIsProxy();
	}
}
