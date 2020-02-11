/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model.edit;

import org.eclipse.xtext.ui.editor.model.edit.ChangeSerializerTextEditComposer;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ChangeSerializerComposerTest extends AbstractTextEditComposerTest {

	@Override
	protected ITextEditComposer createComposer() {
		return get(ChangeSerializerTextEditComposer.class);
	}

	@Override
	@Test
	@Ignore
	public void testRemoveRootObject() throws Exception {
		super.testRemoveRootObject();
	}

	@Override
	@Test
	@Ignore
	public void testReplaceRootObject() throws Exception {
		super.testReplaceRootObject();
	}

	@Override
	@Ignore
	@Test
	public void testObjectReplacement() throws Exception {
		// doesn't work because of xtext.xtext still uses old formatter.
		super.testObjectReplacement();
	}

}
