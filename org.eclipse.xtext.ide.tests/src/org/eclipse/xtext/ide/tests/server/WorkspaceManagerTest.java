/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class WorkspaceManagerTest {
	@Test
	public void testDoRead() throws IOException {
		String model = 
				"type Test {\n" +
				"    string foo\n" +
				"}\n";
		URI path = operator_mappedTo("MyType1.testlang", model);
		workspaceManger.doBuild(Lists.newArrayList(path),
				Collections.emptyList(), null);
		String inMemContents =
				"type Test {\n" +
				"    Test foo\n" +
				"}\n";
		workspaceManger.didOpen(path, 1, inMemContents).build(null);
		Assert.assertEquals(inMemContents,
				workspaceManger.doRead(path, (Document $0, XtextResource $1) -> $0.getContents()));
	}

	@Inject
	protected WorkspaceManager workspaceManger;

	@Inject
	protected UriExtensions uriExtensions;

	@Before
	public void setup() throws FileNotFoundException {
		Injector injector = Guice.createInjector(new ServerModule());
		injector.injectMembers(this);
		root = new File("./test-data/test-project");
		if (!root.mkdirs()) {
			Files.cleanFolder(root, null, true, false);
		}
		root.deleteOnExit();
		workspaceManger.initialize(uriExtensions.withEmptyAuthority(URI.createFileURI(root.getAbsolutePath())),
				(URI $0, Iterable<Issue> $1) -> diagnostics.put($0, IterableExtensions.toList($1)), null);
	}

	@After
	public void cleanup() throws FileNotFoundException {
		if (root.exists()) {
			Files.cleanFolder(root, null, true, true);
		}
	}

	protected Map<URI, List<Issue>> diagnostics = new HashMap<>();

	protected File root;

	public URI operator_mappedTo(String path, CharSequence contents) throws IOException {
		File file = new File(root, path);
		file.getParentFile().mkdirs();
		file.createNewFile();
		try(FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.write(contents.toString());
		}
		return URI.createFileURI(file.getAbsolutePath());
	}
}
