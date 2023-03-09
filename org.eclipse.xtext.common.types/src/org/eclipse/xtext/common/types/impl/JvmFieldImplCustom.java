/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmFieldImplCustom extends JvmFieldImpl {

	@Override
	public long getConstantValueAsLong() {
		return ((Long) getConstantValue()).longValue();
	}

	@Override
	public int getConstantValueAsInt() {
		return ((Integer) getConstantValue()).intValue();
	}

	@Override
	public short getConstantValueAsShort() {
		return ((Short) getConstantValue()).shortValue();
	}

	@Override
	public byte getConstantValueAsByte() {
		return ((Byte) getConstantValue()).byteValue();
	}

	@Override
	public double getConstantValueAsDouble() {
		return ((Double) getConstantValue()).doubleValue();
	}

	@Override
	public float getConstantValueAsFloat() {
		return ((Float) getConstantValue()).floatValue();
	}

	@Override
	public char getConstantValueAsChar() {
		return ((Character) getConstantValue()).charValue();
	}

	@Override
	public boolean getConstantValueAsBoolean() {
		return ((Boolean) getConstantValue()).booleanValue();
	}

	@Override
	public String getConstantValueAsString() {
		String result = (String) getConstantValue();
		if (result == null) {
			throw new NullPointerException("No constant value available.");
		}
		return result;
	}

	
	
}
