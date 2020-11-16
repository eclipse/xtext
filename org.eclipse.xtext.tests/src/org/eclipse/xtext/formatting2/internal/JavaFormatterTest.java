/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.internal;

import org.eclipse.xtext.formatting2.internal.tests.FormatterTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Arne Deutsch - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(FormatterTestLanguageInjectorProvider.class)
public class JavaFormatterTest {

	@Inject
	private JavaFormatterTestHelper helper;

	@Test
	public void javaFormatterWorks() {
		helper.assertFormatted(" idlist  a  b   c", "idlist a b c");
	}

}
