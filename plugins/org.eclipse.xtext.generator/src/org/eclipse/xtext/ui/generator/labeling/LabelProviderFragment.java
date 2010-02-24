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
 * @author Sven Efftinge
 */
public class LabelProviderFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.jface.viewers.ILabelProvider", getEObjectLabelProviderQualifiedName(grammar, getNaming()))
			.addConfiguredBinding("ResourceUIServiceLabelProvider", 
				"binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)" +
				".annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class)" +
				".to(" + getDescriptionLabelProviderQualifiedName(grammar, getNaming()) + ".class)")
			.getBindings();
	}

	public static String getDescriptionLabelProviderQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + ".labeling." + GrammarUtil.getName(grammar) + "DescriptionLabelProvider";
	}
	
	public static String getEObjectLabelProviderQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + ".labeling." + GrammarUtil.getName(grammar) + "LabelProvider";
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui"
		};
	}

}
