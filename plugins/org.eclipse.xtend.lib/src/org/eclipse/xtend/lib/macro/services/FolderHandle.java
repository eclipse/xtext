package org.eclipse.xtend.lib.macro.services;

import com.google.common.annotations.Beta;

/**
 * Representation of a folder.
 * 
 * @author Anton Kosyakov
 */
@Beta
public interface FolderHandle extends ResourceHandle {

	/**
	 * <p>
	 * Returns {@link FileHandle} for the given path relative to this folder.
	 * </p>
	 * 
	 * @param path
	 *            - the relative path to the file
	 * @return the file handle for the given path
	 * @exception IllegalStateException
	 *                if the resolved resource is a folder (not a file)
	 */
	FileHandle getFile(String path);

	/**
	 * <p>
	 * Returns {@link FolderHandle} for the given path relative to this folder.
	 * </p>
	 * 
	 * @param path
	 *            - the relative path to the folder
	 * @return the folder handle for the given path
	 * @exception IllegalStateException
	 *                if the resolved resource is a file (not a folder)
	 */
	FolderHandle getFolder(String path);

}
