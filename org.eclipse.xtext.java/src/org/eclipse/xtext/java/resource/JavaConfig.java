/*******************************************************************************
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.java.resource;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.lib.Pure;

public class JavaConfig {
	public static class JavaConfigAdapter extends AdapterImpl {
		private JavaConfig element;

		public JavaConfigAdapter(JavaConfig element) {
			this.element = element;
		}

		public JavaConfig get() {
			return this.element;
		}

		@Override
		public boolean isAdapterForType(final Object object) {
			return object == JavaConfig.class;
		}
	}

	private JavaVersion javaSourceLevel;

	private JavaVersion javaTargetLevel;

	public static JavaConfig findInEmfObject(Notifier emfObject) {
		JavaConfigAdapter adapter = (JavaConfigAdapter) EcoreUtil.getExistingAdapter(emfObject, JavaConfig.class);
		if (adapter != null) {
			return adapter.get();
		}
		return null;
	}

	public static JavaConfig removeFromEmfObject(Notifier emfObject) {
		List<Adapter> adapters = emfObject.eAdapters();
		for (int i = 0, max = adapters.size(); i < max; i++) {
			Adapter adapter = adapters.get(i);
			if (adapter instanceof JavaConfig.JavaConfigAdapter) {
				emfObject.eAdapters().remove(i);
				return ((JavaConfig.JavaConfigAdapter) adapter).get();
			}
		}
		return null;
	}

	public void attachToEmfObject(Notifier emfObject) {
		JavaConfig result = findInEmfObject(emfObject);
		if (result != null)
			throw new IllegalStateException("The given EMF object already contains an adapter for JavaConfig");
		JavaConfig.JavaConfigAdapter adapter = new JavaConfig.JavaConfigAdapter(this);
		emfObject.eAdapters().add(adapter);
	}

	@Pure
	public JavaVersion getJavaSourceLevel() {
		return this.javaSourceLevel;
	}

	public void setJavaSourceLevel(JavaVersion javaSourceLevel) {
		this.javaSourceLevel = javaSourceLevel;
	}

	@Pure
	public JavaVersion getJavaTargetLevel() {
		return this.javaTargetLevel;
	}

	public void setJavaTargetLevel(JavaVersion javaTargetLevel) {
		this.javaTargetLevel = javaTargetLevel;
	}
}
