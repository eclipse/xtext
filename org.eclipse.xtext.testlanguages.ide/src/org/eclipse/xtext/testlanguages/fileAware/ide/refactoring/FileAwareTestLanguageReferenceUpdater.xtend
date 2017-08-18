package org.eclipse.xtext.testlanguages.fileAware.ide.refactoring

import javax.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.ide.serializer.hooks.IReferenceUpdaterContext
import org.eclipse.xtext.ide.serializer.impl.ReferenceUpdater
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration
import org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwareFactory
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Element

class FileAwareTestLanguageReferenceUpdater extends ReferenceUpdater {

	@Inject IQualifiedNameProvider names
	extension FileAwareFactory = FileAwareFactory.eINSTANCE

	override update(IReferenceUpdaterContext context) {
		super.update(context)
		val pkg = context.resource.contents.head as PackageDeclaration
		val pkgName = names.getFullyQualifiedName(pkg)
		val actual = pkg.imports.toMap[element]
		val targets = context.updatableReferences.map[targetEObject].filter(Element)
		val expected = targets.filter[names.getFullyQualifiedName(it).skipLast(1) != pkgName].toSet
		val toAdd = expected.filter[!actual.containsKey(it)].toSet
		val toDelete = actual.filter[!expected.contains($0)]
		if (!toAdd.isEmpty || !toDelete.isEmpty) {
			context.modifyModel [
				toDelete.values.forEach[EcoreUtil.remove(it)]
				toAdd.forEach[e|pkg.imports += createImport => [element = e]]
			]
		}
	}

}
