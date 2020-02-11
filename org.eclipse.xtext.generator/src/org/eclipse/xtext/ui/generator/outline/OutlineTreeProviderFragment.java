/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/

package org.eclipse.xtext.ui.generator.outline;

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
 * An {@link IGeneratorFragment} to generate the configuration for a transformer for the outline view of an Xtext
 * language.
 *
 * @author Jan Koehnlein
 */
@Deprecated
public class OutlineTreeProviderFragment extends AbstractStubGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		if(isGenerateStub())
			return new BindFactory()
				.addTypeToType("org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider",
						getQualifiedName(grammar, getNaming()))
				.addTypeToType("org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider",
						getQualifiedName(grammar, getNaming()))
				.getBindings();
		else 
			return emptySet();
	}

	public static String getQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + ".outline." + GrammarUtil.getSimpleName(grammar) + "OutlineTreeProvider";
	}

	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[] { "org.eclipse.xtext.ui" };
	}

}
