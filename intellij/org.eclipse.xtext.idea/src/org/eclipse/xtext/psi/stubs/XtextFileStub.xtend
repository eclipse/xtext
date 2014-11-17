package org.eclipse.xtext.psi.stubs

import com.intellij.psi.stubs.PsiFileStub
import com.intellij.psi.stubs.PsiFileStubImpl
import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.impl.BaseXtextFile

class XtextFileStub<T extends BaseXtextFile> extends PsiFileStubImpl<T> implements PsiFileStub<T> {

	@Accessors
	URI uri

	@Accessors
	List<ExportedObject> exportedObjects

	val XtextFileElementType<?> type

	new(T file, XtextFileElementType<?> type) {
		super(file)
		this.type = type
	}

	override getType() {
		this.type
	}

}
