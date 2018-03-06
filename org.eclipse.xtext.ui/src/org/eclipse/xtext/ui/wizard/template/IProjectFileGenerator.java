/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.wizard.template;

/**
 * Generate files from the templates inside the new project wizard.
 * 
 * @author Arne Deutsch - Initial contribution and API
 * @since 2.14
 */
public interface IProjectFileGenerator {

	/**
	 * Generate a new text file with the given name (relative path permitted) and the given contents
	 */
	void generate(CharSequence fileName, CharSequence contents);

}
