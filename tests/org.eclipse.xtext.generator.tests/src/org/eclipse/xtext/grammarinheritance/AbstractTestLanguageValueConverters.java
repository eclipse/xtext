/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.xtext.builtin.conversion.XtextBuiltInConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;

public final class AbstractTestLanguageValueConverters extends XtextBuiltInConverters {
	@ValueConverter(rule = "REAL")
	public IValueConverter REAL() {
		return new AbstractToStringConverter(){

			@Override
			protected Object internalToValue(String string) {
				return Double.valueOf(string);
			}};
	}
}