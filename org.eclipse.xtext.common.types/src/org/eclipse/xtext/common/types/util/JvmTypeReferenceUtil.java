/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class JvmTypeReferenceUtil {
	private static class Marker implements Adapter {
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

	private static final Marker EXPECTED_CLASS_MARKER = new Marker();
	private static final Marker EXPECTED_INTERFACE_MARKER = new Marker();

	private JvmTypeReferenceUtil() {
		// only static methods
	}

	public static void setExpectedAsClass(JvmTypeReference typeReference) {
		typeReference.eAdapters().add(EXPECTED_CLASS_MARKER);
	}

	public static boolean isExpectedAsClass(JvmTypeReference typeReference) {
		return typeReference.eAdapters().contains(EXPECTED_CLASS_MARKER);
	}

	public static void setExpectedAsInterface(JvmTypeReference typeReference) {
		typeReference.eAdapters().add(EXPECTED_INTERFACE_MARKER);
	}

	public static boolean isExpectedAsInterface(JvmTypeReference typeReference) {
		return typeReference.eAdapters().contains(EXPECTED_INTERFACE_MARKER);
	}
}
