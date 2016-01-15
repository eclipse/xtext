/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.xtext.lib.tests;

import org.eclipse.xpect.xtext.lib.setup.ThisResource;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.eclipse.xpect.xtext.lib.setup.XtextWorkspaceSetup;
import org.eclipse.xpect.xtext.lib.util.InMemoryFileSystemAccessFormatter;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.InMemoryFileSystemAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.runner.RunWith;
import org.xpect.XpectImport;
import org.xpect.expectation.IStringExpectation;
import org.xpect.expectation.StringExpectation;
import org.xpect.parameter.ParameterParser;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XpectRunner.class)
@XpectImport({ XtextStandaloneSetup.class, XtextWorkspaceSetup.class })
public class GeneratorTest {

	@Inject
	private IGenerator generator;

	protected InMemoryFileSystemAccessFormatter createInMemoryFileSystemAccessFormatter() {
		return new InMemoryFileSystemAccessFormatter();
	}

	public IGenerator getGenerator() {
		return generator;
	}

	@Xpect
	@ParameterParser(syntax = "('file' arg2=TEXT)?")
	public void generated(@StringExpectation IStringExpectation expectation, @ThisResource XtextResource resource, String arg2) {
		InMemoryFileSystemAccess fsa = new InMemoryFileSystemAccess();
		generator.doGenerate(resource, fsa);
		String files = createInMemoryFileSystemAccessFormatter().includeOnlyFileNamesEndingWith(arg2).apply(fsa);
		expectation.assertEquals(files);
	}
}
