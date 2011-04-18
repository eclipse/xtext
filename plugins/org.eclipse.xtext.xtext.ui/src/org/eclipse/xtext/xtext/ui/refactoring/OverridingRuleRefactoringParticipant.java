/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.refactoring;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.ui.editor.findrefs.FindReferenceQueryDataFactory;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.IQueryData;
import org.eclipse.xtext.ui.refactoring.impl.AbstractProcessorBasedRenameParticipant;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class OverridingRuleRefactoringParticipant extends AbstractProcessorBasedRenameParticipant {

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private FindReferenceQueryDataFactory queryDataFactory;

	@Inject
	private IResourceDescriptions resourceDescriptions;
	
	@Override
	protected EObject getRenamedElement(EObject originalTarget) {
		if(originalTarget instanceof AbstractRule) {
			final String ruleName = ((AbstractRule)originalTarget).getName();
			Grammar grammar = GrammarUtil.getGrammar(originalTarget);
			IQueryData queryData = queryDataFactory.createQueryData(grammar, null);
			final List<IEObjectDescription> overridingRules = newArrayList();
			IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
				public void accept(IReferenceDescription referenceToGrammar) {
					if(referenceToGrammar.getEReference() == XtextPackage.Literals.GRAMMAR__USED_GRAMMARS) {
						IResourceDescription resourceDescription = resourceDescriptions.getResourceDescription(referenceToGrammar.getSourceEObjectUri().trimFragment());
						for(IEObjectDescription rule: resourceDescription.getExportedObjectsByType(XtextPackage.Literals.ABSTRACT_RULE)) {
							if(Strings.equal(ruleName, rule.getQualifiedName().getLastSegment())) {
								overridingRules.add(rule);
								break;
							}
						}
					}
				}
			};
			referenceFinder.findIndexedReferences(queryData, acceptor, new NullProgressMonitor());
			for(IEObjectDescription overridingRule: overridingRules) {
				// TODO: handle more than one subgrammar
				return overridingRule.getEObjectOrProxy();
			}
		}
		return null;
	}

}
