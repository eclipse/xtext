/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.generator.trace;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.ui.generator.trace.OpenGeneratedFileHandler;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XbaseOpenGeneratedFileHandler extends OpenGeneratedFileHandler {

	private final static Logger LOG = Logger.getLogger(XbaseOpenGeneratedFileHandler.class);

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor.getEditorInput() instanceof IClassFileEditorInput) {
			try {
				IDE.openEditor(editor.getEditorSite().getPage(), editor.getEditorInput(), JavaUI.ID_CF_EDITOR);
				return null;
			} catch (PartInitException e) {
				LOG.error(e.getMessage(), e);
				return null;
			}
		}
		return super.execute(event);
	}

}
