/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.compiler.output;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.LineSeparatorHarmonizer;

/**
 * Specializes the {@link LineSeparatorHarmonizer} and is aware of {@link TreeAppendable} thus
 * it can harmonize the line breaks and still maintain the trace information.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TraceAwarePostProcessor extends LineSeparatorHarmonizer {

	@Override
	public CharSequence postProcess(URI fileURI, CharSequence content) {
		if (content instanceof TreeAppendable) {
			final String lineSeparator = getWhitespaceInformationProvider().getLineSeparatorInformation(fileURI).getLineSeparator();
			return ((TreeAppendable) content).acceptVisitor(new TreeAppendable.Visitor() {
				@Override
				protected String visit(String string) {
					return replaceLineSeparators(string, lineSeparator);
				}
			});
		} else {
			return super.postProcess(fileURI, content);
		}
	}
	
}
