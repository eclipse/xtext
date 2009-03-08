/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.boostrap;

import org.apache.log4j.Logger;
import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Run this class in order to generate the domain model grammar.
 */
public class GenerateXtextGrammars {

	private static Logger logger = Logger.getLogger(GenerateXtextGrammars.class);

	public static void main(String... args) {

		try {
			logger.info("Generating Xtext and default languages.");
			new WorkflowFacade("org/eclipse/xtext/boostrap/GenerateXtext.mwe").run();
			logger.info("DONE.");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
