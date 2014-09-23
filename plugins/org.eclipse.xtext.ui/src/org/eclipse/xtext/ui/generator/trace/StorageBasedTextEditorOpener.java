/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ITextRegionWithLineInformation;
import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StorageBasedTextEditorOpener extends FileOpener {
	private final static Logger LOG = Logger.getLogger(StorageBasedTextEditorOpener.class);

	private final ITextRegion region;
	private final IStorage storage;

	public StorageBasedTextEditorOpener(IStorage storage) {
		this(storage, null);
	}

	public StorageBasedTextEditorOpener(IStorage storage, ITextRegion region) {
		super();
		this.storage = storage;
		this.region = region;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		IWorkbenchAdapter workbenchAdapter = adapt(storage, IWorkbenchAdapter.class);
		return workbenchAdapter != null ? workbenchAdapter.getImageDescriptor(storage) : null;
	}

	@Override
	public String getQualifiedLabel() {
		String path = storage.getFullPath().toString();
		String regionLabel = getRegionLabel();
		if (Strings.isEmpty(regionLabel))
			return path;
		return path + " " + regionLabel;
	}

	protected String getRegionLabel() {
		if (region instanceof ITextRegionWithLineInformation) {
			ITextRegionWithLineInformation lines = ((ITextRegionWithLineInformation) region);
			if (lines.getLineNumber() == lines.getEndLineNumber())
				return String.format("line %d", lines.getLineNumber());
			return String.format("lines %d-%d", lines.getLineNumber(), lines.getEndLineNumber());
		} else if (region != null) {
			return String.format("offset %d, lenght %d", region.getOffset(), region.getLength());
		}
		return "";
	}

	@Override
	public String getShortLabel() {
		return storage.getName();
	}

	@Override
	public void open(IWorkbenchPage page) {
		try {
			IEditorInput input = EditorUtils.createEditorInput(storage);
			IEditorDescriptor editorDescriptor = IDE.getEditorDescriptor(storage.getName());
			IEditorPart opened = IDE.openEditor(page, input, editorDescriptor.getId());
			if (region != null && opened instanceof ITextEditor) {
				ITextEditor openedTextEditor = (ITextEditor) opened;
				openedTextEditor.selectAndReveal(region.getOffset(), region.getLength());
			}
		} catch (PartInitException e) {
			LOG.error(e.getMessage(), e);
		}
	}

}
