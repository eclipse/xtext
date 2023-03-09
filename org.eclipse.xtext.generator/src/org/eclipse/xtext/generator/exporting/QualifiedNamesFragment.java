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
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.IQualifiedNameProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class QualifiedNamesFragment extends DefaultGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory().addTypeToType(IQualifiedNameProvider.class.getName(),
				DefaultDeclarativeQualifiedNameProvider.class.getName()).getBindings();
	}

	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		return new BindFactory()
				.addTypeToType("org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher",
						"org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher")
				.addTypeToType("org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator",
						"org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator")
				.getBindings();
	}
}
