package org.eclipse.xtext.psi.stubindex

import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey
import org.eclipse.xtext.psi.impl.BaseXtextFile

class ExportedObjectQualifiedNameIndex extends StringStubIndexExtension<BaseXtextFile> {
	
	public static StubIndexKey<String, BaseXtextFile> KEY = StubIndexKey.<String, BaseXtextFile>createIndexKey("ExportedObjectQualifiedNameIndex"); 
	
	override getKey() {
		KEY
	}
	
}