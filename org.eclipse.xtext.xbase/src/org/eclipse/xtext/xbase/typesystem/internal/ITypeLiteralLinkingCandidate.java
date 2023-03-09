/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A candidate that resolves a feature call to a type literal.
 * 
 * A type literal is never static and never an extension. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeLiteralLinkingCandidate extends IFeatureLinkingCandidate {

	/**
	 * Returns the type that shall be resolved as a literal.
	 * @return the type. 
	 */
	JvmType getType();
	
	/**
	 * A linked type literal does never have type arguments. Returns an empty list.
	 * @return an empty list.
	 */
	@Override
	List<LightweightTypeReference> getTypeArguments();
	
	/**
	 * @return always <code>true</code>.
	 */
	@Override
	boolean isTypeLiteral();
	
	/**
	 * @return always <code>false</code>.
	 */
	@Override
	boolean isStatic();
	
	/**
	 * @return always <code>false</code>.
	 */
	@Override
	boolean isExtension();
	
}
