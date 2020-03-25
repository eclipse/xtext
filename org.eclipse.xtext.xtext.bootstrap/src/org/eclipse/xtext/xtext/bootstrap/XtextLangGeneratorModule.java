/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.bootstrap;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.xtext.generator.DefaultGeneratorModule;
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming;
import org.eclipse.xtext.xtext.generator.model.TypeReference;

public class XtextLangGeneratorModule extends DefaultGeneratorModule {

	public Class<? extends XtextGeneratorNaming> bindNaming() {
		return XtextLangGeneratorNaming.class;
	}

	public static class XtextLangGeneratorNaming extends XtextGeneratorNaming {

		@Override
		public String getGenericIdeBasePackage(Grammar grammar) {
			if (isXtext(grammar)) {
				return "org.eclipse.xtext.xtext.ide";
			} else {
				return super.getGenericIdeBasePackage(grammar);
			}
		}

		@Override
		public String getEclipsePluginBasePackage(Grammar grammar) {
			if (isXtext(grammar)) {
				return "org.eclipse.xtext.xtext.ui";
			} else {
				return super.getEclipsePluginBasePackage(grammar);
			}
		}

		@Override
		public TypeReference getEclipsePluginActivator() {
			return new TypeReference("org.eclipse.xtext.xtext.ui.internal", "Activator");
		}

		public boolean isXtext(Grammar grammar) {
			return grammar.getName().equals("org.eclipse.xtext.Xtext");
		}
	}
}