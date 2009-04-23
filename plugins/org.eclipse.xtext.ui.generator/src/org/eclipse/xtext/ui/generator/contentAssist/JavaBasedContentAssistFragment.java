package org.eclipse.xtext.ui.generator.contentAssist;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.ui.core.editor.contentassist.IContentProposalProvider;

public class JavaBasedContentAssistFragment extends AbstractGeneratorFragment {
	
	private boolean inherit = true;
	
	@Override
	public Map<BindKey, BindValue> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(IContentProposalProvider.class.getName(), grammar.getName()+"ProposalProvider")
			.getBindings();
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui.common",
				"org.eclipse.xtext.ui.core"
		};
	}

	@Override
	public String[] getExportedPackagesUi(Grammar grammar) {
		return new String[] {
			GrammarUtil.getNamespace(grammar)
		};
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.<Object>singletonList(inherit);
	}

	public void setInherit(boolean inherit) {
		this.inherit = inherit;
	}

	public boolean isInherit() {
		return inherit;
	}
	
}
