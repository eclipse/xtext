package org.eclipse.xtext.xbase.typesystem.util;

import com.google.inject.Inject;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeConformanceComputer;
import org.eclipse.xtext.common.types.util.TypeReferences;
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
  private TypeConformanceComputer _typeConformanceComputer;
  
  public TypeConformanceComputer getTypeConformanceComputer() {
    return this._typeConformanceComputer;
  }
  
  public void setTypeConformanceComputer(final TypeConformanceComputer typeConformanceComputer) {
    this._typeConformanceComputer = typeConformanceComputer;
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
