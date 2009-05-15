package org.eclipse.xtext.ui.generator.contentAssist;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;

public class XtendBasedContentAssistFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.xtext.ui.core.editor.contentassist.IContentProposalProvider", 
					GrammarUtil.getNamespace(grammar) + ".contentassist." + GrammarUtil.getName(grammar) + "ProposalProvider")
			.getBindings();
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xpand",
				"org.eclipse.xtend",
				"org.eclipse.xtend.typesystem.emf",
				"org.eclipse.xtext.xtend"
		};
	}
	
}
