/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parseTreeConstructor;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.parsetree.reconstr.IParseTreeConstructor;
import org.eclipse.xtext.parsetree.reconstr.impl.ParseTreeConstructorUtil;

public class ParseTreeConstructorFragment extends AbstractGeneratorFragment {
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addTypeToType(IParseTreeConstructor.class.getName(),ParseTreeConstructorUtil.getParseTreeConstructorName(grammar))
			.getBindings();
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[]{
				ParseTreeConstructorUtil.getPackage(grammar)
		};
	}
}
