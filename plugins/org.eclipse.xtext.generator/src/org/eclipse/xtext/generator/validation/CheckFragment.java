/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validation;

import java.util.Set;

import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.Binding;
import org.eclipse.xtext.generator.IGeneratorFragment;

/**
 * {@link IGeneratorFragment} to generate a check based validity checker for a given grammar.
 * 
 * @author Michael Clay
 */
public class CheckFragment extends AbstractValidatorFragment {

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[]{
			"org.eclipse.xtend","org.eclipse.xtext.xtend"
		};
	}
	
	@Override
	public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
		BindFactory addTypeToInstance = new BindFactory()
			.addTypeToType(ExecutionContext.class.getName(), "org.eclipse.xtext.xtend.InjectableExecutionContext")
			.addTypeToType(ResourceManager.class.getName(), "org.eclipse.xtext.xtend.InjectableResourceManager")
			.addTypeToInstance(ClassLoader.class.getName(), "Abstract" + GrammarUtil.getName(grammar) + 
			        "RuntimeModule.class.getClassLoader()");
		return addTypeToInstance
			.addTypeToTypeEagerSingleton(getCheckValidatorName(grammar), getCheckValidatorName(grammar))
			.getBindings();
	}
	
	public static String getCheckValidatorName(Grammar g) {
		return GrammarUtil.getNamespace(g) + ".validation." + GrammarUtil.getName(g) + "CheckValidator";
	}
}
