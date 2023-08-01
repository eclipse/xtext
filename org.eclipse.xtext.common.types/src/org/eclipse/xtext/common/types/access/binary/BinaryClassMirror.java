/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.binary;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinaryClassMirror extends AbstractClassMirror {

	private final BinaryClass binaryClass;
	private final boolean sealed;
	private final ITypeFactory<BinaryClass, JvmDeclaredType> typeFactory;


	public static BinaryClassMirror createClassMirror(BinaryClass binaryClass, ITypeFactory<BinaryClass, JvmDeclaredType> typeFactory) {
		return createClassMirror(binaryClass, typeFactory, true);
	}
	
	/**
	 * @since 2.35
	 */
	public static BinaryClassMirror createClassMirror(BinaryClass binaryClass, ITypeFactory<BinaryClass, JvmDeclaredType> typeFactory, boolean sealed) {
		if (binaryClass.isPrimitive() || binaryClass.isArray())
			throw new IllegalArgumentException("Cannot create class mirror for " + binaryClass.getName());
		return new BinaryClassMirror(binaryClass, typeFactory, sealed);
	}
	
	/**
	 * @since 2.35
	 */
	protected BinaryClassMirror(BinaryClass binaryClass, ITypeFactory<BinaryClass, JvmDeclaredType> typeFactory, boolean sealed) {
		this.binaryClass = binaryClass;
		this.typeFactory = typeFactory;
		this.sealed = sealed;
	}
	
	@Deprecated
	protected BinaryClassMirror(BinaryClass binaryClass, ITypeFactory<BinaryClass, JvmDeclaredType> typeFactory) {
		this(binaryClass, typeFactory, true);
	}

	@Override
	protected String getTypeName() {
		return binaryClass.getName();
	}

	@Override
	public void initialize(TypeResource typeResource) {
		typeResource.getContents().add(typeFactory.createType(binaryClass));
	}
	
	public BinaryClass getMirroredBinaryClass() {
		return binaryClass;
	}
	
	@Override
	public URI getLocationURI(Resource resource) {
		return binaryClass.getLocationURI();
	}
	
	public Class<?> getMirroredClass() {
		try {
			return Class.forName(binaryClass.getName(), false, binaryClass.getClassLoader());
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public boolean isSealed() {
		return sealed;
	}
}
