/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.validation;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

import com.google.inject.Inject;

/**
 * Separates the composition of the generated validator classes' names from the
 * template of those classes (which may be specialized by clients), since the
 * name is used in the template of the generated quickfix provider classes, too.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
public class ValidatorNaming {
	@Inject
	private XtextGeneratorNaming xtextGeneratorNaming;

	public TypeReference getValidatorClass(Grammar grammar) {
		String runtimeBasePackage = xtextGeneratorNaming.getRuntimeBasePackage(grammar);
		return new TypeReference(
				runtimeBasePackage + ".validation." + GrammarUtil.getSimpleName(grammar) + "Validator");
	}

	protected TypeReference getAbstractValidatorClass(Grammar grammar) {
		String runtimeBasePackage = xtextGeneratorNaming.getRuntimeBasePackage(grammar);
		return new TypeReference(
				runtimeBasePackage + ".validation.Abstract" + GrammarUtil.getSimpleName(grammar) + "Validator");
	}
}
