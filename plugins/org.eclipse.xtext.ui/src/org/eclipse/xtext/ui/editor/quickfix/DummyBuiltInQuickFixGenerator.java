/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.core.resources.IMarker;
import org.eclipse.ui.IMarkerResolution2;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.service.IQuickFixGenerator;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class DummyBuiltInQuickFixGenerator implements IQuickFixGenerator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.service.IQuickFixGenerator#getQuickFixes(org.eclipse
	 * .core.resources.IMarker,
	 * org.eclipse.xtext.ui.editor.model.XtextDocumentProvider)
	 */
	public IMarkerResolution2[] getQuickFixes(IMarker marker, XtextDocumentProvider documentProvider) {
		return new IMarkerResolution2[] { new DummyCanAllAndEverywhereMarkerResolver(marker, documentProvider) };// TODO
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.service.IQuickFixGenerator#hasQuickFixes(org.eclipse
	 * .core.resources.IMarker,
	 * org.eclipse.xtext.ui.editor.model.XtextDocumentProvider)
	 */
	public boolean hasQuickFixes(IMarker marker, XtextDocumentProvider documentProvider) {
		return true;
	}

}
