/*******************************************************************************
 * Copyright (c) 2008 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.example;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.crossref.ILinkingService;
import org.eclipse.xtext.crossref.IScopeProvider;
import org.eclipse.xtext.example.conversion.EcoreDslConverters;
import org.eclipse.xtext.example.linker.EcoreDslLinker;
import org.eclipse.xtext.example.linker.EcoreDslLinkingService;
import org.eclipse.xtext.example.linker.EcoreDslScopeProvider;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;

/**
 * Used to register components to be used within the IDE.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class EcoreDslRuntimeModule extends AbstractEcoreDslRuntimeModule {

	// logger available to subclasses
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Override
	public Class<? extends org.eclipse.xtext.crossref.ILinker> bindILinker() {
		return EcoreDslLinker.class;
	}
	
	@Override
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return EcoreDslConverters.class;
	}

	@Override
	public Class<? extends ITransientValueService> bindITransientValueService() {
		return EcoreDslTransientValueService.class;
	}
	
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return EcoreDslScopeProvider.class;
	}
	
	@Override
	public Class<? extends ILinkingService> bindILinkingService() {
		return EcoreDslLinkingService.class;
	}

	public static class EcoreDslTransientValueService extends DefaultTransientValueService {
		@Override
		public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
			if (EcorePackage.eINSTANCE.getETypedElement_EType() == feature || EcorePackage.eINSTANCE.getEClass_ESuperTypes() == feature)
				return true;
			if (EcorePackage.eINSTANCE.getETypedElement_EGenericType() == feature || EcorePackage.eINSTANCE.getEClass_EGenericSuperTypes() == feature)
				return false;
			return super.isTransient(owner, feature, index);
		}
	}

}
