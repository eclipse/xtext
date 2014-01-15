/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * 
 * TODO - remove Adapter interface, it's not used.
 */
public class JdtTypeMirror extends AbstractClassMirror implements Adapter {

	private IType mirroredType;
	private final ITypeFactory<IType, JvmDeclaredType> typeFactory;
	private TypeResource typeResource;

	public JdtTypeMirror(IType type, ITypeFactory<IType, JvmDeclaredType> typeFactory) {
		this.mirroredType = type;
		this.typeFactory = typeFactory;
	}
	
	public void initialize(TypeResource typeResource) {
		typeResource.getContents().add(typeFactory.createType(mirroredType));
		this.typeResource = typeResource;
	}

	@Override
	protected String getTypeName() {
		return mirroredType.getFullyQualifiedName();
	}

	public IType getMirroredType() {
		return mirroredType;
	}

	protected void unloadResource() {
		typeResource.unload();
		mirroredType = null;
	}

	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object object) {
		return false;
	}

	public void notifyChanged(Notification notification) {
		// ignore
	}

	public void setTarget(Notifier notifier) {
		// ignore
	}

	/**
	 * @since 2.3
	 */
	public boolean isSealed() {
		return mirroredType.isReadOnly();
	}
}
