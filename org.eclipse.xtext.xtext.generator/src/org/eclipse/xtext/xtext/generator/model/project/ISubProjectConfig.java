/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.model.project;

import org.eclipse.xtext.xtext.generator.IGuiceAwareGeneratorComponent;
import org.eclipse.xtext.xtext.generator.model.IXtextGeneratorFileSystemAccess;

/**
 * Configuration of subprojects.
 * 
 * @noimplement This interface should not be implemented by clients.
 */
public interface ISubProjectConfig extends IGuiceAwareGeneratorComponent {
	
	boolean isEnabled();
	
	String getName();
	
	IXtextGeneratorFileSystemAccess getRoot();
	
	IXtextGeneratorFileSystemAccess getMetaInf();
	
	IXtextGeneratorFileSystemAccess getSrc();
	
	IXtextGeneratorFileSystemAccess getSrcGen();
	
	IXtextGeneratorFileSystemAccess getIcons();
	
}
