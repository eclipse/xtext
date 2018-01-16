/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import com.google.inject.Injector

/**
 * The Xtext generator uses dependency injection with <a href="https://github.com/google/guice">Guice</a>
 * for distributing the configuration to all its components. Instances of this interface can initialize
 * themselves with a Guice injector, e.g. by calling {@code injector.injectMembers(this)}.
 */
interface IGuiceAwareGeneratorComponent {
	
	def void initialize(Injector injector)
	
}
