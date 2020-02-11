/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IExpressionScope {

	enum Anchor {
		/**
		 * The context before the given expression
		 */
		BEFORE,
		/**
		 * The context after the given expression
		 */
		AFTER,
		/**
		 * The context with the given expression as receiver.
		 */
		RECEIVER,
		/**
		 * E.g. inside of catch blocks or for-loops, or if the current context is a feature call
		 */
		WITHIN
	}
	
	/* @NonNull */
	IScope getFeatureScope();
	
	/* @NonNull */
	IScope getFeatureScope(/* @Nullable */ XAbstractFeatureCall currentFeatureCall);
	
	/**
	 * Returns the prefix that was used to resolve the feature as 
	 * a type literal if any. 
	 */
	/* @NonNull */
	List<String> getTypeNamePrefix();
	
	/**
	 * If the current feature is worth to be 
	 * tested as a type literal.
	 */
	boolean isPotentialTypeLiteral();
	
	IExpressionScope NULL = new NullExpressionScope();
	
	class NullExpressionScope implements IExpressionScope {
		protected NullExpressionScope() {}

		@Override
		public IScope getFeatureScope() {
			return IScope.NULLSCOPE;
		}
		
		/* @NonNull */
		@Override
		public IScope getFeatureScope(XAbstractFeatureCall currentFeatureCall) {
			return IScope.NULLSCOPE;
		}

		/* @NonNull */
		@Override
		public List<String> getTypeNamePrefix() {
			return Collections.emptyList();
		}

		@Override
		public boolean isPotentialTypeLiteral() {
			return false;
		}
	}
	
}
