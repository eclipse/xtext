/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO toString, null annotations, JAvadoc
 */
@NonNullByDefault
public interface LightweightResolvedTypes extends IResolvedTypes {

	@Nullable
	LightweightTypeReference internalGetActualType(XExpression expression);
	
	@Nullable
	LightweightTypeReference internalGetActualType(JvmIdentifiableElement identifiable);
	
	@Nullable
	LightweightTypeReference internalGetExpectedType(XExpression expression);
	
	/**
	 * @param expression may either be an {@link XAbstractFeatureCall} or {@link XConstructorCall}. Never <code>null</code>.
	 */
	List<LightweightTypeReference> internalGetActualTypeArguments(XExpression expression);
	
	LightweightResolvedTypes NULL = new NullLightweightResolvedTypes();
	
	/**
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 */
	class NullLightweightResolvedTypes extends NullResolvedTypes implements LightweightResolvedTypes {

		protected NullLightweightResolvedTypes() {}
		
		@Nullable
		public LightweightTypeReference internalGetActualType(XExpression expression) {
			return null;
		}

		@Nullable
		public LightweightTypeReference internalGetActualType(JvmIdentifiableElement identifiable) {
			return null;
		}

		@Nullable
		public LightweightTypeReference internalGetExpectedType(XExpression expression) {
			return null;
		}

		public List<LightweightTypeReference> internalGetActualTypeArguments(XExpression expression) {
			return Collections.emptyList();
		}
	}
}
