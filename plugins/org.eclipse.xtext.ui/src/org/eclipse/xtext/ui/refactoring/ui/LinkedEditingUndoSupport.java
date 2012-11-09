/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.ui;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Inject;

/**
 * Reverts document changes when the linked mode is left. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class LinkedEditingUndoSupport {

	@Inject
	private SyncUtil syncUtil;
	
	private static final Logger LOG = Logger.getLogger(LinkedEditingUndoSupport.class);
	
	private IUndoableOperation startingUndoOperation;
	
	private XtextEditor editor;

	public void startRecording(XtextEditor editor) {
		this.editor = editor;
		ISourceViewer viewer = editor.getInternalSourceViewer();
		if (viewer instanceof ITextViewerExtension6) {
			IUndoManager undoManager = ((ITextViewerExtension6) viewer).getUndoManager();
			if (undoManager instanceof IUndoManagerExtension) {
				IUndoManagerExtension undoManagerExtension = (IUndoManagerExtension) undoManager;
				IUndoContext undoContext = undoManagerExtension.getUndoContext();
				IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
				startingUndoOperation = operationHistory.getUndoOperation(undoContext);
			}
		}
	}
	
	public void undoDocumentChanges() {
		final ISourceViewer viewer = editor.getInternalSourceViewer();
		try {
			editor.getSite().getWorkbenchWindow().run(false, true, new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					if (viewer instanceof ITextViewerExtension6) {
						IUndoManager undoManager = ((ITextViewerExtension6) viewer).getUndoManager();
						if (undoManager instanceof IUndoManagerExtension) {
							IUndoManagerExtension undoManagerExtension = (IUndoManagerExtension) undoManager;
							IUndoContext undoContext = undoManagerExtension.getUndoContext();
							IOperationHistory operationHistory = OperationHistoryFactory.getOperationHistory();
							while (undoManager.undoable()) {
								if (startingUndoOperation != null
										&& startingUndoOperation.equals(operationHistory.getUndoOperation(undoContext)))
									return;
								undoManager.undo();
							}
						}
					}
				}
			});
			syncUtil.waitForReconciler(editor);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
}
