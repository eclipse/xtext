/**
 * Copyright (c) 2018, 2020 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.generator.trace.node;

import java.util.concurrent.TimeUnit;

import org.eclipse.xtext.generator.trace.LocationData;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.google.common.base.Strings;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class GeneratorNodePerformanceTest {
	private GeneratorNodeExtensions exts = new GeneratorNodeExtensions();

//	private static final int numberOfLines = 800_000 // Before x sec - after 4.6 sec
//	private static final int numberOfLines = 80_000 // Before 89 sec - after 0.43 sec
	private static final int numberOfLines = 40_000; // Before 20 sec - after 0.32 sec
//	private static final int numberOfLines = 20_000 // Before 5 sec - after 0.25 sec
//	private static final int numberOfLines = 10_000 // Before 1.8 sec - after 0.25 sec

	@Rule
	public final Timeout timeout = new Timeout(1000, TimeUnit.MILLISECONDS);

	@Test
	public void testBasicCreationAndProcessingPerformance() {
		LocationData root = loc(0);
		CompositeGeneratorNode node = exts.appendNewLine(exts.append(exts.trace(root), "notindented"));
		for (int i = 0; i < GeneratorNodePerformanceTest.numberOfLines; i++) {
			exts.appendNewLine(exts.append(
					exts.indent(exts.appendNewLine(exts.append(exts.trace(exts.indent(node), loc(1)), "indented1"))),
					"indented2"));
		}
		exts.append(exts.appendNewLine(node), "dedented");
		GeneratorNodeProcessor processor = new GeneratorNodeProcessor();
		GeneratorNodeProcessor.Result result = processor.process(node);
		String resultAsString = null;
		if (result != null) {
			resultAsString = result.toString();
		}
		Assert.assertFalse(Strings.isNullOrEmpty(resultAsString));
	}

	private LocationData loc(int idx) {
		return new LocationData(idx, 100 - idx, 0, 0, new SourceRelativeURI("foo/mymodel.dsl"));
	}
}
