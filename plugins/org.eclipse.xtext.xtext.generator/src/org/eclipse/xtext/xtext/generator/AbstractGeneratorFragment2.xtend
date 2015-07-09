/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.xtext.generator.IGeneratorFragment2
import org.eclipse.emf.mwe.core.issues.Issues
import com.google.inject.Injector

abstract class AbstractGeneratorFragment2 implements IGeneratorFragment2 {
	
	override checkConfiguration(XtextGenerator generator, Issues issues) {
		// Override this method to check the configured properties of this fragment
	}
	
	override initialize(Injector injector) {
		injector.injectMembers(this)
	}
	
}