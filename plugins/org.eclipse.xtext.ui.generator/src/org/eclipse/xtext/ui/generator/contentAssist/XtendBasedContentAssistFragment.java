package org.eclipse.xtext.ui.generator.contentAssist;

import java.util.Collections;
import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;

public class XtendBasedContentAssistFragment extends AbstractGeneratorFragment {
	
	@Override
	public Map<String, String> getGuiceBindingsUi(Grammar grammar) {
		return Collections.singletonMap(IProposalProvider.class.getName(), grammar.getName()+"Proposals");
	}
	
}
