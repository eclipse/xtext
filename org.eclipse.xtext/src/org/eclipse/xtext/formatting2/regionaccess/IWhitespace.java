/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

/**
 * <p>Represents a whitespace token inside a {@link IHiddenRegion}.</p>
 * 
 * <p>Whitespace are usually hidden tokens for which all characters have {@link Character#isWhitespace(char) isWhitespace == true}.</p>
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @see IComment
 * @see IHiddenRegion
 * @see ITextRegionAccess
 *
 * @since 2.8
 */
public interface IWhitespace extends IHiddenRegionPart {
}