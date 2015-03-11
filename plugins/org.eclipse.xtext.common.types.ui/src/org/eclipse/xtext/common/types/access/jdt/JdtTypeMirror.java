/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.access.IMirrorOptionsAware;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * 
 * 
 * TODO - remove Adapter interface, it's not used.
 */
public class JdtTypeMirror extends AbstractClassMirror implements Adapter, IMirrorOptionsAware {
	
	private final static Logger LOG = Logger.getLogger(JdtTypeMirror.class);

	private IType mirroredType;
	private final ITypeFactory<IType, JvmDeclaredType> typeFactory;
	private TypeResource typeResource;

	/**
	 * @deprecated use {@link #JdtTypeMirror(IType, ITypeFactory, TypeResourceServices)}
	 */
	@Deprecated
	public JdtTypeMirror(IType type, ITypeFactory<IType, JvmDeclaredType> typeFactory) {
		this(type, typeFactory, null);
	}
	
	/**
	 * @since 2.8
	 */
	public JdtTypeMirror(IType type, ITypeFactory<IType, JvmDeclaredType> typeFactory, TypeResourceServices typeResourceServices) {
		super(typeResourceServices);
		this.mirroredType = type;
		this.typeFactory = typeFactory;
	}
	
	@Override
	public void initialize(TypeResource typeResource) {
		initialize(typeResource, null);
	}
	
	/**
	 * @since 2.7
	 */
	@Override
	public void initialize(TypeResource typeResource, Map<?, ?> options) {
		try {
			if (typeFactory instanceof ITypeFactory.OptionsAware<?, ?>) {
				JvmDeclaredType jvmType = ((ITypeFactory.OptionsAware<IType, JvmDeclaredType>) typeFactory).createType(mirroredType, typeResource, options);
				typeResource.getContents().add(jvmType);
			} else {
				typeResource.getContents().add(typeFactory.createType(mirroredType));
			}
		} catch (RuntimeException e) {
			if (typeResourceServices != null) {
				typeResourceServices.getOperationCanceledManager().propagateAsErrorIfCancelException(e);
			}
			LOG.error("Error initializing type "+typeResource.getURI(), e);
			throw e;
		}
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

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public boolean isAdapterForType(Object object) {
		return false;
	}

	@Override
	public void notifyChanged(Notification notification) {
		// ignore
	}

	@Override
	public void setTarget(Notifier notifier) {
		// ignore
	}

	/**
	 * @since 2.3
	 */
	@Override
	public boolean isSealed() {
		return mirroredType.isReadOnly();
	}
}
