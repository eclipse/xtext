/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.trace;

import org.apache.log4j.Logger;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.generator.trace.EditorInputBasedFileOpener;
import org.eclipse.xtext.ui.generator.trace.FileOpener;
import org.eclipse.xtext.ui.generator.trace.OppositeFileOpenerContributor;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ClassFileBasedOpenerContributor extends OppositeFileOpenerContributor {

	private final static Logger LOG = Logger.getLogger(ClassFileBasedOpenerContributor.class);

	@Inject
	private ITraceForTypeRootProvider traceForTypeRootProvider;

	@Override
	public boolean collectGeneratedFileOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor) {
		if (editor instanceof XtextEditor && editor.getEditorInput() instanceof IClassFileEditorInput) {
			acceptor.accept(createEditorOpener(editor.getEditorInput(), JavaUI.ID_CF_EDITOR));
			return true;
		}
		return false;
	}

	@Override
	public boolean collectSourceFileOpeners(IEditorPart editor, IAcceptor<FileOpener> acceptor) {
		if (!(editor instanceof XtextEditor) && editor.getEditorInput() instanceof IClassFileEditorInput) {
			try {
				IClassFile classFile = ((IClassFileEditorInput) editor.getEditorInput()).getClassFile();
				ITrace trace = traceForTypeRootProvider.getTraceToSource(classFile);
				for (ILocationInResource location : trace.getAllAssociatedLocations()) {
					String name = location.getAbsoluteResourceURI().getURI().lastSegment();
					IEditorDescriptor editorDescriptor = IDE.getEditorDescriptor(name);
					acceptor.accept(createEditorOpener(editor.getEditorInput(), editorDescriptor.getId()));
					return true;
				}
			} catch (PartInitException e) {
				LOG.error(e.getMessage(), e);
			}
		}
		return false;
	}

	protected EditorInputBasedFileOpener createEditorOpener(IEditorInput editorInput, String editorId) {
		return new EditorInputBasedFileOpener(editorInput, editorId);
	}

}
