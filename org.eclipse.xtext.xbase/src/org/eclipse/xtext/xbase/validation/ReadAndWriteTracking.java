/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ReadAndWriteTracking {
	protected static class InitializedMarker extends AdapterImpl {
		private Set<JvmConstructor> byConstructors = new HashSet<>();

		public boolean isInitialized(JvmConstructor constructor) {
			return byConstructors.contains(constructor);
		}

		public boolean markInitialized(JvmConstructor constructor) {
			return byConstructors.add(constructor);
		}
	}

	public boolean markReadAccess(EObject object) {
		if (!isRead(object)) {
			return object.eAdapters().add(ReadAndWriteTracking.READMARKER);
		}
		return false;
	}

	public boolean isRead(EObject object) {
		return object.eAdapters().contains(ReadAndWriteTracking.READMARKER);
	}

	private static Adapter READMARKER = new Adapter() {
		@Override
		public Notifier getTarget() {
			return null;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return false;
		}

		@Override
		public void notifyChanged(Notification notification) {
		}

		@Override
		public void setTarget(Notifier newTarget) {
		}
	};

	public boolean markInitialized(EObject it, JvmConstructor constructor) {
		InitializedMarker initializedMarker = getInitializedMarker(it);
		if (initializedMarker == null) {
			initializedMarker = newInitalizedMarker(it);
		}
		return initializedMarker.markInitialized(constructor);
	}

	public boolean isInitialized(EObject it, JvmConstructor constructor) {
		InitializedMarker initializedMarker = getInitializedMarker(it);
		if (initializedMarker != null) {
			return initializedMarker.isInitialized(constructor);
		}
		return false;
	}

	protected InitializedMarker newInitalizedMarker(EObject it) {
		InitializedMarker initializedMarker = new InitializedMarker();
		it.eAdapters().add(initializedMarker);
		return initializedMarker;
	}

	protected InitializedMarker getInitializedMarker(EObject object) {
		for (Adapter a : object.eAdapters()) {
			if (a instanceof InitializedMarker) {
				return (InitializedMarker) a;
			}
		}
		return null;
	}
}
