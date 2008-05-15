/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.xtext.ui.core.language.LanguageDescriptor;
import org.eclipse.xtext.ui.core.language.LanguageRegistry;

/**
 * @author Dennis Hübner
 * 
 */
public class BaseTextEditor extends TextEditor {
	public static final String ID = "org.eclipse.xtext.baseEditor";
	private LanguageDescriptor langDescr;

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		IEditorInput input = getEditorInput();
		if (input.getAdapter(IFile.class) instanceof IFile) {
			IFile file = (IFile) input.getAdapter(IFile.class);
			String fileExtension = file.getFileExtension();
			langDescr = LanguageRegistry.getLanguageDescriptor(fileExtension);
			setPartName(getPartName() + " - For '" + langDescr.getName()
					+ "' language");
		}
	}
}
