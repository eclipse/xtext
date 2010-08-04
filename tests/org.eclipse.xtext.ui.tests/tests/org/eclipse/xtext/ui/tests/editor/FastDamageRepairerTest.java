/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor;

import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.FastDamagerRepairer;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class FastDamageRepairerTest extends AbstractDamagerRepairerTest {

	@Override
	protected IPresentationDamager createRegionDamager() {
		FastDamagerRepairer result = new FastDamagerRepairer(this, new Provider<Lexer>() {
			public Lexer get() {
				return new org.eclipse.xtext.parser.antlr.internal.InternalXtextLexer();
			}
		});
		result.setCheckInvariant(true);
		return result;
	}
	
}
