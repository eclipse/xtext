/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui;

import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.validation.IResourceValidator;
import org.xpect.registry.AbstractDelegatingModule;
import org.xpect.ui.highlighting.XtHighlightingCalculator;
import org.xpect.ui.highlighting.XtHighlightingConfiguration;
import org.xpect.ui.services.XtLanguageSpecificURIEditorOpener;
import org.xpect.ui.services.XtResourceValidator;

import com.google.inject.Binder;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtUIModule extends AbstractDelegatingModule {

	public void configure(Binder binder) {
		overrideAndBackup(binder, IHighlightingConfiguration.class, XtHighlightingConfiguration.class);
		overrideAndBackup(binder, ISemanticHighlightingCalculator.class, XtHighlightingCalculator.class);
		overrideAndBackup(binder, IResourceValidator.class, XtResourceValidator.class);
		overrideAndBackup(binder, IURIEditorOpener.class, LanguageSpecific.class, XtLanguageSpecificURIEditorOpener.class);
	}

}
