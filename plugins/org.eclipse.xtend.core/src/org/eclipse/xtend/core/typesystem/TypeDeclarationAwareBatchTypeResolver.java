/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtext.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeDeclarationAwareBatchTypeResolver extends LogicalContainerAwareBatchTypeResolver {

	@Override
	protected List<EObject> getEntryPoints(EObject object) {
		 List<EObject> result = super.getEntryPoints(object);
		 EObject rootContainer = EcoreUtil.getRootContainer(object);
		 if (rootContainer instanceof XtendFile) {
			 List<EObject> resultIncludingXtendTypes = Lists.newArrayList(result);
			 List<XtendTypeDeclaration> typeDeclarations = ((XtendFile) rootContainer).getXtendTypes();
			 resultIncludingXtendTypes.addAll(typeDeclarations);
			 return resultIncludingXtendTypes;
		 }
		 return result;
	}
	
}
