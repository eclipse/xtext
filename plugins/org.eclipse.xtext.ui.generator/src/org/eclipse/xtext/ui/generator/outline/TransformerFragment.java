package org.eclipse.xtext.ui.generator.outline;

import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.ui.common.editor.outline.ISemanticModelTransformer;

public class TransformerFragment extends AbstractGeneratorFragment {
	
	@Override
	public Map<BindKey, BindValue> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(ISemanticModelTransformer.class.getName(),
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
