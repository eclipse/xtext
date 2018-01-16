/** 
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.impl

import com.google.inject.Inject
import org.eclipse.emf.common.notify.Notifier
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.workspace.IProjectConfigProvider
import org.eclipse.xtext.workspace.IWorkspaceConfig

import static extension org.eclipse.xtext.EcoreUtil2.*

/** 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.14
 */
class LiveShadowedChunkedResourceDescriptions extends LiveShadowedResourceDescriptions {
	
	@Inject(optional = true) IProjectConfigProvider projectConfigProvider
	
	@Accessors(PUBLIC_GETTER) IWorkspaceConfig workspaceConfig

	override void setContext(Notifier ctx) {
		(localDescriptions as ResourceSetBasedResourceDescriptions) => [
			context = ctx
			data = null
		]
		val resourceSet = ctx.resourceSet
		globalDescriptions = ChunkedResourceDescriptions.findInEmfObject(resourceSet)
		workspaceConfig = projectConfigProvider?.getProjectConfig(resourceSet)?.workspaceConfig
	}
}
