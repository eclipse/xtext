/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

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
			setPlatformUri("../..");
		}};
		
		new DirectoryCleaner() {{
			setDirectory("../"+projectName+"/emf-gen");
		}}.invoke(null);
		
		new DirectoryCleaner() {{
			setDirectory("../"+projectName+".edit/emf-gen");
		}}.invoke(null);
		
		new EcoreGenerator() {{
			setGenerateEdit(true);
			setGenModel("platform:/resource/"+projectName+"/model/JavaVMTypes.genmodel");
			addSrcPath("platform:/resource/"+projectName+"/src");
		}}.invoke(null);
	}
}
