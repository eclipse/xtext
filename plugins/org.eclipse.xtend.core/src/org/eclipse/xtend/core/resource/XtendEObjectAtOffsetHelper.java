/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendClassSuperCallReferable;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendEObjectAtOffsetHelper extends EObjectAtOffsetHelper {
	
	@Inject
	private TypeReferences typeReferences;
	
	@Override
	public EObject resolveCrossReferencedElementAt(XtextResource resource, int offset) {
		EObject obj = super.resolveCrossReferencedElementAt(resource, offset);
		if (obj instanceof XtendClassSuperCallReferable) {
			XtendClass xtendClass = ((XtendClassSuperCallReferable) obj).getXtendClass();
			if (xtendClass.getExtends()!=null) {
				return xtendClass.getExtends().getType();
			} else {
				return typeReferences.findDeclaredType(Object.class, xtendClass);
			}
		}
		return obj;
	}
}
