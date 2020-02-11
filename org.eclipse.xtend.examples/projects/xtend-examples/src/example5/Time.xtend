/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Author - Sven Efftinge
 *******************************************************************************/
package example5

import java.math.BigDecimal
import org.eclipse.xtend.lib.annotations.Data

@Data class Time {
	BigDecimal msec
	
	def +(Time other) {
		new Time(this.msec + other.msec)
	}
	
	def -(Time other) {
		new Time(this.msec - other.msec)
	}

	def *(int times) {
		new Time(this.msec * new BigDecimal(times))
	}
	
	def /(int times) {
		new Time(this.msec / new BigDecimal(times))
	}
	
	def static msec(int msec) {
		new Time(new BigDecimal(msec))
	}
	
	def static sec(int sec) {
		msec(sec * 1000)
	}
	
	def static min(int min) {
		sec(min * 60)
	}
	
	def static h(int h) {
		min(h * 60)
	}
	def static h() {
		h(1)
	}
}