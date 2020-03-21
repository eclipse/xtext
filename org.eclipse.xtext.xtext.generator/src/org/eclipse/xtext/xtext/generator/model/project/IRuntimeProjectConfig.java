/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project;

import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

/**
 * Configuration of the runtime project, i.e. the main subproject containing the language definition.
 * 
 * @noimplement This interface should not be implemented by clients.
 */
public interface IRuntimeProjectConfig extends IBundleProjectConfig {
	
	IXtextGeneratorFileSystemAccess getEcoreModel();
	
	String getEcoreModelFolder();
	
	/**
	 * @since 2.13
	 */
	String getXbaseLibVersionLowerBound();
	
	/**
	 * @since 2.13
	 */
	String getXtendLibVersionLowerBound();
	
}
