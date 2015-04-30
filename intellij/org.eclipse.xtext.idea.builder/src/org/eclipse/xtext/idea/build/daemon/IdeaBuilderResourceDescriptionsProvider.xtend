/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.build.daemon

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.common.types.xtext.AbstractProjectAwareResourceDescriptionsProvider

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class IdeaBuilderResourceDescriptionsProvider extends AbstractProjectAwareResourceDescriptionsProvider {
	
	@Inject extension IBuildSessionSingletons
	
	override protected isProjectLocal(URI uri, String encodedProjectName) {
		uri.toString.startsWith(encodedProjectName)
	}
	
	override protected getProjectName(ResourceSet resourceSet) {
		moduleBaseURL
	}
}