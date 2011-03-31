/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static com.google.common.collect.Iterables.*;
import static java.util.Collections.*;

import java.util.Collections;

import org.eclipse.xtext.common.types.JvmAnyTypeReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmMultiTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultFeaturesForTypeProvider implements IFeaturesForTypeProvider {

	public Iterable<? extends JvmFeature> getFeaturesForType(JvmTypeReference declType) {
		if (declType instanceof JvmAnyTypeReference || declType instanceof JvmMultiTypeReference) {
			return Collections.emptyList();
		}
		if (declType != null && declType.getType() instanceof JvmDeclaredType) {
			return filter(filter(((JvmDeclaredType)declType.getType()).getMembers(), JvmFeature.class), new Predicate<JvmFeature>() {
				public boolean apply(JvmFeature input) {
					return !(input instanceof JvmConstructor);
				}
			});
		}
		return emptySet();
	}

	public boolean isExtensionProvider() {
		return false;
	}

}
