/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

/**
 * A fragment that contributes to the {@link XtextGenerator}.
 */
interface IGeneratorFragment2 extends IGuiceAwareGeneratorComponent {
	
	def void checkConfiguration(Issues issues)
	
	def void generate()
	
}