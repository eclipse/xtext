/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.testlanguage.formatting2;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.ide.tests.testlanguage.partialSerializationTestLanguage.Node;

/**
 * @author cdietrich - Initial contribution and API
 */
public class PartialSerializationTestLanguageFormatter extends AbstractJavaFormatter {
	
	protected void format(Node obj, IFormattableDocument doc) {
		for (ISemanticRegion r : regionFor(obj).keywords(";")) {
			doc.prepend(r, it -> it.noSpace());
			doc.append(r, it -> it.oneSpace());
		}
		for (Node child : obj.getChildren()) {
			doc.format(child);
		}
	}

}
