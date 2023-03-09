/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.wizard;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;

public class Ecore2XtextConfiguration {
	private final Set<EPackageInfo> ePackageInfos = new HashSet<>();

	private EPackageInfo defaultEPackageInfo;

	private EClass rootElementClass;

	public Set<EPackageInfo> getEPackageInfos() {
		return ePackageInfos;
	}

	public EPackageInfo getDefaultEPackageInfo() {
		return defaultEPackageInfo;
	}

	public void setDefaultEPackageInfo(EPackageInfo defaultEPackageInfo) {
		this.defaultEPackageInfo = defaultEPackageInfo;
	}

	public EClass getRootElementClass() {
		return rootElementClass;
	}

	public void setRootElementClass(EClass rootElementClass) {
		this.rootElementClass = rootElementClass;
	}
}
