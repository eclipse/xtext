/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

/**
 * Instances will be handled to {@link AbstractFileTemplate#generateFiles(IFileGenerator)} to collect the files the wizard will create.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public interface IFileGenerator {

	/**
	 * Called once for each file that should be created in the workspace.
	 * 
	 * @param path
	 *                    workspace relative location of the file to create.
	 * @param content
	 *                    The content of the file to create.
	 */
	void generate(CharSequence path, CharSequence content);

}
