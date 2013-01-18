package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.ide.codebuilder.VariableNameAcceptor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions.VariableType;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.TypeReferenceSerializer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public abstract class AbstractCodeBuilder implements ICodeBuilder {
  private Object _ownerSource;
  
  public Object getOwnerSource() {
    return this._ownerSource;
  }
  
  public void setOwnerSource(final Object ownerSource) {
    this._ownerSource = ownerSource;
  }
  
  private JvmDeclaredType _owner;
  
  public JvmDeclaredType getOwner() {
    return this._owner;
  }
  
  public void setOwner(final JvmDeclaredType owner) {
    this._owner = owner;
  }
  
  private JvmVisibility _visibility;
  
  public JvmVisibility getVisibility() {
    return this._visibility;
  }
  
  public void setVisibility(final JvmVisibility visibility) {
    this._visibility = visibility;
  }
  
  private EObject _context;
  
  public EObject getContext() {
    return this._context;
  }
  
  public void setContext(final EObject context) {
    this._context = context;
  }
  
  @Inject
  private JdtVariableCompletions _jdtVariableCompletions;
  
  public String preview() {
    String _xblockexpression = null;
    {
      StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable();
      final StringBuilderBasedAppendable appendable = _stringBuilderBasedAppendable;
      IAppendable _append = appendable.append("...");
      IAppendable _newLine = _append.newLine();
      IAppendable _build = this.build(_newLine);
      IAppendable _newLine_1 = _build.newLine();
      _newLine_1.append("...");
      String _string = appendable.toString();
      _xblockexpression = (_string);
    }
    return _xblockexpression;
  }
  
  protected IAppendable appendVisibility(final IAppendable appendable, final JvmVisibility visibility, final JvmVisibility defaultVisibility) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(visibility,defaultVisibility)) {
        _matched=true;
        _switchResult = "";
      }
    }
    if (!_matched) {
      if (Objects.equal(visibility,JvmVisibility.PRIVATE)) {
        _matched=true;
        _switchResult = "private ";
      }
    }
    if (!_matched) {
      if (Objects.equal(visibility,JvmVisibility.PROTECTED)) {
        _matched=true;
        _switchResult = "protected ";
      }
    }
    if (!_matched) {
      if (Objects.equal(visibility,JvmVisibility.PUBLIC)) {
        _matched=true;
        _switchResult = "public ";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    IAppendable _append = appendable.append(_switchResult);
    return _append;
  }
  
  protected IAppendable appendType(final IAppendable appendable, final JvmTypeReference typeRef, final String surrogate) {
    IAppendable _xblockexpression = null;
    {
      boolean _equals = ObjectExtensions.operator_equals(typeRef, null);
      if (_equals) {
        appendable.append(surrogate);
      } else {
        TypeReferenceSerializer _typeReferenceSerializer = this.getTypeReferenceSerializer();
        EObject _context = this.getContext();
        _typeReferenceSerializer.serialize(typeRef, _context, appendable);
      }
      _xblockexpression = (appendable);
    }
    return _xblockexpression;
  }
  
  protected abstract TypeReferenceSerializer getTypeReferenceSerializer();
  
  protected IAppendable appendParameters(final IAppendable appendable, final List<JvmTypeReference> parameterTypes) {
    IAppendable _xblockexpression = null;
    {
      final Iterator<JvmTypeReference> iterator = parameterTypes.iterator();
      appendable.append("(");
      final HashSet<String> notAllowed = CollectionLiterals.<String>newHashSet();
      boolean _hasNext = iterator.hasNext();
      boolean _while = _hasNext;
      while (_while) {
        {
          final JvmTypeReference typeRef = iterator.next();
          boolean _notEquals = ObjectExtensions.operator_notEquals(typeRef, null);
          if (_notEquals) {
            this.appendType(appendable, typeRef, "Object");
            appendable.append(" ");
            VariableNameAcceptor _variableNameAcceptor = new VariableNameAcceptor(notAllowed);
            final VariableNameAcceptor acceptor = _variableNameAcceptor;
            String _identifier = typeRef.getIdentifier();
            EObject _context = this.getContext();
            this._jdtVariableCompletions.getVariableProposals(_identifier, _context, 
              VariableType.PARAMETER, notAllowed, acceptor);
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
  
  protected boolean isInterface(final JvmType t) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (t instanceof JvmGenericType) {
        final JvmGenericType _jvmGenericType = (JvmGenericType)t;
        _matched=true;
        boolean _isInterface = _jvmGenericType.isInterface();
        _switchResult = _isInterface;
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
}
