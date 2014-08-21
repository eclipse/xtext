/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.launching;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class JunitJavaElementDelegateAdapterFactory implements IAdapterFactory {

	public Object getAdapter(Object adaptableObject, @SuppressWarnings("rawtypes") Class adapterType) {
		if (adaptableObject instanceof JUnitJavaElementDelegate)
			return ((JUnitJavaElementDelegate) adaptableObject).getAdapter(adapterType);
		if (!(JUnitJavaElementDelegate.class.equals(adapterType)))
			return null;

		if (adaptableObject instanceof IFileEditorInput)
			return new JUnitJavaElementDelegate((IFileEditorInput) adaptableObject);
		if (adaptableObject instanceof IFile)
			return new JUnitJavaElementDelegate((IFile) adaptableObject);
		if (adaptableObject instanceof IEditorPart)
			return new JUnitJavaElementDelegate((IEditorPart) adaptableObject);
		return null;
	}

	@SuppressWarnings("rawtypes")
	public Class[] getAdapterList() {
		return new Class[] { JUnitJavaElementDelegate.class };
	}

}
