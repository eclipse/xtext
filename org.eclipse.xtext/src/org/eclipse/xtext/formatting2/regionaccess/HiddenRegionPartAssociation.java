/*******************************************************************************
 * Copyright (c) 2018 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * 
 * @since 2.14
 */
public enum HiddenRegionPartAssociation {
	/**
	 * The whitespace or comment belongs to the trailing {@link ISemanticRegion}.
	 */
	NEXT,

	/**
	 * The whitespace or comment belongs to the leading {@link ISemanticRegion}.
	 */
	PREVIOUS,

	/**
	 * The whitespace or comment belongs NEITHER to the leading not trailing {@link ISemanticRegion}.
	 */
	CONTAINER;
}
