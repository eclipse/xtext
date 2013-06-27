package org.eclipse.xtend.lib.macro.services;

import com.google.common.annotations.Beta;

/**
 * 
 * Support for accessing the file system.
 * 
 * @author Anton Kosyakov
 * 
 */
@Beta
public interface FileSystemAccess {

	/**
	 * Returns the root folder handle.
	 * 
	 * @return the root folder handle
	 * @see FolderHandle
	 */
	FolderHandle getRootFolder();

	/**
	 * Returns the source folder handle.
	 * 
	 * @return the source folder handle
	 * @see FolderHandle
	 */
	FolderHandle getSourceFolder();

	/**
	 * Returns the source folder handle.
	 * 
	 * @return the source folder handle
	 * @see FolderHandle
	 */
	FolderHandle getTargetFolder();

}
