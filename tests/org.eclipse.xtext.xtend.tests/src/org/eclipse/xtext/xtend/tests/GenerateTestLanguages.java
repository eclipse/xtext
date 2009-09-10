/*******************************************************************************
 * __  ___            _   
 * \ \/ / |_ _____  __ |_
 *  \  /| __/ _ \ \/ / __|
 *  /  \| |_  __/>  <| |_
 * /_/\_\\__\___/_/\_\\__|
 * 
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.tests;

import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Generates all required testgrammars with xtend services for this test
 * project.
 * 
 * This code was copied from class
 * <code>org.eclipse.xtext.ui.common.GenerateAllTestGrammarsWithUiConfig</code>
 * within project 'org.eclipse.xtext.ui.common.tests'.
 * <p/>
 * 
 * The duplication of this class was required because we need a language setup
 * with xtend services. services.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Jan Koehnlein
 */
public class GenerateTestLanguages {

	public static void main(String... args) throws Exception {
		try {
			new WorkflowFacade("org/eclipse/xtext/xtend/tests/GenerateTestLanguages.mwe").run();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
