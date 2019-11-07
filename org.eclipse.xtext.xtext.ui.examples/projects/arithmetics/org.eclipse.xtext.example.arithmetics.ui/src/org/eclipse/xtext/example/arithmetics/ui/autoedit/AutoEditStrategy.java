/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.autoedit;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.example.arithmetics.ui.autoedit.InterpreterAutoEdit;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class AutoEditStrategy extends DefaultAutoEditStrategyProvider {
	@Inject
	private Provider<InterpreterAutoEdit> interpreterAutoEdit;

	@Override
	protected void configure(AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		acceptor.accept(this.interpreterAutoEdit.get(), IDocument.DEFAULT_CONTENT_TYPE);
	}
}
