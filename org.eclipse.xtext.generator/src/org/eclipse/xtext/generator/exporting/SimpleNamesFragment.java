/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.exporting;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.SimpleNameProvider;

/**
 * An {@link IGeneratorFragment} to create simple name based scopes.
 *
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated(forRemoval = true)
public class SimpleNamesFragment extends DefaultGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addfinalTypeToType(IQualifiedNameProvider.class.getName(), SimpleNameProvider.class.getName())
			.getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
		.addTypeToType("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator",
				"org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator")
		.getBindings();
	}
}
