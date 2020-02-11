/*******************************************************************************
 * Copyright (c) 2019 Sigasi N.V. (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Iterator;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.junit.Assert;
import org.junit.Test;

public class DiagnosticTreeIterableTest {

	@Test
	public void testIteratorIsNotConsumed() {
		BasicDiagnostic root = new BasicDiagnostic();
		root.add(new BasicDiagnostic());
		AssertableDiagnostics diagnostics = new AssertableDiagnostics(root);
		Iterable<Diagnostic> allDiagnostics = diagnostics.getAllDiagnostics();
		Iterator<Diagnostic> first = allDiagnostics.iterator();
		while (first.hasNext()) {
			first.next();
		}

		Assert.assertTrue(allDiagnostics.iterator().hasNext());
	}
}
