/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import java.io.File;

import org.eclipse.emf.mwe.utils.DirectoryCleaner;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.emf.mwe2.ecore.EcoreGenerator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class GenerateEMF {
	/**
	 * Can't use MWE2 because of circular dependencies
	 */
	public static void main(String[] args) {
		final String projectName = "org.eclipse.xtext.common.types";
		
		new StandaloneSetup() {{
			registerProject(new File(".project").getAbsoluteFile());
		}};
		
		new DirectoryCleaner() {{
			setDirectory("../"+projectName+"/emf-gen");
		}}.invoke(null);
		
		
		new EcoreGenerator() {{
			setGenModel("platform:/resource/"+projectName+"/model/JavaVMTypes.genmodel");
			addSrcPath("platform:/resource/"+projectName+"/src");
			setLineDelimiter("\n");
		}}.invoke(null);
	}
}
