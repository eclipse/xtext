/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.scoping;

import java.util.List;

import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.access.impl.Primitives;
import org.eclipse.xtext.common.types.xtext.AbstractTypeScope;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveAwareScope extends AbstractScope {

	private AbstractTypeScope typeScope;
	private AbstractScope parent;

	protected PrimitiveAwareScope(AbstractScope parent, AbstractTypeScope typeScope) {
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
	
	@Override
	protected void doGetElements(JvmType type, List<IEObjectDescription> result) {
		if (type instanceof JvmVoid) {
			result.add(EObjectDescription.create("void", type));
			return;
		}
		if (type instanceof JvmPrimitiveType) {
			result.add(EObjectDescription.create(((JvmPrimitiveType) type).getSimpleName(), type));
			return;
		}
		parent.doGetElements(type, result);
	}
	
}