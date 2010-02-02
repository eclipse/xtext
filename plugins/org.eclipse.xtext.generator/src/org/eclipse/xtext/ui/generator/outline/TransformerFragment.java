/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/

package org.eclipse.xtext.ui.generator.outline;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.Naming;

/**
 * An {@link IGeneratorFragment} to generate the configuration for a transformer for the outline view of an Xtext
 * language.
 * 
 * @author koehnlein
 */
public class TransformerFragment extends AbstractGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory().addTypeToType(
				"org.eclipse.xtext.ui.common.editor.outline.transformer.ISemanticModelTransformer",
				getQualifiedName(grammar, getNaming())).getBindings();
	}

	public static String getQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + ".outline." + GrammarUtil.getName(grammar) + "Transformer";
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.ui.common", "org.eclipse.xtext.ui.core" };
	}

}
