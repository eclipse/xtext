/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common;

import java.util.Set;

import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.ui.core.SimpleLabelProvider;

/**
 * An {@link IGeneratorFragment} to generate the binding of a {@link SimpleLabelProvider} for an Xtext language.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleLabelProviderFragment extends AbstractGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory().addTypeToType("org.eclipse.jface.viewers.ILabelProvider",
				"org.eclipse.xtext.ui.core.SimpleLabelProvider").getBindings();
	}

	@Override
	public void generate(Grammar grammar, XpandExecutionContext ctx) {
		// noop
	}

	@Override
	public void addToStandaloneSetup(Grammar grammar, XpandExecutionContext ctx) {
		// noop
	}

	@Override
	public void addToPluginXmlRt(Grammar grammar, XpandExecutionContext ctx) {
		// noop
	}

	@Override
	public void addToPluginXmlUi(Grammar grammar, XpandExecutionContext ctx) {
		// noop
	}

}
