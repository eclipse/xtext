/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.xtext.generator.AbstractXtextGeneratorFragment
import org.eclipse.xtend.lib.annotations.Accessors
import com.google.inject.Inject

abstract class AbstractStubGeneratingFragment extends AbstractXtextGeneratorFragment {

	@Inject
	extension CodeConfig

	@Accessors
	boolean generateStub = true
	
	@Accessors(PUBLIC_SETTER)
	Boolean generateXtendStub = null
	
	def isGenerateXtendStub() {
		if (generateXtendStub != null) generateXtendStub.booleanValue else preferXtendStubs
	}
}