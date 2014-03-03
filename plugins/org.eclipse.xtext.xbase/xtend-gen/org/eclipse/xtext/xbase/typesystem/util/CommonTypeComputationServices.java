/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.typesystem.util;

import com.google.inject.Inject;
import com.google.inject.Singleton;
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
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.ExtendedEarlyExitComputer;
import org.eclipse.xtext.xbase.util.XExpressionHelper;
import org.eclipse.xtext.xtype.XtypeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@Singleton
@SuppressWarnings("all")
public class CommonTypeComputationServices {
  @Inject
  private OperatorMapping _operatorMapping;
  
  public OperatorMapping getOperatorMapping() {
    return this._operatorMapping;
  }
  
  public void setOperatorMapping(final OperatorMapping operatorMapping) {
    this._operatorMapping = operatorMapping;
  }
  
  @Inject
  private XExpressionHelper _expressionHelper;
  
  public XExpressionHelper getExpressionHelper() {
    return this._expressionHelper;
  }
  
  public void setExpressionHelper(final XExpressionHelper expressionHelper) {
    this._expressionHelper = expressionHelper;
  }
  
  @Inject
  private TypeReferences _typeReferences;
  
  public TypeReferences getTypeReferences() {
    return this._typeReferences;
  }
  
  public void setTypeReferences(final TypeReferences typeReferences) {
    this._typeReferences = typeReferences;
  }
  
  @Inject
  private TypeConformanceComputer _typeConformanceComputer;
  
  public TypeConformanceComputer getTypeConformanceComputer() {
    return this._typeConformanceComputer;
  }
  
  public void setTypeConformanceComputer(final TypeConformanceComputer typeConformanceComputer) {
    this._typeConformanceComputer = typeConformanceComputer;
  }
  
  @Inject
  private IRawTypeHelper _rawTypeHelper;
  
  public IRawTypeHelper getRawTypeHelper() {
    return this._rawTypeHelper;
  }
  
  public void setRawTypeHelper(final IRawTypeHelper rawTypeHelper) {
    this._rawTypeHelper = rawTypeHelper;
  }
  
  @Inject
  private Primitives _primitives;
  
  public Primitives getPrimitives() {
    return this._primitives;
  }
  
  public void setPrimitives(final Primitives primitives) {
    this._primitives = primitives;
  }
  
  @Inject
  private FunctionTypes _functionTypes;
  
  public FunctionTypes getFunctionTypes() {
    return this._functionTypes;
  }
  
  public void setFunctionTypes(final FunctionTypes functionTypes) {
    this._functionTypes = functionTypes;
  }
  
  @Inject
  private ArrayTypes _arrayTypes;
  
  public ArrayTypes getArrayTypes() {
    return this._arrayTypes;
  }
  
  public void setArrayTypes(final ArrayTypes arrayTypes) {
    this._arrayTypes = arrayTypes;
  }
  
  @Inject
  private BoundTypeArgumentMerger _boundTypeArgumentMerger;
  
  public BoundTypeArgumentMerger getBoundTypeArgumentMerger() {
    return this._boundTypeArgumentMerger;
  }
  
  public void setBoundTypeArgumentMerger(final BoundTypeArgumentMerger boundTypeArgumentMerger) {
    this._boundTypeArgumentMerger = boundTypeArgumentMerger;
  }
  
  @Inject
  private SynonymTypesProvider _synonymTypesProvider;
  
  public SynonymTypesProvider getSynonymTypesProvider() {
    return this._synonymTypesProvider;
  }
  
  public void setSynonymTypesProvider(final SynonymTypesProvider synonymTypesProvider) {
    this._synonymTypesProvider = synonymTypesProvider;
  }
  
  @Inject
  private IJvmModelAssociations _jvmModelAssociations;
  
  public IJvmModelAssociations getJvmModelAssociations() {
    return this._jvmModelAssociations;
  }
  
  public void setJvmModelAssociations(final IJvmModelAssociations jvmModelAssociations) {
    this._jvmModelAssociations = jvmModelAssociations;
  }
  
  @Inject
  private ExtendedEarlyExitComputer _earlyExitComputer;
  
  public ExtendedEarlyExitComputer getEarlyExitComputer() {
    return this._earlyExitComputer;
  }
  
  public void setEarlyExitComputer(final ExtendedEarlyExitComputer earlyExitComputer) {
    this._earlyExitComputer = earlyExitComputer;
  }
  
  @Inject(optional = true)
  private XtypeFactory _xtypeFactory = XtypeFactory.eINSTANCE;
  
  public XtypeFactory getXtypeFactory() {
    return this._xtypeFactory;
  }
  
  public void setXtypeFactory(final XtypeFactory xtypeFactory) {
    this._xtypeFactory = xtypeFactory;
  }
  
  @Inject(optional = true)
  private TypesFactory _typesFactory = TypesFactory.eINSTANCE;
  
  public TypesFactory getTypesFactory() {
    return this._typesFactory;
  }
  
  public void setTypesFactory(final TypesFactory typesFactory) {
    this._typesFactory = typesFactory;
  }
}
