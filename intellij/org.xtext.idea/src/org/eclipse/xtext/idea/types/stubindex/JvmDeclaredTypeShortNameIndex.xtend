package org.eclipse.xtext.idea.types.stubindex

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import org.eclipse.xtext.psi.impl.BaseXtextFile

class JvmDeclaredTypeShortNameIndex extends StringStubIndexExtension<BaseXtextFile> {
	
	public static StubIndexKey<String, BaseXtextFile> KEY = StubIndexKey.<String, BaseXtextFile>createIndexKey("JvmDeclaredTypeShortNameIndex");
	
	override getKey() {
		KEY
	}

}