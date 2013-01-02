/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.ContextualVisibilityHelper;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSessionWithContext extends AbstractNestedFeatureScopeSession {

	private IVisibilityHelper visibilityHelper;

	public FeatureScopeSessionWithContext(AbstractFeatureScopeSession parent, LightweightTypeReference contextType) {
		super(parent);
		this.visibilityHelper = new ContextualVisibilityHelper(parent, contextType);
	}
	
	@Override
	public boolean isVisible(JvmMember member) {
		return visibilityHelper.isVisible(member);
	}

}
