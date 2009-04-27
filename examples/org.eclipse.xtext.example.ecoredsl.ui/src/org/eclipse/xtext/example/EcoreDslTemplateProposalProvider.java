/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.DefaultTemplateProposalProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EcoreDslTemplateProposalProvider extends DefaultTemplateProposalProvider {

	@Override
	public Template[] getTemplates(String contextTypeId) {
		return EcoreDslActivator.getDefault().getTemplateStore().getTemplates(contextTypeId);
	}

	@Override
	public TemplateContextType getTemplateContextType(Keyword keyword, ContentAssistContext contentAssistContext) {
		return EcoreDslActivator.getDefault().getTemplateContextRegistry()
				.getContextType(EcoreDslActivator.PREFIX + keyword.getValue());
	}

	@Override
	public TemplateContextType getTemplateContextType(RuleCall ruleCall, ContentAssistContext contentAssistContext) {
		if (ruleCall.eContainer() instanceof Assignment
				&& ((Assignment) ruleCall.eContainer()).getFeature().equals("lowerBound")) {
			return EcoreDslActivator.getDefault().getTemplateContextRegistry().getContextType(EcoreDslActivator.PREFIX + "lowerBound");
		}
		return EcoreDslActivator.getDefault().getTemplateContextRegistry().getContextType(
				EcoreDslActivator.PREFIX + ruleCall.getRule().getName());
	}
}
