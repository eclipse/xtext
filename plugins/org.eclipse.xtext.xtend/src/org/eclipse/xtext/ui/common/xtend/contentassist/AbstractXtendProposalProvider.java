/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.xtend.contentassist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.AbstractJavaProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.ProposalFilterSorterUtil;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.XtextCompletionProposal;
import org.eclipse.xtext.ui.common.xtend.AbstractXtendService;
import org.eclipse.xtext.ui.common.xtend.NoSuchExtensionException;
import org.eclipse.xtext.util.Strings;

/**
 * Super class for <code>IProposalProvider</code> implementations that call
 * Xtend extensions.
 * 
 * Delegates calls to {@link #completeRuleCall(RuleCall, IContentAssistContext)}
 * and {@link #completeAssignment(Assignment, IContentAssistContext)} to grammar
 * specific extensions. The signature of such funcions invoked reflectively
 * follows the following pattern:
 * 
 * List[ICompletionProposal] complete[Typename][featureName](Assignment ele,
 * EObject model, String prefix)
 * 
 * <b>Example</b> Given the following grammar : <code>
 *  RuleA returns MyType :
 *  	"myType" name=ID;
 *  </code>
 * 
 * @author Jan K&ouml;hnlein
 * @author Michael Clay
 * 
 * @see IProposalProvider
 * @see AbstractJavaProposalProvider
 */
public abstract class AbstractXtendProposalProvider extends AbstractXtendService implements IProposalProvider {

	protected final Logger logger = Logger.getLogger(IProposalProvider.class);

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeKeyword(Keyword, IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeKeyword(Keyword keyword,
			IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeKeyword '" + keyword.getValue() + "' for model '" + contentAssistContext.getModel()
					+ "' and prefix '" + contentAssistContext.getMatchString().trim() + "'");
		}
		return Collections
				.singletonList(new XtextCompletionProposal(keyword, keyword.getValue(), contentAssistContext));
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeRuleCall(RuleCall, IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '" + ruleCall.getRule().getName() + "' cardinality '"
					+ ruleCall.getCardinality() + "' for model '" + contentAssistContext.getModel() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim().trim() + "'");
		}
		AbstractRule calledRule = ruleCall.getRule();
		if (calledRule instanceof LexerRule) {
			return completeLexerRuleRuleCall((LexerRule) calledRule, ruleCall, contentAssistContext);
		}
		else if (calledRule.getType() != null) {
			TypeRef typeRef = calledRule.getType();
			return invokeExtension("complete" + Strings.toFirstUpper(typeRef.getMetamodel().getAlias()) + "_"
					+ Strings.toFirstUpper(typeRef.getType().getName()), Arrays.asList(ruleCall, contentAssistContext
					.getModel(), contentAssistContext));
		}
		return Collections.emptyList();
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeAssignment(Assignment, IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeAssignment(Assignment assignment,
			IContentAssistContext contentAssistContext) {
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);
		return invokeExtension("complete" + Strings.toFirstUpper(parserRule.getName()) + "_"
				+ Strings.toFirstUpper(assignment.getFeature()), Arrays.asList(assignment, contentAssistContext));
	}

	@SuppressWarnings("unchecked")
	protected List<? extends ICompletionProposal> invokeExtension(String extensionName, List<?> parameterValues) {
		try {
			Object result = super.invokeExtension(extensionName, parameterValues);
			List<ICompletionProposal> proposals = (List<ICompletionProposal>) result;
			return proposals;
		}
		catch(NoSuchExtensionException nsee) {
			return null;
		}
		catch(ClassCastException cce) {
			logger.error("Extension " + extensionName + " must return a Collection of ICompletionProposals.", cce);
		}
		catch(Throwable e) {
			logger.error("Error invoking extension " + extensionName, e);
		}
		return null;
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#getTemplateContextType(Keyword, IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(Keyword keyword, IContentAssistContext contentAssistContext) {
		return null;
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#getTemplateContextType(RuleCall, IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		return null;
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#getTemplates(String)
	 */
	public Template[] getTemplates(String contextTypeId) {
		return new Template[] {};
	}

	protected List<? extends ICompletionProposal> completeLexerRuleRuleCall(LexerRule lexerRule, RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		return invokeExtension("complete" + lexerRule.getName(), Arrays.asList(ruleCall, contentAssistContext));
	}

	/**
	 * @return the id of the plug-in containing the image files;
	 *         <code>null </code> is returned if the plug-in does not exist
	 */
	protected abstract String getPluginId();

	/**
	 * Returns the the relative path of the default image file, relative to the
	 * root of the containing plug-in; the path must be legal The image would
	 * typically be shown to the left of the <code>ICompletionProposal</code>
	 * display string.
	 * 
	 * @return the image file path of the default image to be shown or
	 *         <code>null</code> if no image is desired
	 * @see #getPluginId()
	 */
	protected String getDefaultImageFilePath() {
		return "icons/editor.gif";
	}
	
	/**
	 * Concrete subclasses can override this for custom sort and filter
	 * behavior. Called right after all completion proposals have been
	 * collected.
	 * 
	 * The default behavior of this implementation is to filter duplicates and
	 * to trim matching <code>ICompletionProposal#displayString</code> with
	 * matching prefix values.
	 * 
	 * @see #sortAndFilter(List, EObject, String, IDocument, int, AbstractNode,
	 *      LeafNode)
	 */
	public List<? extends ICompletionProposal> sortAndFilter(
			List<? extends ICompletionProposal> completionProposalList, IContentAssistContext contentAssistContext) {
		return ProposalFilterSorterUtil.sortAndFilter(completionProposalList, contentAssistContext);
	}
}
