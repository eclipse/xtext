package org.eclipse.xtend.core.macro.fsaccess

import com.google.common.annotations.Beta
import org.eclipse.xtend.lib.macro.services.FolderHandle
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl

@Beta
interface FileSystemAccessImpl {

	def FolderHandle getSourceFolder(CompilationUnitImpl impl)

	def FolderHandle getRootFolder(CompilationUnitImpl impl)

	def FolderHandle getTargetFolder(CompilationUnitImpl impl)

}
