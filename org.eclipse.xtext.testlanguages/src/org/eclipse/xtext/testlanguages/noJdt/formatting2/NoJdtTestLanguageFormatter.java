/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.noJdt.formatting2;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.testlanguages.noJdt.noJdt.Greeting;
import org.eclipse.xtext.testlanguages.noJdt.noJdt.Model;

public class NoJdtTestLanguageFormatter extends AbstractJavaFormatter {

	protected void format(Model model, IFormattableDocument doc) {
		for (Greeting greeting : model.getGreetings()) {
			doc.format(greeting);
		}
	}

	protected void format(Greeting greeting, IFormattableDocument doc) {
		doc.append(greeting, it -> it.setNewLines(1, 1, 2));
	}

}
