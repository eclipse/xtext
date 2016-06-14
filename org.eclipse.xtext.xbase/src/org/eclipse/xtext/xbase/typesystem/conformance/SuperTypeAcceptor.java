/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface SuperTypeAcceptor {
	/**
	 * @param superType a visited super type
	 * @param distance the distance to the starting type. StringBuilder has a distance 1 to 
	 * AbstractStringBuilder, distance 1 and 2 to CharSequence and distance 2 to Appendable.
	 */
	boolean accept(LightweightTypeReference superType, int distance);
}