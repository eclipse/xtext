package org.eclipse.xtend.core.resource

import org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager
import org.eclipse.xtext.resource.impl.DefaultResourceDescription
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy
import org.eclipse.xtext.resource.impl.EObjectDescriptionLookUp
import org.eclipse.xtext.naming.QualifiedName

class XtendResourceDescriptionManager extends DerivedStateAwareResourceDescriptionManager {

	override protected createResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new XtendResourceDescription(resource, strategy)
	}
}

class XtendResourceDescription extends DefaultResourceDescription {

	val primitivesFilter = #['boolean', 'int', 'char', 'byte', 'short', 'long']

	new(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		super(resource, strategy)
	}

	override protected getLookUp() {
		if (lookup == null)
			lookup = new EObjectDescriptionLookUp(computeExportedObjects());
		return lookup;
	}

	def override Iterable<QualifiedName> getImportedNames() {
		var originalImportedNames = super.getImportedNames();

		var filteredImportedNames = originalImportedNames.filter [
			!primitivesFilter.contains(it.lastSegment)
		]

		return filteredImportedNames;
	}
}
