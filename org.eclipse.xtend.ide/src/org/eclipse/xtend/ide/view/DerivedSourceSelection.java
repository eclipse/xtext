/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.view;

import org.eclipse.core.resources.IStorage;
import org.eclipse.xtext.ui.views.DefaultWorkbenchPartSelection;
import org.eclipse.xtext.ui.views.IWorkbenchPartSelection;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class DerivedSourceSelection extends DefaultWorkbenchPartSelection {
	private IStorage storage;

	DerivedSourceSelection(IWorkbenchPartSelection workbenchPartSelection, IStorage storage) {
		super(workbenchPartSelection.getWorkbenchPart(), workbenchPartSelection.getSelection());
		this.storage = storage;
	}

	IStorage getStorage() {
		return storage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((storage == null) ? 0 : storage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		DerivedSourceSelection other = (DerivedSourceSelection) obj;
		if (storage == null) {
			if (other.storage != null)
				return false;
		} else if (!storage.equals(other.storage))
			return false;
		return true;
	}

}
