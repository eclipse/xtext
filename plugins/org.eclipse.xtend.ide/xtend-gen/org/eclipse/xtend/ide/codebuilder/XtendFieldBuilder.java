package org.eclipse.xtend.ide.codebuilder;

import javax.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.ide.codebuilder.AbstractFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Xtend;
import org.eclipse.xtend.ide.codebuilder.XtendTypeReferenceSerializer;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class XtendFieldBuilder extends AbstractFieldBuilder implements Xtend {
  @Inject
  private XtendTypeReferenceSerializer typeRefSerializer;
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(appendable, _visibility, JvmVisibility.PRIVATE);
    JvmTypeReference _fieldType = this.getFieldType();
    IAppendable _appendType = this.appendType(_appendVisibility, _fieldType, "Object");
    IAppendable _append = _appendType.append(" ");
    String _fieldName = this.getFieldName();
    IAppendable _append_1 = _append.append(_fieldName);
    return _append_1;
  }
  
  public int getInsertOffset() {
    int _xblockexpression = (int) 0;
    {
      EObject _context = this.getContext();
      final XtendMember member = EcoreUtil2.<XtendMember>getContainerOfType(_context, XtendMember.class);
      boolean _equals = ObjectExtensions.operator_equals(member, null);
      if (_equals) {
        RuntimeException _runtimeException = new RuntimeException("Cannot insert field without a reference member");
        throw _runtimeException;
      }
      final ICompositeNode memberNode = NodeModelUtils.findActualNodeFor(member);
      int _offset = memberNode.getOffset();
      _xblockexpression = (_offset);
    }
    return _xblockexpression;
  }
  
  public XtendClass getXtendClass() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendClass) _ownerSource);
  }
}
