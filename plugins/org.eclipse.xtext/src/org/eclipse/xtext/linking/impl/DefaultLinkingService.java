/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.linking.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeDelegatingScopeProvider;

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

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	private Provider<ImportedNamesAdapter> importedNamesAdapterProvider;
	
	@Inject 
	private LinkingHelper linkingHelper;

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

	private void unRegisterImportedNamesAdapter() {
		unRegisterImportedNamesAdapter(getScopeProvider());
	}
	
	private void unRegisterImportedNamesAdapter(IScopeProvider scopeProvider) {
		if (scopeProvider instanceof AbstractGlobalScopeDelegatingScopeProvider) {
			AbstractGlobalScopeDelegatingScopeProvider provider = (AbstractGlobalScopeDelegatingScopeProvider) scopeProvider;
			provider.setWrapper(null);
		} else if (scopeProvider instanceof AbstractDeclarativeScopeProvider) {
			AbstractDeclarativeScopeProvider declarativeScopeProvider = (AbstractDeclarativeScopeProvider) scopeProvider;
			unRegisterImportedNamesAdapter(declarativeScopeProvider.getDelegate());
		}
	}

	private void registerImportedNamesAdapter(EObject context) {
		registerImportedNamesAdapter(getScopeProvider(), context);
	}
	
	private void registerImportedNamesAdapter(IScopeProvider scopeProvider, EObject context) {
		if (scopeProvider instanceof AbstractGlobalScopeDelegatingScopeProvider) {
			AbstractGlobalScopeDelegatingScopeProvider provider = (AbstractGlobalScopeDelegatingScopeProvider) scopeProvider;
			ImportedNamesAdapter adapter = getImportedNamesAdapter(context);
			provider.setWrapper(adapter);
		} else if (scopeProvider instanceof AbstractDeclarativeScopeProvider) {
			AbstractDeclarativeScopeProvider declarativeScopeProvider = (AbstractDeclarativeScopeProvider) scopeProvider;
			registerImportedNamesAdapter(declarativeScopeProvider.getDelegate(), context);
		}
	}

	private ImportedNamesAdapter getImportedNamesAdapter(EObject context) {
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(context.eResource());
		if (adapter!=null)
			return adapter;
		ImportedNamesAdapter importedNamesAdapter = importedNamesAdapterProvider.get();
		context.eResource().eAdapters().add(importedNamesAdapter);
		return importedNamesAdapter;
	}

	/**
	 * @return the first element returned from the injected {@link IScopeProvider} which matches the text of the passed
	 *         {@link LeafNode}
	 */
	public List<EObject> getLinkedObjects(EObject context, EReference ref, AbstractNode node)
			throws IllegalNodeException {
		final EClass requiredType = ref.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();

		final IScope scope = getScope(context, ref);
		final String s = getCrossRefNodeAsString(node);
		if (s != null) {
			IEObjectDescription eObjectDescription = scope.getContentByName(s);
			if (eObjectDescription != null)
				return Collections.singletonList(eObjectDescription.getEObjectOrProxy());
		}
		return Collections.emptyList();
	}

	public String getCrossRefNodeAsString(AbstractNode node) throws IllegalNodeException {
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
