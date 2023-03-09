/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmVisibility;

/**
 * Context independent treatment of visibility computation. 
 * A feature is considered to be visible if it is public
 * 
 * TODO: consider the declarator
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PublicVisibilityHelper implements IVisibilityHelper {

	@Override
	public boolean isVisible(/* @NonNull */ JvmMember member) {
		return member.getVisibility() == JvmVisibility.PUBLIC;
	}
	
}
