package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring

import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration
import org.eclipse.emf.ecore.resource.Resource

class FileAwareTestLanguageResourceRelocationStrategy extends IResourceRelocationStrategy.AbstractImpl {

	override applySideEffects(ResourceRelocationChange change, Resource resource, ResourceRelocationContext context) {
		val rootElement = resource.contents.head
		if (rootElement instanceof PackageDeclaration) {
			val newPackage = change.toURI.trimSegments(1).segmentsList.drop(2).join('.')
			rootElement.name = newPackage
		}
	}
}
