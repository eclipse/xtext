/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmVisibility;

import com.google.inject.ImplementedBy;

/**
 * Determines whether a given {@link JvmFeature} is accessible according to the Java VM's 
 * visibility rules.
 * 
 * @see ContextualVisibilityHelper
 * @see PublicVisibilityHelper
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(PublicVisibilityHelper.class)
public interface IVisibilityHelper {

	/**
	 * Returns <code>true</code> if the member is visible according to the {@link JvmVisibility} and the local context.
	 * @param member the member that shall be accessed.
	 * @return <code>true</code> if the feature can be accessed.
	 */
	boolean isVisible(/* @NonNull */ JvmMember member);
	
	/**
	 * Treats all members as visible members independently from their own visibility or 
	 * the visibility of their containers. 
	 */
	IVisibilityHelper ALL = new IVisibilityHelper() {
		
		/**
		 * @return always <code>true</code>.
		 */
		@Override
		public boolean isVisible(/* @NonNull */ JvmMember member) {
			return true;
		}
		
	};
	
}
