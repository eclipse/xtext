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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.SimpleAttributeResolver;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class ReferenceQueryExecutor {

	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private ReferenceQuery referenceQuery;

	protected Iterable<URI> getTargetURIs(EObject primaryTarget) {
		return singleton(EcoreUtil2.getPlatformResourceOrNormalizedURI(primaryTarget));
	}

	public String getLabel(EObject primaryTarget) {
		StringBuilder builder = new StringBuilder();
		builder.append(getLabelPrefix());
		builder.append(getElementName(primaryTarget));
		String resourceName = getResourceName(primaryTarget);
		if (resourceName != null) {
			builder.append(Messages.FindReferencesHandler_1).append(resourceName)
					.append(Messages.FindReferencesHandler_2);
		}
		return builder.toString();
	}

	protected String getLabelPrefix() {
		return Messages.FindReferencesHandler_labelPrefix;
	}

	protected String getElementName(EObject primaryTarget) {
		QualifiedName qualifiedName = qualifiedNameProvider.getFullyQualifiedName(primaryTarget);
		if (qualifiedName != null) {
			return qualifiedNameConverter.toString(qualifiedName);
		}
		String simpleName = SimpleAttributeResolver.NAME_RESOLVER.getValue(primaryTarget);
		return (simpleName != null) ? simpleName : primaryTarget.eResource().getURIFragment(primaryTarget);
	}

	protected String getResourceName(EObject primaryTarget) {
		Iterator<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(EcoreUtil.getURI(primaryTarget))
				.iterator();
		return (storages.hasNext()) ? storages.next().getFirst().getFullPath().toString() : null;
	}

	protected Predicate<IReferenceDescription> getFilter(EObject primaryTarget) {
		return Predicates.alwaysTrue();
	}

	public void init(EObject target) {
		referenceQuery.init(getTargetURIs(target), getFilter(target), getLabel(target));
	}

	public void execute() {
		NewSearchUI.activateSearchResultView();
		NewSearchUI.runQueryInBackground(referenceQuery);
	}
}
