/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.releng;

import org.eclipse.emf.mwe.core.WorkflowFacade;

/**
 * Generates all test and example languages.
 *
 * @author Jan Köhnlein - Initial contribution and API
 */
public class GenerateAllLanguages {

	public static void main(String... args) {
		try {
			new WorkflowFacade("org/eclipse/xtext/releng/GenerateAllLanguages.mwe").run();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
