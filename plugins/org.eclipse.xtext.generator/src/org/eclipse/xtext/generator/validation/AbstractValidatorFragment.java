/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GeneratedMetamodel;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.util.Strings;

/**
 * Common base class for {@link IGeneratorFragment fragments} generating some
 * validation support classes.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractValidatorFragment extends
		AbstractGeneratorFragment {
	
	private String basePackage = null;

	/**
	 * Sets the name of the Java base package for the language.
	 * 
	 * @param basePackage
	 */
	public void setBasePackage(String basePackage) {
		if ("".equals(basePackage.trim()))
			return;
		this.basePackage = basePackage;
	}

	public String getBasePackage(Grammar g) {
		if (basePackage == null)
			return GrammarUtil.getNamespace(g);
		return basePackage;
	}
	
	public String getGeneratedEPackageName(Grammar g, EPackage pack) {
		return getBasePackage(g) + "." + pack.getName() + "."
				+ Strings.toFirstUpper(pack.getName()) + "Package";
	}
	
	public static String getValidationPackage(Grammar grammar) {
		return GrammarUtil.getNamespace(grammar) + ".validation";
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[]{ getValidationPackage(grammar) };
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
}
