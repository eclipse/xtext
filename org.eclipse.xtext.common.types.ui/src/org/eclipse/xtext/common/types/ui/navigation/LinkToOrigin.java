/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.ui.navigation;

import org.eclipse.jdt.core.IMember;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkToOrigin extends XtextHyperlink {

	@Inject
	private GlobalDerivedMemberAwareURIEditorOpener uriEditorOpener;
	
	private IMember member;

	public void setMember(IMember member) {
		this.member = member;
	}

	@Override
	public void open() {
		uriEditorOpener.open(getURI(), member, true);
	}
	
}
