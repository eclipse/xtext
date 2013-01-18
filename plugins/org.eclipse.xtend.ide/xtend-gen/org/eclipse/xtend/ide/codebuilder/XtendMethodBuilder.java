package org.eclipse.xtend.ide.codebuilder;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.ide.codebuilder.AbstractMethodBuilder;
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
public class XtendMethodBuilder extends AbstractMethodBuilder implements Xtend {
  @Inject
  private XtendTypeReferenceSerializer typeRefSerializer;
  
  protected TypeReferenceSerializer getTypeReferenceSerializer() {
    return this.typeRefSerializer;
  }
  
  public IAppendable build(final IAppendable appendable) {
    IAppendable _append = appendable.append("def ");
    JvmVisibility _visibility = this.getVisibility();
    IAppendable _appendVisibility = this.appendVisibility(_append, _visibility, JvmVisibility.PUBLIC);
    String _methodName = this.getMethodName();
    IAppendable _append_1 = _appendVisibility.append(_methodName);
    List<JvmTypeReference> _parameterTypes = this.getParameterTypes();
    IAppendable _appendParameters = this.appendParameters(_append_1, _parameterTypes);
    IAppendable _append_2 = _appendParameters.append(" {");
    IAppendable _increaseIndentation = _append_2.increaseIndentation();
    IAppendable _newLine = _increaseIndentation.newLine();
    IAppendable _appendDefaultBody = this.appendDefaultBody(_newLine, "");
    IAppendable _decreaseIndentation = _appendDefaultBody.decreaseIndentation();
    IAppendable _newLine_1 = _decreaseIndentation.newLine();
    IAppendable _append_3 = _newLine_1.append("}");
    return _append_3;
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
      int _length = memberNode.getLength();
      int _plus = (_offset + _length);
      _xblockexpression = (_plus);
    }
    return _xblockexpression;
  }
  
  public XtendClass getXtendClass() {
    Object _ownerSource = this.getOwnerSource();
    return ((XtendClass) _ownerSource);
  }
}
