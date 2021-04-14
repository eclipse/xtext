/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.util.Strings;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GenericFormatterTestRequest extends FormatterTestRequest {
	private GenericFormatter<? extends EObject> formatter;

	public GenericFormatter<? extends EObject> getFormatter() {
		return formatter;
	}

	public void setFormatter(GenericFormatter<? extends EObject> formatter) {
		this.formatter = formatter;
	}
	
	@Override
	public FormatterTestRequest setExpectation(CharSequence expectation) {
		return super.setExpectation(Strings.toPlatformLineSeparator(expectation));
	}
	
	@Override
	public FormatterTestRequest setToBeFormatted(CharSequence toBeFormatted) {
		return super.setToBeFormatted(Strings.toPlatformLineSeparator(toBeFormatted));
	}
}
