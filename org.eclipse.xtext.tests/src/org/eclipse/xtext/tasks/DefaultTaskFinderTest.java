/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.tasks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.xtext.documentation.impl.AbstractMultiLineCommentProvider;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.noJdt.NoJdtTestLanguageStandaloneSetup;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.name.Names;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class DefaultTaskFinderTest extends AbstractXtextTests {
	public static class NoJdtTestLanguageStandaloneSetupCustom extends NoJdtTestLanguageStandaloneSetup {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new NoJdtTestLanguageRuntimeModule() {
				@SuppressWarnings("unused")
				public void configureEndTag(Binder binder) {
					binder.bind(String.class).annotatedWith(Names.named(AbstractMultiLineCommentProvider.END_TAG))
							.toInstance("\\*\\*\\*/");
				}
			});
		}
	}

	private ITaskFinder finder;

	@Before
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(NoJdtTestLanguageStandaloneSetup.class);
		finder = get(DefaultTaskFinder.class);
	}

	@Test
	public void testNonXtextResource() {
		assertContainsTasks(new ResourceImpl(), new ArrayList<>());
	}

	@Test
	public void test() throws Exception {
		Task task1 = new Task();
		task1.setTag(new TaskTag("TODO", Priority.NORMAL));
		task1.setDescription(" foo");
		task1.setOffset(2);
		task1.setLineNumber(1);
		Task task2 = new Task();
		task2.setTag(new TaskTag("FIXME", Priority.HIGH));
		task2.setDescription(" bar");
		task2.setOffset(17);
		task2.setLineNumber(3);
		Task task3 = new Task();
		task3.setTag(new TaskTag("TODO", Priority.NORMAL));
		task3.setDescription(" Get rid of this ");
		task3.setOffset(73);
		task3.setLineNumber(7);
		assertContainsTasks(getResourceFromString(
				"//TODO foo\n" +
				"/*\n" +
				" * FIXME bar\n" +
				" * Fixme no match\n" +
				" * FOO also no match\n" +
				" */\n" +
				"/* TODO Get rid of this */\n" +
				"Hello notATODO!\n"),
				Lists.newArrayList(task1, task2, task3));
	}

	@Test
	public void testSpecialEndTag() throws Exception {
		with(NoJdtTestLanguageStandaloneSetupCustom.class);
		finder = get(DefaultTaskFinder.class);
		Task task = new Task();
		task.setTag(new TaskTag("TODO", Priority.NORMAL));
		task.setDescription(" Get rid of this ");
		task.setOffset(3);
		task.setLineNumber(1);
		assertContainsTasks(getResourceFromString(
				"/* TODO Get rid of this ***/\n" +
				"Hello notATODO!\n"),
				Lists.newArrayList(task));
	}

	private void assertContainsTasks(Resource resource, List<Task> expectedTasks) {
		List<Task> actualTasks = finder.findTasks(resource);
		Assert.assertEquals(expectedTasks.size(), actualTasks.size());
		for (int i = 0; i < expectedTasks.size(); i++) {
			Assert.assertEquals(expectedTasks.get(i), actualTasks.get(i));
		}
	}
}
