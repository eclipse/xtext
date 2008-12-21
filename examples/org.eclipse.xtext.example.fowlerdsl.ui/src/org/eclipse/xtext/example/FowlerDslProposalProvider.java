package org.eclipse.xtext.example;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

public class FowlerDslProposalProvider extends FowlerDslGenProposalProvider {

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
		return Activator.getDefault().getTemplateContextRegistry().getContextType(
				Activator.PREFIX + ruleCall.getRule().getName());
	}

}
