/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Jan Koehnlein
 */
public class DefaultQuickfixProvider extends AbstractDeclarativeQuickfixProvider {

	@Inject
	private ISimilarityMatcher similarityMatcher;

	@Inject
	private IssueModificationContext.Factory modificationContextFactory;

	@Inject
	private Provider<IssueResolutionAcceptor> issueResolutionAcceptorProvider;

	@Inject
	private IScopeProvider scopeProvider;

	private CrossReference findCrossReference(EObject context, AbstractNode node) {
		if (node == null || context.equals(node.getElement()))
			return null;

		EObject grammarElement = node.getGrammarElement();
		if (grammarElement instanceof CrossReference) {
			return (CrossReference) grammarElement;
		} else
			return findCrossReference(context, (AbstractNode) node.eContainer());
	}

	public List<IssueResolution> getResolutionsForLinkingIssue(final Issue issue) {
		final IssueResolutionAcceptor issueResolutionAcceptor = issueResolutionAcceptorProvider.get();
		createLinkingIssueResolutions(issue, issueResolutionAcceptor);
		return issueResolutionAcceptor.getIssueResolutions();
	}

	public void createLinkingIssueResolutions(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		final IModificationContext modificationContext = modificationContextFactory.createModificationContext(issue);
		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		xtextDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				EObject target = state.getEObject(issue.getUriToProblem().fragment());
				EReference reference = getUnresolvedEReference(issue, target);
				if (reference == null)
					return;

				String issueString = xtextDocument.get(issue.getOffset(), issue.getLength());
				IScope scope = scopeProvider.getScope(target, reference);
				List<IEObjectDescription> discardedDescriptions = Lists.newArrayList();
				Set<String> qualifiedNames = Sets.newHashSet();
				int addedDescriptions = 0;
				for (IEObjectDescription referableElement : scope.getAllContents()) {
					if (similarityMatcher.isSimilar(issueString, referableElement.getName())) {
						addedDescriptions++;
						createResolution(issueString, referableElement);
						qualifiedNames.add(referableElement.getQualifiedName());
					} else {
						if (qualifiedNames.add(referableElement.getQualifiedName()))
							discardedDescriptions.add(referableElement);
					}
				}
				if (discardedDescriptions.size() + addedDescriptions <= 5) {
					for(IEObjectDescription referableElement: discardedDescriptions) {
						createResolution(issueString, referableElement);
					}
				}
			}
			
			public void createResolution(String issueString, IEObjectDescription solution) {
				String replacement = solution.getName();
				String replaceLabel = fixCrossReferenceLabel(issueString, replacement);
				issueResolutionAcceptor.accept(issue, replaceLabel, replaceLabel, fixCrossReferenceImage(
						issueString, replacement), new ReplaceModification(issue, replacement));
			}

		});
	}

	protected EReference getUnresolvedEReference(final Issue issue, EObject target) {
		CompositeNode rootNode = NodeUtil.getRootNode(target);
		AbstractNode leaf = NodeUtil.findLeafNodeAtOffset(rootNode, issue.getOffset() + 1);
		CrossReference crossReference = findCrossReference(target, leaf);
		if (crossReference != null) {
			return  GrammarUtil.getReference(crossReference);
		}
		return null;
	}

	protected String fixCrossReferenceLabel(String issueString, String replacement) {
		return "Change to '" + replacement + "'";
	}

	protected String fixCrossReferenceImage(String issueString, String replacement) {
		return "";
	}

	@Override
	public List<IssueResolution> getResolutions(Issue issue) {
		if (Diagnostic.LINKING_DIAGNOSTIC.equals(issue.getCode())) {
			List<IssueResolution> result = new ArrayList<IssueResolution>();
			result.addAll(getResolutionsForLinkingIssue(issue));
			result.addAll(super.getResolutions(issue));
			return result;
		} else
			return super.getResolutions(issue);
	}

	@Override
	public boolean hasResolutionFor(String issueCode) {
		return Diagnostic.LINKING_DIAGNOSTIC.equals(issueCode) || super.hasResolutionFor(issueCode);
	}

}
