/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import java.math.BigDecimal;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractNullSafeConverter;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DatatypeRulesTestLanguageValueConverters extends DefaultTerminalConverters {

	@ValueConverter(rule = "Fraction")
	public IValueConverter<BigDecimal> Fraction() {
		return new AbstractNullSafeConverter<BigDecimal>(){
			@Override
			protected BigDecimal internalToValue(String string, AbstractNode node) {
				String[] splitted = string.split("/");
				if (splitted.length > 1) {
					return new BigDecimal(splitted[0].trim()).divide(new BigDecimal(splitted[1].trim()));
				}
				return new BigDecimal(string);
			}

			@Override
			protected String internalToString(BigDecimal value) {
				BigDecimal bd = value;
				int scale = bd.scale();
				if (scale <= 0) {
					return bd.toPlainString();
				}
				bd = bd.multiply(BigDecimal.valueOf(1, -1 * scale));
				return bd.toPlainString() + '/' + BigDecimal.valueOf(1, -1 * scale).toPlainString();
			}};
	}

}
