package org.eclipse.xtext.idea.resource

import com.google.inject.Inject
import com.intellij.openapi.fileTypes.FileType
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.FilenameIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.util.indexing.FileBasedIndex
import java.util.Collection
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.idea.resource.impl.PsiFileBasedResourceDescription
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.psi.impl.BaseXtextFile
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex
import org.eclipse.xtext.resource.IResourceDescription
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable

abstract class AbstractScopeBasedSelectable extends AbstractCompoundSelectable {

	@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)
	GlobalSearchScope scope

	@Inject
	ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex

	override protected getSelectables() {
		resourceDescriptions
	}

	def IResourceDescription getResourceDescription(URI uri) {
		val psiFile = uri.findFile
		if (psiFile != null) {
			return new PsiFileBasedResourceDescription(psiFile)
		}
		null
	}

	def getResourceDescriptions() {
		val extension psiManager = PsiManager.getInstance(scope.project)
		val descriptions = <IResourceDescription>newArrayList
		processFiles[ files |
			for (xtextFile : files.map[findFile].filter(BaseXtextFile)) {
				descriptions += new PsiFileBasedResourceDescription(xtextFile)
			}
			true
		]
		descriptions
	}

	override isEmpty() {
		val boolean[] emptinessCheck = #[true]
		processFiles[ files |
			if (files.empty) {
				return true
			}
			emptinessCheck.set(0, false)
			false
		]
		emptinessCheck.head
	}

	override getExportedObjects(EClass type, QualifiedName qualifiedName, boolean ignoreCase) {
		exportedObjectQualifiedNameIndex.get(qualifiedName.toString, scope.project, scope).fold(newArrayList) [ allDescriptions, xtextFile |
			val resourceDescription = new PsiFileBasedResourceDescription(xtextFile)
			allDescriptions += resourceDescription.getExportedObjects(type, qualifiedName, ignoreCase)
			allDescriptions
		]
	}

	protected def findFile(URI uri) {
		val fileName = uri.lastSegment
		FilenameIndex.getFilesByName(scope.project, fileName, scope).filter(BaseXtextFile).findFirst [
			uri.equals(URI)
		]
	}

	protected def processFiles((Collection<VirtualFile>)=>boolean acceptor) {
		for (FileType fileType : xtextLanguageFilesTypes) {
			if (!acceptor.apply(FileTypeIndex.getFiles(fileType, scope))) {
				return
			}
		}
	}

	protected def getXtextLanguageFilesTypes() {
		FileBasedIndex.instance.getAllKeys(FileTypeIndex.NAME, scope.project).filter[xtextLanguage]
	}

	protected def isXtextLanguage(FileType fileType) {
		switch fileType {
			LanguageFileType: fileType.language instanceof IXtextLanguage
			default: false
		}
	}

}
