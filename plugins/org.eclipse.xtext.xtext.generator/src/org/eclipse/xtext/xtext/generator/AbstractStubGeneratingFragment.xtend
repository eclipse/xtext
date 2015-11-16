/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.util.BooleanGeneratorOption

abstract class AbstractStubGeneratingFragment extends AbstractXtextGeneratorFragment {

	@Inject
	extension CodeConfig

	@Accessors(PUBLIC_GETTER)
	val generateStub = new BooleanGeneratorOption(true)
	
	val generateXtendStub = new BooleanGeneratorOption
	
	def boolean isGenerateStub() {
		generateStub.get
	}
	
	def void setGenerateStub(boolean generateStub) {
		this.generateStub.set(generateStub)
	}
	
	def boolean isGenerateXtendStub() {
		if (generateXtendStub.isSet)
			generateXtendStub.get
		else
			preferXtendStubs
	}
	
	def void setGenerateXtendStub(boolean generateXtendStub) {
		this.generateXtendStub.set(generateXtendStub)
	}
	
}