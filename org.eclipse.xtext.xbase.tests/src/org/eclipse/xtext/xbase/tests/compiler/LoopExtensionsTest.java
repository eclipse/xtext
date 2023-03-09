/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.compiler;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.xbase.compiler.LoopExtensions;
import org.eclipse.xtext.xbase.compiler.LoopParams;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class LoopExtensionsTest extends AbstractXbaseTestCase {
	@Inject
	private LoopExtensions loopExtensions;

	@Test
	public void testForEach_all() {
		List<String> all = Lists.newArrayList("jan", "hein", "class", "pit");
		assertForEach(all, p -> {
		}, "janheinclasspit");
		assertForEach(all, p -> {
			p.setPrefix("_");
		}, "_janheinclasspit");
		assertForEach(all, p -> {
			p.setPrefix("_");
			p.setSeparator(" ");
		}, "_jan hein class pit");
		assertForEach(all, p -> {
			p.setPrefix("_");
			p.setSuffix("*");
		}, "_janheinclasspit*");
		assertForEach(all, p -> {
			p.setPrefix("_");
			p.setSeparator(" ");
			p.setSuffix("*");
		}, "_jan hein class pit*");
		assertForEach(all, p -> {
			p.setSeparator(" ");
		}, "jan hein class pit");
		assertForEach(all, p -> {
			p.setSeparator(" ");
			p.setSuffix("*");
		}, "jan hein class pit*");
		assertForEach(all, p -> {
			p.setSuffix("*");
		}, "janheinclasspit*");
	}

	@Test
	public void testForEach_single() {
		List<String> single = Lists.newArrayList("foo");
		assertForEach(single, p -> {
		}, "foo");
		assertForEach(single, p -> {
			p.setPrefix("_");
		}, "_foo");
		assertForEach(single, p -> {
			p.setPrefix("_");
			p.setSeparator(" ");
		}, "_foo");
		assertForEach(single, p -> {
			p.setPrefix("_");
			p.setSuffix("*");
		}, "_foo*");
		assertForEach(single, p -> {
			p.setPrefix("_");
			p.setSeparator(" ");
			p.setSuffix("*");
		}, "_foo*");
		assertForEach(single, p -> {
			p.setSeparator(" ");
		}, "foo");
		assertForEach(single, p -> {
			p.setSeparator(" ");
			p.setSuffix("*");
		}, "foo*");
		assertForEach(single, p -> {
			p.setSuffix("*");
		}, "foo*");
	}

	@Test
	public void testForEach_empty() {
		List<String> empty = Collections.emptyList();
		assertForEach(empty, p -> {
		}, "");
		assertForEach(empty, p -> {
			p.setPrefix("_");
		}, "");
		assertForEach(empty, p -> {
			p.setPrefix("_");
			p.setSeparator(" ");
		}, "");
		assertForEach(empty, p -> {
			p.setPrefix("_");
			p.setSuffix("*");
		}, "");
		assertForEach(empty, p -> {
			p.setPrefix("_");
			p.setSeparator(" ");
			p.setSuffix("*");
		}, "");
		assertForEach(empty, p -> {
			p.setSeparator(" ");
		}, "");
		assertForEach(empty, p -> {
			p.setSeparator(" ");
			p.setSuffix("*");
		}, "");
		assertForEach(empty, p -> {
			p.setSuffix("*");
		}, "");
	}

	public void testForEachWithSkip() {
		List<String> all = Lists.newArrayList("jan", "hein", "class", "pit");
		assertForEachWithSkip(all, (String it) -> "jan".equals(it), "{hein, class, pit}");
		assertForEachWithSkip(all, (String it) -> "hein".equals(it), "{jan, class, pit}");
		assertForEachWithSkip(all, (String it) -> "pit".equals(it), "{jan, hein, class}");
		assertForEachWithSkip(all, (String it) -> true, "{}");
	}

	@Test
	public void testForEachWithShortcut() {
		assertForEachWithShortcut(Lists.newArrayList("jan", "hein", "class", "pit"), "{ jan, hein, class, pit }");
		assertForEachWithShortcut(Lists.newArrayList("foo"), "foo");
		assertForEachWithShortcut(Lists.newArrayList(), "{}");
	}

	protected void assertForEach(Iterable<String> elements, Procedure1<? super LoopParams> params, String expectedResult) {
		FakeTreeAppendable app = new FakeTreeAppendable();
		loopExtensions.forEach(app, elements, params, (String it) -> app.append(it));
		Assert.assertEquals(expectedResult, app.toString());
	}

	protected void assertForEachWithSkip(Iterable<String> elements, Function1<? super String, ? extends Boolean> append,
			String expectedResult) {
		FakeTreeAppendable app = new FakeTreeAppendable();
		loopExtensions.forEach(app, elements, p -> {
			p.setPrefix("{");
			p.setSeparator(", ");
			p.setSuffix("}");
		}, (String it) -> {
			if (!append.apply(it)) {
				app.append(it);
			}
		});
		Assert.assertEquals(expectedResult, app.toString());
	}

	protected void assertForEachWithShortcut(Iterable<String> elements, String expectedResult) {
		FakeTreeAppendable app = new FakeTreeAppendable();
		loopExtensions.forEachWithShortcut(app, elements, (String it) -> app.append(it));
		Assert.assertEquals(expectedResult, app.toString());
	}
}
