/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	@Override
	public IStorage getStorage() throws CoreException {
		return storage;
	}

	@Override
	public boolean exists() {
		return true;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	@Override
	public String getName() {
		return storage.getName();
	}

	@Override
	public IPersistableElement getPersistable() {
		return null;
	}

	@Override
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
