/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator

import com.google.inject.Inject
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.runtime.Path
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IShouldGenerate
import org.eclipse.xtext.util.CancelIndicator

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class EclipseBasedShouldGenerate implements IShouldGenerate {

	@Inject IWorkspaceRoot workspace

	override shouldGenerate(Resource resource, String projectName, CancelIndicator cancelIndicator) {
		val uri = resource.URI
		if (uri === null || !uri.isPlatformResource)
			return false
		val member = workspace.findMember(new Path(uri.toPlatformString(true)))
		if (member !== null && member.type === IResource.FILE && member.project.name == projectName) {
			return member.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE) !== IMarker.SEVERITY_ERROR
		}
		return false
	}

}