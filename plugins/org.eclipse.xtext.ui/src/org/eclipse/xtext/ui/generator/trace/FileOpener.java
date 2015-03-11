/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class FileOpener {

	protected <T> T adapt(Object object, Class<T> type) {
		if (type.isInstance(object))
			return type.cast(object);
		if (object instanceof IAdaptable) {
			Object result = ((IAdaptable) object).getAdapter(type);
			if (type.isInstance(result))
				return type.cast(result);
		}
		Object result = Platform.getAdapterManager().getAdapter(object, type);
		if (type.isInstance(result))
			return type.cast(object);
		return null;
	}

	public abstract ImageDescriptor getImageDescriptor();

	public String getQualifiedLabel() {
		return getShortLabel();
	}

	public abstract String getShortLabel();

	public abstract void open(IWorkbenchPage page);

}
