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
import org.eclipse.xtext.generator.AbstractGeneratorFragment;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.util.Strings;

/**
 * Common base class for {@link IGeneratorFragment fragments} generating some
 * validation support classes.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractValidatorFragment extends
		AbstractGeneratorFragment {
	
	public void setBasePackage(String basePackage) {
		throw new UnsupportedOperationException();
	}

	public String getBasePackage(Grammar g, Naming n) {
		return n.basePackageRuntime(g);
	}
	
	public String getGeneratedEPackageName(Grammar g, Naming n , EPackage pack) {
		return getBasePackage(g,n) + "." + pack.getName() + "."
				+ Strings.toFirstUpper(pack.getName()) + "Package";
	}
	
	public static String getValidationPackage(Grammar grammar, Naming n) {
		return n.basePackageRuntime(grammar) + ".validation";
	}
	
	@Override
	public String[] getExportedPackagesRt(Grammar grammar) {
		return new String[]{ getValidationPackage(grammar, getNaming()) };
	}

	@Override
	protected List<Object> getParameters(Grammar grammar) {
		List<String> packageQNames = new ArrayList<String>();
		List<GeneratedMetamodel> list = EcoreUtil2.typeSelect(grammar.getMetamodelDeclarations(),GeneratedMetamodel.class);
		for (GeneratedMetamodel generatedMetamodel : list) {
			packageQNames.add(getGeneratedEPackageName(grammar, getNaming(), generatedMetamodel.getEPackage()));
		}
		return Collections.singletonList((Object)packageQNames);
	}
}
