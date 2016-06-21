/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.purexbase.test;

import static org.junit.Assert.assertEquals;

import org.eclipse.xtext.purexbase.PureXbaseInjectorProvider;
import org.eclipse.xtext.purexbase.pureXbase.Model;
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
