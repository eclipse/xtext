/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.scoping;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.ui.codetemplates.scoping.CodetemplatesScopeProvider;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplates;
import org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplateResourceProvider;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntheticResourceAwareScopeProvider extends CodetemplatesScopeProvider {

	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	public IScope scope_Codetemplates_language(Codetemplates templates, EReference reference) {
		if (TemplateResourceProvider.SYNTHETIC_SCHEME.equals(templates.eResource().getURI().scheme())) {
			ResourceSet resourceSet = templates.eResource().getResourceSet();
			List<Grammar> grammars = Lists.newArrayListWithExpectedSize(1);
			for(Resource resource: resourceSet.getResources()) {
				EObject root = resource.getContents().get(0);
				if (root instanceof Grammar) {
					grammars.add((Grammar) root);
				}
			}
			return Scopes.scopeFor(grammars, new Function<Grammar, QualifiedName>() {

				@Override
				public QualifiedName apply(Grammar from) {
					return qualifiedNameConverter.toQualifiedName(from.getName());
				}
				
			}, IScope.NULLSCOPE);
		} else {
			return delegateGetScope(templates, reference);
		}
	}
}
