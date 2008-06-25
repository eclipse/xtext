/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.ui.editor.model.IEditorModel;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IFormatterService extends ILanguageService {

	void format(IEditorModel editorModel, IDocument document, IRegion region);
}