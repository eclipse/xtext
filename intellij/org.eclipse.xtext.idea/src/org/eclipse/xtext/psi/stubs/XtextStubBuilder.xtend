package org.eclipse.xtext.psi.stubs

import com.google.inject.Inject
import com.intellij.psi.PsiFile
import com.intellij.psi.stubs.DefaultStubBuilder
import com.intellij.psi.stubs.StubElement
import org.eclipse.xtext.idea.lang.IElementTypeProvider
import org.eclipse.xtext.psi.impl.BaseXtextFile

class XtextStubBuilder extends DefaultStubBuilder {

	@Inject
	IElementTypeProvider elementTypeProvider

	override protected StubElement<?> createStubForFile(PsiFile file) {
		switch file {
			BaseXtextFile: file.createStubForFile
			default: super.createStubForFile(file)
		}
	}

	protected def createStubForFile(BaseXtextFile xtextFile) {
		val stub = new XtextFileStub(xtextFile, elementTypeProvider.fileType as XtextFileElementType<?>)
		stub.uri = xtextFile.physicalURI
		stub.exportedObjects = newArrayList
		val resourceDescription = xtextFile.resourceDescription
		if (resourceDescription != null) {
			stub.exportedObjects += resourceDescription.exportedObjects.map [
				new ExportedObject(qualifiedName, EClass, EObjectURI)
			]
		}
		stub
	}

}
