/*******************************************************************************
 * Copyright (c) 2024 Lorenzo Bettini and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.conversion;

import org.eclipse.xtext.conversion.impl.STRINGValueConverter;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

/**
 * Avoid Windows EOL characters from the original parsed text: this would result
 * in different generated Java files in Windows see
 * https://github.com/eclipse/xtext/issues/2293 This is aligned with Java text
 * blocks' "Normalization of Line Terminators"
 * 
 * @author Lorenzo Bettini - Initial contribution and API
 * @since 2.35
 */
public class XbaseStringValueConverter extends STRINGValueConverter {
	@Override
	public String toValue(String string, INode node) {
		return super.toValue(Strings.toUnixLineSeparator(string), node);
	}
}
