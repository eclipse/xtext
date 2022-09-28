/**
 * Copyright (c) 2022 Ruben Porras-Campo (Ruben.PorrasCampo@avaloq.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.List;

import org.eclipse.lsp4j.Diagnostic;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

public class UriExtensionsIntegrationTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testDiagnosticDoesNotCrashWithaHashinFileName() {
		String model = 
				"type lowercase\n" +
				"{\n" +
				"}\n";
		// The # as part of the name is the important part of the test
		writeFile("MyType#1.testlang", model); 
		initialize();
		List<Diagnostic> problems = problems();
		Assert.assertEquals(1, problems.size());
	}

	private List<Diagnostic> problems() {
		return Iterables.getFirst(getDiagnostics().entrySet(), null).getValue();
	}
}
