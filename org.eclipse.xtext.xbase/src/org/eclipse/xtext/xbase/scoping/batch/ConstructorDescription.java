/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConstructorDescription extends BucketedEObjectDescription {

	private final boolean anonymous;

	public ConstructorDescription(
			QualifiedName qualifiedName, 
			JvmConstructor constructor,
			int bucketId,
			boolean visible) {
		this(qualifiedName, constructor, bucketId, visible, false);
	}
	
	public ConstructorDescription(
			QualifiedName qualifiedName, 
			JvmConstructor constructor,
			int bucketId,
			boolean visible,
			boolean anonymous) {
		super(qualifiedName, constructor, bucketId, visible);
		this.
		anonymous = anonymous;
	}
	
	/**
	 * Constructors of non-member types are considered to be static.
	 */
	@Override
	public boolean isStatic() {
		return true;
	}
	
	@Override
	public boolean isExtension() {
		return false;
	}
	
	@Override
	public boolean isAnonymousClassConstructorCall() {
		return anonymous;
	}
}
