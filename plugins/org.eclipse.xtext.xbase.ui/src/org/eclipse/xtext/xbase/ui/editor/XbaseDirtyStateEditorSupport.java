/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport;
import org.eclipse.xtext.xbase.resource.BatchLinkableResource;

/**
 * For {@link BatchLinkableResource}s, the dirty state announcement has to be performed by the reconciler. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @see XbaseDirtyStateEditorSupport
 * @see XbaseDirtyStateResourceDescription
 */
public class XbaseDirtyStateEditorSupport extends DirtyStateEditorSupport {
	
	public void announceDirtyState(BatchLinkableResource resource) {
		super.modelChanged(resource);
	}
	
	@Override
	public void modelChanged(XtextResource resource) {
		if(!(resource instanceof BatchLinkableResource))
			super.modelChanged(resource);
	}
	
	@Override
	protected Manager getResourceDescriptionManager(URI resourceURI) {
		XbaseDirtyStateResourceDescription.Manager xbaseSpecific = getResourceServiceProviderRegistry()
				.getResourceServiceProvider(resourceURI).get(XbaseDirtyStateResourceDescription.Manager.class);
		return xbaseSpecific != null ? xbaseSpecific : super.getResourceDescriptionManager(resourceURI);
	}
}
