/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author cdietrich - Initial contribution and API
 */
public class JavaRuntimeVersionTest {
	
	@Test
	public void testDetermineJavaVersion() {
		assertEquals(8, JavaRuntimeVersion.determineJavaVersion("1.8.0_302"));
		assertEquals(11, JavaRuntimeVersion.determineJavaVersion("11.0.12"));
		assertEquals(13, JavaRuntimeVersion.determineJavaVersion("13.0.2"));
		assertEquals(14, JavaRuntimeVersion.determineJavaVersion("14"));
		assertEquals(15, JavaRuntimeVersion.determineJavaVersion("15.0.2"));
		assertEquals(16, JavaRuntimeVersion.determineJavaVersion("16.0.2"));
		assertEquals(17, JavaRuntimeVersion.determineJavaVersion("17-beta"));
		assertEquals(17, JavaRuntimeVersion.determineJavaVersion("17-ea"));
	}

}
