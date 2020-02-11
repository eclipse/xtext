/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.outline;

import org.eclipse.xtext.ui.editor.outline.actions.OutlineWithEditorLinker;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class CustomOutlineWithEditorLinker extends OutlineWithEditorLinker {

	public static volatile boolean DEACTIVATE_CALLED_WITH_NULL_TEXT_LISTENER = false;

	@Override
	public void deactivate() {
		DEACTIVATE_CALLED_WITH_NULL_TEXT_LISTENER |= (textListener == null);
		super.deactivate();
	}
}
