/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.Primitives
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider
import org.eclipse.xtext.xbase.typesystem.conformance.IRawTypeHelper
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypes
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes
import org.eclipse.xtext.xbase.util.XExpressionHelper
import org.eclipse.xtext.xtype.XtypeFactory

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Singleton
@Accessors
class CommonTypeComputationServices {
	
	@Inject
	OperatorMapping operatorMapping
	
	@Inject
	XExpressionHelper expressionHelper
	
	@Inject
	TypeReferences typeReferences
	
	@Inject
	TypeConformanceComputer typeConformanceComputer;

	@Inject
	IRawTypeHelper rawTypeHelper
	
	@Inject
	Primitives primitives;
	
	@Inject
	FunctionTypes functionTypes;
	
	@Inject
	ArrayTypes arrayTypes;
	
	@Inject
	BoundTypeArgumentMerger boundTypeArgumentMerger

	@Inject
	SynonymTypesProvider synonymTypesProvider
	
	@Inject
	IJvmModelAssociations jvmModelAssociations
	
	@Inject
	ExtendedEarlyExitComputer earlyExitComputer
	
	@Inject
	HumanReadableTypeNames humanReadableTypeNames
	
	@Inject(optional = true)
	XtypeFactory xtypeFactory = XtypeFactory.eINSTANCE;
	
	@Inject(optional = true)
	TypesFactory typesFactory = TypesFactory.eINSTANCE;
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
class ConstraintVisitingInfo {
	Set<JvmTypeParameter> visiting
	JvmTypeParameterDeclarator declarator
	int idx
	
	new() {
		visiting = newHashSet
	}
	new(JvmTypeParameter initial) {
		visiting = newHashSet(initial)
	}
	def boolean tryVisit(JvmTypeParameter parameter) {
		return visiting.add(parameter);
	}
	def boolean canVisit(JvmTypeParameter parameter) {
		return !visiting.contains(parameter)
	}
	def void didVisit(JvmTypeParameter parameter) {
		visiting.remove(parameter);
	}
	def void pushInfo(JvmTypeParameterDeclarator declarator, int idx) {
		if (declarator === null)
			throw new NullPointerException("declarator may not be null")
		this.declarator = declarator;
		this.idx = idx;
	}
	def getCurrentDeclarator() {
		return declarator
	}
	def getCurrentIndex() {
		return idx
	}
}
