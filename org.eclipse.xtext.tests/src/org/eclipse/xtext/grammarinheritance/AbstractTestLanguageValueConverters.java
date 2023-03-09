/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;
import org.eclipse.xtext.nodemodel.INode;

public final class AbstractTestLanguageValueConverters extends DefaultTerminalConverters {
	@ValueConverter(rule = "REAL")
	public IValueConverter<Double> REAL() {
		return new AbstractToStringConverter<Double>(){

			@Override
			protected Double internalToValue(String string, INode node) {
				return Double.valueOf(string);
			}
		};
	}
}