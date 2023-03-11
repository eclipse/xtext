/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.serializer;

import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.testing.serializer.SerializerTestHelper;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtendSerializerWithNodeModelTest extends AbstractXtendTestData {

	@Inject
	private SerializerTestHelper tester;

	@Override
	protected void doTest(String fileContents) throws Exception {
		XtendFile file = file(fileContents, true);
		tester.assertSerializeWithNodeModel(file);
	}

}
