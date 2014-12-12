/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.naming.QualifiedName;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * TODO JavaDoc - no implicit receiver, implicit argument or whatever
 */
public class StaticFeatureDescription extends BucketedEObjectDescription {

	public StaticFeatureDescription(QualifiedName qualifiedName, JvmFeature feature, int bucketId,
			boolean visible) {
		super(qualifiedName, feature, bucketId, visible);
		if (!feature.isStatic()) {
			throw new IllegalArgumentException(String.valueOf(feature));
		}
	}
	
	@Override
	public boolean isStatic() {
		return true;
	}
	
	@Override
	public boolean isExtension() {
		return false;
	}

}
