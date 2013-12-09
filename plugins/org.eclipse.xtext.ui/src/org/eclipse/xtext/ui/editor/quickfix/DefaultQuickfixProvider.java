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

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.ICaseInsensitivityHelper;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.IssueModificationContext;
import org.eclipse.xtext.util.StopWatch;
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

	private static final Logger logger = Logger.getLogger(DefaultQuickfixProvider.class);
	
	@Inject
	private ISimilarityMatcher similarityMatcher;

	@Inject
	private IssueModificationContext.Factory modificationContextFactory;

	@Inject
	private Provider<IssueResolutionAcceptor> issueResolutionAcceptorProvider;

	@Inject
	private IScopeProvider scopeProvider;
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
	@Inject
	private ICaseInsensitivityHelper caseInsensitivityHelper;
	
	@Inject
	private CrossRefResolutionConverter converter;

	/**
	 *
	 * Can be sub classed to supress usage of value converter for e.g. operators.
	 *
	 * @since 2.4
	 */
	public static class CrossRefResolutionConverter {
		@Inject
		private IValueConverterService valueConverter;

		public String convertToString(String replacement, String ruleName) {
			try {
				return valueConverter.toString(replacement, ruleName);
			} catch (ValueConverterException e) {
				return null;
			}
		}
	}

	private CrossReference findCrossReference(EObject context, INode node) {
		if (node == null || (node.hasDirectSemanticElement() && context.equals(node.getSemanticElement())))
			return null;

		EObject grammarElement = node.getGrammarElement();
		if (grammarElement instanceof CrossReference) {
			return (CrossReference) grammarElement;
		} else
			return findCrossReference(context, node.getParent());
	}

	public List<IssueResolution> getResolutionsForLinkingIssue(final Issue issue) {
		final IssueResolutionAcceptor issueResolutionAcceptor = issueResolutionAcceptorProvider.get();
		createLinkingIssueResolutions(issue, issueResolutionAcceptor);
		return issueResolutionAcceptor.getIssueResolutions();
	}

	public void createLinkingIssueResolutions(final Issue issue, final IssueResolutionAcceptor issueResolutionAcceptor) {
		final IModificationContext modificationContext = modificationContextFactory.createModificationContext(issue);
		final IXtextDocument xtextDocument = modificationContext.getXtextDocument();
		if (xtextDocument == null)
			return;
		xtextDocument.readOnly(new IUnitOfWork.Void<XtextResource>() {
			@Override
			public void process(XtextResource state) throws Exception {
				EObject target = state.getEObject(issue.getUriToProblem().fragment());
				EReference reference = getUnresolvedEReference(issue, target);
				if (reference == null)
					return;
				fixUnresolvedReference(issue, xtextDocument, target, reference);
			}

			protected void fixUnresolvedReference(final Issue issue, final IXtextDocument xtextDocument,
					EObject target, EReference reference) throws BadLocationException {
				boolean caseInsensitive = caseInsensitivityHelper.isIgnoreCase(reference);
				EObject crossReferenceTerminal = getCrossReference(issue, target);
				String ruleName = null;
				Keyword keyword = null;
				if (crossReferenceTerminal instanceof RuleCall) {
					RuleCall ruleCall = (RuleCall) crossReferenceTerminal;
					ruleName = ruleCall.getRule().getName();
				} else if (crossReferenceTerminal instanceof Keyword) {
					keyword = (Keyword) crossReferenceTerminal;
				}
				String issueString = xtextDocument.get(issue.getOffset(), issue.getLength());
				IScope scope = scopeProvider.getScope(target, reference);
				List<IEObjectDescription> discardedDescriptions = Lists.newArrayList();
				Set<String> qualifiedNames = Sets.newHashSet();
				int addedDescriptions = 0;
				int checkedDescriptions = 0;
				for (IEObjectDescription referableElement : queryScope(scope)) {
					String referableElementQualifiedName = qualifiedNameConverter.toString(referableElement.getQualifiedName());
					if (similarityMatcher.isSimilar(issueString, qualifiedNameConverter.toString(referableElement.getName()))) {
						addedDescriptions++;
						createResolution(issueString, referableElement, ruleName, keyword, caseInsensitive);
						qualifiedNames.add(referableElementQualifiedName);
					} else {
						if (qualifiedNames.add(referableElementQualifiedName))
							discardedDescriptions.add(referableElement);
					}
					checkedDescriptions++;
					if (checkedDescriptions>100)
						break;
				}
				if (discardedDescriptions.size() + addedDescriptions <= 5) {
					for(IEObjectDescription referableElement: discardedDescriptions) {
						createResolution(issueString, referableElement, ruleName, keyword, caseInsensitive);
					}
				}
			}

			protected AbstractElement getCrossReference(final Issue issue, EObject target) {
				final ICompositeNode node = NodeModelUtils.getNode(target);
				if (node == null)
					throw new IllegalStateException("Cannot happen since we found a reference");
				ICompositeNode rootNode = node.getRootNode();
				ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, issue.getOffset());
				CrossReference crossReference = findCrossReference(target, leaf);
				return crossReference.getTerminal();
			}

			public void createResolution(String issueString, IEObjectDescription solution, String ruleName, Keyword keyword, boolean caseInsensitive) {
				String replacement = qualifiedNameConverter.toString(solution.getName());
				String replaceLabel = fixCrossReferenceLabel(issueString, replacement);
				if (keyword != null) {
					if (caseInsensitive && !replacement.equalsIgnoreCase(keyword.getValue()))
						return;
					if (!caseInsensitive && !replacement.equals(keyword.getValue()))
						return;
				} else if (ruleName != null) {
					replacement = converter.convertToString(replacement, ruleName);
					if (replacement == null) {
						return;
					}
				} else {
					logger.error("either keyword or ruleName have to present", new IllegalStateException());
				}
				issueResolutionAcceptor.accept(issue, replaceLabel, replaceLabel, fixCrossReferenceImage(
						issueString, replacement), new ReplaceModification(issue, replacement));
			}

		});
	}
	
	protected Iterable<IEObjectDescription> queryScope(IScope scope) {
		return scope.getAllElements();
	}

	protected EReference getUnresolvedEReference(final Issue issue, EObject target) {
		final ICompositeNode node = NodeModelUtils.getNode(target);
		if (node==null)
			return null;
		ICompositeNode rootNode = node.getRootNode();
		ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(rootNode, issue.getOffset());
		CrossReference crossReference = findCrossReference(target, leaf);
		if (crossReference != null) {
			return  GrammarUtil.getReference(crossReference, target.eClass());
		}
		return null;
	}

	protected String fixCrossReferenceLabel(String issueString, String replacement) {
		return Messages.DefaultQuickfixProvider_changeTo + replacement + Messages.DefaultQuickfixProvider_1;
	}

	protected String fixCrossReferenceImage(String issueString, String replacement) {
		return ""; //$NON-NLS-1$
	}

	@Override
	public List<IssueResolution> getResolutions(Issue issue) {
		StopWatch stopWatch = new StopWatch(logger);
		try {
			if (Diagnostic.LINKING_DIAGNOSTIC.equals(issue.getCode())) {
				List<IssueResolution> result = new ArrayList<IssueResolution>();
				result.addAll(getResolutionsForLinkingIssue(issue));
				result.addAll(super.getResolutions(issue));
				return result;
			} else
				return super.getResolutions(issue);
		} finally {
			stopWatch.resetAndLog("#getResolutions");			
		}
		
	}

	@Override
	public boolean hasResolutionFor(String issueCode) {
		return Diagnostic.LINKING_DIAGNOSTIC.equals(issueCode) || super.hasResolutionFor(issueCode);
	}

	/**
	 * @since 2.0
	 */
	protected IssueModificationContext.Factory getModificationContextFactory() {
		return modificationContextFactory;
	}

	/**
	 * @since 2.0
	 */
	protected IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	/**
	 * @since 2.0
	 */
	protected IQualifiedNameConverter getQualifiedNameConverter() {
		return qualifiedNameConverter;
	}

	/**
	 * @since 2.0
	 */
	protected ISimilarityMatcher getSimilarityMatcher() {
		return similarityMatcher;
	}
}
