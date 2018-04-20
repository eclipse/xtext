/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests;

import static org.junit.Assert.*;

import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;
import org.eclipse.xtext.util.JavaVersion;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class JavaVersionExtendedTest {

	@Test
	public void testToJdtClassFileConstant() {
		assertEquals(ClassFileConstants.JDK1_5, JavaVersion.JAVA5.toJdtClassFileConstant());
		assertEquals(ClassFileConstants.JDK1_6, JavaVersion.JAVA6.toJdtClassFileConstant());
		assertEquals(ClassFileConstants.JDK1_7, JavaVersion.JAVA7.toJdtClassFileConstant());
		try {
			long value = ClassFileConstants.class.getField("JDK1_8").getLong(null);
			assertEquals(value, JavaVersion.JAVA8.toJdtClassFileConstant());
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
			// ok
		}
		try {
			long value = ClassFileConstants.class.getField("JDK9").getLong(null);
			assertEquals(value, JavaVersion.JAVA9.toJdtClassFileConstant());
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
			// ok
		}
		try {
			long value = ClassFileConstants.class.getField("JDK10").getLong(null);
			assertEquals(value, JavaVersion.JAVA10.toJdtClassFileConstant());
		} catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | SecurityException e) {
			// ok
		}
	}

}
