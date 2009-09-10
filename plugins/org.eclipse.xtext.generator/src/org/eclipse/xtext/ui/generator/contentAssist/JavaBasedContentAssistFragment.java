package org.eclipse.xtext.ui.generator.contentAssist;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;

/**
 * A {@link IGeneratorFragment} to generate a java-based content assist for an Xtext language.
 * 
 * @author koehnlein
 */
public class JavaBasedContentAssistFragment extends AbstractGeneratorFragment {
	
	private boolean inherit = true;
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.xtext.ui.core.editor.contentassist.IContentProposalProvider",
					getProposalProviderClassName(grammar))
			.getBindings();
	}

	private String getProposalProviderClassName(Grammar grammar) {
		return GrammarUtil.getNamespace(grammar) + ".contentassist." + GrammarUtil.getName(grammar) + "ProposalProvider";
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
			GrammarUtil.getNamespace(grammar) + ".contentassist"
		};
	}
	
	@Override
	protected List<Object> getParameters(Grammar grammar) {
		return Collections.<Object>singletonList(inherit);
	}

	/**
	 * Decide whether to inherit content assist from the super language. 
	 * 
	 * @param inherit
	 */
	public void setInherit(boolean inherit) {
		this.inherit = inherit;
	}

	public boolean isInherit() {
		return inherit;
	}
	
}
