/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator;

/**
 * A fragment that generates a class that inherits from the generated class of
 * the super-grammar. This inheritance can be disabled with the
 * {@code inheritImplementation} property.
 */
public abstract class AbstractInheritingFragment extends AbstractStubGeneratingFragment {

	private boolean inheritImplementation = true;

	public boolean isInheritImplementation() {
		return inheritImplementation;
	}

	public void setInheritImplementation(boolean inheritImplementation) {
		this.inheritImplementation = inheritImplementation;
	}
}
