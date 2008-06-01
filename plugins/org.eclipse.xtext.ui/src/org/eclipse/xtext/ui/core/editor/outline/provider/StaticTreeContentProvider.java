/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.outline.provider;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.ITreeContentProvider;

/**
 * @author Peter Friese - Initial contribution and API
 *
 */
public abstract class StaticTreeContentProvider extends BaseContentProvider implements ITreeContentProvider, IExecutableExtension {

	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		setName(config.getAttribute("name"));
	}

}
