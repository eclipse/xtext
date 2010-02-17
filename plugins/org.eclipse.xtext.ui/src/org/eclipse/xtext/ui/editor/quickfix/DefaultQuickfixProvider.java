/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.validation.IssueContext;
import org.eclipse.xtext.validation.IssueResolution;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class DefaultQuickfixProvider extends AbstractDeclarativeQuickfixProvider {
	
	@Inject
	private IScopeProvider scopeProvider;
	
	public void setScopeProvider(IScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}
	
	private CrossReference findCrossReference(EObject context, AbstractNode node) {
		if(node == null || context.equals(node.getElement()))
			return null;
		
		EObject grammarElement = node.getGrammarElement();
		if (grammarElement instanceof CrossReference) {
			return (CrossReference) grammarElement;
		} else
			return findCrossReference(context, (AbstractNode)node.eContainer());
	}

	public List<IssueResolution> getResolutionsForLinkingIssue(IssueContext context) {
		EObject target = context.getModel();
		CompositeNode rootNode = NodeUtil.getRootNode(target);
		AbstractNode leaf = NodeUtil.findLeafNodeAtOffset(rootNode, context.getIssue().getOffset() + 1);
		
		CrossReference cr = findCrossReference(target, leaf);
		if(cr==null)
			return Collections.emptyList();
		
		EReference reference = GrammarUtil.getReference(cr);
		if(reference == null)
			return Collections.emptyList();
		
		IScope scope = getScopeProvider().getScope(target, reference);
		String leafString = context.getContent().substring(context.getIssue().getOffset(), context.getIssue().getOffset() + context.getIssue().getLength());
		return getResolutionsForLinkingIssue(target, reference, scope, leafString);
	}

	public List<IssueResolution> getResolutionsForLinkingIssue(EObject target, EReference reference, IScope scope,
			String leafString) {
		List<IssueResolution> result = new ArrayList<IssueResolution>();
		
		for(IEObjectDescription desc : getMatchingDescriptionsForLinkingIssue(scope, target, reference, leafString)) {
			if(EcoreUtil2.isAssignableFrom(reference.getEReferenceType(), desc.getEClass()))
				result.add(new FeatureSettingIssueResolution(target, reference, desc.getName(), desc.getEObjectOrProxy()));
		}
		
		return result;
	}

	public Iterable<IEObjectDescription> getMatchingDescriptionsForLinkingIssue(final IScope scope, final EObject model,
			final EReference reference, final String leafString) {
		// TODO: work more explicit with true qualified name delimiter instead of word break
		// TODO: and/or reuse code available in content assist
		
		final String regex = "(?i)(^|.*?\\W)" + Pattern.quote(leafString) + ".*"; 
		
		return Iterables.filter(scope.getAllContents(), new Predicate<IEObjectDescription>() {

			public boolean apply(IEObjectDescription input) {
				return input.getName().matches(regex) || input.getQualifiedName().matches(regex);
			}

		});
	}

	@Override
	public List<IssueResolution> getResolutions(IssueContext context) {
		if(Diagnostic.LINKING_DIAGNOSTIC.equals(context.getIssue().getCode())) {
			List<IssueResolution> result = new ArrayList<IssueResolution>();
			result.addAll(getResolutionsForLinkingIssue(context));
			result.addAll(super.getResolutions(context));
			return result;
		} else
			return super.getResolutions(context);
	}

	@Override
	public boolean hasResolutionFor(String issueCode) {
		return Diagnostic.LINKING_DIAGNOSTIC.equals(issueCode) || super.hasResolutionFor(issueCode);
	}

	

}
