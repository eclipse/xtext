/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.quickfix;

import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider.CrossRefResolutionConverter;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.4
 */
public class XbaseCrossRefResolutionConverter extends CrossRefResolutionConverter {
	@Override
	public String convertToString(String replacement, String ruleName) {
		if (ruleName.equals("ID") || ruleName.equals("IdOrSuper") || ruleName.equals("FeatureCallID"))
			return super.convertToString(replacement, ruleName);
		return replacement;
	}
}
