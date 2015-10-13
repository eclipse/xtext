/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;

public class StateMachineGeneratorModule extends DefaultGeneratorModule {

	public Class<? extends XtextGeneratorNaming> bindNaming() {
		return StateMachineGeneratorNaming.class;
	}

	public static class StateMachineGeneratorNaming extends XtextGeneratorNaming {
		@Override
		public String getWebBasePackage(Grammar grammar) {
			if (grammar.getName().equals("org.eclipse.xtext.web.example.statemachine.Statemachine")) {
				return "org.eclipse.xtext.web.example.jetty";
			} else {
				return super.getWebBasePackage(grammar);
			}
		}
	}
}
