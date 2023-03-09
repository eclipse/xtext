/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.model.edit;

import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
public class DefaultTextEditComposerTest extends AbstractTextEditComposerTest {

	@Override
	protected ITextEditComposer createComposer() {
		return get(ITextEditComposer.class);
	}

}
