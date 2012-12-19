/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Author - Sven Efftinge
 *******************************************************************************/
package example5

import org.eclipse.xtend.lib.Data
import java.math.BigDecimal

@Data class Distance {
	BigDecimal mm
	
	def operator_plus(Distance other) {
		new Distance(this.mm + other.mm)
	}
	
	def operator_minus(Distance other) {
		new Distance(this.mm - other.mm)
	}

	def operator_multiply(int times) {
		new Distance(this.mm * new BigDecimal(times))
	}
	
	def operator_divide(int times) {
		new Distance(this.mm / new BigDecimal(times))
	}
	
	def static mm(int millimeters) {
		new Distance(new BigDecimal(millimeters))
	}
	
	def static cm(int centimeters) {
		mm(centimeters * 10)
	}
	
	def static m(int meters) {
		cm(meters * 100)
	}
	
	def static km(int kilometers) {
		m(kilometers * 1000)
	}
	
}