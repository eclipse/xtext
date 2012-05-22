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

import org.junit.Test
import static org.junit.Assert.*
import static extension example5.Distance.*
import static extension example5.Time.*
import static extension example5.Speed.*

/**
 * This example shows the usage of operator overloading combined with
 * extension methods.
 */
class Operators {
	
	@Test def void testOperators() {
		assertEquals( 23.cm , 10.mm + 22.cm )
		assertEquals( 3.km , 1.km * 3 )
		assertEquals( 1_019_99_7.mm, 1.km + 20.m - 3.mm )
		
		val speed = 42.km / 1.h
		assertEquals( 21.km, speed * 30.min)
	}
	
	@Test def void testOperators2() {
		assertEquals( 23.cm , 10.mm + 22.cm )
		assertEquals( 3.km , 1.km * 3 )
		assertEquals( 1_019_99_7.mm, 1.km + 20.m - 3.mm )
	}
}

@Data class Distance {
	double mm
	
	def operator_plus(Distance other) {
		new Distance(this.mm + other.mm)
	}
	
	def operator_minus(Distance other) {
		new Distance(this.mm - other.mm)
	}

	def operator_multiply(int times) {
		new Distance(this.mm * times)
	}
	
	def operator_divide(int times) {
		new Distance(this.mm / times)
	}
	
	def static mm(int millimeters) {
		new Distance(millimeters)
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

@Data class Speed {
	double mm_msec
	
	def operator_plus(Speed other) {
		new Time(this.mm_msec + other.mm_msec)
	}
	
	def operator_minus(Speed other) {
		new Time(this.mm_msec - other.mm_msec)
	}

	def operator_multiply(int times) {
		new Speed(this.mm_msec * times)
	}
	
	def operator_multiply(Time time) {
		new Distance(this.mm_msec * time.ms)
	}
	
	def operator_divide(int times) {
		new Time(this.mm_msec / times)
	}
	
	def static operator_divide(Distance distance, Time time) {
		new Speed(distance.mm / time.ms)
	}
}

@Data class Time {
	double ms
	
	def operator_plus(Time other) {
		new Time(this.ms + other.ms)
	}
	
	def operator_minus(Time other) {
		new Time(this.ms - other.ms)
	}

	def operator_multiply(int times) {
		new Time(this.ms * times)
	}
	
	def operator_divide(int times) {
		new Time(this.ms / times)
	}
	
	def static msec(int milliSeconds) {
		new Time(milliSeconds)
	}
	
	def static sec(int seconds) {
		msec(seconds * 1000)
	}
	
	def static min(int minutes) {
		sec(minutes * 60)
	}
	
	def static h(int hours) {
		min(hours * 60)
	}
	
}