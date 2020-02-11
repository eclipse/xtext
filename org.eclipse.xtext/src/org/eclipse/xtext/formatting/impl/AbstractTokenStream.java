/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.ITokenStreamExtension;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTokenStream implements ITokenStreamExtension {

	
	@Override
	public void flush() throws IOException {
	}

	@Override
	public void writeHidden(EObject grammarElement, String value) throws IOException {
	}

	@Override
	public void writeSemantic(EObject grammarElement, String value) throws IOException {
	}

	/**
	 * @since 2.0
	 */
	@Override
	public void init(ParserRule startRule) {
	}
	
}