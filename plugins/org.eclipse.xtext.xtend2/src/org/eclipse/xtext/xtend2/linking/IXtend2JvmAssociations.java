/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.linking;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

import com.google.inject.ImplementedBy;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(Xtend2InferredJvmAssociator.class)
public interface IXtend2JvmAssociations {

	Set<EObject> getAssociatedElements(EObject inferredJvmOrXtendElement);

	<T> Set<T> getAssociatedElements(EObject inferredJvmOrXtendElement, Class<T> type);
	
	Set<EObject> getInferredJvmElements(EObject xtendElement);
	
	Set<EObject> getXtendElements(EObject inferredJvmElement);

	XtendFunction getXtendFunction(JvmOperation inferredOperation);

	XtendClass getXtendClass(JvmGenericType inferredType);

	JvmOperation getDirectlyInferredOperation(XtendFunction xtendFunction);

	JvmConstructor getInferredConstructor(XtendClass xtendClass);

	JvmGenericType getInferredType(XtendClass xtendClass);

}
