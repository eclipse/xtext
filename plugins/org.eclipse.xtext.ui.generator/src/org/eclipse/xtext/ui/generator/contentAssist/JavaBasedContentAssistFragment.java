package org.eclipse.xtext.ui.generator.contentAssist;

import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.ui.common.editor.contentassist.IProposalProvider;

public class JavaBasedContentAssistFragment extends AbstractGeneratorFragment {
	
	@Override
	public Map<BindKey, BindValue> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
		.addTypeToType(IProposalProvider.class.getName(), grammar.getName()+"Proposals")
		.getBindings();
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui.common"
		};
	}
	
}
