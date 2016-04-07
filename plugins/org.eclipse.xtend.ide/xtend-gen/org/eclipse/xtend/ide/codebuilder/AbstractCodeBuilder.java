/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.codebuilder;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeConstraint;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmUnknownTypeReference;
import org.eclipse.xtext.common.types.JvmUpperBound;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.jdt.IJavaElementFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.ISourceAppender;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

/**
 * @author Jan Koehnlein
 */
@SuppressWarnings("all")
public abstract class AbstractCodeBuilder implements ICodeBuilder {
  @Accessors
  private Object ownerSource;
  
  @Accessors
  private JvmDeclaredType owner;
  
  @Accessors
  private JvmVisibility visibility;
  
  @Accessors
  private EObject context;
  
  @Inject
  @Extension
  private IJavaElementFinder _iJavaElementFinder;
  
  @Inject
  private CommonTypeComputationServices services;
  
  @Override
  public boolean isValid() {
    final IJavaElement javaElement = this._iJavaElementFinder.findElementFor(this.owner);
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _or = false;
    boolean _equals = Objects.equal(javaElement, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _isReadOnly = javaElement.isReadOnly();
      boolean _not = (!_isReadOnly);
      _or = _not;
    }
    if (!_or) {
      _and_2 = false;
    } else {
      boolean _notEquals = (!Objects.equal(this.ownerSource, null));
      _and_2 = _notEquals;
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      boolean _notEquals_1 = (!Objects.equal(this.owner, null));
      _and_1 = _notEquals_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      boolean _notEquals_2 = (!Objects.equal(this.context, null));
      _and = _notEquals_2;
    }
    return _and;
  }
  
  @Override
  public String getPreview() {
    String _xblockexpression = null;
    {
      final StringBuilderBasedAppendable appendable = new StringBuilderBasedAppendable();
      IAppendable _append = appendable.append("...");
      IAppendable _newLine = _append.newLine();
      ISourceAppender _build = this.build(_newLine);
      ISourceAppender _newLine_1 = _build.newLine();
      _newLine_1.append("...");
      _xblockexpression = appendable.toString();
    }
    return _xblockexpression;
  }
  
  protected ISourceAppender appendVisibility(final ISourceAppender appendable, final JvmVisibility visibility, final JvmVisibility skippableDefault) {
    String _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(visibility, skippableDefault)) {
      _matched=true;
      _switchResult = "";
    }
    if (!_matched) {
      if (Objects.equal(visibility, JvmVisibility.PRIVATE)) {
        _matched=true;
        _switchResult = "private ";
      }
    }
    if (!_matched) {
      if (Objects.equal(visibility, JvmVisibility.PROTECTED)) {
        _matched=true;
        _switchResult = "protected ";
      }
    }
    if (!_matched) {
      if (Objects.equal(visibility, JvmVisibility.PUBLIC)) {
        _matched=true;
        _switchResult = "public ";
      }
    }
    if (!_matched) {
      _switchResult = "";
    }
    return appendable.append(_switchResult);
  }
  
  protected <T extends EObject> T findByFragment(final XtextResource resource, final T object) {
    final Resource myResource = object.eResource();
    boolean _equals = Objects.equal(myResource, resource);
    if (_equals) {
      return object;
    }
    final String fragment = myResource.getURIFragment(object);
    EObject _eObject = resource.getEObject(fragment);
    final T result = ((T) _eObject);
    return result;
  }
  
  protected ISourceAppender appendType(final ISourceAppender appendable, final LightweightTypeReference typeRef, final String surrogate) {
    ISourceAppender _xblockexpression = null;
    {
      boolean _equals = Objects.equal(typeRef, null);
      if (_equals) {
        appendable.append(surrogate);
      } else {
        appendable.append(typeRef);
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }
  
  protected ISourceAppender appendTypeParameters(final ISourceAppender appendable, final List<JvmTypeParameter> typeParameters) {
    ISourceAppender _xblockexpression = null;
    {
      final Iterator<JvmTypeParameter> iterator = typeParameters.iterator();
      boolean _hasNext = iterator.hasNext();
      if (_hasNext) {
        appendable.append("<");
        do {
          {
            final JvmTypeParameter typeParameter = iterator.next();
            String _name = typeParameter.getName();
            appendable.append(_name);
            EList<JvmTypeConstraint> _constraints = typeParameter.getConstraints();
            Iterable<JvmUpperBound> _filter = Iterables.<JvmUpperBound>filter(_constraints, JvmUpperBound.class);
            final Function1<JvmUpperBound, Boolean> _function = new Function1<JvmUpperBound, Boolean>() {
              @Override
              public Boolean apply(final JvmUpperBound it) {
                JvmTypeReference _typeReference = it.getTypeReference();
                String _identifier = _typeReference.getIdentifier();
                return Boolean.valueOf((!Objects.equal(_identifier, "java.lang.Object")));
              }
            };
            final Iterable<JvmUpperBound> upperBounds = IterableExtensions.<JvmUpperBound>filter(_filter, _function);
            boolean _isEmpty = IterableExtensions.isEmpty(upperBounds);
            boolean _not = (!_isEmpty);
            if (_not) {
              appendable.append(" extends ");
              boolean isFirst = true;
              final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, this.context);
              for (final JvmUpperBound upperBound : upperBounds) {
                {
                  if ((!isFirst)) {
                    appendable.append(" & ");
                  }
                  isFirst = false;
                  JvmTypeReference _typeReference = upperBound.getTypeReference();
                  LightweightTypeReference _lightweightTypeReference = owner.toLightweightTypeReference(_typeReference);
                  this.appendType(appendable, _lightweightTypeReference, "Object");
                }
              }
            }
            boolean _hasNext_1 = iterator.hasNext();
            if (_hasNext_1) {
              appendable.append(",");
            }
          }
        } while(iterator.hasNext());
        appendable.append("> ");
      }
      _xblockexpression = appendable;
    }
    return _xblockexpression;
  }
  
  protected String getIdentifierOrObject(final JvmTypeReference typeReference) {
    String _switchResult = null;
    boolean _matched = false;
    if (typeReference instanceof JvmUnknownTypeReference) {
      _matched=true;
      _switchResult = "java.lang.Object";
    }
    if (!_matched) {
      _switchResult = typeReference.getIdentifier();
    }
    return _switchResult;
  }
  
  protected boolean isInterface(final JvmType t) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (t instanceof JvmGenericType) {
      _matched=true;
      _switchResult = ((JvmGenericType)t).isInterface();
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  @Pure
  public Object getOwnerSource() {
    return this.ownerSource;
  }
  
  public void setOwnerSource(final Object ownerSource) {
    this.ownerSource = ownerSource;
  }
  
  @Pure
  public JvmDeclaredType getOwner() {
    return this.owner;
  }
  
  public void setOwner(final JvmDeclaredType owner) {
    this.owner = owner;
  }
  
  @Pure
  public JvmVisibility getVisibility() {
    return this.visibility;
  }
  
  public void setVisibility(final JvmVisibility visibility) {
    this.visibility = visibility;
  }
  
  @Pure
  public EObject getContext() {
    return this.context;
  }
  
  public void setContext(final EObject context) {
    this.context = context;
  }
}
