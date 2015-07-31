/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.generator.trace;

import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.common.types.ui.trace.ClassFileBasedOpenerContributor;
import org.eclipse.xtext.ui.generator.trace.FileOpener;
import org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XbaseOpenGeneratedFileHandler extends OpenGeneratedFileHandler {

	@Inject
	private ClassFileBasedOpenerContributor classFileBasedOpenerCollector;

	@Override
	protected void collectOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor) {
		super.collectOpeners(editor, acceptor);
		classFileBasedOpenerCollector.collectGeneratedFileOpeners(editor, acceptor);
	}
}
