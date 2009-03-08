/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parseTreeConstructor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;

public class ParseTreeConstructorFragment extends AbstractGeneratorFragment {
	@Override
	public Map<String, String> getGuiceBindingsRt(Grammar grammar) {
		Map<String, String> bindings = new HashMap<String, String>();
		bindings.put(IParseTreeConstructor.class.getName(),ParseTreeConstructorUtil.getParseTreeConstructorName(grammar));
		return bindings;
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[]{
				ParseTreeConstructorUtil.getPackage(grammar)
		};
	}
}
