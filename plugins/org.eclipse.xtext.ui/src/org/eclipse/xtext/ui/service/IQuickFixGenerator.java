/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.service;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.xtext.service.ILanguageService;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public interface IQuickFixGenerator extends ILanguageService {
	/**
	 * @param marker
	 * @param documentProvider
	 * @return
	 */
	IMarkerResolution2[] getQuickFixes(IMarker marker, XtextDocumentProvider documentProvider);

	/**
	 * @param marker
	 * @param documentProvider
	 * @return true if there are quickfixes available for given marker
	 */
	boolean hasQuickFixes(IMarker marker, XtextDocumentProvider documentProvider);
}
