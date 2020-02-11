/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ILineRegion extends ITextSegment {

	ILineRegion getNextLine();

	ILineRegion getPreviousLine();

	ITextSegment getIndentation();
}
