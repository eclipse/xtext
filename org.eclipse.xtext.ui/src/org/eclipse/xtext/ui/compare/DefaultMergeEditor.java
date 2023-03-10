/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.compare;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.DocumentProviderRegistry;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.ui.editor.XtextEditor;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DefaultMergeEditor extends XtextEditor {
	public static final String PROVIDER = DefaultMergeEditor.class.getName();
	private int textOrientation;
	private boolean editable;
	private boolean inputSet;

	public void setInternalSite(IWorkbenchPartSite site) {
		setSite(site);
	}

	@Override
	protected void doSetInput(IEditorInput input) throws CoreException {
		if (input != null) {
			setDocumentProvider(DocumentProviderRegistry.getDefault().getDocumentProvider(input));
		}
		super.doSetInput(input);
		inputSet = true;
	}

	public void setTextOrientation(int textOrientation) {
		this.textOrientation = textOrientation;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public boolean isEditable() {
		return editable;
	}

	@Override
	public boolean isEditorInputModifiable() {
		return editable;
	}

	@Override
	public boolean isEditorInputReadOnly() {
		return !editable;
	}

	@Override
	public void createActions() {
		if (inputSet) {
			super.createActions();
		}
	}

	@Override
	public void close(boolean save) {
		super.close(save);
		getDocumentProvider().disconnect(getEditorInput());
	}

	@Override
	public void createPartControl(Composite composite) {
		SourceViewer sourceViewer = (SourceViewer) createSourceViewer(composite, createVerticalRuler(), SWT.H_SCROLL
				| SWT.V_SCROLL | textOrientation);
		setSourceViewer(this, sourceViewer);
		getSourceViewer().configure(getXtextSourceViewerConfiguration());
		getSourceViewerDecorationSupport(sourceViewer).install(getPreferenceStore());
		getSelectionProvider().addSelectionChangedListener(getSelectionChangedListener());
	}

	//helper methods initially copied from CompilationUnitEditorAdapter
	protected void setActionsActivated(boolean state) {
		Method method = null;
		try {
			method = AbstractTextEditor.class.getDeclaredMethod("setActionActivation", new Class[] { boolean.class }); //$NON-NLS-1$
			method.setAccessible(true);
			method.invoke(this, new Object[] { Boolean.valueOf(state) });
		} catch (Exception exception) {
			throw new WrappedException(exception);
		}
	}

	private void setSourceViewer(ITextEditor editor, SourceViewer viewer) {
		Field field = null;
		try {
			field = AbstractTextEditor.class.getDeclaredField("fSourceViewer"); //$NON-NLS-1$
			field.setAccessible(true);
			field.set(editor, viewer);
		} catch (Exception exception) {
			throw new WrappedException(exception);
		}

	}
}
