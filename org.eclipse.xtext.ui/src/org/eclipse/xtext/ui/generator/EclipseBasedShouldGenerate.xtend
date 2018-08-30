/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Path
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IShouldGenerate
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.workspace.ProjectConfigAdapter
import com.google.inject.Singleton

/**
 * Answers true if the resource does not contain any error markers and is contained
 * in an Eclipse project.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
class EclipseBasedShouldGenerate implements IShouldGenerate {

	override shouldGenerate(Resource resource, CancelIndicator cancelIndicator) {
		val uri = resource.URI
		if (uri === null || !uri.isPlatformResource)
			return false
		val member = ResourcesPlugin.workspace.root.findMember(new Path(uri.toPlatformString(true)))
		if (member !== null && member.type === IResource.FILE) {
			val projectConfig = ProjectConfigAdapter.findInEmfObject(resource.resourceSet)?.projectConfig
			if (member.project.name == projectConfig?.name) {
				return member.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE) !== IMarker.SEVERITY_ERROR
			}
		}
		return false
	}

}