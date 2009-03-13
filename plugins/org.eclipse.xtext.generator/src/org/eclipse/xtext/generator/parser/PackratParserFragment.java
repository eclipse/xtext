/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser;

import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.parser.packrat.IPackratParser;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PackratParserFragment extends AbstractGeneratorFragment {

	@Override
	public Map<BindKey, BindValue> getGuiceBindingsRt(Grammar g) {
		return new BindFactory()
		.addTypeToType(IPackratParser.class.getName(),PackratParserGenUtil.getGeneratedParser(g))	
		.getBindings();
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[]{
				GrammarUtil.getNamespace(grammar) + ".parser.packrat",
				GrammarUtil.getNamespace(grammar) + ".parser.packrat.consumers",
		};
	}

}
