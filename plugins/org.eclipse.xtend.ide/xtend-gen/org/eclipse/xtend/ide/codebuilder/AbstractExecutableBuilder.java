/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
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
import org.eclipse.xtend.lib.annotations.Accessors;
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
import org.eclipse.xtext.xbase.lib.Pure;
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
  
  @Accessors
  private List<AbstractParameterBuilder> parameterBuilders = CollectionLiterals.<AbstractParameterBuilder>emptyList();
  
  @Accessors
  private List<LightweightTypeReference> exceptions = CollectionLiterals.<LightweightTypeReference>emptyList();
  
  @Accessors
  private List<JvmTypeParameter> typeParameters = CollectionLiterals.<JvmTypeParameter>emptyList();
  
  @Accessors
  private Procedure1<? super ISourceAppender> bodyGenerator;
  
  @Accessors
  private boolean varArgsFlag;
  
  public ISourceAppender appendBody(final ISourceAppender appendable, final String statementSeparator) {
    ISourceAppender _xblockexpression = null;
    {
      ISourceAppender _append = appendable.append(" {");
      ISourceAppender _increaseIndentation = _append.increaseIndentation();
      _increaseIndentation.newLine();
      boolean _notEquals = (!Objects.equal(this.bodyGenerator, null));
      if (_notEquals) {
        this.bodyGenerator.apply(appendable);
      } else {
        String _defaultBody = this.defaultBody();
        appendable.append(_defaultBody);
      }
      ISourceAppender _append_1 = appendable.append(statementSeparator);
      ISourceAppender _decreaseIndentation = _append_1.decreaseIndentation();
      ISourceAppender _newLine = _decreaseIndentation.newLine();
      _xblockexpression = _newLine.append("}");
    }
    return _xblockexpression;
  }
  
  protected String defaultBody() {
    return AbstractExecutableBuilder.DEFAULT_BODY;
  }
  
  @Override
  public void setContext(final EObject ctx) {
    super.setContext(ctx);
    for (final AbstractParameterBuilder it : this.parameterBuilders) {
      it.setContext(ctx);
    }
  }
  
  public AbstractParameterBuilder newParameterBuilder() {
    AbstractParameterBuilder _xblockexpression = null;
    {
      boolean _isEmpty = this.parameterBuilders.isEmpty();
      if (_isEmpty) {
        ArrayList<AbstractParameterBuilder> _newArrayList = CollectionLiterals.<AbstractParameterBuilder>newArrayList();
        this.parameterBuilders = _newArrayList;
      }
      JvmDeclaredType _owner = this.getOwner();
      final AbstractParameterBuilder builder = this._codeBuilderFactory.createParameterBuilder(_owner);
      EObject _context = this.getContext();
      builder.setContext(_context);
      this.parameterBuilders.add(builder);
      _xblockexpression = builder;
    }
    return _xblockexpression;
  }
  
  protected ISourceAppender appendParameters(final ISourceAppender appendable) {
    ISourceAppender _xblockexpression = null;
    {
      appendable.append("(");
      final HashSet<String> notAllowed = CollectionLiterals.<String>newHashSet();
      boolean _isEmpty = this.parameterBuilders.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        AbstractParameterBuilder _last = IterableExtensions.<AbstractParameterBuilder>last(this.parameterBuilders);
        _last.setVarArgsFlag(this.varArgsFlag);
      }
      int _size = this.parameterBuilders.size();
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, _size, true);
      for (final Integer i : _doubleDotLessThan) {
        {
          final AbstractParameterBuilder parameterBuilder = this.parameterBuilders.get((i).intValue());
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
          int _size_1 = this.parameterBuilders.size();
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
      final Iterator<LightweightTypeReference> iterator = this.exceptions.iterator();
      boolean _hasNext = iterator.hasNext();
      if (_hasNext) {
        appendable.append(" throws ");
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
        } while(iterator.hasNext());
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }
  
  @Override
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
  
  @Override
  public boolean isValid() {
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    final Function1<AbstractParameterBuilder, Boolean> _function = new Function1<AbstractParameterBuilder, Boolean>() {
      @Override
      public Boolean apply(final AbstractParameterBuilder it) {
        return Boolean.valueOf(it.isValid());
      }
    };
    boolean _forall = IterableExtensions.<AbstractParameterBuilder>forall(this.parameterBuilders, _function);
    if (!_forall) {
      _and_2 = false;
    } else {
      boolean _contains = this.exceptions.contains(null);
      boolean _not = (!_contains);
      _and_2 = _not;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _contains_1 = this.typeParameters.contains(null);
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
  
  @Pure
  public List<AbstractParameterBuilder> getParameterBuilders() {
    return this.parameterBuilders;
  }
  
  public void setParameterBuilders(final List<AbstractParameterBuilder> parameterBuilders) {
    this.parameterBuilders = parameterBuilders;
  }
  
  @Pure
  public List<LightweightTypeReference> getExceptions() {
    return this.exceptions;
  }
  
  public void setExceptions(final List<LightweightTypeReference> exceptions) {
    this.exceptions = exceptions;
  }
  
  @Pure
  public List<JvmTypeParameter> getTypeParameters() {
    return this.typeParameters;
  }
  
  public void setTypeParameters(final List<JvmTypeParameter> typeParameters) {
    this.typeParameters = typeParameters;
  }
  
  @Pure
  public Procedure1<? super ISourceAppender> getBodyGenerator() {
    return this.bodyGenerator;
  }
  
  public void setBodyGenerator(final Procedure1<? super ISourceAppender> bodyGenerator) {
    this.bodyGenerator = bodyGenerator;
  }
  
  @Pure
  public boolean isVarArgsFlag() {
    return this.varArgsFlag;
  }
  
  public void setVarArgsFlag(final boolean varArgsFlag) {
    this.varArgsFlag = varArgsFlag;
  }
}
