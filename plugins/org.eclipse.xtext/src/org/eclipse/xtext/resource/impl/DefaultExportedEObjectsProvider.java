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
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IExportedEObjectsProvider;
import org.eclipse.xtext.resource.IQualifiedNameProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultExportedEObjectsProvider implements IExportedEObjectsProvider {
	
	@Inject
	private IQualifiedNameProvider nameProvider;
	
	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}
	
	private final static Logger log = Logger.getLogger(DefaultExportedEObjectsProvider.class);

	public Iterable<IEObjectDescription> getExportedObjects(final Resource resource) {
		if (!resource.isLoaded()) {
			try {
				resource.load(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				return Iterables.emptyIterable();
			}
		}
		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllProperContents(resource, true);
			}
		};
		Iterable<IEObjectDescription> result = transform(contents, new Function<EObject, IEObjectDescription>() {
			public IEObjectDescription apply(EObject from) {
				return createIEObjectDescription(from);
			}
		});
		return Iterables.filter(result,Predicates.notNull());
	}

	protected IEObjectDescription createIEObjectDescription(EObject from) {
		String qualifiedName = nameProvider.getQualifiedName(from);
		if (qualifiedName != null) {
			return EObjectDescription.create(qualifiedName, from);
		}
		return null;
	}

}
