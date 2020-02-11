/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
