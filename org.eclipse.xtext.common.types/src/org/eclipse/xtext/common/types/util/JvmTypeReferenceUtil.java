/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class JvmTypeReferenceUtil {

	private static class ExpectedClassMarker extends AdapterImpl {
	}

	private static class ExpectedInterfaceMarker extends AdapterImpl {
	}

	private JvmTypeReferenceUtil() {
		// only static methods
	}

	public static void setExpectedAsClass(JvmTypeReference typeReference) {
		typeReference.eAdapters().add(new ExpectedClassMarker());
	}

	public static boolean isExpectedAsClass(JvmTypeReference typeReference) {
		return typeReference.eAdapters().stream().anyMatch(ExpectedClassMarker.class::isInstance);
	}

	public static void setExpectedAsInterface(JvmTypeReference typeReference) {
		typeReference.eAdapters().add(new ExpectedInterfaceMarker());
	}

	public static boolean isExpectedAsInterface(JvmTypeReference typeReference) {
		return typeReference.eAdapters().stream().anyMatch(ExpectedInterfaceMarker.class::isInstance);
	}
}
