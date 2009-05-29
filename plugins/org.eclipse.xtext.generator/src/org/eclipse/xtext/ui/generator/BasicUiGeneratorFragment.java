/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.generator;

import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.xtext.generator.DefaultGeneratorFragment;

@Deprecated
public class BasicUiGeneratorFragment extends DefaultGeneratorFragment {
	private String fileExtensions;

	public void setFileExtensions(String text) {
		this.fileExtensions = text;;
	}
	
	public void checkConfiguration(Issues issues) {
		issues.addWarning("Fragment org.eclipse.xtext.ui.generator.BasicUiGeneratorFragment is deprecated and not needed anymore. Just remove it from the mwe configuration.");
		if (fileExtensions!=null) 
			issues.addError("the fileExtensions property has been moved to the main language configuration. \n\tPlease change your *.mwe file to something like \n\n\t"
						+ "<language uri='${grammarURI}' fileExtensions='" + fileExtensions + "'> \n\t\t <-- fragments go here ... --> \n\t</languageConfig>\n\n",this);
	}

}
