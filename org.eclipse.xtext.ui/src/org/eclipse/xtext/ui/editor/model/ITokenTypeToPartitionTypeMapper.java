/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(TerminalsTokenTypeToPartitionMapper.class)
public interface ITokenTypeToPartitionTypeMapper {
	
	/**
	 * returns the partition type for the given antlr type
	 */
	String getPartitionType(int antlrTokenType);
	
	/**
	 * returns all supported partition types
	 */
	String[] getSupportedPartitionTypes();
}
