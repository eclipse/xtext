/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.navigation;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IMember;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LinkToOrigin extends XtextHyperlink {

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;
	
	private IMember member;

	public void setMember(IMember member) {
		this.member = member;
	}

	@Override
	public void open() {
		URI resourceURI = getURI().trimFragment();
		IResourceServiceProvider serviceProvider = resourceServiceProviderRegistry.getResourceServiceProvider(resourceURI);
		IDerivedMemberAwareEditorOpener opener = serviceProvider.get(IDerivedMemberAwareEditorOpener.class);
		if (opener != null) {
			opener.open(getURI(), member, true);
		} else {
			super.open();
		}
	}
	
}
