/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.shared

import org.eclipse.xtext.builder.standalone.incremental.JavaSupport
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest
import org.eclipse.xtext.builder.standalone.incremental.BuildContext

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class IdeaJavaSupport extends JavaSupport {
	
	override installLocalOnlyTypeProvider(Iterable<URI> classPathRoots, XtextResourceSet resourceSet) {
		super.installLocalOnlyTypeProvider(classPathRoots, resourceSet)
	}

	override installTypeProvider(Iterable<URI> classPathRoots, XtextResourceSet resSet) {
		super.installTypeProvider(classPathRoots, resSet)
		
	}
	
	override preCompileJavaFiles(Iterable<URI> changedResources, ResourceDescriptionsData newIndex, BuildRequest request, extension BuildContext context) {
		null
	}
	
}