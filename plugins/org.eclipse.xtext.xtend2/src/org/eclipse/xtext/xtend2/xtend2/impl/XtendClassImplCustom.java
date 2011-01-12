/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.xtend2.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendClassImplCustom extends XtendClassImpl {
	@Override
	public String getSimpleName() {
		return getName();
	}
	
	@Override
	public String getCanonicalName() {
		String packageName = getPackageName();
		if (packageName!=null)
			return packageName+"."+getSimpleName();
		return getSimpleName();
	}
	
	@Override
	public String getPackageName() {
		if (eContainer() instanceof XtendFile) {
			XtendFile file = (XtendFile) eContainer();
			return file.getPackage();
		}
		return null;
	}
	
	@Override
	public EList<JvmTypeReference> getSuperTypes() {
		BasicEList<JvmTypeReference> basicEList = new BasicEList<JvmTypeReference>();
		if (getExtends()!=null)
			basicEList.add(getExtends());
		basicEList.addAll(getImplements());
		return basicEList;
	}
}
