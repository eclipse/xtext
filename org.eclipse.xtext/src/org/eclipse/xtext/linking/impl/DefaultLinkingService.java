/*******************************************************************************
 * Copyright (c) 2008, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.IDelegatingScopeProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Michael Clay
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Moritz Eysholdt
 */
public class DefaultLinkingService extends AbstractLinkingService {

	private static final Logger logger = Logger.getLogger(DefaultLinkingService.class);
	
	@Inject
	@LinkingScopeProviderBinding
	private IScopeProvider scopeProvider;

	@Inject
	private Provider<ImportedNamesAdapter> importedNamesAdapterProvider;
	
	@Inject 
	private LinkingHelper linkingHelper;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;

	protected IScope getScope(EObject context, EReference reference) {
		if (getScopeProvider() == null)
			throw new IllegalStateException("scopeProvider must not be null.");
		try {
			registerImportedNamesAdapter(context);
			return getScopeProvider().getScope(context, reference);
		} finally {
			unRegisterImportedNamesAdapter();
		}
	}

	protected void unRegisterImportedNamesAdapter() {
		unRegisterImportedNamesAdapter(getScopeProvider());
	}
	
	protected void unRegisterImportedNamesAdapter(IScopeProvider scopeProvider) {
		IDelegatingScopeProvider.setWrapper(scopeProvider, null);
	}

	protected void registerImportedNamesAdapter(EObject context) {
		registerImportedNamesAdapter(getScopeProvider(), context);
	}
	
	protected void registerImportedNamesAdapter(IScopeProvider scopeProvider, EObject context) {
		ImportedNamesAdapter adapter = getImportedNamesAdapter(context);
		IDelegatingScopeProvider.setWrapper(scopeProvider, adapter);
	}

	protected ImportedNamesAdapter getImportedNamesAdapter(EObject context) {
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(context.eResource());
		if (adapter!=null)
			return adapter;
		ImportedNamesAdapter importedNamesAdapter = importedNamesAdapterProvider.get();
		context.eResource().eAdapters().add(importedNamesAdapter);
		return importedNamesAdapter;
	}

	/**
	 * @return the first element returned from the injected {@link IScopeProvider} which matches the text of the passed
	 *         {@link INode node}
	 */
	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference ref, INode node) throws IllegalNodeException {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null) {
			return Collections.<EObject>emptyList();
		}
		final String crossRefString = getCrossRefNodeAsString(node);
		if (crossRefString == null || crossRefString.equals("")) {
			return Collections.<EObject>emptyList();
		}
		if (logger.isDebugEnabled()) {
			logger.debug("before getLinkedObjects: node: '" + crossRefString + "'");
		}
		final IScope scope = getScope(context, ref);
		if (scope == null) {
			throw new AssertionError(
					"Scope provider " + scopeProvider.getClass().getName() + " must not return null for context "
							+ context + ", reference " + ref + "! Consider to return IScope.NULLSCOPE instead.");
		}
		final QualifiedName qualifiedLinkName = qualifiedNameConverter.toQualifiedName(crossRefString);
		final IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedLinkName);
		if (logger.isDebugEnabled()) {
			logger.debug("after getLinkedObjects: node: '" + crossRefString + "' result: " + eObjectDescription);
		}
		if (eObjectDescription == null) {
			return Collections.emptyList();
		}
		final EObject result = eObjectDescription.getEObjectOrProxy();
		return Collections.singletonList(result);
	}
	
	public String getCrossRefNodeAsString(INode node) throws IllegalNodeException {
		return linkingHelper.getCrossRefNodeAsString(node, true);
	}

	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	protected LinkingHelper getLinkingHelper() {
		return linkingHelper;
	}

}
