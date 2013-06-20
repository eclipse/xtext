/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.3
 */
public class DefaultWorkbenchPartSelection implements IWorkbenchPartSelection {

	private IWorkbenchPart workbenchPart;
	private ISelection selection;

	public IWorkbenchPart getWorkbenchPart() {
		return workbenchPart;
	}

	public ISelection getSelection() {
		return selection;
	}

	public DefaultWorkbenchPartSelection(IWorkbenchPart workbenchPart, ISelection selection) {
		this.workbenchPart = workbenchPart;
		this.selection = selection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((selection == null) ? 0 : selection.hashCode());
		result = prime * result + ((workbenchPart == null) ? 0 : workbenchPart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DefaultWorkbenchPartSelection other = (DefaultWorkbenchPartSelection) obj;
		if (selection == null) {
			if (other.selection != null)
				return false;
		} else if (!selection.equals(other.selection))
			return false;
		if (workbenchPart == null) {
			if (other.workbenchPart != null)
				return false;
		} else if (!workbenchPart.equals(other.workbenchPart))
			return false;
		return true;
	}

}
