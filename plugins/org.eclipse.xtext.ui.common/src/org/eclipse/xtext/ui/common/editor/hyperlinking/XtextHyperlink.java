/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.hyperlinking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.core.editor.IURIEditorOpener;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextHyperlink extends AbstractHyperlink implements IURIEditorOpener {

	@Inject 
	private IURIEditorOpener uriEditorOpener;
	
	public void open() {
		uriEditorOpener.open();
	}

	public URI getURI() {
		return uriEditorOpener.getURI();
	}
	
	public void setURI(URI uri) {
		uriEditorOpener.setURI(uri);
	}

}