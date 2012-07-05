package org.eclipse.xtext.xbase.typesystem.util;

import com.google.inject.Inject;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typesystem.conformance.IRawTypeHelper;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputer;
import org.eclipse.xtext.xbase.typesystem.references.FunctionTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReferences;
import org.eclipse.xtext.xbase.typesystem.util.BoundTypeArgumentMerger;
import org.eclipse.xtext.xtype.XtypeFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
@SuppressWarnings("all")
public class CommonTypeComputationServices {
  @Inject
  private TypeReferences _typeReferences;
  
  public TypeReferences getTypeReferences() {
    return this._typeReferences;
  }
  
  public void setTypeReferences(final TypeReferences typeReferences) {
    this._typeReferences = typeReferences;
  }
  
  @Inject
  private LightweightTypeReferences _lightweightTypeReferences;
  
  public LightweightTypeReferences getLightweightTypeReferences() {
    return this._lightweightTypeReferences;
  }
  
  public void setLightweightTypeReferences(final LightweightTypeReferences lightweightTypeReferences) {
    this._lightweightTypeReferences = lightweightTypeReferences;
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
  private BoundTypeArgumentMerger _boundTypeArgumentMerger;
  
  public BoundTypeArgumentMerger getBoundTypeArgumentMerger() {
    return this._boundTypeArgumentMerger;
  }
  
  public void setBoundTypeArgumentMerger(final BoundTypeArgumentMerger boundTypeArgumentMerger) {
    this._boundTypeArgumentMerger = boundTypeArgumentMerger;
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
