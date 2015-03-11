/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hover.html;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.internal.text.html.BrowserInformationControl;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Holger Schill - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * @since 2.3
 */
public class XtextBrowserInformationControl extends BrowserInformationControl implements
		IXtextBrowserInformationControl {

	public XtextBrowserInformationControl(Shell parent, String symbolicFontName, boolean resizable) {
		super(parent, symbolicFontName, resizable);
	}

	public XtextBrowserInformationControl(Shell parent, String symbolicFontName, String statusFieldText) {
		super(parent, symbolicFontName, statusFieldText);
	}
	
	public XtextBrowserInformationControl(Shell parent, String symbolicFontName, ToolBarManager toolBarManager) {
		super(parent, symbolicFontName, toolBarManager);
	}


}
