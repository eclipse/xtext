/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IType;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.impl.ITypeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtTypeMirror extends AbstractClassMirror implements Adapter {

	private IType mirroredType;
	private final ITypeFactory<IType> typeFactory;
	private TypeResource typeResource;

	public JdtTypeMirror(IType type, ITypeFactory<IType> typeFactory) {
		this.mirroredType = type;
		this.typeFactory = typeFactory;
	}
	
	public void initialize(TypeResource typeResource) {
		typeResource.getContents().add(typeFactory.createType(mirroredType));
		this.typeResource = typeResource;
		typeResource.getResourceSet().eAdapters().add(this);
	}

	@Override
	protected String getTypeName() {
		return mirroredType.getFullyQualifiedName();
	}

	public IType getMirroredType() {
		return mirroredType;
	}

	protected void unloadResource() {
		if (typeResource.getResourceSet() != null)
			typeResource.getResourceSet().eAdapters().remove(this);
		typeResource.unload();
		if (typeResource.getResourceSet() != null)
			typeResource.getResourceSet().getResources().remove(typeResource);
		mirroredType = null;
	}

	public Notifier getTarget() {
		return null;
	}

	public boolean isAdapterForType(Object object) {
		return false;
	}

	public void notifyChanged(Notification notification) {
		if (notification.isTouch())
			return;
		switch(notification.getEventType()) {
			case Notification.REMOVE:
				if (notification.getOldValue() == typeResource) {
					unloadResource();
					ResourceSet resourceSet = (ResourceSet) notification.getNotifier();
					resourceSet.eAdapters().remove(this);
				}
				break;
			case Notification.REMOVE_MANY:
				if (((List<?>) notification.getOldValue()).contains(typeResource)) {
					unloadResource();
					ResourceSet resourceSet = (ResourceSet) notification.getNotifier();
					resourceSet.eAdapters().remove(this);
				}
				break;
		}
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
