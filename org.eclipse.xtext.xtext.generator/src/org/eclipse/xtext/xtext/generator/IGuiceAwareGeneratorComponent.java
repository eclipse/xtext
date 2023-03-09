/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator;

import com.google.inject.Injector;

/**
 * The Xtext generator uses dependency injection with <a href="https://github.com/google/guice">Guice</a>
 * for distributing the configuration to all its components. Instances of this interface can initialize
 * themselves with a Guice injector, e.g. by calling {@code injector.injectMembers(this)}.
 */
public interface IGuiceAwareGeneratorComponent {
	
	void initialize(Injector injector);
	
}
