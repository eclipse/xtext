/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.apache.log4j.Logger;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class EditorInputBasedFileOpener extends FileOpener {

	private final static Logger LOG = Logger.getLogger(EditorInputBasedFileOpener.class);

	private final String editorId;
	private final IEditorInput input;

	public EditorInputBasedFileOpener(IEditorInput input, String editorId) {
		super();
		this.input = input;
		this.editorId = editorId;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return input.getImageDescriptor();
	}

	@Override
	public String getShortLabel() {
		return input.getName();
	}

	@Override
	public void open(IWorkbenchPage page) {
		try {
			page.openEditor(input, editorId, true, IWorkbenchPage.MATCH_INPUT | IWorkbenchPage.MATCH_ID);
		} catch (PartInitException e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
