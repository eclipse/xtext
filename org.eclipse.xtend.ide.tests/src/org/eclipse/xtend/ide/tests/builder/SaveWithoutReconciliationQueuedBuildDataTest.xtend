/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder

import org.eclipse.ui.texteditor.ITextEditor

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class SaveWithoutReconciliationQueuedBuildDataTest extends AbstractSingleEditorQueuedBuildTest {

	override doSave(ITextEditor editor, (ITextEditor)=>ITextEditor consumer) {
		editor.save(consumer)
	}

	override doClose(ITextEditor editor, (ITextEditor)=>ITextEditor consumer) {
		editor.close(consumer)
	}

}
