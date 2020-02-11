/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.packrat;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;
import org.eclipse.xtext.parser.packrat.IPackratParser;

/**
 * An {@link IGeneratorFragment} to generate a packrat parser.
 *
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated
public class PackratParserFragment extends AbstractGeneratorFragment {

	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar g) {
		return new BindFactory()
		.addTypeToType(IPackratParser.class.getName(),PackratParserGenUtil.getGeneratedParser(g,getNaming()))
		.getBindings();
	}

	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[]{
				getNaming().basePackageRuntime(grammar) + ".parser.packrat",
				getNaming().basePackageRuntime(grammar) + ".parser.packrat.consumers",
		};
	}

}
