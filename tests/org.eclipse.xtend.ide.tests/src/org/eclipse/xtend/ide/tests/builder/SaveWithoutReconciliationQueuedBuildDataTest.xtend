/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
