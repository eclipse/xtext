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
 * An {@link IGeneratorFragment} to generate a adapter factory for outline nodes.
 * 
 * @author Peter Friese - Initial contribution and API
 */
public class OutlineNodeAdapterFactoryFragment extends AbstractGeneratorFragment {
	
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
			.addTypeToType("org.eclipse.xtext.ui.editor.outline.actions.IContentOutlineNodeAdapterFactory",
					getQualifiedName(grammar,getNaming()))
			.getBindings();
	}

	public static String getQualifiedName(Grammar grammar, Naming n) {
		return n.basePackageUi(grammar) + ".outline." + GrammarUtil.getName(grammar) + "OutlineNodeAdapterFactory";
	}
	
	@Override
	public String[] getRequiredBundlesUi(Grammar grammar) {
		return new String[]{
				"org.eclipse.xtext.ui"
		};
	}

}
