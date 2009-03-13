/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ResourceManager;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.BindFactory;
import org.eclipse.xtext.generator.BindKey;
import org.eclipse.xtext.generator.BindValue;
import org.eclipse.xtext.util.Strings;

public class CheckFragment extends AbstractGeneratorFragment {

	@Override
	public String[] getRequiredBundlesRt(Grammar grammar) {
		return new String[]{
			"org.eclipse.xtend","org.eclipse.xtend.typesystem.emf","org.eclipse.xtext.xtend"
		};
	}

	@Override
	public Map<BindKey, BindValue> getGuiceBindingsRt(Grammar grammar) {
		return new BindFactory()
			.addTypeToTypeSingleton(ExecutionContext.class.getName(), "org.eclipse.xtext.xtend.InjectableExecutionContext")
			.addTypeToTypeSingleton(ResourceManager.class.getName(), "org.eclipse.xtext.xtend.InjectableResourceManager")
			.addTypeToTypeEagerSingleton(getCheckValidatorName(grammar),getCheckValidatorName(grammar))
			.addTypeToInstance(ClassLoader.class.getName(), "getClass().getClassLoader()")
			.getBindings();
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		List<String> packageQNames = new ArrayList<String>();
		List<GeneratedMetamodel> list = EcoreUtil2.typeSelect(grammar.getMetamodelDeclarations(),GeneratedMetamodel.class);
		for (GeneratedMetamodel generatedMetamodel : list) {
			packageQNames.add(getGeneratedEPackageName(grammar, generatedMetamodel.getEPackage()));
		}
		return Collections.singletonList((Object)packageQNames);
	}

	public static String getCheckValidatorName(Grammar g) {
		return g.getName()+"CheckValidator";
	}

	private String basePackage = null;

	public void setBasePackage(String basePackage) {
		if ("".equals(basePackage.trim()))
			return;
		this.basePackage = basePackage;
	}

	public String getBasePackage(Grammar g) {
		if (basePackage==null)
			return GrammarUtil.getNamespace(g);
		return basePackage;
	}

	public String getGeneratedEPackageName(Grammar g, EPackage pack) {
		return getBasePackage(g) + "." +pack.getName() +"."+ Strings.toFirstUpper(pack.getName())
				+ "Package";
	}
}
