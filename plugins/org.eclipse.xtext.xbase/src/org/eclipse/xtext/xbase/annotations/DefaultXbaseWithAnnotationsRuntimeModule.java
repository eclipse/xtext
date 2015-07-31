/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations;

import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.xbase.DefaultXbaseRuntimeModule;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsBatchScopeProvider;
import org.eclipse.xtext.xbase.annotations.typesystem.XbaseWithAnnotationsTypeComputer;
import org.eclipse.xtext.xbase.annotations.validation.UnresolvedAnnotationTypeAwareMessageProducer;
import org.eclipse.xtext.xbase.scoping.batch.XbaseBatchScopeProvider;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultXbaseWithAnnotationsRuntimeModule extends DefaultXbaseRuntimeModule {

	public Class<? extends ITypeComputer> bindITypeComputer() {
		return XbaseWithAnnotationsTypeComputer.class;
	}

	public Class<? extends XbaseBatchScopeProvider> bindXbaseBatchScopeProvider() {
		return XbaseWithAnnotationsBatchScopeProvider.class;
	}

	@Override
	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return UnresolvedAnnotationTypeAwareMessageProducer.class;
	}
}
