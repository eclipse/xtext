package org.eclipse.xtext.psi.stubs

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.naming.QualifiedName

@FinalFieldsConstructor
class ExportedObject {
	@Accessors val QualifiedName qualifiedName
	@Accessors val EClass EClass 
	@Accessors val URI EObjectURI
}
