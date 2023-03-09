/*******************************************************************************
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.tests.data;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Amount {
	
	private BigDecimal value = null;

	public Amount(BigDecimal value) {
		super();
		this.value = value;
	}
	
	public Amount(String value) {
		super();
		this.value = new BigDecimal(value);
	}
	
	@Override
	public String toString() {
		return value.setScale(2, RoundingMode.HALF_UP).toString();
	}
	
	public Amount operator_plus(Amount other) {
		return new Amount(this.value.add(other.value));
	}
	
	public Amount operator_minus(Amount other) {
		return new Amount(this.value.subtract(other.value));
	}
	
	public Amount operator_multiply(int factor) {
		return new Amount(this.value.multiply(new BigDecimal(factor)));
	}
	
	public Amount operator_divide(int divisor) {
		return new Amount(this.value.divide(new BigDecimal(divisor)));
	}
	
}
