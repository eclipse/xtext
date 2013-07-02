package org.eclipse.xtend.core.macro.fsaccess

import com.google.common.annotations.Beta
import org.eclipse.jdt.annotation.NonNull
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.lib.macro.services.FolderHandle

@Beta
interface FileSystemAccessSPI {

	@NonNull
	def FolderHandle getSourceFolder(CompilationUnitImpl impl)

	@NonNull
	def FolderHandle getRootFolder(CompilationUnitImpl impl)

	@NonNull
	def FolderHandle getTargetFolder(CompilationUnitImpl impl)

}

abstract class AbstractFileSystemAccessImpl implements FileSystemAccessSPI {

	override final getSourceFolder(CompilationUnitImpl it) {
		getFolder([|doGetSourceFolder], "source")
	}

	abstract def FolderHandle doGetSourceFolder(CompilationUnitImpl it);

	override final getRootFolder(CompilationUnitImpl it) {
		getFolder([|doGetRootFolder], "root")
	}

	abstract def FolderHandle doGetRootFolder(CompilationUnitImpl it);

	override final getTargetFolder(CompilationUnitImpl it) {
		getFolder([|doGetTargetFolder], "target")
	}

	abstract def FolderHandle doGetTargetFolder(CompilationUnitImpl it);

	def private FolderHandle getFolder(()=>FolderHandle it, String folderType) {
		val folder = apply
		if (folder == null) {
			throw new IllegalStateException('''Could not find «folderType» folder.''')
		}
		folder
	}

}
