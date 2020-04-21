/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import org.eclipse.xtext.ide.editor.model.TokenTypeToStringMapper;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.9
 */
public abstract class AbstractAntlrTokenToAttributeIdMapper extends TokenTypeToStringMapper {
	public String getId(int tokenType) {
		return getMappedValue(tokenType);
	}
}
