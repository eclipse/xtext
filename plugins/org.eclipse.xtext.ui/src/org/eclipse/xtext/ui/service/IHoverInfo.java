/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.ui.editor.model.IEditorModelProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IHoverInfo extends ILanguageService {
	EObject getHoverInfo(ITextViewer textViewer, int offset, IEditorModelProvider editorModelProvider);

	void createContents(EObject input, IContentContainer contentContainer);

	List<IAction> getHoverActions(EObject input);

	public interface IContentContainer {
		void appendText(StyledString text);

		void appendImage(Image image);
	}
}
