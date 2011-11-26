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
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendConstructor;
import org.eclipse.xtext.xtend2.xtend2.XtendField;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(IXtend2JvmAssociations.Impl.class)
public interface IXtend2JvmAssociations extends IJvmModelAssociations {

	JvmGenericType getInferredType(XtendClass xtendClass);
	
	JvmConstructor getInferredConstructor(XtendClass xtendClass);

	JvmConstructor getInferredConstructor(XtendConstructor xtendConstructor);
	
	JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction);
	
	JvmOperation getDispatchOperation(XtendFunction dispatchFunction);
	
	JvmField getJvmField(XtendField field);
	
	XtendClass getXtendClass(JvmGenericType jvmType);
	
	XtendFunction getXtendFunction(JvmOperation jvmOperation);

	XtendConstructor getXtendConstructor(JvmConstructor jvmConstructor);
	
	static class Impl extends JvmModelAssociator implements IXtend2JvmAssociations {

		public JvmGenericType getInferredType(XtendClass xtendClass) {
			final JvmGenericType firstOrNull = getFirstOrNull(getJvmElements(xtendClass), JvmGenericType.class);
			return firstOrNull;
		}

		public JvmConstructor getInferredConstructor(XtendClass xtendClass) {
			final JvmConstructor firstOrNull = getFirstOrNull(getJvmElements(xtendClass), JvmConstructor.class);
			return firstOrNull;
		}

		public JvmConstructor getInferredConstructor(XtendConstructor xtendConstructor) {
			final JvmConstructor firstOrNull = getFirstOrNull(getJvmElements(xtendConstructor), JvmConstructor.class);
			return firstOrNull;
		}

		public JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction) {
			final Iterable<JvmOperation> jvmElements = filter(getJvmElements(xtendFunction), JvmOperation.class);
			String expectedName = xtendFunction.getName();
			if (xtendFunction.isDispatch()) {
				expectedName = "_"+expectedName;
			}
			for (JvmOperation jvmOperation : jvmElements) {
				if (jvmOperation.getSimpleName().equals(expectedName)) {
					return jvmOperation;
				}
			}
			return null;
		}
		
		public JvmOperation getDispatchOperation(XtendFunction dispatchFunction) {
			if (!dispatchFunction.isDispatch())
				throw new IllegalArgumentException("Function " + dispatchFunction.getName() + " is not a dispatch function");
			Set<EObject> jvmElements = getJvmElements(dispatchFunction);
			for(EObject candidate: jvmElements) {
				if (candidate instanceof JvmOperation) {
					// other operation has '_' prefix
					if (dispatchFunction.getName().equals(((JvmOperation) candidate).getSimpleName())) {
						return (JvmOperation) candidate;
					}
				}
			}
			return null;
		}

		public XtendClass getXtendClass(JvmGenericType jvmType) {
			return (XtendClass) getPrimarySourceElement(jvmType);
		}

		public XtendFunction getXtendFunction(JvmOperation jvmOperation) {
			return (XtendFunction) getPrimarySourceElement(jvmOperation);
		}

		public XtendConstructor getXtendConstructor(JvmConstructor jvmConstructor) {
			EObject primarySourceElement = getPrimarySourceElement(jvmConstructor);
			return primarySourceElement instanceof XtendConstructor ? (XtendConstructor) primarySourceElement : null;
		}

		protected <T> T getFirstOrNull(Iterable<EObject> elements, Class<T> type) {
			Iterator<T> iterator = filter(elements, type).iterator();
			return iterator.hasNext() ? iterator.next() : null;
		}

		public JvmField getJvmField(XtendField field) {
			return getFirstOrNull(getJvmElements(field), JvmField.class);
		}

	}
	
}
