/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.internal.Activator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaProjectsStateProvider implements IAllContainersState.Provider{

	public IAllContainersState get(IResourceDescriptions context) {
		return Activator.getDefault().getJavaProjectsState();
	}
	
}
