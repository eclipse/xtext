/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.boostrap;

import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Run this class in order to generate the domain model grammar.
 */
public class  GenerateXtextGrammars {

	public static void main(String... args) {
		try {
			new WorkflowFacade("org/eclipse/xtext/boostrap/generateXtext.mwe").run();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}

