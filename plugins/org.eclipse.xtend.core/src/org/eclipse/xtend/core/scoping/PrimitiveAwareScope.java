/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import org.eclipse.xtext.common.types.access.impl.Primitives;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveAwareScope extends AbstractScope {

	private AbstractTypeScope typeScope;
	private IScope parent;

	protected PrimitiveAwareScope(IScope parent, AbstractTypeScope typeScope) {
		this.parent = parent;
		this.typeScope = typeScope;
	}
	
	@Override
	public IEObjectDescription getSingleElement(QualifiedName name) {
		if (isPrimitive(name)) {
			return typeScope.getSingleElement(name, true);
		}
		return parent.getSingleElement(name);
	}
	
	protected boolean isPrimitive(QualifiedName name) {
		return name.getSegmentCount() == 1 && Primitives.forName(name.getFirstSegment()) != null;
	}
	
}