package org.eclipse.xtext.ui.generator.labeling;

import static java.util.Collections.*;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractStubGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.generator.Naming;

/**
 * An {@link IGeneratorFragment} to generate a label provider.
 *
 * @author Jan Koehnlein - javadocs
 * @author Sven Efftinge
 */
public class LabelProviderFragment extends AbstractStubGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if(isGenerateStub())
			return new BindFactory()
				.addTypeToType("org.eclipse.jface.viewers.ILabelProvider", getEObjectLabelProviderQualifiedName(grammar, getNaming()))
				.addConfiguredBinding("ResourceUIServiceLabelProvider",
					"binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)" +
					".annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class)" +
					".to(" + getDescriptionLabelProviderQualifiedName(grammar, getNaming()) + ".class)").getBindings();
		else 
			return emptySet();
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
