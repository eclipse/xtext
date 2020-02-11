/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tests

import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.ecore.EMFGeneratorFragment2

/**
 * @author spoenemann - Initial contribution and API
 */
class TestsEMFGeneratorFragment extends EMFGeneratorFragment2 {
	
	@Accessors(PUBLIC_SETTER)
	String ecoreModel
	
	String genModel
	
	new() {
		super()
		updateBuildProperties = false
	}
	
	override setGenModel(String genModel) {
		this.genModel = genModel
		super.setGenModel(genModel)
	}
	
	override protected getEcoreFilePath(Grammar grammar) {
		if (!ecoreModel.nullOrEmpty)
			ecoreModel
		else
			javaModelDirectory
				+ '/' + grammar.name.substring(0, grammar.name.lastIndexOf('.')).replace('.', '/')
				+ '/' + grammar.modelName + '.ecore'
	}
	
	override protected getGenModelPath(Grammar grammar) {
		if (!genModel.nullOrEmpty)
			genModel
		else
			javaModelDirectory
				+ '/' + grammar.name.substring(0, grammar.name.lastIndexOf('.')).replace('.', '/')
				+ '/' + grammar.modelName + '.genmodel'
	}
	
}
