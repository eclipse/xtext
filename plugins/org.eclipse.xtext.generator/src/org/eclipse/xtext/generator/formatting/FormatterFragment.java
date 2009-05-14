/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.formatting;

import java.util.Map;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class FormatterFragment extends AbstractGeneratorFragment {
	@Override
	public Map<BindKey, BindValue> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
		.addTypeToType(ITokenSerializer.class.getName(), getFormatterName(grammar))
		.getBindings();
	}

	public static String getFormatterName(Grammar grammar) {
		return GrammarUtil.getNamespace(grammar) + ".formatting." + GrammarUtil.getName(grammar) + "Formatter";
	}
	
}
