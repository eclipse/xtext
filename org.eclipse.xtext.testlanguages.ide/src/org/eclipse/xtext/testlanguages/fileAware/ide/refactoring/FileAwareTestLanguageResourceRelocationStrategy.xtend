package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring

import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration

class FileAwareTestLanguageResourceRelocationStrategy extends IResourceRelocationStrategy.AbstractImpl {

	override applySideEffects(ResourceRelocationContext context) {
		context.changes.filter[ isFile && canHandle ].forEach[ change |
			val resource = context.resourceSet.getResource(change.toURI, false)			
			val rootElement = resource.contents.head
			if (rootElement instanceof PackageDeclaration) {
				val newPackage = change.toURI.trimSegments(1).segmentsList.drop(2).join('.')
				rootElement.name = newPackage
			}
		]
	}
}
