/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static java.util.Collections.*;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IGlobalServiceProvider;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.IQueryData;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FindReferenceQueryDataFactory {

	@Inject
	protected IGlobalServiceProvider globalServiceProvider;

	public IQueryData createQueryData(EObject element, URI localResourceURI) {
		URI targetURI = EcoreUtil.getURI(element);
		IQueryData queryData = new ReferenceQueryData(targetURI, createTargetURIs(element), localResourceURI,
				createResultFilter(element), createLabel(element));
		return queryData;
	}

	protected Set<URI> createTargetURIs(EObject target) {
		return singleton(EcoreUtil.getURI(target));
	}

	protected Predicate<IReferenceDescription> createResultFilter(EObject target) {
		return null;
	}

	protected String createLabel(EObject target) {
		QueryLabelProvider queryLabelProvider = globalServiceProvider
				.findService(target, QueryLabelProvider.class);
		return queryLabelProvider.get(target);
	}

	public static class QueryLabelProvider {
		@Inject
		private IStorage2UriMapper storage2UriMapper;

		@Inject
		private IQualifiedNameProvider qualifiedNameProvider;

		@Inject
		private IQualifiedNameConverter qualifiedNameConverter;

		public String get(EObject target) {
			StringBuilder builder = new StringBuilder();
			builder.append(Messages.FindReferencesHandler_labelPrefix).append(
					qualifiedNameConverter.toString(qualifiedNameProvider.getFullyQualifiedName(target)));
			Iterator<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(EcoreUtil.getURI(target))
					.iterator();
			if (storages.hasNext()) {
				builder.append(Messages.FindReferencesHandler_1)
						.append(storages.next().getFirst().getFullPath().toString())
						.append(Messages.FindReferencesHandler_2);
			}
			return builder.toString();
		}
	}
}