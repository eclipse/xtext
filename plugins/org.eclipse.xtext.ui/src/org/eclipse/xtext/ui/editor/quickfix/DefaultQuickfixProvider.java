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
		final IModificationContext modificationContext = modificationContextFactory.createModificationContext(issue);
		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		return xtextDocument.readOnly(new IUnitOfWork<List<IssueResolution>, XtextResource>() {
			public List<IssueResolution> exec(XtextResource state) throws Exception {
				EObject target = state.getEObject(issue.getUriToProblem().fragment());
				EReference reference = getUnresolvedEReference(issue, target);
				if (reference == null)
					return Collections.emptyList();

				String issueString = xtextDocument.get(issue.getOffset(), issue.getLength());
				IScope scope = scopeProvider.getScope(target, reference);
				final IssueResolutionAcceptor issueResolutionAcceptor = issueResolutionAcceptorProvider.get();
				for (IEObjectDescription referableElement : scope.getAllContents()) {
					String replacement = referableElement.getName();
					if (similarityMatcher.isSimilar(issueString, replacement)) {
						String replaceLabel = fixCrossReferenceLabel(issueString, replacement);
						issueResolutionAcceptor.accept(issue, replaceLabel, replaceLabel, fixCrossReferenceImage(
								issueString, replacement), new ReplaceModification(issue, replacement));
					}
				}
				return issueResolutionAcceptor.getIssueResolutions();
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
