/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class JavaVersionTest {
	
	@Test
	public void testFromQualifier() {
		assertEquals(JavaVersion.JAVA10, JavaVersion.fromQualifier("10"));
		assertEquals(JavaVersion.JAVA10, JavaVersion.fromQualifier("1.10"));
		assertEquals(JavaVersion.JAVA9, JavaVersion.fromQualifier("9"));
		assertEquals(JavaVersion.JAVA9, JavaVersion.fromQualifier("1.9"));
		assertEquals(JavaVersion.JAVA8, JavaVersion.fromQualifier("8"));
		assertEquals(JavaVersion.JAVA8, JavaVersion.fromQualifier("1.8"));
		assertEquals(JavaVersion.JAVA7, JavaVersion.fromQualifier("7"));
		assertEquals(JavaVersion.JAVA7, JavaVersion.fromQualifier("1.7"));
		assertEquals(JavaVersion.JAVA6, JavaVersion.fromQualifier("6"));
		assertEquals(JavaVersion.JAVA6, JavaVersion.fromQualifier("1.6"));
		assertEquals(JavaVersion.JAVA5, JavaVersion.fromQualifier("1.5"));
		assertNull(JavaVersion.fromQualifier("1.4"));
		assertNull(JavaVersion.fromQualifier("5"));
	}

}
