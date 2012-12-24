package org.eclipse.xtend.ide.quickfix;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.ide.quickfix.ExpectedTypeResolver;
import org.eclipse.xtend.ide.quickfix.VariableNameAcceptor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.Primitives.Primitive;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.VariableType;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

@SuppressWarnings("all")
public class XtendMethodBuilder {
  @Inject
  private ITypeProvider _iTypeProvider;
  
  @Inject
  private JdtVariableCompletions _jdtVariableCompletions;
  
  @Inject
  private Primitives _primitives;
  
  @Inject
  private ExpectedTypeResolver _expectedTypeResolver;
  
  @Inject
  private TypeReferenceSerializer _typeReferenceSerializer;
  
  private String _methodName;
  
  public String getMethodName() {
    return this._methodName;
  }
  
  public void setMethodName(final String methodName) {
    this._methodName = methodName;
  }
  
  private boolean _isInterface;
  
  public boolean isIsInterface() {
    return this._isInterface;
  }
  
  public void setIsInterface(final boolean isInterface) {
    this._isInterface = isInterface;
  }
  
  private XAbstractFeatureCall _featureCall;
  
  public XAbstractFeatureCall getFeatureCall() {
    return this._featureCall;
  }
  
  public void setFeatureCall(final XAbstractFeatureCall featureCall) {
    this._featureCall = featureCall;
  }
  
  public IAppendable build(final IAppendable appendable) {
    final Procedure1<IAppendable> _function = new Procedure1<IAppendable>() {
        public void apply(final IAppendable it) {
          XtendMethodBuilder.this.addPrefix(it);
          XtendMethodBuilder.this.addName(it);
          XtendMethodBuilder.this.addArguments(it);
          XtendMethodBuilder.this.addBody(it);
        }
      };
    IAppendable _doubleArrow = ObjectExtensions.<IAppendable>operator_doubleArrow(appendable, _function);
    return _doubleArrow;
  }
  
  protected IAppendable addName(final IAppendable appendable) {
    String _methodName = this.getMethodName();
    IAppendable _append = appendable.append(_methodName);
    return _append;
  }
  
  protected IAppendable addPrefix(final IAppendable appendable) {
    IAppendable _append = appendable.append("def ");
    return _append;
  }
  
  protected IAppendable addBody(final IAppendable appendable) {
    IAppendable _xblockexpression = null;
    {
      boolean _isIsInterface = this.isIsInterface();
      if (_isIsInterface) {
        return appendable.append(";");
      }
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t");
      Object _returnStatement = this.returnStatement();
      _builder.append(_returnStatement, "	");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      IAppendable _append = appendable.append(_builder);
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  protected Object returnStatement() {
    boolean _or = false;
    XAbstractFeatureCall _featureCall = this.getFeatureCall();
    boolean _equals = ObjectExtensions.operator_equals(_featureCall, null);
    if (_equals) {
      _or = true;
    } else {
      XAbstractFeatureCall _featureCall_1 = this.getFeatureCall();
      boolean _isVoid = this.isVoid(_featureCall_1);
      _or = (_equals || _isVoid);
    }
    if (_or) {
      return "";
    } else {
      return this.defaultReturnStatement();
    }
  }
  
  protected StringBuilder defaultReturnStatement() {
    final JvmTypeReference expectedType = this.returnType();
    StringBuilder _stringBuilder = new StringBuilder("return ");
    final StringBuilder result = _stringBuilder;
    boolean _isPrimitive = this._primitives.isPrimitive(expectedType);
    if (_isPrimitive) {
      JvmType _type = expectedType.getType();
      final Primitive primitiveKind = this._primitives.primitiveKind(((JvmPrimitiveType) _type));
      boolean _matched = false;
      if (!_matched) {
        if (Objects.equal(primitiveKind,Primitive.Boolean)) {
          _matched=true;
          result.append("false");
        }
      }
      if (!_matched) {
        result.append("0");
      }
    } else {
      return result.append("null");
    }
    return result;
  }
  
  private boolean isVoid(final XAbstractFeatureCall featureCall) {
    final JvmTypeReference returnType = this.returnType();
    boolean _or = false;
    boolean _equals = ObjectExtensions.operator_equals(returnType, null);
    if (_equals) {
      _or = true;
    } else {
      String _simpleName = returnType.getSimpleName();
      boolean _equals_1 = ObjectExtensions.operator_equals(_simpleName, "void");
      _or = (_equals || _equals_1);
    }
    return _or;
  }
  
  protected JvmTypeReference returnType() {
    XAbstractFeatureCall _featureCall = this.getFeatureCall();
    JvmTypeReference _expectedType = this._iTypeProvider.getExpectedType(_featureCall);
    return _expectedType;
  }
  
  protected IAppendable addArguments(final IAppendable appendable) {
    IAppendable _xblockexpression = null;
    {
      XAbstractFeatureCall _featureCall = this.getFeatureCall();
      boolean _equals = ObjectExtensions.operator_equals(_featureCall, null);
      if (_equals) {
        return appendable.append("()");
      }
      Iterator<XExpression> _xifexpression = null;
      XAbstractFeatureCall _featureCall_1 = this.getFeatureCall();
      if ((_featureCall_1 instanceof XMemberFeatureCall)) {
        XAbstractFeatureCall _featureCall_2 = this.getFeatureCall();
        EList<XExpression> _memberCallArguments = ((XMemberFeatureCall) _featureCall_2).getMemberCallArguments();
        Iterator<XExpression> _iterator = _memberCallArguments.iterator();
        _xifexpression = _iterator;
      } else {
        XAbstractFeatureCall _featureCall_3 = this.getFeatureCall();
        EList<XExpression> _explicitArguments = _featureCall_3.getExplicitArguments();
        Iterator<XExpression> _iterator_1 = _explicitArguments.iterator();
        _xifexpression = _iterator_1;
      }
      Iterator<XExpression> iterator = _xifexpression;
      final HashSet<String> notallowed = CollectionLiterals.<String>newHashSet();
      appendable.append("(");
      boolean _hasNext = iterator.hasNext();
      boolean _while = _hasNext;
      while (_while) {
        {
          final XExpression expression = iterator.next();
          final JvmTypeReference typeRef = this._iTypeProvider.getType(expression);
          boolean _notEquals = ObjectExtensions.operator_notEquals(typeRef, null);
          if (_notEquals) {
            this.append(appendable, typeRef);
            appendable.append(" ");
            VariableNameAcceptor _variableNameAcceptor = new VariableNameAcceptor(notallowed);
            final VariableNameAcceptor acceptor = _variableNameAcceptor;
            String _identifier = typeRef.getIdentifier();
            XAbstractFeatureCall _featureCall_4 = this.getFeatureCall();
            this._jdtVariableCompletions.getVariableProposals(_identifier, _featureCall_4, VariableType.PARAMETER, notallowed, acceptor);
            String _variableName = acceptor.getVariableName();
            appendable.append(_variableName);
          }
          boolean _hasNext_1 = iterator.hasNext();
          if (_hasNext_1) {
            appendable.append(", ");
          }
        }
        boolean _hasNext_1 = iterator.hasNext();
        _while = _hasNext_1;
      }
      IAppendable _append = appendable.append(")");
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  protected IAppendable append(final IAppendable appendable, final JvmTypeReference typeRef) {
    IAppendable _xblockexpression = null;
    {
      boolean _equals = ObjectExtensions.operator_equals(typeRef, null);
      if (_equals) {
        appendable.append("void");
      } else {
        XAbstractFeatureCall _featureCall = this.getFeatureCall();
        final JvmTypeReference resolvedExpectedType = this._expectedTypeResolver.resolveExpectedType(_featureCall, typeRef);
        XAbstractFeatureCall _featureCall_1 = this.getFeatureCall();
        this._typeReferenceSerializer.serialize(resolvedExpectedType, _featureCall_1, appendable);
      }
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
}
