/**
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.example.arithmetics.ui.autoedit.InterpreterAutoEdit;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

@SuppressWarnings("all")
public class AutoEditStrategy extends DefaultAutoEditStrategyProvider {
  @Override
  protected void configure(final AbstractEditStrategyProvider.IEditStrategyAcceptor acceptor) {
    super.configure(acceptor);
    InterpreterAutoEdit _interpreterAutoEdit = new InterpreterAutoEdit();
    acceptor.accept(_interpreterAutoEdit, IDocument.DEFAULT_CONTENT_TYPE);
  }
}
