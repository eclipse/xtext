/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.resource

import java.util.Collections
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.containers.IAllContainersState

class IdeaAllContainerStateProvider implements IAllContainersState.Provider {
	
	override get(IResourceDescriptions context) {
		return new FlatContainerState(context)
	}
	
	@Data static class FlatContainerState implements IAllContainersState {
		
		private final static String HANDLE = "ALL"
		
		IResourceDescriptions descriptions
		
		override getContainedURIs(String containerHandle) {
			descriptions.allResourceDescriptions.map[URI].toList
		}
		override String getContainerHandle(URI uri) {
			return HANDLE 
		}
		override List<String> getVisibleContainerHandles(String handle) {
			return Collections.singletonList(HANDLE) 
		}
		override boolean isEmpty(String containerHandle) {
			return !HANDLE.equals(containerHandle) 
		}

	}
	
}