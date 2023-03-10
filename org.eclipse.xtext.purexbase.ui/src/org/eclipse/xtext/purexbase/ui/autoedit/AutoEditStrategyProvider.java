/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.ui.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

import com.google.inject.Inject;

public class AutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {
	
	@Inject ReplAutoEdit autoEdit;
	
	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		super.configure(acceptor);
		//acceptor.accept(newShortCuts("PI", "PI"));
		acceptor.accept(autoEdit,IDocument.DEFAULT_CONTENT_TYPE);
	}
}
