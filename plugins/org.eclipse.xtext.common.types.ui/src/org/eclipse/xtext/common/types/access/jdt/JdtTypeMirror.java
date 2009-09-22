/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtTypeMirror extends AbstractClassMirror {

	private final IType mirroredType;
	private final ITypeFactory<IType> typeFactory;

	public JdtTypeMirror(IType type, ITypeFactory<IType> typeFactory) {
		this.mirroredType = type;
		this.typeFactory = typeFactory;
	}

	public void initialize(TypeResource typeResource) {
		typeResource.getContents().add(typeFactory.createType(mirroredType));
	}

	@Override
	protected String getTypeName() {
		return mirroredType.getFullyQualifiedName();
	}

	public IType getMirroredType() {
		return mirroredType;
	}

}
