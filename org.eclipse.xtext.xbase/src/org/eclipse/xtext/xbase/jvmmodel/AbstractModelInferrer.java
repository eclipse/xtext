/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.inject.Inject;

/**
 * A base dispatch class to be subclassed by clients.
 * It allows subclasses to use Xtend's dispatch methods in order to avoid explicit tree navigation and 
 * instanceof checking.
 * 
 * see also {@link IJvmModelInferrer}
 * 
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.7
 */
public abstract class AbstractModelInferrer implements IJvmModelInferrer {
	
	private @Inject JvmAnnotationReferenceBuilder.Factory annotationRefBuilderFactory;
	private @Inject JvmTypeReferenceBuilder.Factory typeRefBuilderFactory;
	
	protected @Extension JvmAnnotationReferenceBuilder _annotationTypesBuilder;
	protected @Extension JvmTypeReferenceBuilder _typeReferenceBuilder;
	
	/**
	 * @noreference This method is called by the framework
	 * @nooverride
	 */
	void setContext(Resource resource) {
		_annotationTypesBuilder = annotationRefBuilderFactory.create(resource.getResourceSet());
		_typeReferenceBuilder = typeRefBuilderFactory.create(resource.getResourceSet());
	}
	
	@Override
	public void infer(EObject e, final /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		_infer(e, acceptor, preIndexingPhase);
	}
	
	public void _infer(EObject e, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		for (EObject child : e.eContents()) {
			infer(child, acceptor, preIndexingPhase);
		}
	}
}
