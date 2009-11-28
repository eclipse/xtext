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

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.util.OnChangeEvictingCacheAdapter;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescription extends AbstractResourceDescription {

	private final static Logger log = Logger.getLogger(DefaultResourceDescription.class);
	
	private final Resource resource;

	private final IQualifiedNameProvider nameProvider;

	public DefaultResourceDescription(Resource resource, IQualifiedNameProvider nameProvider) {
		this.resource = resource;
		this.nameProvider = nameProvider;
	}

	public Iterable<IEObjectDescription> getExportedObjects() {
		OnChangeEvictingCacheAdapter adapter = OnChangeEvictingCacheAdapter.getOrCreate(getResource()); 
		if (adapter.get(getClass().getName()) == null) {
			if (!getResource().isLoaded()) {
				try {
					getResource().load(null);
				} catch (IOException e) {
					log.error(e.getMessage(), e);
					return Iterables.emptyIterable();
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
			adapter.set(getClass().getName(),filter);
		}
		return adapter.get(getClass().getName());
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
		if (adapter!=null) {
			ImmutableSet<String> result = ImmutableSet.copyOf(adapter.getImportedNames());
			return result;
		}
		return Collections.emptySet();
	}
	
	public Resource getResource() {
		return resource;
	}

	public URI getURI() {
		return resource.getURI();
	}

	public IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}
	
}
