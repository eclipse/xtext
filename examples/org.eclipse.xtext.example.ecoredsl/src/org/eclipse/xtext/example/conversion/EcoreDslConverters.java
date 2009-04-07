/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example.conversion;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;
import org.eclipse.xtext.conversion.impl.AbstractValueConverter;
import org.eclipse.xtext.parsetree.AbstractNode;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslConverters extends DefaultTerminalConverters {

	@ValueConverter(rule = "SINT")
	public IValueConverter<Integer> sint() {
		return new AbstractToStringConverter<Integer>() {
			@Override
			public Integer internalToValue(String string, AbstractNode node) {
				return Integer.valueOf(string);
			}
		};
	}

	@ValueConverter(rule = "STRING_OR_QID")
	public IValueConverter<String> stringOrQid() {
		return STRING();
	}
	
	@ValueConverter(rule = "Bag")
	public IValueConverter<Boolean> bag() {
		return negatedBooleanConverter("bag");
	}

	@ValueConverter(rule = "Random")
	public IValueConverter<Boolean> random() {
		return negatedBooleanConverter("random");
	}

	@ValueConverter(rule = "Readonly")
	public IValueConverter<Boolean> readonly() {
		return negatedBooleanConverter("readonly");
	}

	@ValueConverter(rule = "Local")
	public IValueConverter<Boolean> local() {
		return negatedBooleanConverter("local");
	}

	@ValueConverter(rule = "Serializable")
	public IValueConverter<Boolean> serializable() {
		return negatedBooleanConverter("!serializable");
	}

	private IValueConverter<Boolean> negatedBooleanConverter(final String keyword) {
		return new AbstractValueConverter<Boolean>(){
			public Boolean toValue(String string, AbstractNode node) throws ValueConverterException {
				return string == null;
			}
		
			public String toString(Boolean value) {
				return value ? "" : keyword;
			}
		};
	}

}
