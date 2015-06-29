/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.generator

import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IStorage
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.WrappedException
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IShouldGenerate
import org.eclipse.xtext.ui.resource.IStorage2UriMapper
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.util.Pair

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class EclipseBasedShouldGenerate implements IShouldGenerate {

	@Inject IStorage2UriMapper storage2UriMapper

	override shouldGenerate(Resource resource, CancelIndicator cancelIndicator) {
		val uri = resource?.resourceSet?.resources?.head?.URI
		if (uri == null || !uri.isPlatformResource)
			return false
		val project = ResourcesPlugin.workspace.root.getProject(uri.segment(1))
		try {
			var Iterable<Pair<IStorage, IProject>> storages = storage2UriMapper.getStorages(resource.getURI())
			for (Pair<IStorage, IProject> pair : storages) {
				if (pair.getFirst() instanceof IFile && pair.getSecond().equals(project)) {
					var IFile file = pair.getFirst() as IFile
					return file.findMaxProblemSeverity(null, true, IResource.DEPTH_INFINITE) !== IMarker.SEVERITY_ERROR
				}
			}
			return false
		} catch (CoreException exc) {
			throw new WrappedException(exc)
		}
	}

}