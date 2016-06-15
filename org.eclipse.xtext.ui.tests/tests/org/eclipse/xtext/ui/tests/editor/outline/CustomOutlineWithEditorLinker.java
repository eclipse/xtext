/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
