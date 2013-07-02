package org.eclipse.xtend.lib.macro.services;

import com.google.common.annotations.Beta;

/**
 * A representation of file system resources.
 * 
 * @author Anton Kosyakov
 * 
 */
@Beta
public interface ResourceHandle {

	/**
	 * Returns the last segment of the file path.
	 * 
	 * @return the last segment of the file path
	 */
	String getName();

	/**
	 * Returns the canonical path to the file.
	 * 
	 * @return the canonical path to the file
	 */
	String getPath();

	/**
	 * Tests whether this resource exists.
	 * 
	 * @return <code>true</code> if this resource exists; otherwise
	 *         <code>false</code>
	 */
	boolean exists();

}
