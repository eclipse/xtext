package org.eclipse.xtend.core.tests.debug

import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccessExtension
import org.eclipse.xtext.generator.IFileSystemAccessExtension2

class AbstractTraceRegionFSA implements IFileSystemAccessExtension2, IFileSystemAccessExtension, IFileSystemAccess {

	override getURI(String fileName, String outputConfiguration) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override getURI(String fileName) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override deleteFile(String fileName, String outputConfigurationName) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override deleteFile(String fileName) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	override generateFile(String fileName, CharSequence contents) {
		this.charSequence = contents
	}
	
	override generateFile(String fileName, String outputConfigurationName, CharSequence contents) {
		throw new UnsupportedOperationException("Auto-generated function stub")
	}
	
	public CharSequence charSequence
	
}