/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.xtend2.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.xtend.core.xtend.Xtend2Factory;
import org.eclipse.xtend.core.xtend.Xtend2Package;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.impl.XtendClassImpl;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendClassImplCustom extends XtendClassImpl {
	
	{
		setSuperCallReferable(Xtend2Factory.eINSTANCE.createXtendClassSuperCallReferable());
	}
	
	@Override
	public String getSimpleName() {
		return getName();
	}
	
	@Override
	public String getPackageName() {
		if (eContainer() instanceof XtendFile) {
			XtendFile file = (XtendFile) eContainer();
			return file.getPackage();
		}
		return null;
	}
	
	//TODO get rid of me
	@Override
	public EList<JvmTypeReference> getSuperTypes() {
		EList<JvmTypeReference> result = new EObjectEList<JvmTypeReference>(JvmTypeReference.class, this, Xtend2Package.XTEND_CLASS__SUPER_TYPES);
		eSetDeliver(false);
		try {
			if (getExtends()!=null)
				result.add(getExtends());
			result.addAll(getImplements());
		} finally {
			eSetDeliver(true);
		}
		return result;
	}
	
	
}
