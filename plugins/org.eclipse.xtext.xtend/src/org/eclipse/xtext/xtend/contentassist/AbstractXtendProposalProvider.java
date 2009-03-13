/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.contentassist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.AbstractJavaProposalProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.ProposalFilterSorterUtil;
import org.eclipse.xtext.ui.common.editor.contentassist.impl.XtextCompletionProposal;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtend.AbstractXtendService;
import org.eclipse.xtext.xtend.NoSuchExtensionException;

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
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeKeyword(Keyword,
	 *      IContentAssistContext)
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
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeRuleCall(RuleCall,
	 *      IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeRuleCall(RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		if (logger.isDebugEnabled()) {
			logger.debug("completeRuleCall '" + ruleCall.getRule().getName() + "' cardinality '"
					+ ruleCall.getCardinality() + "' for model '" + contentAssistContext.getModel() + "' and prefix '"
					+ contentAssistContext.getMatchString().trim().trim() + "'");
		}
		AbstractRule calledRule = ruleCall.getRule();
		if (calledRule instanceof TerminalRule) {
			return completeTerminalRuleRuleCall((TerminalRule) calledRule, ruleCall, contentAssistContext);
		}
		else if (calledRule.getType() != null) {
			TypeRef typeRef = calledRule.getType();
			return invokeExtension("complete" + Strings.toFirstUpper(typeRef.getMetamodel().getAlias()) + "_"
					+ Strings.toFirstUpper(typeRef.getClassifier().getName()), Arrays.asList(contentAssistContext
					.getModel(), ruleCall, contentAssistContext));
		}
		return Collections.emptyList();
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#completeAssignment(Assignment,
	 *      IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> completeAssignment(Assignment assignment,
			IContentAssistContext contentAssistContext) {
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);
		return invokeExtension("complete" + Strings.toFirstUpper(parserRule.getName()) + "_"
				+ Strings.toFirstUpper(assignment.getFeature()), Arrays.asList(contentAssistContext.getModel(),
				assignment, contentAssistContext));
	}

	protected List<? extends ICompletionProposal> invokeExtension(String extensionName, List<?> parameterValues) {
		try {
			List<ICompletionProposal> proposals = super.invokeExtension(extensionName, parameterValues);
			return proposals;
		}
		catch (NoSuchExtensionException nsee) {
			return null;
		}
		catch (Throwable e) {
			logger.error("Error invoking extension " + extensionName, e);
		}
		return null;
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#getTemplateContextType(Keyword,
	 *      IContentAssistContext)
	 */
	public TemplateContextType getTemplateContextType(Keyword keyword, IContentAssistContext contentAssistContext) {
		return null;
	}

	/**
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#getTemplateContextType(RuleCall,
	 *      IContentAssistContext)
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

	protected List<? extends ICompletionProposal> completeTerminalRuleRuleCall(TerminalRule lexerRule, RuleCall ruleCall,
			IContentAssistContext contentAssistContext) {
		return invokeExtension("complete" + lexerRule.getName(), Arrays.asList(ruleCall, contentAssistContext));
	}

	/**
	 * Returns the the relative path of the default image file, relative to the
	 * root of the containing plug-in; the path must be legal The image would
	 * typically be shown to the left of the <code>ICompletionProposal</code>
	 * display string.
	 * 
	 * @return the image file path of the default image to be shown or <code>null</code> if no image is desired
	 * @see #getPluginId()
	 */
	protected String getDefaultImageFilePath() {
		return "icons/editor.gif";
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#filter(java.util.List, org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext)
	 */
	public List<? extends ICompletionProposal> filter(List<ICompletionProposal> completionProposalList,
			IContentAssistContext contentAssistContext) {
		return ProposalFilterSorterUtil.filter(completionProposalList, contentAssistContext);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider#sort(java.util.List)
	 */
	public List<? extends ICompletionProposal> sort(List<ICompletionProposal> completionProposalList) {
		return ProposalFilterSorterUtil.sort(completionProposalList);
	}
}
