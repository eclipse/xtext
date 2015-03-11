/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.tests.containers

import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.resource.impl.AbstractResourceDescription

@FinalFieldsConstructor
class URIBasedTestResourceDescription extends AbstractResourceDescription {

	val URI uri

	override protected computeExportedObjects() {
		emptyList
	}

	override getImportedNames() {
		emptyList
	}

	override getReferenceDescriptions() {
		emptyList
	}

	override getURI() {
		uri
	}

}
