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
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.computation.SynonymTypesProvider;
import org.eclipse.xtext.xbase.typesystem.conformance.IRawTypeHelper;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.ArrayTypes;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xbase.typesystem.util.ExtendedEarlyExitComputer;
import org.eclipse.xtext.xbase.typesystem.util.HumanReadableTypeNames;
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
  @Property
  private OperatorMapping _operatorMapping;
  
  @Inject
  @Property
  private XExpressionHelper _expressionHelper;
  
  @Inject
  @Property
  private TypeReferences _typeReferences;
  
  @Inject
  @Property
  private TypeConformanceComputer _typeConformanceComputer;
  
  @Inject
  @Property
  private IRawTypeHelper _rawTypeHelper;
  
  @Inject
  @Property
  private Primitives _primitives;
  
  @Inject
  @Property
  private FunctionTypes _functionTypes;
  
  @Inject
  @Property
  private ArrayTypes _arrayTypes;
  
  @Inject
  @Property
  private BoundTypeArgumentMerger _boundTypeArgumentMerger;
  
  @Inject
  @Property
  private SynonymTypesProvider _synonymTypesProvider;
  
  @Inject
  @Property
  private IJvmModelAssociations _jvmModelAssociations;
  
  @Inject
  @Property
  private ExtendedEarlyExitComputer _earlyExitComputer;
  
  @Inject
  @Property
  private HumanReadableTypeNames _humanReadableTypeNames;
  
  @Inject(optional = true)
  @Property
  private XtypeFactory _xtypeFactory = XtypeFactory.eINSTANCE;
  
  @Inject(optional = true)
  @Property
  private TypesFactory _typesFactory = TypesFactory.eINSTANCE;
  
  @Pure
  public OperatorMapping getOperatorMapping() {
    return this._operatorMapping;
  }
  
  public void setOperatorMapping(final OperatorMapping operatorMapping) {
    this._operatorMapping = operatorMapping;
  }
  
  @Pure
  public XExpressionHelper getExpressionHelper() {
    return this._expressionHelper;
  }
  
  public void setExpressionHelper(final XExpressionHelper expressionHelper) {
    this._expressionHelper = expressionHelper;
  }
  
  @Pure
  public TypeReferences getTypeReferences() {
    return this._typeReferences;
  }
  
  public void setTypeReferences(final TypeReferences typeReferences) {
    this._typeReferences = typeReferences;
  }
  
  @Pure
  public TypeConformanceComputer getTypeConformanceComputer() {
    return this._typeConformanceComputer;
  }
  
  public void setTypeConformanceComputer(final TypeConformanceComputer typeConformanceComputer) {
    this._typeConformanceComputer = typeConformanceComputer;
  }
  
  @Pure
  public IRawTypeHelper getRawTypeHelper() {
    return this._rawTypeHelper;
  }
  
  public void setRawTypeHelper(final IRawTypeHelper rawTypeHelper) {
    this._rawTypeHelper = rawTypeHelper;
  }
  
  @Pure
  public Primitives getPrimitives() {
    return this._primitives;
  }
  
  public void setPrimitives(final Primitives primitives) {
    this._primitives = primitives;
  }
  
  @Pure
  public FunctionTypes getFunctionTypes() {
    return this._functionTypes;
  }
  
  public void setFunctionTypes(final FunctionTypes functionTypes) {
    this._functionTypes = functionTypes;
  }
  
  @Pure
  public ArrayTypes getArrayTypes() {
    return this._arrayTypes;
  }
  
  public void setArrayTypes(final ArrayTypes arrayTypes) {
    this._arrayTypes = arrayTypes;
  }
  
  @Pure
  public BoundTypeArgumentMerger getBoundTypeArgumentMerger() {
    return this._boundTypeArgumentMerger;
  }
  
  public void setBoundTypeArgumentMerger(final BoundTypeArgumentMerger boundTypeArgumentMerger) {
    this._boundTypeArgumentMerger = boundTypeArgumentMerger;
  }
  
  @Pure
  public SynonymTypesProvider getSynonymTypesProvider() {
    return this._synonymTypesProvider;
  }
  
  public void setSynonymTypesProvider(final SynonymTypesProvider synonymTypesProvider) {
    this._synonymTypesProvider = synonymTypesProvider;
  }
  
  @Pure
  public IJvmModelAssociations getJvmModelAssociations() {
    return this._jvmModelAssociations;
  }
  
  public void setJvmModelAssociations(final IJvmModelAssociations jvmModelAssociations) {
    this._jvmModelAssociations = jvmModelAssociations;
  }
  
  @Pure
  public ExtendedEarlyExitComputer getEarlyExitComputer() {
    return this._earlyExitComputer;
  }
  
  public void setEarlyExitComputer(final ExtendedEarlyExitComputer earlyExitComputer) {
    this._earlyExitComputer = earlyExitComputer;
  }
  
  @Pure
  public HumanReadableTypeNames getHumanReadableTypeNames() {
    return this._humanReadableTypeNames;
  }
  
  public void setHumanReadableTypeNames(final HumanReadableTypeNames humanReadableTypeNames) {
    this._humanReadableTypeNames = humanReadableTypeNames;
  }
  
  @Pure
  public XtypeFactory getXtypeFactory() {
    return this._xtypeFactory;
  }
  
  public void setXtypeFactory(final XtypeFactory xtypeFactory) {
    this._xtypeFactory = xtypeFactory;
  }
  
  @Pure
  public TypesFactory getTypesFactory() {
    return this._typesFactory;
  }
  
  public void setTypesFactory(final TypesFactory typesFactory) {
    this._typesFactory = typesFactory;
  }
}
