/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSessionWithContext extends AbstractNestedFeatureScopeSession {

	private JvmType contextType;
	private Set<String> superTypeNames;

	public FeatureScopeSessionWithContext(AbstractFeatureScopeSession parent, JvmType contextType) {
		super(parent);
		this.contextType = contextType;
		SuperTypeCollector superTypeCollector = getFeatureScopes().getSuperTypeCollector();
		superTypeNames = superTypeCollector.collectSuperTypeNames(contextType);
	}
	
	@Override
	public boolean isVisible(JvmFeature feature) {
		JvmVisibility visibility = feature.getVisibility();
		if (visibility == JvmVisibility.PUBLIC) {
			return true;
		}
		JvmDeclaredType type = feature.getDeclaringType();
		if (type == contextType) {
			return true;
		}
		if (type != null && superTypeNames.contains(type.getIdentifier())) {
			if (visibility == JvmVisibility.PROTECTED) {
				return true;
			}
		}
		if (type != null && contextType instanceof JvmDeclaredType) {
			String packageName = ((JvmDeclaredType) contextType).getPackageName();
			if (Strings.isEmpty(packageName) && Strings.isEmpty(type.getPackageName())
					|| (packageName != null && packageName.equals(type.getPackageName()))) {
				if (visibility == JvmVisibility.DEFAULT || visibility == JvmVisibility.PROTECTED)
					return true;
			}
		}
		return super.isVisible(feature);
	}

}
