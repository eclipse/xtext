/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

/**
 * A scope for the statically imported features.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticImportsScope extends AbstractStaticImportsScope {
	
	public StaticImportsScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall context) {
		super(parent, session, context, null);
	}

	@Override
	protected List<TypeBucket> getBuckets() {
		return getSession().getStaticallyImportedTypes();
	}
	
	@Override
	protected BucketedEObjectDescription createDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		return new StaticFeatureDescription(name, feature, bucket.getId(), getSession().isVisible(feature));
	}
	
	
}
