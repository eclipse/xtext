/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.exporting;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.namespaces.SimpleNameProvider;

/**
 * An {@link IGeneratorFragment} to create simple name based scopes.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class SimpleNamesFragment extends DefaultGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addfinalTypeToType(IQualifiedNameProvider.class.getName(), SimpleNameProvider.class.getName())
			.getBindings();
	}

}
