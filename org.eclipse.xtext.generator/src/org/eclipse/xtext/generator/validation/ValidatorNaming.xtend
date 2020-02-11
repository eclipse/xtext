/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.generator.Naming

import static org.eclipse.xtext.GrammarUtil.*
import static extension org.eclipse.xtext.generator.IInheriting.Util.*

/**
 * @author Jan Koehnlein
 * @since 2.4
 */
@Deprecated
class ValidatorNaming {
	
	@Inject Grammar grammar
	
	@Inject extension Naming
	
	def getValidatorName(Grammar g) {
		'''«g.basePackageRuntime».validation.«getSimpleName(g)»Validator'''.toString
	}

	def getAbstractValidatorName() {
		'''«grammar.basePackageRuntime».validation.Abstract«getSimpleName(grammar)»Validator'''.toString
	}
	
	def getValidatorSuperClassName(boolean isInheritImplementation) {
		val superGrammar = grammar.nonTerminalsSuperGrammar
		if(isInheritImplementation && superGrammar !== null) 
			superGrammar.validatorName 
		else
			'org.eclipse.xtext.validation.AbstractDeclarativeValidator'
	}
		
	def String getGeneratedEPackageName(EPackage pack) {
		return '''«grammar.basePackageRuntime».«pack.getName()».«pack.name.toFirstUpper»Package'''
	}
	
}
