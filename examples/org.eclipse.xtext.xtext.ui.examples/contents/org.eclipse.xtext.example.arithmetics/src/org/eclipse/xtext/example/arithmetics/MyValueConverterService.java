/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.arithmetics;

import java.math.BigDecimal;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sven Efftinge - initial contribution and API
 */
public class MyValueConverterService extends DefaultTerminalConverters {

	/**
	 * provides an IValueConverter for the 'NUMBER' rule
	 */
	@ValueConverter(rule = "NUMBER")
	public IValueConverter<BigDecimal> NUMBER() {
		return new AbstractNullSafeConverter<BigDecimal>() {
			
			@Override
			protected BigDecimal internalToValue(String string, AbstractNode node) {
				return new BigDecimal(string);
			}

			@Override
			protected String internalToString(BigDecimal value) {
				return value.toString();
			}
		};
	}
}
