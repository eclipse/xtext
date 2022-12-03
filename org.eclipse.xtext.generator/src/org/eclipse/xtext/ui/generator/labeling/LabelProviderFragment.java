/*******************************************************************************
 * Copyright (c) 2009, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.labeling;

import static org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment.*;

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
@Deprecated(forRemoval = true)
public class LabelProviderFragment extends AbstractStubGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		BindFactory bindFactory = new BindFactory();
		if(isGenerateStub())
			bindFactory
				.addTypeToType("org.eclipse.jface.viewers.ILabelProvider", getEObjectLabelProviderQualifiedName(grammar, getNaming()))
				.addConfiguredBinding("ResourceUIServiceLabelProvider",
					"binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)" +
					".annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class)" +
					".to(" + getDescriptionLabelProviderQualifiedName(grammar, getNaming()) + ".class)");
		else if(doesUseXbase(grammar))
			bindFactory.addTypeToType("org.eclipse.jface.viewers.ILabelProvider", "org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider")
				.addConfiguredBinding("ResourceUIServiceLabelProvider",
						"binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)" +
								".annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class)" +
								".to(org.eclipse.xtext.xbase.ui.labeling.XbaseDescriptionLabelProvider.class)");
		return bindFactory.getBindings();
	}

	public static String getDescriptionLabelProviderQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + ".labeling." + GrammarUtil.getSimpleName(grammar) + "DescriptionLabelProvider";
	}

	public static String getEObjectLabelProviderQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + ".labeling." + GrammarUtil.getSimpleName(grammar) + "LabelProvider";
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui"
		};
	}

}
