/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.common.editor.bracketmatching

import org.eclipse.xtext.ide.editor.bracketmatching.BracePair
import org.eclipse.xtext.ide.editor.bracketmatching.DefaultBracePairProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendBracePairProvider extends DefaultBracePairProvider {
	new() {
		super(#{
			new BracePair("(", ")", false),
			new BracePair("{", "}", true),
			new BracePair("[", "]", true),
			new BracePair("«", "»", false)
		})
	}
}