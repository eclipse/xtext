/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.typesystem;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureScopeSession;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.eclipse.xtext.xtype.XImportDeclaration;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ExtensionAwareScopeProvider extends XbaseWithAnnotationsBatchScopeProvider {

	@Override
	public IFeatureScopeSession newSession(Resource context) {
		IFeatureScopeSession result = super.newSession(context);
		if (context.getContents().isEmpty())
			return result;
		EObject rootInstance = context.getContents().get(0);
		if (!(rootInstance instanceof XtendFile) || ((XtendFile)rootInstance).getImportSection() == null) {
			return result;
		}
		XtendFile file = (XtendFile) rootInstance;
		List<XImportDeclaration> imports = file.getImportSection().getImportDeclarations();
		List<JvmType> staticFeatureProviders = Lists.newArrayListWithCapacity(imports.size() / 2);
		List<JvmType> staticExtensionFeatureProviders = Lists.newArrayListWithCapacity(imports.size() / 2);
		for(XImportDeclaration _import: imports) {
			if (_import.isWildcard() && _import.isStatic()) {
				staticFeatureProviders.add(_import.getImportedType());
				if (_import.isExtension()) {
					staticExtensionFeatureProviders.add(_import.getImportedType());
				}
			}
		}
		if (!staticFeatureProviders.isEmpty() || !staticExtensionFeatureProviders.isEmpty()) {
			result = result.addTypesToStaticScope(staticFeatureProviders, staticExtensionFeatureProviders);
		}
		return result;
	}
	
}
