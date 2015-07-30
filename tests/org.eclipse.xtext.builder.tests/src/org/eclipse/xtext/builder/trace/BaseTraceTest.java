/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.generator.trace.TraceRegion;
import org.eclipse.xtext.generator.trace.internal.AbstractTrace;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BaseTraceTest {

	private AbstractTrace testMe;

	@Before
	public void setUp() {
		testMe = new AbstractTrace() {
			
			@Override
			protected TraceRegion doGetRootTraceRegion() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			/* @NonNull */
			public IProjectConfig getLocalProjectConfig() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			/* @NonNull */
			public AbsoluteURI getLocalURI() {
				throw new UnsupportedOperationException();
			}

			@Override
			/* @NonNull */
			protected InputStream getContents(/* @NonNull */ SourceRelativeURI uri, /* @NonNull */ IProjectConfig project) throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			protected Reader getContentsAsText(SourceRelativeURI uri, IProjectConfig project) throws IOException {
				throw new UnsupportedOperationException();
			}

			@Override
			protected Reader getLocalContentsAsText(IProjectConfig projectConfig) throws IOException {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEncloses_NegativeOffset() {
		testMe.encloses(0, 0, -1, false);
	}
	
	@Test
	public void testEnclosesNot_Before() {
		Assert.assertFalse(testMe.encloses(10, 1, 9, false));
		Assert.assertFalse(testMe.encloses(10, 1, 9, true));
	}
	
	@Test
	public void testEnclosesNot_After() {
		Assert.assertFalse(testMe.encloses(10, 1, 12, false));
		Assert.assertFalse(testMe.encloses(10, 1, 12, true));
	}
	
	@Test
	public void testEnclosesLeft_SameOffset_ZeroLength() {
		Assert.assertTrue(testMe.encloses(10, 0, 10, false));
	}
	
	@Test
	public void testEnclosesLeft_SameOffset() {
		Assert.assertTrue(testMe.encloses(10, 1, 10, false));
	}
	
	@Test
	public void testEnclosesLeft_AtEnd() {
		Assert.assertFalse(testMe.encloses(10, 1, 11, false));
	}
	
	@Test
	public void testEnclosesRight_SameOffset_ZeroLength() {
		Assert.assertTrue(testMe.encloses(10, 0, 10, true));
	}
	
	@Test
	public void testEnclosesRight_SameOffset() {
		Assert.assertTrue(testMe.encloses(10, 1, 10, true));
	}
	
	@Test
	public void testEnclosesRight_AtEnd() {
		Assert.assertTrue(testMe.encloses(10, 1, 11, true));
	}
}
