/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
 package org.eclipse.xtext.ui.codetemplates.scoping;

import java.util.LinkedHashSet;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplate;
import org.eclipse.xtext.ui.codetemplates.templates.Codetemplates;
import org.eclipse.xtext.xtext.UsedRulesFinder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 *
 */
public class CodetemplatesScopeProvider extends AbstractDeclarativeScopeProvider {

	public IScope scope_Codetemplate_context(Codetemplate template, EReference reference) {
		Codetemplates root = EcoreUtil2.getContainerOfType(template, Codetemplates.class);
		if (root != null && root.getLanguage() != null) {
			Grammar grammar = root.getLanguage();
			if (!grammar.eIsProxy()) {
				LinkedHashSet<AbstractRule> usedRules = Sets.newLinkedHashSet();
				new UsedRulesFinder(usedRules).compute(grammar);
				return Scopes.scopeFor(Iterables.filter(usedRules, ParserRule.class));
			}
		}
		return IScope.NULLSCOPE;
	}
	
}
