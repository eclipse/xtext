/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.generator.trace;

import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class FileOpener {

	protected <T> T adapt(Object object, Class<T> type) {
		return Adapters.adapt(object, type);
	}

	public abstract ImageDescriptor getImageDescriptor();

	public String getQualifiedLabel() {
		return getShortLabel();
	}

	public abstract String getShortLabel();

	public abstract void open(IWorkbenchPage page);

}
