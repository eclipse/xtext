/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.bracketmatching.ui.autoedit;

import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AutoEditStrategy extends DefaultAutoEditStrategy {
	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		acceptor.accept(newShortCuts("fbb", "foobarbaz"));
		acceptor.accept(newSingleLineTerminals('(', ')'));
		acceptor.accept(newMultiLineTerminals("{", null, "}"));
		acceptor.accept(newMultiLineTerminals("begin", null, "end"));
		acceptor.accept(newSameTerminal('"'));
		acceptor.accept(newSameTerminal('\''));
	}
}
