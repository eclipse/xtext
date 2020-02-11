/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model.edit;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.text.edits.TextEdit;

import com.google.inject.ImplementedBy;

/**
 * @author Knut Wannheden - Initial contribution and API
 */
@ImplementedBy(DefaultTextEditComposer.class)
public interface ITextEditComposer {

	void beginRecording(Resource resource);

	TextEdit endRecording();

	TextEdit getTextEdit();

}
