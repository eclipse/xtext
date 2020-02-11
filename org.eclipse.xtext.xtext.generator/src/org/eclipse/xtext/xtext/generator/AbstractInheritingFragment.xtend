/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.xtext.generator.AbstractStubGeneratingFragment
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * A fragment that generates a class that inherits from the generated class of the super-grammar.
 * This inheritance can be disabled with the {@code inheritImplementation} property.
 */
abstract class AbstractInheritingFragment extends AbstractStubGeneratingFragment {
	
	@Accessors boolean inheritImplementation = true
	
}
