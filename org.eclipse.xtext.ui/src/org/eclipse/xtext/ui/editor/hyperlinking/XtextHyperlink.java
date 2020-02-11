/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hyperlinking;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextHyperlink extends AbstractHyperlink {

	private URI uri;
	@Inject 
	private IURIEditorOpener uriEditorOpener;
	
	@Override
	public void open() {
		uriEditorOpener.open(getURI(), true);
	}

	public URI getURI() {
		return uri;
	}
	
	public void setURI(URI uri) {
		this.uri = uri;
	}

}