/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import org.eclipse.core.internal.utils.WrappedRuntimeException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.internal.ui.JavaPluginImages;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Michael Clay - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class OpenEditorAction extends Action {
	private static final String COMPILATION_UNIT_EDITOR_ID = "org.eclipse.jdt.ui.CompilationUnitEditor";
	private DerivedSourceView derivedSourceView;
	private IFile inputFile;
	private ITextRegion selectedRegion;

	void setInputFile(IFile selectedFile) {
		if (selectedFile == null) {
			setEnabled(false);
		} else {
			setEnabled(true);
		}
		this.inputFile = selectedFile;
	}

	void setSelectedRegion(ITextRegion textRegion) {
		this.selectedRegion = textRegion;
	}

	public OpenEditorAction(DerivedSourceView derivedSourceView) {
		Assert.isNotNull(derivedSourceView);
		this.derivedSourceView = derivedSourceView;
		JavaPluginImages.setLocalImageDescriptors(this, "goto_input.gif"); //$NON-NLS-1$
		setText(Messages.OpenEditorAction_Label);
		setToolTipText(Messages.OpenEditorAction_ToolTip);
		setDescription(Messages.OpenEditorAction_Description);

	}

	@Override
	public void run() {
		if (inputFile == null) {
			return;
		}
		IWorkbenchPartSite workbenchPartSite = derivedSourceView.getSite();
		IWorkbenchPage workbenchPage = workbenchPartSite.getPage();
		try {
			IEditorPart editorPart = workbenchPage.openEditor(new FileEditorInput(inputFile),
					COMPILATION_UNIT_EDITOR_ID, true, IWorkbenchPage.MATCH_ID | IWorkbenchPage.MATCH_INPUT);
			if (selectedRegion != null) {
				((ITextEditor) editorPart).selectAndReveal(selectedRegion.getOffset(), selectedRegion.getLength());
			}
		} catch (PartInitException partInitException) {
			throw new WrappedRuntimeException(partInitException);
		}

	}
}