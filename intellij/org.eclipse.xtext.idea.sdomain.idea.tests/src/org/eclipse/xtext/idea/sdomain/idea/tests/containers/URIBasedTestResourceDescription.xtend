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
