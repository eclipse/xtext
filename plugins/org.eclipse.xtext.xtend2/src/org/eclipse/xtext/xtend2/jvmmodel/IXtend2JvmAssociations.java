/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.jvmmodel;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IXtend2JvmAssociations.Impl.class)
public interface IXtend2JvmAssociations extends IJvmModelAssociations {

	JvmGenericType getInferredType(XtendClass xtendClass);
	
	JvmConstructor getInferredConstructor(XtendClass xtendClass);
	
	JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction);
	
	XtendClass getXtendClass(JvmGenericType jvmType);
	
	XtendFunction getXtendFunction(JvmOperation jvmOperation);
	
	static class Impl extends JvmModelAssociator implements IXtend2JvmAssociations {

		public JvmGenericType getInferredType(XtendClass xtendClass) {
			return getFirstOrNull(getJvmElements(xtendClass), JvmGenericType.class);
		}

		public JvmConstructor getInferredConstructor(XtendClass xtendClass) {
			return getFirstOrNull(getJvmElements(xtendClass), JvmConstructor.class);
		}

		public JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction) {
			return getFirstOrNull(getJvmElements(xtendFunction), JvmOperation.class);
		}

		public XtendClass getXtendClass(JvmGenericType jvmType) {
			return (XtendClass) getPrimarySourceElement(jvmType);
		}

		public XtendFunction getXtendFunction(JvmOperation jvmOperation) {
			return (XtendFunction) getPrimarySourceElement(jvmOperation);
		}

		protected <T> T getFirstOrNull(Iterable<EObject> elements, Class<T> type) {
			Iterator<T> iterator = filter(elements, type).iterator();
			return iterator.hasNext() ? iterator.next() : null;
		}


	}
	
}
