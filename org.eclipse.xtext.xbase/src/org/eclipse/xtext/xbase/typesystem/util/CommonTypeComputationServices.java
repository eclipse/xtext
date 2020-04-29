/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.IRawTypeHelper;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xtype.XtypeFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API TODO JavaDoc
 */
@Singleton
public class CommonTypeComputationServices {
	@Inject
	private OperatorMapping operatorMapping;

	@Inject
	private XExpressionHelper expressionHelper;

	@Inject
	private TypeReferences typeReferences;

	@Inject
	private TypeConformanceComputer typeConformanceComputer;

	@Inject
	private IRawTypeHelper rawTypeHelper;

	@Inject
	private Primitives primitives;

	@Inject
	private FunctionTypes functionTypes;

	@Inject
	private ArrayTypes arrayTypes;

	@Inject
	private BoundTypeArgumentMerger boundTypeArgumentMerger;

	@Inject
	private SynonymTypesProvider synonymTypesProvider;

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Inject
	private ExtendedEarlyExitComputer earlyExitComputer;

	@Inject
	private HumanReadableTypeNames humanReadableTypeNames;

	@Inject(optional = true)
	private XtypeFactory xtypeFactory = XtypeFactory.eINSTANCE;

	@Inject(optional = true)
	private TypesFactory typesFactory = TypesFactory.eINSTANCE;

	public OperatorMapping getOperatorMapping() {
		return operatorMapping;
	}

	public void setOperatorMapping(OperatorMapping operatorMapping) {
		this.operatorMapping = operatorMapping;
	}

	public XExpressionHelper getExpressionHelper() {
		return expressionHelper;
	}

	public void setExpressionHelper(XExpressionHelper expressionHelper) {
		this.expressionHelper = expressionHelper;
	}

	public TypeReferences getTypeReferences() {
		return typeReferences;
	}

	public void setTypeReferences(TypeReferences typeReferences) {
		this.typeReferences = typeReferences;
	}

	public TypeConformanceComputer getTypeConformanceComputer() {
		return typeConformanceComputer;
	}

	public void setTypeConformanceComputer(TypeConformanceComputer typeConformanceComputer) {
		this.typeConformanceComputer = typeConformanceComputer;
	}

	public IRawTypeHelper getRawTypeHelper() {
		return rawTypeHelper;
	}

	public void setRawTypeHelper(IRawTypeHelper rawTypeHelper) {
		this.rawTypeHelper = rawTypeHelper;
	}

	public Primitives getPrimitives() {
		return primitives;
	}

	public void setPrimitives(Primitives primitives) {
		this.primitives = primitives;
	}

	public FunctionTypes getFunctionTypes() {
		return functionTypes;
	}

	public void setFunctionTypes(FunctionTypes functionTypes) {
		this.functionTypes = functionTypes;
	}

	public ArrayTypes getArrayTypes() {
		return arrayTypes;
	}

	public void setArrayTypes(ArrayTypes arrayTypes) {
		this.arrayTypes = arrayTypes;
	}

	public BoundTypeArgumentMerger getBoundTypeArgumentMerger() {
		return boundTypeArgumentMerger;
	}

	public void setBoundTypeArgumentMerger(BoundTypeArgumentMerger boundTypeArgumentMerger) {
		this.boundTypeArgumentMerger = boundTypeArgumentMerger;
	}

	public SynonymTypesProvider getSynonymTypesProvider() {
		return synonymTypesProvider;
	}

	public void setSynonymTypesProvider(SynonymTypesProvider synonymTypesProvider) {
		this.synonymTypesProvider = synonymTypesProvider;
	}

	public IJvmModelAssociations getJvmModelAssociations() {
		return jvmModelAssociations;
	}

	public void setJvmModelAssociations(IJvmModelAssociations jvmModelAssociations) {
		this.jvmModelAssociations = jvmModelAssociations;
	}

	public ExtendedEarlyExitComputer getEarlyExitComputer() {
		return earlyExitComputer;
	}

	public void setEarlyExitComputer(ExtendedEarlyExitComputer earlyExitComputer) {
		this.earlyExitComputer = earlyExitComputer;
	}

	public HumanReadableTypeNames getHumanReadableTypeNames() {
		return humanReadableTypeNames;
	}

	public void setHumanReadableTypeNames(HumanReadableTypeNames humanReadableTypeNames) {
		this.humanReadableTypeNames = humanReadableTypeNames;
	}

	public XtypeFactory getXtypeFactory() {
		return xtypeFactory;
	}

	public void setXtypeFactory(XtypeFactory xtypeFactory) {
		this.xtypeFactory = xtypeFactory;
	}

	public TypesFactory getTypesFactory() {
		return typesFactory;
	}

	public void setTypesFactory(TypesFactory typesFactory) {
		this.typesFactory = typesFactory;
	}
}
