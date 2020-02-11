/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.xtext.generator.util.BooleanGeneratorOption

/**
 * A fragment that generates a <em>stub</em>, that is a class where the user can add
 * custom behavior, e.g. validation or formatting rules. The stub is generated into
 * the source folder that is not overwritten when the generator is executed again
 * ({@code src} for plain project layout, {@code src/main/java} for Maven/Gradle
 * project layout). If you want the stub to be generated again, delete the already
 * existing file.
 */
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
