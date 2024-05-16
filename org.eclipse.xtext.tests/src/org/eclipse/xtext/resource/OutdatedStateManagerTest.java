/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import java.io.IOException;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class OutdatedStateManagerTest extends AbstractXtextTests {

	@Inject
	private OutdatedStateManager outdatedStateManager;
	private XtextResource resource;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		injectMembers(this);
		resource = getResourceFromString("");
	}

	@Test(expected = OperationCanceledException.class)
	public void testCancellation() {
		outdatedStateManager.exec((r) -> {
			throw new OperationCanceledException();
		}, resource);
	}

	@Test(expected = OperationCanceledError.class)
	public void testCancellation2() {
		outdatedStateManager.exec((r) -> {
			throw new OperationCanceledError(null);
		}, resource);
	}

	@Test(expected = NullPointerException.class)
	public void testNPE() {
		outdatedStateManager.exec((r) -> {
			throw new NullPointerException();
		}, resource);
	}

	@Test
	public void testChecked() {
		try {
			outdatedStateManager.exec((r) -> {
				throw new IOException();
			}, resource);
			fail("Exception Expected");
		} catch (WrappedException e) {
			Throwable cause = e.getCause();
			assertTrue("wrong cause", cause instanceof IOException);
		}
	}
}
