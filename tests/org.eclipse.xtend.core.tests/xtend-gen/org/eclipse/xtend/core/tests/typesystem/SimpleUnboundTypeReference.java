package org.eclipse.xtend.core.tests.typesystem;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

@SuppressWarnings("all")
public class SimpleUnboundTypeReference extends UnboundTypeReference {
  public SimpleUnboundTypeReference(final TypeReferenceOwner owner, final JvmTypeParameter typeParameter, final Object handle) {
    super(owner, typeParameter, handle);
  }
  
  protected UnboundTypeReference createCopy(final TypeReferenceOwner owner) {
    JvmTypeParameter _typeParameter = this.getTypeParameter();
    Object _handle = this.getHandle();
    SimpleUnboundTypeReference _simpleUnboundTypeReference = new SimpleUnboundTypeReference(owner, _typeParameter, _handle);
    return _simpleUnboundTypeReference;
  }
}
