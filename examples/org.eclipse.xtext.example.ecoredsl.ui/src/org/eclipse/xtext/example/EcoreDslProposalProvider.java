/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

/**
 * Adds template completion support and customizes the default behaviour of <code>GenEcoreDslProposalProvider</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslProposalProvider extends GenEcoreDslProposalProvider {

	@Override
	public Template[] getTemplates(String contextTypeId) {
		return Activator.getDefault().getTemplateStore().getTemplates(contextTypeId);
	}

	@Override
	public TemplateContextType getTemplateContextType(Keyword keyword, IContentAssistContext contentAssistContext) {
		return Activator.getDefault().getTemplateContextRegistry()
				.getContextType(Activator.PREFIX + keyword.getValue());
	}

	@Override
	public TemplateContextType getTemplateContextType(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (ruleCall.eContainer() instanceof Assignment
				&& ((Assignment) ruleCall.eContainer()).getFeature().equals("lowerBound")) {
			return Activator.getDefault().getTemplateContextRegistry().getContextType(Activator.PREFIX + "lowerBound");
		}
		return Activator.getDefault().getTemplateContextRegistry().getContextType(
				Activator.PREFIX + ruleCall.getRule().getName());
	}

}
