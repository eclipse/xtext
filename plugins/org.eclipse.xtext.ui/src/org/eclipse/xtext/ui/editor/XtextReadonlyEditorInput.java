/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.IStorageEditorInput;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextReadonlyEditorInput extends PlatformObject implements IStorageEditorInput {

	private final IStorage storage;

	public XtextReadonlyEditorInput(IStorage storage) {
		this.storage = storage;
	}

	public IStorage getStorage() throws CoreException {
		return storage;
	}

	public boolean exists() {
		return true;
	}

	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public String getName() {
		return storage.getName();
	}

	public IPersistableElement getPersistable() {
		return null;
	}

	public String getToolTipText() {
		return storage.getName();
	}

	@Override
	public boolean equals(Object obj) {
		try {
			return (obj == this || obj != null && (obj instanceof IStorageEditorInput) &&
					storage.equals(((IStorageEditorInput)obj).getStorage()));
		} catch (CoreException e) {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return storage.hashCode();
	}
}
