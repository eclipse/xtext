/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.jface.text.TextAttribute;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(TextAttributeProvider.class)
public interface ITextAttributeProvider {

	TextAttribute getAttribute(String id);

	TextAttribute getMergedAttributes(String[] ids);
	
}
