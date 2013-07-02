package org.eclipse.xtend.core.macro.fsaccess

import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.services.FileSystemAccess

/**
 * <p>
 * This class is the stub for the Runtime mode. 
 * </p><p>
 * Currently {@link FileSystemAccess} is used only in the context of active annotations processing with Eclipse or Maven.</p>
 */
class RuntimeFileSystemAccessImpl implements FileSystemAccessSPI {

	override getSourceFolder(CompilationUnitImpl impl) {
		throw new UnsupportedOperationException("FileSystemAccess is not supported in the Runtime mode")
	}

	override getRootFolder(CompilationUnitImpl impl) {
		throw new UnsupportedOperationException("FileSystemAccess is not supported in the Runtime mode")
	}

	override getTargetFolder(CompilationUnitImpl impl) {
		throw new UnsupportedOperationException("FileSystemAccess is not supported in the Runtime mode")
	}

}
