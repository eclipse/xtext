/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test;

import java.io.File;

import org.eclipse.xtext.web.server.XtextServiceDispatcher;
import org.eclipse.xtext.web.server.persistence.ResourceContentResult;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.io.Files;

public class ResourcePersistenceTest extends AbstractWebServerTest {
	@Test
	public void testLoadFile() {
		String resourceContent = "state foo end";
		File file = createFile(resourceContent);
		XtextServiceDispatcher.ServiceDescriptor load = getService(
				nb().put("serviceType", "load").put("resource", file.getName()).build());
		Assert.assertFalse(load.isHasSideEffects());
		ResourceContentResult result = (ResourceContentResult) load.getService().apply();
		assertEquals(resourceContent, result.getFullText());
		Assert.assertFalse(result.isDirty());
	}

	@Test
	public void testLoadDummy() {
		HashMapSession session = new HashMapSession();
		String resourceContent = "state foo end";
		XtextServiceDispatcher.ServiceDescriptor update = getService(nb().put("serviceType", "update")
				.put("resource", "dummy.statemachine").put("fullText", resourceContent).build(), session);
		update.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor load = getService(
				nb().put("serviceType", "load").put("resource", "dummy.statemachine").build(), session);
		ResourceContentResult result = (ResourceContentResult) load.getService().apply();
		assertEquals(resourceContent, result.getFullText());
		update = getService(nb().put("serviceType", "update").put("resource", "dummy.statemachine")
				.put("deltaText", "bar").put("deltaOffset", "6").put("deltaReplaceLength", "3").build(), session);
		update.getService().apply();
		load = getService(nb().put("serviceType", "load").put("resource", "dummy.statemachine").build(), session);
		result = (ResourceContentResult) load.getService().apply();
		assertEquals("state bar end", result.getFullText());
	}

	@Test
	public void testRevertFile() {
		String resourceContent = "state foo end";
		File file = createFile(resourceContent);
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor load = getService(
				nb().put("serviceType", "load").put("resource", file.getName()).build(), session);
		load.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor update = getService(
				nb().put("serviceType", "update").put("resource", file.getName()).put("deltaText", "bar")
						.put("deltaOffset", "6").put("deltaReplaceLength", "3").build(),
				session);
		update.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor revert = getService(
				nb().put("serviceType", "revert").put("resource", file.getName()).build(), session);
		Assert.assertTrue(revert.isHasSideEffects());
		ResourceContentResult result = (ResourceContentResult) revert.getService().apply();
		assertEquals(resourceContent, result.getFullText());
	}

	@Test
	public void testSaveFile() throws Exception {
		File file = createFile("state foo end");
		HashMapSession session = new HashMapSession();
		XtextServiceDispatcher.ServiceDescriptor load = getService(
				nb().put("serviceType", "load").put("resource", file.getName()).build(), session);
		load.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor update = getService(
				nb().put("serviceType", "update").put("resource", file.getName()).put("deltaText", "bar")
						.put("deltaOffset", "6").put("deltaReplaceLength", "3").build(),
				session);
		update.getService().apply();
		XtextServiceDispatcher.ServiceDescriptor save = getService(
				nb().put("serviceType", "save").put("resource", file.getName()).build(), session);
		Assert.assertTrue(save.isHasSideEffects());
		save.getService().apply();
		String resourceContent = Files.asCharSource(file, Charsets.UTF_8).read();
		assertEquals("state bar end", resourceContent);
	}

	private Builder<String, String> nb() {
		return ImmutableMap.<String, String>builder();
	}
}
