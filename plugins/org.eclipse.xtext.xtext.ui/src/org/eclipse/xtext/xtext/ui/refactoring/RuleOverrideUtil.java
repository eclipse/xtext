/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.EditorResourceAccess;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RuleOverrideUtil {

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private IResourceDescriptions resourceDescriptions;

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;
	
	@Inject
	private EditorResourceAccess localContextProvider;

	public List<IEObjectDescription> getOverridingRules(final AbstractRule originalRule) {
		Grammar grammar = GrammarUtil.getGrammar(originalRule);

		final List<IEObjectDescription> overridingRules = newArrayList();
		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
			@Override
			public void accept(IReferenceDescription referenceToGrammar) {
				if (referenceToGrammar.getEReference() == XtextPackage.Literals.GRAMMAR__USED_GRAMMARS) {
					IResourceDescription resourceDescription = resourceDescriptions
							.getResourceDescription(referenceToGrammar.getSourceEObjectUri().trimFragment());
					for (IEObjectDescription rule : resourceDescription.getExportedObjectsByType(originalRule.eClass())) {
						if (Strings.equal(originalRule.getName(), rule.getQualifiedName().getLastSegment())) {
							overridingRules.add(rule);
							break;
						}
					}
				}
			}
		};
		referenceFinder.findAllReferences(singleton(EcoreUtil2.getPlatformResourceOrNormalizedURI(grammar)), localContextProvider, acceptor,
				new NullProgressMonitor());
		return overridingRules;
	}

	public List<IEObjectDescription> getOverriddenRules(final AbstractRule originalRule) {
		Grammar grammar = GrammarUtil.getGrammar(originalRule);
		final List<IEObjectDescription> overriddenRules = newArrayList();
		IAcceptor<AbstractRule> acceptor = new IAcceptor<AbstractRule>() {
			@Override
			public void accept(AbstractRule overriddenRule) {
				if (overriddenRule != null) {
					IEObjectDescription description = EObjectDescription.create(
							qualifiedNameProvider.getFullyQualifiedName(overriddenRule), overriddenRule);
					overriddenRules.add(description);
				}
			}
		};
		findOverriddenRule(originalRule, grammar.getUsedGrammars(), acceptor);
		return overriddenRules;
	}

	protected void findOverriddenRule(AbstractRule originalRule, List<Grammar> grammars,
			IAcceptor<AbstractRule> acceptor) {
		for (Grammar grammar : grammars) {
			for (AbstractRule rule : grammar.getRules()) {
				if (rule.eClass() == originalRule.eClass() && Strings.equal(rule.getName(), originalRule.getName())) {
					acceptor.accept(rule);
				}
			}
			findOverriddenRule(originalRule, grammar.getUsedGrammars(), acceptor);
		}
	}
}
