/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.ide.server.TopologicalSorter;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class BuildOrderTest {
	@Test
	public void testChain() {
		ProjectDescription a = newProjectDescription("a", "b");
		ProjectDescription b = newProjectDescription("b", "c");
		ProjectDescription c = newProjectDescription("c", "d");
		ProjectDescription d = newProjectDescription("d");
		assertEquals(Lists.newArrayList(d, c, b, a),
				new TopologicalSorter().sortByDependencies(Lists.newArrayList(a, b, c, d), it -> Assert.fail()));
	}

	@Test
	public void testDiamond() {
		ProjectDescription a = newProjectDescription("a", "b", "c");
		ProjectDescription b = newProjectDescription("b", "c");
		ProjectDescription c = newProjectDescription("c", "d");
		ProjectDescription d = newProjectDescription("d");
		assertEquals(Lists.newArrayList(d, c, b, a),
				new TopologicalSorter().sortByDependencies(Lists.newArrayList(a, b, c, d), it -> Assert.fail()));
	}

	@Test
	public void testDiamond_1() {
		ProjectDescription a = newProjectDescription("a", "b", "c", "d");
		ProjectDescription b = newProjectDescription("b", "c");
		ProjectDescription c = newProjectDescription("c", "d");
		ProjectDescription d = newProjectDescription("d");
		assertEquals(Lists.newArrayList(d, c, b, a),
				new TopologicalSorter().sortByDependencies(Lists.newArrayList(a, b, c, d), it -> Assert.fail()));
	}

	@Test
	public void testJustOne() {
		ProjectDescription a = newProjectDescription("a", "b");
		ProjectDescription b = newProjectDescription("b");
		assertEquals(Lists.newArrayList(a),
				new TopologicalSorter().sortByDependencies(Lists.newArrayList(a), it -> Assert.fail()));
		assertEquals(Lists.newArrayList(b),
				new TopologicalSorter().sortByDependencies(Lists.newArrayList(b), it -> Assert.fail()));
	}

	@Test
	public void testCycle() {
		ProjectDescription a = newProjectDescription("a", "b", "c");
		ProjectDescription b = newProjectDescription("b", "c", "d");
		ProjectDescription c = newProjectDescription("c", "d");
		ProjectDescription d = newProjectDescription("d", "b");
		ProjectDescription e = newProjectDescription("e");
		ArrayList<ProjectDescription> cyclic = Lists.newArrayList();
		assertEquals(Lists.newArrayList(e),
				new TopologicalSorter().sortByDependencies(Lists.newArrayList(a, b, c, d, e), it -> cyclic.add(it)));
		assertEquals(Lists.newArrayList(b, d, c, a), cyclic);
	}

	private ProjectDescription newProjectDescription(String name, String... dependencies) {
		ProjectDescription result = new ProjectDescription();
		result.setName(name);
		result.setDependencies(Arrays.asList(dependencies));
		return result;
	}

	@Test
	public void testCycle1() {
		ProjectDescription a = newProjectDescription("a", "a");
		ArrayList<ProjectDescription> cyclic = Lists.newArrayList();
		assertEquals(Lists.newArrayList(),
				new TopologicalSorter().sortByDependencies(Lists.newArrayList(a), it -> cyclic.add(it)));
		assertEquals(Lists.newArrayList(a), cyclic);
	}

	public void assertEquals(List<ProjectDescription> expected, List<ProjectDescription> actual) {
		Assert.assertEquals("Expected: " + asString(expected) + " but was " + asString(actual), expected, actual);
	}

	public String asString(List<ProjectDescription> list) {
		return Joiner.on(", ").join(Lists.transform(list, ProjectDescription::getName));
	}
}
