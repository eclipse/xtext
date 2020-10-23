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
import java.io.FileWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.ide.server.IMultiRootWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.MultiProjectWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ServerModule;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.Files;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class MultiProjectTest {
	private File project0;

	private File project1;

	private Map<URI, List<Issue>> diagnostics = new HashMap<>();

	@Inject
	private WorkspaceManager workspaceManager;

	@Test
	public void testCrossProjectLink() throws Exception {
		URI foo = createFile(project0, "Foo.testlang", "type Foo { Bar bar }");
		URI bar = createFile(project1, "Bar.testlang", "type Bar {}");
		workspaceManager.doBuild(Lists.newArrayList(foo, bar), Collections.emptyList(), CancelIndicator.NullImpl);
		Assert.assertEquals(2, diagnostics.size());
		Assert.assertEquals(1, diagnostics.get(foo).size());
		Assert.assertEquals(Diagnostic.LINKING_DIAGNOSTIC, Iterables.getFirst(diagnostics.get(foo), null).getCode());
		Assert.assertTrue(diagnostics.get(bar).isEmpty());
		diagnostics.clear();
		workspaceManager.getProjectManager(project0.getName()).getProjectDescription().getDependencies()
				.add(project1.getName());
		workspaceManager.doBuild(Lists.newArrayList(foo, bar), Collections.emptyList(), CancelIndicator.NullImpl);
		Assert.assertEquals(2, diagnostics.size());
		Assert.assertTrue(diagnostics.get(foo).isEmpty());
		Assert.assertTrue(diagnostics.get(bar).isEmpty());
	}

	@Before
	public void setup() throws Exception {
		Injector injector = Guice.createInjector(Modules2.mixin(new ServerModule(), new AbstractModule() {
			@Override
			protected void configure() {
				bind(IMultiRootWorkspaceConfigFactory.class).to(MultiProjectWorkspaceConfigFactory.class);
			}
		}));
		injector.injectMembers(this);
		File workspaceRoot = getRoot("test-data");
		project0 = new File(workspaceRoot, "test-project0");
		project1 = new File(workspaceRoot, "test-project1");
		project0.mkdir();
		project1.mkdir();
		workspaceManager.initialize(URI.createFileURI(workspaceRoot.getAbsolutePath()),
				(URI $0, Iterable<Issue> $1) -> diagnostics.put($0, IterableExtensions.toList($1)), null);
	}

	protected File getRoot(String path) throws Exception {
		File root = new File(path);
		if (!root.mkdirs()) {
			Files.cleanFolder(root, null, true, false);
		}
		root.deleteOnExit();
		return root;
	}

	public URI createFile(File root, String path, CharSequence contents) throws Exception {
		File file = new File(root, path);
		file.getParentFile().mkdirs();
		file.createNewFile();
		try (FileWriter fileWriter = new FileWriter(file)) {
			fileWriter.write(contents.toString());
		}
		return URI.createFileURI(file.getAbsolutePath());
	}
}
