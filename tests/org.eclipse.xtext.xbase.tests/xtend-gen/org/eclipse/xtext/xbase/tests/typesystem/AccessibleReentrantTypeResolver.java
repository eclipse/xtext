package org.eclipse.xtext.xbase.tests.typesystem;

import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputer;
import org.eclipse.xtext.xbase.typesystem.internal.DefaultReentrantTypeResolver;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AccessibleReentrantTypeResolver extends DefaultReentrantTypeResolver {
  public void setTypeComputer(final ITypeComputer typeComputer) {
    super.setTypeComputer(typeComputer);
  }
  
  public TypeReferences getTypeReferences() {
    TypeReferences _typeReferences = super.getTypeReferences();
    return _typeReferences;
  }
}
