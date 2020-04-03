/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.compiler;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;

public class DisableCodeGenerationAdapter extends AdapterImpl {
	@Override
	public boolean isAdapterForType(Object type) {
		return type == DisableCodeGenerationAdapter.class;
	}

	public static boolean isDisabled(JvmDeclaredType type) {
		return DisableCodeGenerationAdapter.getAdapter(type) != null;
	}

	public static void disableCodeGeneration(JvmDeclaredType declaredType) {
		if (DisableCodeGenerationAdapter.getAdapter(declaredType) == null) {
			DisableCodeGenerationAdapter adapter = new DisableCodeGenerationAdapter();
			declaredType.eAdapters().add(adapter);
		}
	}

	public static void enableCodeGeneration(JvmDeclaredType declaredType) {
		Adapter adapter = DisableCodeGenerationAdapter.getAdapter(declaredType);
		if (adapter != null) {
			declaredType.eAdapters().remove(adapter);
		}
	}

	private static Adapter getAdapter(JvmDeclaredType declaredType) {
		return EcoreUtil.getAdapter(declaredType.eAdapters(), DisableCodeGenerationAdapter.class);
	}
}
