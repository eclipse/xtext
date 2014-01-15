/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinaryClassMirror extends AbstractClassMirror {

	private final BinaryClass binaryClass;
	private final ITypeFactory<BinaryClass> typeFactory;


	public static BinaryClassMirror createClassMirror(BinaryClass binaryClass, ITypeFactory<BinaryClass> typeFactory) {
		return new BinaryClassMirror(binaryClass, typeFactory);
	}
	
	protected BinaryClassMirror(BinaryClass binaryClass, ITypeFactory<BinaryClass> typeFactory) {
		this.binaryClass = binaryClass;
		this.typeFactory = typeFactory;
	}

	@Override
	protected String getTypeName() {
		return binaryClass.getName();
	}

	public void initialize(TypeResource typeResource) {
		typeResource.getContents().add(typeFactory.createType(binaryClass));
	}
	
	public BinaryClass getMirroredClass() {
		return binaryClass;
	}

	public boolean isSealed() {
		return true;
	}
}
