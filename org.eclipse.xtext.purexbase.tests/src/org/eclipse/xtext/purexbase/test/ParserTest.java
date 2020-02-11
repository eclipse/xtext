/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.purexbase.tests.PureXbaseInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(PureXbaseInjectorProvider.class)
public class ParserTest {
	
	@Inject
	private ParseHelper<Model> parseHelper;
	
	@Test
	public void testParser() throws Exception {
		XBlockExpression expression = parseHelper.parse(
				"val x = 'hello' " +
				"val y = 'world!' " +
				"println(x+' '+y)").getBlock();
		assertEquals(3, expression.getExpressions().size());
	}

}
