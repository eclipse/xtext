/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	public boolean isStatic() {
		return true;
	}
	
	public boolean isExtension() {
		return false;
	}
	
	@Override
	public boolean isAnonymousClassConstructorCall() {
		return anonymous;
	}
}
