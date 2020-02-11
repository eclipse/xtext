/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util.jdt;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;

import com.google.inject.ImplementedBy;

/**
 * Service to locate the respective {@link IJavaElement java elements} for a
 * given {@link JvmIdentifiableElement}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
@ImplementedBy(JavaElementFinder.class)
public interface IJavaElementFinder {

	/**
	 * Find the {@link IJavaElement} for the {@code element}. If it cannot be located,
	 * tries to find the {@link IJavaElement} for the container of {@code element}. Returns 
	 * <code>null</code> if no suitable result can be found. If the given {@code element} is <code>null</code>,
	 * the result will be <code>null</code>.
	 * 
	 * @param element the identifiable. May be <code>null</code>.
	 * @return the found {@link IJavaElement} or <code>null</code>.
	 */
	IJavaElement findElementFor(JvmIdentifiableElement element);
	
	/**
	 * Find the {@link IJavaElement} for the {@code element}. 
	 * Returns <code>null</code> if no suitable result can be found. If the given {@code element} is <code>null</code>,
	 * the result will be <code>null</code>.
	 * 
	 * @param element the identifiable. May be <code>null</code>.
	 * @return the found {@link IJavaElement} or <code>null</code>.
	 * @since 2.3
	 */
	IJavaElement findExactElementFor(JvmIdentifiableElement element);
	
}
