/*******************************************************************************
 * Copyright (c) 2018 TypeFox (https://typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.trace.node

import java.util.concurrent.TimeUnit
import org.eclipse.xtext.generator.trace.LocationData
import org.eclipse.xtext.generator.trace.SourceRelativeURI
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.rules.Timeout

/**
 * @author Dennis Huebner - Initial contribution and API
 */
class GeneratorNodePerformanceTest {

	extension GeneratorNodeExtensions exts = new GeneratorNodeExtensions()

//	static val numberOfLines = 800_000 // Before x sec - after 4.6 sec
//	static val numberOfLines = 80_000 // Before 89 sec - after 0.43 sec
	static val numberOfLines = 40_000 // Before 20 sec - after 0.32 sec
//	static val numberOfLines = 20_000 // Before 5 sec - after 0.25 sec
//	static val numberOfLines = 10_000 // Before 1.8 sec - after 0.25 sec
	@Rule
	public val Timeout timeout = new Timeout(1000, TimeUnit.MILLISECONDS)

	@Test def void testBasicCreationAndProcessingPerformance() {
		val root = loc(0)
		var node = root.trace.append('notindented').appendNewLine
		for (i : 0 ..< numberOfLines) {
			node.indent.trace(loc(1)).append('indented1').appendNewLine.indent.append('indented2').appendNewLine
		}
		node.appendNewLine.append('dedented')
		val processor = new GeneratorNodeProcessor
		Assert.assertFalse(processor.process(node)?.toString.nullOrEmpty)
	}

	private def loc(int idx) {
		new LocationData(idx, 100 - idx, 0, 0, new SourceRelativeURI('foo/mymodel.dsl'))
	}
}
