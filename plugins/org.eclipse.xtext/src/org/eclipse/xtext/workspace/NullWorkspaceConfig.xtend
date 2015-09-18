/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.workspace

import org.eclipse.xtext.workspace.IWorkspaceConfig
import org.eclipse.emf.common.util.URI

class NullWorkspaceConfig implements IWorkspaceConfig {
	
	override getProjects() {
		emptySet
	}
	
	override findProjectByName(String name) {
		null
	}
	
	override findProjectContaining(URI member) {
		null
	}
	
}