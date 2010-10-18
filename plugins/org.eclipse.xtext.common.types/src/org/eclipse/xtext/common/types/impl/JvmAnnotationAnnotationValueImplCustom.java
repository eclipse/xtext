/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.common.util.DelegatingEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.TypesPackage;

public class JvmAnnotationAnnotationValueImplCustom extends JvmAnnotationAnnotationValueImpl {

	@Override
	public EList<JvmAnnotationReference> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentWithInverseEList<JvmAnnotationReference>(JvmAnnotationReference.class, this, TypesPackage.JVM_ANNOTATION_ANNOTATION_VALUE__ANNOTATIONS, TypesPackage.JVM_ANNOTATION_REFERENCE__TARGET) {
				private static final long serialVersionUID = 1L;

				@Override
				protected void didChange() {
					values = null;
					super.didChange();
				}
			};
		}
		return annotations;
	}

	@Override
	public EList<JvmAnnotationReference> getValues() {
		if (values == null) {
			EObjectResolvingEList<JvmAnnotationReference> list = new EObjectResolvingEList<JvmAnnotationReference>(JvmAnnotationReference.class, this, TypesPackage.JVM_ANNOTATION_ANNOTATION_VALUE__VALUES);
			list.addAll(getAnnotations());
			values = new DelegatingEList.UnmodifiableEList<JvmAnnotationReference>(list);
		}
		return values;
	}

	
}
