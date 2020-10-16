/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.parser.indentation;

import org.eclipse.xtext.parser.indentation.indentationAwareTestLanguage.Tree;
import org.eclipse.xtext.parser.indentation.tests.IndentationAwareTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndentationAwareTestLanguageInjectorProvider.class)
public class IndentationAwarePartialParsingErrorTest {
	@Inject
	private ParseHelper<Tree> parseHelper;

	@Test
	public void testResourceUpdate() throws Exception {
		String model = 
				"\n" +
				"a\n" +
				"	b // single tab\n" +
				"         // 8 spaces eq 1 tab\n" +
				"d\n";
		Tree tree = parseHelper.parse(model);
		XtextResource resource = (XtextResource) tree.eResource();
		int idx = model.indexOf(" // 8");
		resource.update(idx, 0, "c");
		Tree reparsed = (Tree) Iterables.getFirst(resource.getContents(), null);
		Assert.assertNotSame(tree, reparsed);
	}

	@Test
	public void testResourceUpdate_02() throws Exception {
		String model = 
				"\n" +
				"a\n"+"	x\n" +
				"		b // two tabs\n" +
				"	         // tab and 8 spaces (eq 2 tabs)\n" +
				"	y\n";
		Tree tree = parseHelper.parse(model);
		XtextResource resource = (XtextResource) tree.eResource();
		int idx = model.indexOf(" // tab");
		resource.update(idx, 0, "c");
		Tree tree2 = (Tree) Iterables.getFirst(resource.getContents(), null);
		Tree reparsed = tree2;
		Assert.assertNotSame(tree, reparsed);
	}
}
