/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.validation

import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*

/**
 * Separates the composition of the generated validator classes' names from
 *  the template of those classes (which may be specialized by clients),
 *  since the name is used in the template of the generated quickfix provider classes, too.
 * 
 * @author Christian Schneider - Initial contribution and API
 */
class ValidatorNaming {

	@Inject
	extension XtextGeneratorNaming
	
	public def TypeReference getValidatorClass(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage + '.validation.' + grammar.simpleName + 'Validator')
	}
	
	protected def TypeReference getAbstractValidatorClass(Grammar grammar) {
		new TypeReference(grammar.runtimeBasePackage + '.validation.Abstract' + grammar.simpleName + 'Validator')
	}
}