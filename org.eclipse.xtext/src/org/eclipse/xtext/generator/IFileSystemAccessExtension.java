/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.1
 */
public interface IFileSystemAccessExtension {

	/**
	 * @param fileName using '/' as file separator
	 * @param outputConfigurationName the name of the output configuration
	 * @since 2.1
	 */
	public void deleteFile(String fileName, String outputConfigurationName);
}
