/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
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
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class ReferenceQueryExecutor {

	@Inject
	private Provider<TargetURIs> targetURIsProvider; 
	
	@Inject
	private TargetURICollector uriCollector;
	
	@Inject
	private IStorage2UriMapper storage2UriMapper;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	@Inject
	private ReferenceQuery referenceQuery;
	
	/**
	 * Returns an instance of {@link TargetURIs} by default.
	 * Clients may override and enhance the result.
	 */
	protected Iterable<URI> getTargetURIs(EObject primaryTarget) {
		TargetURIs result = targetURIsProvider.get();
		uriCollector.add(primaryTarget, result);
		return result;
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
		Iterable<URI> targetURIs = getTargetURIs(target);
		Predicate<IReferenceDescription> filter = getFilter(target);
		String label = getLabel(target);
		referenceQuery.init(targetURIs, filter, label);
	}

	public void execute() {
		NewSearchUI.activateSearchResultView();
		NewSearchUI.runQueryInBackground(referenceQuery);
	}
}
