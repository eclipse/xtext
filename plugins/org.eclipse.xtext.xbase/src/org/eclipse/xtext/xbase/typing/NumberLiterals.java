/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typing;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XNumberLiteral;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class NumberLiterals {

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private ITypeProvider typeProvider;

	public int getBase(XNumberLiteral literal) {
		if (literal.getValue().startsWith("0x"))
			return 16;
		else if (literal.getValue().startsWith("0") && literal.getValue().length() > 1 && literal.getValue().indexOf('.') == -1)
			return 8;
		else
			return 10;
	}

	protected char getLastChar(XNumberLiteral literal) {
		return Character.toLowerCase(literal.getValue().charAt(literal.getValue().length() - 1));
	}

	public String getDigits(XNumberLiteral literal) {
		String value = literal.getValue();
		int length = value.length();
		char lastChar = getLastChar(literal);
		switch (getBase(literal)) {
			case 8:
				if (lastChar == 'l')
					return value.substring(1, length - 1);
				else
					return value.substring(1, length);
			case 10:
				if (lastChar == 'l' || lastChar == 'd' || lastChar == 'f' || lastChar == 'b')
					return value.substring(0, length - 1);
				else
					return value;
			case 16:
				if (lastChar == 'l')
					return value.substring(2, length - 1);
				else
					return value.substring(2, length);
			default:
				throw new IllegalArgumentException("Invalid number literal base " + getBase(literal));
		}
	}

	public boolean isFloatingPoint(XNumberLiteral literal) {
		if (literal.getValue().indexOf('.') != -1) {
			return true;
		}
		String lowerCaseValue = literal.getValue().toLowerCase();
		switch (getBase(literal)) {
			case 8:
			case 16:
				return false;
			case 10:
				char lastChar = getLastChar(literal);
				return lowerCaseValue.indexOf('e') != -1 || lastChar == 'd' || lastChar == 'f';
			default:
				throw new IllegalArgumentException("Invalid number literal base " + getBase(literal));
		}
	}
	
	protected Class<? extends Number> getExplicitJavaType(XNumberLiteral literal, char lastChar) {
		if(getBase(literal)==16) {
			if(lastChar == 'l') 
				return Long.TYPE; 
		} else {
			switch(lastChar) {
				case 'd': return Double.TYPE;
				case 'f': return Float.TYPE;
				case 'l': return Long.TYPE;
			}
		}
		return null;
	}
	
	public Class<? extends Number> getJavaType(XNumberLiteral literal) {
		char lastChar = getLastChar(literal);
 		Class<? extends Number> explicitType = getExplicitJavaType(literal, lastChar);
		if(explicitType != null)
			return explicitType;
		else {
			if(lastChar == 'b')
				return (isFloatingPoint(literal)) ? BigDecimal.class : BigInteger.class;
			else 
				return (isFloatingPoint(literal)) ? Double.TYPE : Integer.TYPE;
		}
	}

	public Number numberValue(XNumberLiteral literal, Class<? extends Number> numberType) {
		if(numberType == Float.TYPE || numberType == Float.class)
			return Float.parseFloat(getDigits(literal));
		else if(numberType == Double.TYPE || numberType == Double.class)
			return Double.parseDouble(getDigits(literal));
		else if(numberType == Long.TYPE || numberType == Long.class)
			return Long.parseLong(getDigits(literal), getBase(literal));
		else if(numberType == Integer.TYPE || numberType == Integer.class)
			return Integer.parseInt(getDigits(literal), getBase(literal));
		else if(numberType == BigInteger.class)
			return toBigInteger(literal);
		else if(numberType == BigDecimal.class)
			return toBigDecimal(literal);
		else 
			throw new IllegalArgumentException("Cannot convert number literal to type" + numberType.getCanonicalName());
	}

	protected BigInteger toBigInteger(XNumberLiteral literal) {
		if (isFloatingPoint(literal))
			return toBigDecimal(literal).toBigInteger();
		else
			return new BigInteger(getDigits(literal), getBase(literal));
	}

	protected BigDecimal toBigDecimal(XNumberLiteral literal) {
		if (isFloatingPoint(literal)) {
			return new BigDecimal(getDigits(literal));
		} else {
			int base = getBase(literal);
			switch (base) {
				case 16:
				case 8:
					return new BigDecimal(new BigInteger(getDigits(literal), base));
				case 10:
					return new BigDecimal(getDigits(literal));
				default:
					throw new IllegalArgumentException("Invalid number literal base " + base);
			}
		}
	}
}
