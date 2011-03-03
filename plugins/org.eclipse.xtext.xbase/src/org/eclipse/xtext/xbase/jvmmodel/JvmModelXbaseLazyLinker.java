/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.IDiagnosticConsumer;
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader;
import org.eclipse.xtext.xbase.linking.XbaseLazyLinker;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelXbaseLazyLinker extends XbaseLazyLinker {

	@Inject
	private IJvmModelInferrer jvmModelInferrer;

	@Inject
	private IReferableElementsUnloader.GenericUnloader unloader;

	@Override
	protected void beforeModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		Resource resource = model.eResource();
		if (EcoreUtil.getAdapter(resource.eAdapters(), UnloadJvmModelAdapter.class) == null) {
			resource.eAdapters().add(new UnloadJvmModelAdapter());
		}
		EList<EObject> rootElements = resource.getContents();
		for (Iterator<EObject> i = rootElements.iterator(); i.hasNext();) {
			EObject rootElement = i.next();
			if (isJvmModel(rootElement)) {
				unloader.unloadRoot(rootElement);
				i.remove();
			}
		}
		super.beforeModelLinked(model, diagnosticsConsumer);
	}

	@Override
	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		super.afterModelLinked(model, diagnosticsConsumer);
		if (model != null) {
			List<? extends EObject> jvmModel = jvmModelInferrer.inferJvmModel(model);
			for(EObject jvmElement: jvmModel) 
				jvmElement.eAdapters().add(new JvmModelMarker());
			model.eResource().getContents().addAll(jvmModel);
		}
	}
	
	protected boolean isJvmModel(EObject element) {
		return EcoreUtil.getAdapter(element.eAdapters(), JvmModelMarker.class) != null;
	}

	protected static class JvmModelMarker extends AdapterImpl {
		@Override
		public boolean isAdapterForType(Object type) {
			return type == JvmModelMarker.class;
		}
	}
	
	protected class UnloadJvmModelAdapter implements Adapter {

		public void notifyChanged(Notification notification) {
			if (!notification.isTouch() && notification.getFeatureID(null) == Resource.RESOURCE__CONTENTS) {
				if (notification.getEventType() == Notification.REMOVE && notification.getOldValue() instanceof EObject
						&& !isJvmModel((EObject) notification.getOldValue())) {
					Resource resource = (Resource) notification.getNotifier();
					while (!resource.getContents().isEmpty()) {
						EObject object = resource.getContents().get(0);
						unloader.unloadRoot(object);
						resource.getContents().remove(0);
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
			return type == UnloadJvmModelAdapter.class;
		}
	}

}
