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
package org.eclipse.xtext.ui.common;

import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Generates all required test grammars with UI configuration for this test project.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class GenerateAllTestGrammarsWithUiConfig {

	public static void main(String... args) throws Exception {
		try {
			new WorkflowFacade("org/eclipse/xtext/ui/common/GenerateTestLanguages.mwe").run();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
