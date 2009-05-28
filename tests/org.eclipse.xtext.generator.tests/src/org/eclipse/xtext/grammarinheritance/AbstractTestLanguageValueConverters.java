/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;
import org.eclipse.xtext.parsetree.AbstractNode;

public final class AbstractTestLanguageValueConverters extends DefaultTerminalConverters {
	@ValueConverter(rule = "REAL")
	public IValueConverter<Double> REAL() {
		return new AbstractToStringConverter<Double>(){

			@Override
			protected Double internalToValue(String string, AbstractNode node) {
				return Double.valueOf(string);
			}
		};
	}
}