/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.linking;

import java.util.Iterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.linking.lazy.LazyLinker;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class Xtend2LazyLinker extends LazyLinker implements Adapter {

	@Inject
	private JvmModelInferrer jvmModelInferrer;
	
	@Inject
	private IReferableElementsUnloader.GenericUnloader unloader;

	@Override
	protected void beforeModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		Resource resource = model.eResource();
		if (EcoreUtil.getAdapter(resource.eAdapters(), this) == null) {
			resource.eAdapters().add(this);
		}
		EList<EObject> rootElements = resource.getContents();
		for (Iterator<EObject> i = rootElements.iterator(); i.hasNext();) {
			EObject rootElement = i.next();
			if (rootElement instanceof JvmGenericType) {
				unloader.unloadRoot(rootElement);
				i.remove();
			}
		}
		super.beforeModelLinked(model, diagnosticsConsumer);
	}

	@Override
	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		super.afterModelLinked(model, diagnosticsConsumer);
		XtendClass xtendClass = getXtendClass(model);
		if (xtendClass != null && xtendClass.getName() != null) {
			jvmModelInferrer.inferJvmGenericType(xtendClass);
		}
	}

	protected XtendClass getXtendClass(EObject root) {
		return (root instanceof XtendFile) ? ((XtendFile) root).getXtendClass() : null;
	}

	public void notifyChanged(Notification notification) {
		if (!notification.isTouch() && notification.getFeatureID(null) == Resource.RESOURCE__CONTENTS) {
			if (notification.getEventType() == Notification.REMOVE) {
				if (notification.getOldValue() instanceof XtendFile) {
					Resource resource = (Resource) notification.getNotifier();
					while(!resource.getContents().isEmpty()) {
						EObject object = resource.getContents().get(0);
						unloader.unloadRoot(object);
						resource.getContents().remove(0);
					}
				}
			}
		}
	}

	public Notifier getTarget() {
		// ignore
		return null;
	}

	public void setTarget(Notifier newTarget) {
		// ignore
	}

	public boolean isAdapterForType(Object type) {
		return type == this;
	}
 
}
