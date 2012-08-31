/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.jvmmodel.annotationprocessing;

import org.eclipse.xtext.common.types.JvmAnnotationTarget;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IAnnotationProcessor {

	static class Provider {
		public IAnnotationProcessor get(JvmAnnotationType annotationType) {
			if (annotationType != null && annotationType.eResource() instanceof XtextResource) {
				XtextResource resource = (XtextResource) annotationType.eResource();
				IAnnotationProcessor participant = resource.getResourceServiceProvider()
						.get(IAnnotationProcessor.class);
				if (participant != null)
					return participant;
			}
			return null;
		}
	}

	/**
	 * called by the Xtend's compiler. Once for each annotation.
	 * 
	 * @param annotation
	 *            - the original annotation. including all expressions
	 * @param elements
	 *            - the java elements inferred from the annotated element. This often is just one element. In case of
	 *            dispatch methods, this would include the dispatch case, as well as the synthetic dispatching method.
	 * @param cancelIndicator - to be asked regularly whethe rthe process was canceled.
	 */
	public void process(XAnnotation annotation, Iterable<? extends JvmAnnotationTarget> elements, CancelIndicator cancelIndicator);
}
