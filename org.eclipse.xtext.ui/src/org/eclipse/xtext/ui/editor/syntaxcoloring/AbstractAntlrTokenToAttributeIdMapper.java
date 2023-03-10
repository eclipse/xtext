/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import org.eclipse.xtext.ui.editor.model.TokenTypeToStringMapper;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(DefaultAntlrTokenToAttributeIdMapper.class)
public abstract class AbstractAntlrTokenToAttributeIdMapper extends TokenTypeToStringMapper {
	
	@Inject(optional = true)
	org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper mapper;

	public String getId(int tokenType) {
		if (mapper != null) {
			return mapper.getId(tokenType);
		}
		return getMappedValue(tokenType);
	}

}