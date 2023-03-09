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
 * A fragment that contributes to the {@link XtextGenerator}. Use {@link AbstractXtextGeneratorFragment}
 * for implementing new fragments.
 */
public interface IXtextGeneratorFragment extends IGuiceAwareGeneratorComponent {
	
	void checkConfiguration(Issues issues);
	
	void generate();
	
}
