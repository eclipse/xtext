/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.util;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.util.LineDelimiters;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author dhuebner - Initial contribution and API
 */
public class PluginProjectFactoryTest {
	@Test
	public void testAddToBuildProperties() {
		TestablePluginProjectFactory factory = new TestablePluginProjectFactory();
		StringBuilder content = new StringBuilder();
		factory.addToBuildProperties(content, null, "key");
		Assert.assertEquals("", content.toString());
		content = new StringBuilder();
		factory.addToBuildProperties(content, Lists.newArrayList(), "key");
		Assert.assertEquals("", content.toString());
		content = new StringBuilder();
		factory.addToBuildProperties(content, Lists.newArrayList("entry1"), "key");
		Assert.assertEquals("key = entry1", content.toString());
		content = new StringBuilder();
		factory.addToBuildProperties(content, Lists.newArrayList("entry1", "entry2", "entry3"), "key");
		StringConcatenation builder = new StringConcatenation();
		// @formatter:off
		builder.append("key = entry1,\\"); builder.newLine();
		builder.append("      entry2,\\"); builder.newLine();
		builder.append("      entry3");
		// @formatter:on
		Assert.assertEquals(builder.toString(), LineDelimiters.toPlatform(content.toString()));
	}
}
