/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.ui.autoedit;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.jface.text.IDocument;
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
