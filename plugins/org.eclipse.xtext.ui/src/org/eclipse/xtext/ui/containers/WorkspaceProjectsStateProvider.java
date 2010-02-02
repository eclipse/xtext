/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.internal.Activator;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class WorkspaceProjectsStateProvider implements Provider<IAllContainersState>{

	public IAllContainersState get() {
		return Activator.getDefault().getWorkspaceProjectsState();
	}
	
}

