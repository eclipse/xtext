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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;
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
		// remove old unload adapter
		final Adapter adapter = EcoreUtil.getAdapter(resource.eAdapters(), UnloadJvmModelAdapter.class);
		if (adapter != null) {
			resource.eAdapters().remove(adapter);
		}
		// make sure any old JvmModels are removed
		removeInferredJvmModels(resource);
		super.beforeModelLinked(model, diagnosticsConsumer);
	}

	@Override
	protected void afterModelLinked(EObject model, IDiagnosticConsumer diagnosticsConsumer) {
		super.afterModelLinked(model, diagnosticsConsumer);
		if (model != null) {
			Resource resource = model.eResource();
			// infer jvm model
			List<? extends EObject> jvmModel = jvmModelInferrer.inferJvmModel(model);
			for (EObject jvmElement : jvmModel)
				jvmElement.eAdapters().add(new JvmModelMarker());
			model.eResource().getContents().addAll(jvmModel);
			
			// install fresh unload adapter
			resource.eAdapters().add(new UnloadJvmModelAdapter());
		}
	}

	protected boolean isJvmModel(EObject element) {
		return EcoreUtil.getAdapter(element.eAdapters(), JvmModelMarker.class) != null;
	}

	protected void removeInferredJvmModels(Object notifier) {
		Resource resource = (Resource) notifier;
		Iterator<EObject> iterator = resource.getContents().iterator();
		while (iterator.hasNext()) {
			EObject object = iterator.next();
			if (isJvmModel(object)) {
				unloader.unloadRoot(object);
				iterator.remove();
			}
		}
	}

	protected static class JvmModelMarker extends AdapterImpl {
		@Override
		public boolean isAdapterForType(Object type) {
			return type == JvmModelMarker.class;
		}
	}

	protected class UnloadJvmModelAdapter extends EContentAdapter {

		@Override
		public void notifyChanged(Notification notification) {
			if (!notification.isTouch() && notification.getNotifier() instanceof EObject
				|| (notification.getNotifier() instanceof Resource && notification.getFeatureID(null) == Resource.RESOURCE__CONTENTS)) {
				Object notifier = notification.getNotifier();
				if (notifier instanceof EObject)
					notifier = ((EObject) notifier).eResource();
				if (notifier instanceof Resource) {
					removeInferredJvmModels(notifier);
				}
			}
		}

		@Override
		public Notifier getTarget() {
			// ignore
			return null;
		}

		@Override
		public void setTarget(Notifier newTarget) {
			// ignore
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == UnloadJvmModelAdapter.class;
		}
		
		@Override
		protected boolean resolve() {
			return false;
		}
	}

}
