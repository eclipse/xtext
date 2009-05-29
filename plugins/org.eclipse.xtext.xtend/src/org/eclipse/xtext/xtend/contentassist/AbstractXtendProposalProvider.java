/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.contentassist;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.AbstractContentProposalProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtend.AbstractXtendExecutionException;
import org.eclipse.xtext.xtend.NoSuchExtensionException;
import org.eclipse.xtext.xtend.XtendServiceHelper;

import com.google.inject.Inject;

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
public abstract class AbstractXtendProposalProvider extends AbstractContentProposalProvider {

	private static final Logger logger = Logger.getLogger(AbstractXtendProposalProvider.class);

	private XtendServiceHelper helper;

	@Inject
	public void setHelper(XtendServiceHelper helper) {
		this.setHelper(helper);
		helper.setMasterXtendFileName(getMasterXtendFileName());
	}
	
	protected abstract String getMasterXtendFileName();

	public XtendServiceHelper getHelper() {
		return helper;
	}
	
	protected List<ICompletionProposal> invokeExtension(final String extensionName, final List<?> parameterValues)
		throws AbstractXtendExecutionException {
		try {
			List<ICompletionProposal> proposals = helper.invokeExtension(extensionName, parameterValues);
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

	@Override
	public void completeAssignment(Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		ParserRule parserRule = GrammarUtil.containingParserRule(assignment);
		String extensionName = "complete" + Strings.toFirstUpper(parserRule.getName()) + "_"
			+ Strings.toFirstUpper(assignment.getFeature());
		List<ICompletionProposal> proposals =  invokeExtension(extensionName, Arrays.asList(context.getCurrentModel(),
				assignment, context));
		addProposals(acceptor, proposals);
	}

	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		ICompletionProposal proposal = ContentAssistHelper.newProposal(keyword, keyword.getValue(), context);
		acceptor.accept(proposal);
	}

	@Override
	public void completeRuleCall(RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		AbstractRule calledRule = ruleCall.getRule();
		String extensionName = "complete_" + calledRule.getName();
		
		List<ICompletionProposal> proposals = invokeExtension(extensionName, Arrays.asList(context.getCurrentModel(), ruleCall, context));
		addProposals(acceptor, proposals);
	}

	private void addProposals(ICompletionProposalAcceptor acceptor, List<ICompletionProposal> proposals) {
		if (proposals != null) {
			for(ICompletionProposal proposal: proposals) {
				if (!acceptor.canAcceptMoreProposals())
					return;
				acceptor.accept(proposal);
			}
		}
	}

}
