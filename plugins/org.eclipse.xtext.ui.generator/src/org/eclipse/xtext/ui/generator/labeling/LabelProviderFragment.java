package org.eclipse.xtext.ui.generator.labeling;

import java.util.Map;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;

public class LabelProviderFragment extends AbstractGeneratorFragment {
	
	@Override
	public Map<BindKey, BindValue> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(ILabelProvider.class.getName(),
					getQualifiedName(grammar))
			.getBindings();
	}

	public static String getQualifiedName(Grammar grammar) {
		return GrammarUtil.getNamespace(grammar) + ".labeling." + GrammarUtil.getName(grammar) + "LabelProvider";
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui.common",
				"org.eclipse.xtext.ui.core"
		};
	}

}
