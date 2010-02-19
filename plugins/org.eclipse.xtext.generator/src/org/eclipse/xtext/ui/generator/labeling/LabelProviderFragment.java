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
			.addConfiguredBinding("HyperlinkLabelProvider", 
				"binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)" +
				".annotatedWith(org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkLabelProvider.class)" +
				".to(" + getEObjectLabelProviderQualifiedName(grammar, getNaming()) + ".class)")
			.addConfiguredBinding("OutlineLabelProvider", 
				"binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)" +
				".annotatedWith(org.eclipse.xtext.ui.editor.outline.OutlineLabelProvider.class)" +
				".to(" + getEObjectLabelProviderQualifiedName(grammar, getNaming()) + ".class)")
			.addConfiguredBinding("ContentProposalLabelProvider", 
				"binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)" +
				".annotatedWith(org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider.class)" +
				".to(" + getEObjectLabelProviderQualifiedName(grammar, getNaming()) + ".class)")
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
