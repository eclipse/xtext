/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.navigation;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class GlobalDerivedMemberAwareURIEditorOpener extends GlobalURIEditorOpener {

	private static final Logger LOG = Logger.getLogger(GlobalDerivedMemberAwareURIEditorOpener.class);
	
	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Override
	public IEditorPart open(URI uri, Object context, boolean select) {
		try {
			if (context instanceof IMember) {
				if(uri != null) {
					URI sourceResourceURI = uri.trimFragment();
					IResourceServiceProvider serviceProvider = resourceServiceProviderRegistry
							.getResourceServiceProvider(sourceResourceURI);
					if (serviceProvider != null) {
						IDerivedMemberAwareEditorOpener opener = serviceProvider.get(IDerivedMemberAwareEditorOpener.class);
						if (opener != null) {
							return opener.open(sourceResourceURI, (IMember) context, select);
						}
					}
				}
				return JavaUI.openInEditor((IJavaElement) context, true, true);
			}
		} catch(Exception exc) {
			LOG.error("Error opening Java editor", exc);
		}
		return super.open(uri, select);
	}
}
