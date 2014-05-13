/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util

import com.google.inject.Inject
import java.util.Set
import org.eclipse.xtend.lib.Property
import org.eclipse.xtext.common.types.JvmTypeParameter
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.Primitives
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.xbase.typesystem.conformance.IRawTypeHelper
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer
import org.eclipse.xtext.xtype.XtypeFactory
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypes
import com.google.inject.Singleton
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping
import org.eclipse.xtext.xbase.util.XExpressionHelper

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Singleton
class CommonTypeComputationServices {
	
	@Inject
	@Property
	OperatorMapping operatorMapping
	
	@Inject
	@Property
	XExpressionHelper expressionHelper
	
	@Inject
	@Property
	TypeReferences typeReferences
	
	@Inject
	@Property
	TypeConformanceComputer typeConformanceComputer;

	@Inject
	@Property
	IRawTypeHelper rawTypeHelper
	
	@Inject
	@Property
	Primitives primitives;
	
	@Inject
	@Property
	FunctionTypes functionTypes;
	
	@Inject
	@Property
	ArrayTypes arrayTypes;
	
	@Inject
	@Property
	BoundTypeArgumentMerger boundTypeArgumentMerger

	@Inject
	@Property
	SynonymTypesProvider synonymTypesProvider
	
	@Inject
	@Property
	IJvmModelAssociations jvmModelAssociations
	
	@Inject
	@Property
	ExtendedEarlyExitComputer earlyExitComputer
	
	@Inject
	@Property
	HumanReadableTypeNames humanReadableTypeNames
	
	@Inject(optional = true)
	@Property
	XtypeFactory xtypeFactory = XtypeFactory.eINSTANCE;
	
	@Inject(optional = true)
	@Property
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
		if (declarator == null)
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