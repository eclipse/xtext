package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.ide.codebuilder.VariableNameAcceptor;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.VariableType;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractExecutableBuilder extends AbstractCodeBuilder {
  @Inject
  @Extension
  private JdtVariableCompletions _jdtVariableCompletions;
  
  private List<String> _parameterNames = new Function0<List<String>>() {
    public List<String> apply() {
      List<String> _emptyList = CollectionLiterals.<String>emptyList();
      return _emptyList;
    }
  }.apply();
  
  public List<String> getParameterNames() {
    return this._parameterNames;
  }
  
  public void setParameterNames(final List<String> parameterNames) {
    this._parameterNames = parameterNames;
  }
  
  private List<JvmTypeReference> _parameterTypes = new Function0<List<JvmTypeReference>>() {
    public List<JvmTypeReference> apply() {
      List<JvmTypeReference> _emptyList = CollectionLiterals.<JvmTypeReference>emptyList();
      return _emptyList;
    }
  }.apply();
  
  public List<JvmTypeReference> getParameterTypes() {
    return this._parameterTypes;
  }
  
  public void setParameterTypes(final List<JvmTypeReference> parameterTypes) {
    this._parameterTypes = parameterTypes;
  }
  
  private List<JvmTypeReference> _exceptions = new Function0<List<JvmTypeReference>>() {
    public List<JvmTypeReference> apply() {
      List<JvmTypeReference> _emptyList = CollectionLiterals.<JvmTypeReference>emptyList();
      return _emptyList;
    }
  }.apply();
  
  public List<JvmTypeReference> getExceptions() {
    return this._exceptions;
  }
  
  public void setExceptions(final List<JvmTypeReference> exceptions) {
    this._exceptions = exceptions;
  }
  
  private List<JvmTypeParameter> _typeParameters = new Function0<List<JvmTypeParameter>>() {
    public List<JvmTypeParameter> apply() {
      List<JvmTypeParameter> _emptyList = CollectionLiterals.<JvmTypeParameter>emptyList();
      return _emptyList;
    }
  }.apply();
  
  public List<JvmTypeParameter> getTypeParameters() {
    return this._typeParameters;
  }
  
  public void setTypeParameters(final List<JvmTypeParameter> typeParameters) {
    this._typeParameters = typeParameters;
  }
  
  private String _body;
  
  public String getBody() {
    return this._body;
  }
  
  public void setBody(final String body) {
    this._body = body;
  }
  
  public IAppendable appendBody(final IAppendable appendable, final String statementSeparator) {
    IAppendable _append = appendable.append(" {");
    IAppendable _increaseIndentation = _append.increaseIndentation();
    IAppendable _newLine = _increaseIndentation.newLine();
    String _elvis = null;
    String _body = this.getBody();
    if (_body != null) {
      _elvis = _body;
    } else {
      String _defaultBody = this.defaultBody();
      _elvis = ObjectExtensions.<String>operator_elvis(_body, _defaultBody);
    }
    IAppendable _append_1 = _newLine.append(_elvis);
    IAppendable _append_2 = _append_1.append(statementSeparator);
    IAppendable _decreaseIndentation = _append_2.decreaseIndentation();
    IAppendable _newLine_1 = _decreaseIndentation.newLine();
    IAppendable _append_3 = _newLine_1.append("}");
    return _append_3;
  }
  
  protected String defaultBody() {
    return "throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")";
  }
  
  protected IAppendable appendParameters(final IAppendable appendable) {
    IAppendable _xblockexpression = null;
    {
      boolean _and = false;
      List<String> _parameterNames = this.getParameterNames();
      boolean _isEmpty = _parameterNames.isEmpty();
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        List<String> _parameterNames_1 = this.getParameterNames();
        int _size = _parameterNames_1.size();
        List<JvmTypeReference> _parameterTypes = this.getParameterTypes();
        int _size_1 = _parameterTypes.size();
        boolean _notEquals = (_size != _size_1);
        _and = (_not && _notEquals);
      }
      if (_and) {
        IllegalStateException _illegalStateException = new IllegalStateException("Number of parameter names and types must match");
        throw _illegalStateException;
      }
      appendable.append("(");
      final HashSet<String> notAllowed = CollectionLiterals.<String>newHashSet();
      List<JvmTypeReference> _parameterTypes_1 = this.getParameterTypes();
      int _size_2 = _parameterTypes_1.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size_2, true);
      for (final Integer i : _doubleDotLessThan) {
        {
          List<JvmTypeReference> _parameterTypes_2 = this.getParameterTypes();
          final JvmTypeReference typeRef = _parameterTypes_2.get((i).intValue());
          boolean _notEquals_1 = (!Objects.equal(typeRef, null));
          if (_notEquals_1) {
            this.appendType(appendable, typeRef, "Object");
            appendable.append(" ");
            List<String> _parameterNames_2 = this.getParameterNames();
            boolean _isEmpty_1 = _parameterNames_2.isEmpty();
            if (_isEmpty_1) {
              VariableNameAcceptor _variableNameAcceptor = new VariableNameAcceptor(notAllowed);
              final VariableNameAcceptor acceptor = _variableNameAcceptor;
              String _identifierOrObject = this.getIdentifierOrObject(typeRef);
              EObject _context = this.getContext();
              this._jdtVariableCompletions.getVariableProposals(_identifierOrObject, _context, 
                VariableType.PARAMETER, notAllowed, acceptor);
              String _variableName = acceptor.getVariableName();
              appendable.append(_variableName);
            } else {
              List<String> _parameterNames_3 = this.getParameterNames();
              String _get = _parameterNames_3.get((i).intValue());
              appendable.append(_get);
            }
          }
          List<JvmTypeReference> _parameterTypes_3 = this.getParameterTypes();
          int _size_3 = _parameterTypes_3.size();
          int _minus = (_size_3 - 1);
          boolean _notEquals_2 = ((i).intValue() != _minus);
          if (_notEquals_2) {
            appendable.append(", ");
          }
        }
      }
      IAppendable _append = appendable.append(")");
      _xblockexpression = (_append);
    }
    return _xblockexpression;
  }
  
  protected IAppendable appendThrowsClause(final IAppendable appendable) {
    IAppendable _xblockexpression = null;
    {
      List<JvmTypeReference> _exceptions = this.getExceptions();
      final Iterator<JvmTypeReference> iterator = _exceptions.iterator();
      boolean _hasNext = iterator.hasNext();
      if (_hasNext) {
        appendable.append(" throws ");
        boolean _dowhile = false;
        do {
          {
            final JvmTypeReference typeRef = iterator.next();
            boolean _notEquals = (!Objects.equal(typeRef, null));
            if (_notEquals) {
              this.appendType(appendable, typeRef, "Exception");
            }
            boolean _hasNext_1 = iterator.hasNext();
            if (_hasNext_1) {
              appendable.append(", ");
            }
          }
          boolean _hasNext_1 = iterator.hasNext();
          _dowhile = _hasNext_1;
        } while(_dowhile);
      }
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  public String getImage() {
    String _switchResult = null;
    JvmVisibility _visibility = this.getVisibility();
    final JvmVisibility getVisibility = _visibility;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(getVisibility,JvmVisibility.PRIVATE)) {
        _matched=true;
        _switchResult = "methpri_obj.gif";
      }
    }
    if (!_matched) {
      if (Objects.equal(getVisibility,JvmVisibility.PROTECTED)) {
        _matched=true;
        _switchResult = "methpro_obj.gif";
      }
    }
    if (!_matched) {
      if (Objects.equal(getVisibility,JvmVisibility.PUBLIC)) {
        _matched=true;
        _switchResult = "methpub_obj.gif";
      }
    }
    if (!_matched) {
      _switchResult = "methdef_obj.gif";
    }
    return _switchResult;
  }
}
