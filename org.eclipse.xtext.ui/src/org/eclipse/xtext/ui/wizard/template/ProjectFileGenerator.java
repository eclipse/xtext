/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

import org.eclipse.xtext.generator.IFileSystemAccess2;

/**
 * Default implementation of IProjectFileGeneratorm based on IFileSystemAccess2.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public class ProjectFileGenerator implements IProjectFileGenerator {

	private final IFileSystemAccess2 access;

	public ProjectFileGenerator(IFileSystemAccess2 access) {
		this.access = access;
	}

	@Override
	public void generate(CharSequence fileName, CharSequence contents) {
		access.generateFile(fileName.toString(), contents);
	}

}
