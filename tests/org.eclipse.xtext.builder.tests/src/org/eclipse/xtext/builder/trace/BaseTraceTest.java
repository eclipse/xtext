/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.TraceRegion;
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
			public IProject getLocalProject() {
				throw new UnsupportedOperationException();
			}
			
			@Override
			/* @NonNull */
			public URI getLocalURI() {
				throw new UnsupportedOperationException();
			}

			@Override
			/* @NonNull */
			protected IStorage findStorage(/* @NonNull */ URI uri, /* @NonNull */ IProject project) {
				throw new UnsupportedOperationException();
			}

			@Override
			/* @NonNull */
			protected InputStream getContents(/* @NonNull */ URI uri, /* @NonNull */ IProject project) throws CoreException {
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
