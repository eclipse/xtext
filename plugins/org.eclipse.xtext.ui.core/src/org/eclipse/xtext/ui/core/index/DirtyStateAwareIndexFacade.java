/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.index;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.index.XtextIndexFacade;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.core.editor.IDirtyStateManager;

import com.google.inject.Inject;

/**
 * Implementation of the {@link org.eclipse.xtext.index.IXtextIndexFacade} that should
 * be used by the editor. Editors are aware of currently modified content of other 
 * editors. This index facade will transparently merge the dirty resource descriptions 
 * into the result of common queries.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DirtyStateAwareIndexFacade extends XtextIndexFacade {

	@Inject
	private IDirtyStateManager dirtyStateManager;
	
	@Override
	protected IResourceDescription getActualResourceDescription(IResourceDescription persisted) {
		URI uri = persisted.getURI();
		IResourceDescription description = dirtyStateManager.getDirtyResourceDescription(uri);
		if (description != null)
			return description;
		return super.getActualResourceDescription(persisted);
	}
	
	public IDirtyStateManager getDirtyStateManager() {
		return dirtyStateManager;
	}
	
	public void setDirtyStateManager(IDirtyStateManager dirtyStateManager) {
		this.dirtyStateManager = dirtyStateManager;
	}
	
}
