/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.wizard.ecore2xtext;

import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.xtext.ui.wizard.project.XtextProjectInfo;

/**
 * @author Jan Koehnlein
 */
public class Ecore2XtextProjectInfo extends XtextProjectInfo {

	private Collection<EPackageInfo> ePackageInfos;
	private EPackageInfo defaultEPackageInfo;
	private EClass rootElementClass;
		
	public Collection<EPackageInfo> getEPackageInfos() {
		return ePackageInfos;
	}
	
	public void setEPackageInfos(Collection<EPackageInfo> ePackageInfos) {
		this.ePackageInfos=ePackageInfos;
	}

	public EClass getRootElementClass() {
		return rootElementClass;
	}

	public void setRootElementClass(EClass rootElementClass) {
		this.rootElementClass = rootElementClass;
	}

	public EPackageInfo getDefaultEPackageInfo() {
		return defaultEPackageInfo;
	}

	public void setDefaultEPackageInfo(EPackageInfo defaultEPackageInfo) {
		this.defaultEPackageInfo = defaultEPackageInfo;
	}
	
}
