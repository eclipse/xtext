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
 */
public interface IFileSystemAccess {
	
	public final static String DEFAULT_OUTPUT = "DEFAULT_OUTPUT";
	
	/**
	 * @param fileName using '/' as file separator
	 * @param contents the to-be-written contents.
	 */
	public void generateFile(String fileName, CharSequence contents);
	
	/**
	 * @param fileName using '/' as file separator
	 * @param outputConfigurationName the name of the output configuration
	 * @param contents the to-be-written contents.
	 */
	public void generateFile(String fileName, String outputConfigurationName, CharSequence contents);
	
	/**
	 * @param fileName using '/' as file separator
	 */
	public void deleteFile(String fileName);
	
}
