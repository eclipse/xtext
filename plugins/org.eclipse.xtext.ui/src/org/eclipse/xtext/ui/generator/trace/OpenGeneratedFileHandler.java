/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

public class OpenGeneratedFileHandler extends OpenOppositeFileHandler {

	@Inject
	private TraceOrMarkerBasedOpenerContributor traceOrMarkerBasedOpenerContributor;

	@Override
	protected void collectOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor) {
		traceOrMarkerBasedOpenerContributor.collectGeneratedFileOpeners(editor, acceptor);
	}

}
