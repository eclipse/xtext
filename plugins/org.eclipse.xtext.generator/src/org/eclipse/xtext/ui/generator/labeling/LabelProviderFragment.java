package org.eclipse.xtext.ui.generator.labeling;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;

/**
 * An {@link IGeneratorFragment} to generate a label provider.
 * 
 * @author koehnlein - javadocs
 */
public class LabelProviderFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.jface.viewers.ILabelProvider",
					getQualifiedName(grammar,getNaming()))
			.addTypeToType("org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider",
					getQualifiedName(grammar, getNaming()))
			.getBindings();
	}

	public static String getQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + ".labeling." + GrammarUtil.getName(grammar) + "LabelProvider";
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui.common",
				"org.eclipse.xtext.ui.core"
		};
	}

}
