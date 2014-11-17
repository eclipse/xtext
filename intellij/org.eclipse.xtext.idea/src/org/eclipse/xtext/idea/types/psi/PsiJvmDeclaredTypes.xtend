package org.eclipse.xtext.idea.types.psi

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.impl.BaseXtextFile

import static org.eclipse.xtext.common.types.TypesPackage.Literals.JVM_DECLARED_TYPE

@Singleton
class PsiJvmDeclaredTypes {

	@Inject
	extension IPsiModelAssociations

	def getPsiJvmDeclaredTypesByName(BaseXtextFile it, String name) {
		val resource = resource

		val result = newArrayList
		for (description : resourceDescription.getExportedObjectsByType(JVM_DECLARED_TYPE)) {
			switch jvmDeclaredType : resource.resourceSet.getEObject(description.EObjectURI, true) {
				JvmDeclaredType case jvmDeclaredType.simpleName == name:
					result += jvmDeclaredType.psiElement as JvmPsiClass
			}
		}
		result
	}

	def getPsiJvmDeclaredTypes(BaseXtextFile it, QualifiedName qualifiedName) {
		val resource = resource

		val result = newArrayList
		for (description : resourceDescription.getExportedObjects(JVM_DECLARED_TYPE, qualifiedName, false)) {
			switch jvmDeclaredType : resource.resourceSet.getEObject(description.EObjectURI, true) {
				JvmDeclaredType:
					result += jvmDeclaredType.psiElement as JvmPsiClass
			}
		}
		result
	}

}
