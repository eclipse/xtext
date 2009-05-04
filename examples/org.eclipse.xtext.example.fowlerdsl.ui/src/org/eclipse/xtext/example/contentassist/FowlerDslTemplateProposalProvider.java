/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.contentassist;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.example.FowlerDslActivator;
import org.eclipse.xtext.ui.common.editor.templates.DefaultTemplateProposalProvider;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FowlerDslTemplateProposalProvider extends DefaultTemplateProposalProvider {

	@Override
	public Template[] getTemplates(String contextTypeId) {
		return FowlerDslActivator.getDefault().getTemplateStore().getTemplates(contextTypeId);
	}

	@Override
	public TemplateContextType getTemplateContextType(Keyword keyword, ContentAssistContext contentAssistContext) {
		return FowlerDslActivator.getDefault().getTemplateContextRegistry()
				.getContextType(FowlerDslActivator.PREFIX + keyword.getValue());
	}

	@Override
	public TemplateContextType getTemplateContextType(RuleCall ruleCall, ContentAssistContext contentAssistContext) {
		return FowlerDslActivator.getDefault().getTemplateContextRegistry().getContextType(
				FowlerDslActivator.PREFIX + ruleCall.getRule().getName());
	}
}
