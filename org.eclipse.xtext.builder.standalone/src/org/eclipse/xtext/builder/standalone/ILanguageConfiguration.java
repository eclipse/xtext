/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.standalone;

import java.util.Set;

import org.eclipse.xtext.generator.OutputConfiguration;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public interface ILanguageConfiguration {
	
	/* @NonNull */
	String getSetup();

	Set<OutputConfiguration> getOutputConfigurations();
	
	/**
	 * @return whether this language links or produces Java types
	 */
	boolean isJavaSupport();
}
