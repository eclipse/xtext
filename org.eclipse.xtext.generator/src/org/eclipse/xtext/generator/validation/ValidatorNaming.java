/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.validation;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.generator.IInheriting;
import org.eclipse.xtext.generator.Naming;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein
 * @since 2.4
 */
@Deprecated(forRemoval = true)
public class ValidatorNaming {
	@Inject
	private Grammar grammar;

	@Inject
	private Naming naming;

	public String getValidatorName(Grammar g) {
		return naming.basePackageRuntime(g) + ".validation." + GrammarUtil.getSimpleName(g) + "Validator";
	}

	public String getAbstractValidatorName() {
		return naming.basePackageRuntime(grammar) + ".validation.Abstract" + GrammarUtil.getSimpleName(grammar)
				+ "Validator";
	}

	public String getValidatorSuperClassName(boolean isInheritImplementation) {
		Grammar superGrammar = IInheriting.Util.getNonTerminalsSuperGrammar(grammar);
		if (isInheritImplementation && superGrammar != null) {
			return getValidatorName(superGrammar);
		} else {
			return "org.eclipse.xtext.validation.AbstractDeclarativeValidator";
		}
	}

	public String getGeneratedEPackageName(EPackage pack) {
		return naming.basePackageRuntime(grammar) + "." + pack.getName() + "."
				+ StringExtensions.toFirstUpper(pack.getName()) + "Package";
	}
}
