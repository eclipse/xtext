/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.navigation;

import org.eclipse.jdt.core.IMember;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkToOrigin extends XtextHyperlink {

	@Inject
	private GlobalURIEditorOpener uriEditorOpener;
	
	private IMember member;

	public void setMember(IMember member) {
		this.member = member;
	}

	@Override
	public void open() {
		uriEditorOpener.open(getURI(), member, true);
	}
	
}
