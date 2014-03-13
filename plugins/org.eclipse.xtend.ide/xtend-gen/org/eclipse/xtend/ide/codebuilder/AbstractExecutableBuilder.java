package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.ide.codebuilder.AbstractCodeBuilder;
import org.eclipse.xtend.ide.codebuilder.AbstractParameterBuilder;
import org.eclipse.xtend.ide.codebuilder.CodeBuilderFactory;
import org.eclipse.xtend.ide.codebuilder.VariableNameAcceptor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.xtext.ui.JdtVariableCompletions;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractExecutableBuilder extends AbstractCodeBuilder {
  public final static String DEFAULT_BODY = "throw new UnsupportedOperationException(\"TODO: auto-generated method stub\")";
  
  @Inject
  @Extension
  private JdtVariableCompletions _jdtVariableCompletions;
  
  @Inject
  @Extension
  private CodeBuilderFactory _codeBuilderFactory;
  
  private List<AbstractParameterBuilder> _parameterBuilders = CollectionLiterals.<AbstractParameterBuilder>emptyList();
  
  public List<AbstractParameterBuilder> getParameterBuilders() {
    return this._parameterBuilders;
  }
  
  public void setParameterBuilders(final List<AbstractParameterBuilder> parameterBuilders) {
    this._parameterBuilders = parameterBuilders;
  }
  
  private List<LightweightTypeReference> _exceptions = CollectionLiterals.<LightweightTypeReference>emptyList();
  
  public List<LightweightTypeReference> getExceptions() {
    return this._exceptions;
  }
  
  public void setExceptions(final List<LightweightTypeReference> exceptions) {
    this._exceptions = exceptions;
  }
  
  private List<JvmTypeParameter> _typeParameters = CollectionLiterals.<JvmTypeParameter>emptyList();
  
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
  
  private boolean _varArgsFlag;
  
  public boolean isVarArgsFlag() {
    return this._varArgsFlag;
  }
  
  public void setVarArgsFlag(final boolean varArgsFlag) {
    this._varArgsFlag = varArgsFlag;
  }
  
  public ISourceAppender appendBody(final ISourceAppender appendable, final String statementSeparator) {
    ISourceAppender _append = appendable.append(" {");
    ISourceAppender _increaseIndentation = _append.increaseIndentation();
    ISourceAppender _newLine = _increaseIndentation.newLine();
    String _elvis = null;
    String _body = this.getBody();
    if (_body != null) {
      _elvis = _body;
    } else {
      String _defaultBody = this.defaultBody();
      _elvis = _defaultBody;
    }
    ISourceAppender _append_1 = _newLine.append(_elvis);
    ISourceAppender _append_2 = _append_1.append(statementSeparator);
    ISourceAppender _decreaseIndentation = _append_2.decreaseIndentation();
    ISourceAppender _newLine_1 = _decreaseIndentation.newLine();
    return _newLine_1.append("}");
  }
  
  protected String defaultBody() {
    return AbstractExecutableBuilder.DEFAULT_BODY;
  }
  
  public void setContext(final EObject ctx) {
    super.setContext(ctx);
    List<AbstractParameterBuilder> _parameterBuilders = this.getParameterBuilders();
    final Procedure1<AbstractParameterBuilder> _function = new Procedure1<AbstractParameterBuilder>() {
      public void apply(final AbstractParameterBuilder it) {
        it.setContext(ctx);
      }
    };
    IterableExtensions.<AbstractParameterBuilder>forEach(_parameterBuilders, _function);
  }
  
  public AbstractParameterBuilder newParameterBuilder() {
    AbstractParameterBuilder _xblockexpression = null;
    {
      List<AbstractParameterBuilder> _parameterBuilders = this.getParameterBuilders();
      boolean _isEmpty = _parameterBuilders.isEmpty();
      if (_isEmpty) {
        ArrayList<AbstractParameterBuilder> _newArrayList = CollectionLiterals.<AbstractParameterBuilder>newArrayList();
        this.setParameterBuilders(_newArrayList);
      }
      JvmDeclaredType _owner = this.getOwner();
      final AbstractParameterBuilder builder = this._codeBuilderFactory.createParameterBuilder(_owner);
      EObject _context = this.getContext();
      builder.setContext(_context);
      List<AbstractParameterBuilder> _parameterBuilders_1 = this.getParameterBuilders();
      _parameterBuilders_1.add(builder);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }
  
  protected ISourceAppender appendParameters(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      appendable.append("(");
      final HashSet<String> notAllowed = CollectionLiterals.<String>newHashSet();
      List<AbstractParameterBuilder> _parameterBuilders = this.getParameterBuilders();
      boolean _isEmpty = _parameterBuilders.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        List<AbstractParameterBuilder> _parameterBuilders_1 = this.getParameterBuilders();
        AbstractParameterBuilder _last = IterableExtensions.<AbstractParameterBuilder>last(_parameterBuilders_1);
        boolean _isVarArgsFlag = this.isVarArgsFlag();
        _last.setVarArgsFlag(_isVarArgsFlag);
      }
      List<AbstractParameterBuilder> _parameterBuilders_2 = this.getParameterBuilders();
      int _size = _parameterBuilders_2.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for (final Integer i : _doubleDotLessThan) {
        {
          List<AbstractParameterBuilder> _parameterBuilders_3 = this.getParameterBuilders();
          final AbstractParameterBuilder parameterBuilder = _parameterBuilders_3.get((i).intValue());
          final VariableNameAcceptor acceptor = new VariableNameAcceptor(notAllowed);
          String _name = parameterBuilder.getName();
          boolean _equals = Objects.equal(_name, null);
          if (_equals) {
            LightweightTypeReference _type = parameterBuilder.getType();
            String _identifier = _type.getIdentifier();
            EObject _context = this.getContext();
            this._jdtVariableCompletions.getVariableProposals(_identifier, _context, 
              JdtVariableCompletions.VariableType.PARAMETER, notAllowed, acceptor);
            String _variableName = acceptor.getVariableName();
            parameterBuilder.setName(_variableName);
          }
          parameterBuilder.build(appendable);
          List<AbstractParameterBuilder> _parameterBuilders_4 = this.getParameterBuilders();
          int _size_1 = _parameterBuilders_4.size();
          int _minus = (_size_1 - 1);
          boolean _notEquals = ((i).intValue() != _minus);
          if (_notEquals) {
            appendable.append(", ");
          }
        }
      }
      _xblockexpression = appendable.append(")");
    }
    return _xblockexpression;
  }
  
  protected ISourceAppender appendThrowsClause(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      List<LightweightTypeReference> _exceptions = this.getExceptions();
      final Iterator<LightweightTypeReference> iterator = _exceptions.iterator();
      boolean _hasNext = iterator.hasNext();
      if (_hasNext) {
        appendable.append(" throws ");
        boolean _dowhile = false;
        do {
          {
            final LightweightTypeReference typeRef = iterator.next();
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
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }
  
  public String getImage() {
    String _switchResult = null;
    JvmVisibility _visibility = this.getVisibility();
    if (_visibility != null) {
      switch (_visibility) {
        case PRIVATE:
          _switchResult = "methpri_obj.gif";
          break;
        case PROTECTED:
          _switchResult = "methpro_obj.gif";
          break;
        case PUBLIC:
          _switchResult = "methpub_obj.gif";
          break;
        default:
          _switchResult = "methdef_obj.gif";
          break;
      }
    } else {
      _switchResult = "methdef_obj.gif";
    }
    return _switchResult;
  }
  
  public boolean isValid() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    List<AbstractParameterBuilder> _parameterBuilders = this.getParameterBuilders();
    final Function1<AbstractParameterBuilder, Boolean> _function = new Function1<AbstractParameterBuilder, Boolean>() {
      public Boolean apply(final AbstractParameterBuilder it) {
        return Boolean.valueOf(it.isValid());
      }
    };
    boolean _forall = IterableExtensions.<AbstractParameterBuilder>forall(_parameterBuilders, _function);
    if (!_forall) {
      _and_2 = false;
    } else {
      List<LightweightTypeReference> _exceptions = this.getExceptions();
      boolean _contains = _exceptions.contains(null);
      boolean _not = (!_contains);
      _and_2 = _not;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      List<JvmTypeParameter> _typeParameters = this.getTypeParameters();
      boolean _contains_1 = _typeParameters.contains(null);
      boolean _not_1 = (!_contains_1);
      _and_1 = _not_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _isValid = super.isValid();
      _and = _isValid;
    }
    return _and;
  }
}
