/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
public class XtextVersionTests {
	private static Pattern VERSION_MATCHER = Pattern.compile("\\d\\.\\d+\\.\\d+(?:-SNAPSHOT)?");

	@Test
	public void testVersionKinds() {

		XtextVersion version = new XtextVersion("2.9.0-SNAPSHOT");
		//snapshot
		assertTrue(version.isSnapshot());
		assertFalse(version.isStable());

		// stable version pre-release
		version = new XtextVersion("2.9.0.beta1");
		assertFalse(version.isSnapshot());
		assertTrue(version.isStable());
		
		version = new XtextVersion("2.9.0.rc1");
		assertFalse(version.isSnapshot());
		assertTrue(version.isStable());
		
		version = new XtextVersion("2.9.0.maybeSomthingElse");
		assertFalse(version.isSnapshot());
		assertTrue(version.isStable());
		
		// releases
		version = new XtextVersion("2.9.0");
		assertFalse(version.isSnapshot());
		assertFalse(version.isStable());
		
		version = new XtextVersion("2.9.0.1");
		assertFalse(version.isSnapshot());
		assertFalse(version.isStable());
		
	}
	
	@Test
	public void test_getCurrent() {
		// just to show what the pattern matches
		assertTrue(VERSION_MATCHER.matcher("2.20.0").matches());
		assertTrue(VERSION_MATCHER.matcher("2.20.0-SNAPSHOT").matches());
		
		assertFalse(VERSION_MATCHER.matcher("2.20.0.qualifier").matches());
		assertFalse(VERSION_MATCHER.matcher("2.20.0.vSomething").matches());
		assertFalse(VERSION_MATCHER.matcher("2.20").matches());
		
		XtextVersion xtextVersion = XtextVersion.getCurrent();
		assertNotNull(xtextVersion);
		String version = xtextVersion.getVersion();
		assertNotNull(version);
		if (!"unknown".equals(version)) {
			assertTrue(VERSION_MATCHER.matcher(version).matches());
		}
	}
}
