/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.server.persistence

import java.io.File
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.web.server.InvalidRequestException

/**
 * Default resource base provider that assumes all resource identifiers are relative
 * paths inside a certain resource base path, which has to be given when creating
 * this provider.
 */
@FinalFieldsConstructor
class ResourceBaseProviderImpl implements IResourceBaseProvider {
	
	val String resourceBase
	
	override getFileURI(String resourceId) {
		if (resourceId.contains('..'))
			throw new InvalidRequestException.InvalidParametersException('Invalid resource path.')
		if (resourceBase.endsWith(File.separator))
			URI.createFileURI(resourceBase + resourceId)
		else
			URI.createFileURI(resourceBase + File.separator + resourceId)
	}
	
}