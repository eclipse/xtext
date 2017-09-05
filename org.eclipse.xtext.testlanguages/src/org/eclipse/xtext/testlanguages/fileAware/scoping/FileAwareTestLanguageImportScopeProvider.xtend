package org.eclipse.xtext.testlanguages.fileAware.scoping

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.scoping.impl.ImportNormalizer
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider
import org.eclipse.xtext.testlanguages.fileAware.fileAware.Import
import org.eclipse.xtext.testlanguages.fileAware.fileAware.PackageDeclaration
import static org.eclipse.xtext.testlanguages.fileAware.fileAware.FileAwarePackage.Literals.*

class FileAwareTestLanguageImportScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {

	override protected internalGetImportedNamespaceResolvers(EObject context, boolean ignoreCase) {
		val resolvers = super.internalGetImportedNamespaceResolvers(context, ignoreCase)
		if (context instanceof PackageDeclaration) {
			resolvers += new ImportNormalizer(qualifiedNameConverter.toQualifiedName(context.name), true, false)
			for (imp : context.imports) {
				val name = imp.importedNamespace
				resolvers += new ImportNormalizer(name, false, false)
			}
		}
		return resolvers
	}

	private def QualifiedName getImportedNamespace(Import imp) {
		val ele = imp.element
		if (ele.eIsProxy) {
			val name = NodeModelUtils.findNodesForFeature(imp, IMPORT__ELEMENT).head.text.trim
			return qualifiedNameConverter.toQualifiedName(name)
		} else {
			return qualifiedNameProvider.getFullyQualifiedName(ele)
		}
	}
}
