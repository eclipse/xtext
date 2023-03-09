/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.jvmmodel.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class OperatorMappingUtil {

	@Inject
	private OperatorMapping operatorMapping;
	
	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter;

	public boolean isMappedOperator(EObject element) {
		if(element instanceof JvmOperation) { 
			QualifiedName simpleName = qualifiedNameConverter.toQualifiedName((((JvmOperation) element).getSimpleName()));
			QualifiedName operator = operatorMapping.getOperator(simpleName);
			return operator != null; 
		}
		return false;
	}
}
