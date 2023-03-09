/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.imports;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.xbase.ui.imports.ImportsUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dhuebner - Initial contribution and API
 */
public class ImportsUtilTest {
	public static class ImportUtilExtension extends ImportsUtil {
		@Override
		protected Pair<String, String> splitInTypeAndMember(String featuresQName) {
			return super.splitInTypeAndMember(featuresQName);
		}
	}

	@Test
	public void testQnameSplitting() {
		ImportsUtilTest.ImportUtilExtension util = new ImportsUtilTest.ImportUtilExtension();
		Assert.assertEquals(Tuples.create("java.util.Collections", "*"), util.splitInTypeAndMember("java.util.Collections.*"));
		Assert.assertEquals(Tuples.create("java.util.Collections", "sort"), util.splitInTypeAndMember("java.util.Collections.sort"));
		Assert.assertEquals(Tuples.create("java.util.Collections", "sort"), util.splitInTypeAndMember("java.util.Collections.sort()"));
		Assert.assertEquals(Tuples.create("java.util.Collections", "sort"),
				util.splitInTypeAndMember("java.util.Collections.sort(Object)"));
		Assert.assertEquals(Tuples.create("java.util.Collections", ""), util.splitInTypeAndMember("java.util.Collections.("));
		Assert.assertEquals(Tuples.create("java.util.Collections", ""), util.splitInTypeAndMember("java.util.Collections."));
		Assert.assertEquals(Tuples.create("java.util", "Collections"), util.splitInTypeAndMember("java.util.Collections"));
	}
}
