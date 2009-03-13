
package org.eclipse.xtext.example;

import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.IContentAssistContext;

public class EcoreDslProposalProvider extends org.eclipse.xtext.example.GenEcoreDslProposalProvider {

	@Override
	public Template[] getTemplates(String contextTypeId) {
		return EcoreDslActivator.getDefault().getTemplateStore().getTemplates(contextTypeId);
	}

	@Override
	public TemplateContextType getTemplateContextType(Keyword keyword, IContentAssistContext contentAssistContext) {
		return EcoreDslActivator.getDefault().getTemplateContextRegistry()
				.getContextType(EcoreDslActivator.PREFIX + keyword.getValue());
	}

	@Override
	public TemplateContextType getTemplateContextType(RuleCall ruleCall, IContentAssistContext contentAssistContext) {
		if (ruleCall.eContainer() instanceof Assignment
				&& ((Assignment) ruleCall.eContainer()).getFeature().equals("lowerBound")) {
			return EcoreDslActivator.getDefault().getTemplateContextRegistry().getContextType(EcoreDslActivator.PREFIX + "lowerBound");
		}
		return EcoreDslActivator.getDefault().getTemplateContextRegistry().getContextType(
				EcoreDslActivator.PREFIX + ruleCall.getRule().getName());
	}

}
