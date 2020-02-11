/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.bracketmatching.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.ShortCutEditStrategy;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AutoEditStrategy extends DefaultAutoEditStrategyProvider {
	@Inject
	protected Provider<ShortCutEditStrategy> shortCut;
	
	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(shortCut.get().configure("fbb", "foobarbaz"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(singleLineTerminals.newInstance("begin", "end"),IDocument.DEFAULT_CONTENT_TYPE);
		acceptor.accept(multiLineTerminals.newInstance("begin", null, "end"),IDocument.DEFAULT_CONTENT_TYPE);
	}
}
