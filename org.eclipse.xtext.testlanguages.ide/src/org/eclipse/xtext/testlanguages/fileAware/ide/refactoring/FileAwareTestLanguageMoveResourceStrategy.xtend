package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring

import org.eclipse.xtext.ide.refactoring.MoveResourceContext
import org.eclipse.xtext.ide.refactoring.XtextMoveResourceStrategy
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration
import com.google.inject.Inject
import org.eclipse.xtext.resource.IResourceServiceProvider

class FileAwareTestLanguageMoveResourceStrategy implements XtextMoveResourceStrategy {

	@Inject IResourceServiceProvider resourceServiceProvider

	override applyMove(MoveResourceContext context) {
		for (change : context.fileChanges) {
			if(resourceServiceProvider.canHandle(change.newURI)) {
				context.addModification(change.oldURI, [ resource |
					resource.URI = change.newURI
					val rootElement = resource.contents.head
					if (rootElement instanceof PackageDeclaration) {
						val newPackage = change.newURI.trimSegments(1).segmentsList.drop(2).join('.')
						rootElement.name = newPackage
					}
				])
			}
		}
	}
}
