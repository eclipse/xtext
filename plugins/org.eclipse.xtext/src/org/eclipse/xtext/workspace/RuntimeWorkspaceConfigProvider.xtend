/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil

class RuntimeWorkspaceConfigProvider implements IWorkspaceConfigProvider {

	override getWorkspaceConfig(ResourceSet context) {
		val adapters = context.eAdapters
		val adapter = EcoreUtil.getAdapter(adapters, WorkspaceConfigAdapter) as WorkspaceConfigAdapter
		adapter?.workspaceConfig ?: new NullWorkspaceConfig
	}

}