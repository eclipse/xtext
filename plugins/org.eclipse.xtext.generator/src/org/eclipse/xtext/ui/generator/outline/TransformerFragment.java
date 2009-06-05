package org.eclipse.xtext.ui.generator.outline;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;

public class TransformerFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.xtext.ui.common.editor.outline.transformer.ISemanticModelTransformer",
					getQualifiedName(grammar))
			.getBindings();
	}

	public static String getQualifiedName(Grammar grammar) {
		return GrammarUtil.getNamespace(grammar) + ".outline." + GrammarUtil.getName(grammar) + "Transformer";
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui.common",
				"org.eclipse.xtext.ui.core"
		};
	}

}
