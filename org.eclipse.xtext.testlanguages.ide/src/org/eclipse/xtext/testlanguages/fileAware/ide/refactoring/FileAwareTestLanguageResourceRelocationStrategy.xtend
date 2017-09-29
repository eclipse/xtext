package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring

import com.google.inject.Inject
import org.eclipse.xtext.ide.refactoring.IResourceRelocationStrategy
import org.eclipse.xtext.ide.refactoring.ResourceRelocationChange
import org.eclipse.xtext.ide.refactoring.ResourceRelocationContext
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration

class FileAwareTestLanguageResourceRelocationStrategy implements IResourceRelocationStrategy {

	@Inject IResourceServiceProvider resourceServiceProvider
		
	def boolean canHandle(ResourceRelocationChange change) {
		resourceServiceProvider.canHandle(change.fromURI)
	}
		
	override applyChange(ResourceRelocationContext context) {
		context.changes.filter[ canHandle ].forEach [ change | 
			context.addModification(change) [ resource |
				val rootElement = resource.contents.head
				if (rootElement instanceof PackageDeclaration) {
					val newPackage = change.toURI.trimSegments(1).segmentsList.drop(2).join('.')
					rootElement.name = newPackage
				}
			]			
		]
	}
}
