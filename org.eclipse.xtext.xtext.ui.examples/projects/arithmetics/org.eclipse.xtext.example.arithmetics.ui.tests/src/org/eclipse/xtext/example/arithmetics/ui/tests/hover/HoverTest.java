/**
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.arithmetics.ui.tests.hover;

import org.eclipse.jface.text.Region;
import org.eclipse.xtext.example.arithmetics.ui.tests.ArithmeticsUiInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractHoverTest;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(ArithmeticsUiInjectorProvider.class)
public class HoverTest extends AbstractHoverTest {
	@Test
	public void hover_over_function_call() {
		String text =
				"module arithmetics\n" +
				"\n" +
				"/*\n" +
				" * A mathematical constant.\n" +
				" * It is approximately equal to 3.14.\n" +
				" */\n" +
				"def pi: 3.14\n" +
				"\n" +
				"pi * 4;\n";
		String hoverText = "pi";
		Region hoverRegion = new Region(text.lastIndexOf(hoverText), hoverText.length());
		String expectedHover =
				"A mathematical constant.\n" +
				"It is approximately equal to 3.14.";
		hasHoverOver(text, hoverRegion, expectedHover);
	}
}
