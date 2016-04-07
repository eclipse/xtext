/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.common.outline;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.DispatchHelper;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.common.outline.AbstractXtendOutlineTreeBuilder;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineTreeBuilder;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendOutlineSourceTreeBuilder extends AbstractXtendOutlineTreeBuilder implements IXtendOutlineTreeBuilder {
  @Inject
  @Extension
  private DispatchHelper dispatchHelper;
  
  protected void _build(final XtendFile xtendFile, final IXtendOutlineContext context) {
    this.buildPackageAndImportSection(xtendFile, context);
    EList<XtendTypeDeclaration> _xtendTypes = xtendFile.getXtendTypes();
    for (final XtendTypeDeclaration it : _xtendTypes) {
      this.buildXtendType(it, context);
    }
  }
  
  protected void _build(final XtendTypeDeclaration xtendType, final IXtendOutlineContext context) {
    JvmDeclaredType _inferredType = this._iXtendJvmAssociations.getInferredType(xtendType);
    this.buildMembers(xtendType, _inferredType, context);
  }
  
  protected void buildXtendType(final XtendTypeDeclaration xtendType, final IXtendOutlineContext context) {
    final JvmDeclaredType inferredType = this._iXtendJvmAssociations.getInferredType(xtendType);
    IXtendOutlineContext _buildXtendNode = this.xtendOutlineNodeBuilder.buildXtendNode(xtendType, context);
    final IXtendOutlineContext xtendTypeContext = _buildXtendNode.markAsProcessed(inferredType);
    this.buildMembers(xtendType, inferredType, xtendTypeContext);
  }
  
  protected void buildMembers(final XtendTypeDeclaration xtendType, final JvmDeclaredType inferredType, final IXtendOutlineContext context) {
    boolean _notEquals = (!Objects.equal(inferredType, null));
    if (_notEquals) {
      final IXtendOutlineContext membersContext = context.newContext();
      this.buildMembers(xtendType, inferredType, inferredType, membersContext);
    } else {
      EList<XtendMember> _members = xtendType.getMembers();
      for (final XtendMember it : _members) {
        this.xtendOutlineNodeBuilder.buildEObjectNode(it, context);
      }
    }
  }
  
  protected void buildMembers(final XtendTypeDeclaration xtendType, final JvmDeclaredType inferredType, final JvmDeclaredType baseType, @Extension final IXtendOutlineContext context) {
    boolean _notEquals = (!Objects.equal(xtendType, null));
    if (_notEquals) {
      EList<XtendMember> _members = xtendType.getMembers();
      for (final XtendMember member : _members) {
        {
          final EObject jvmElement = this._iXtendJvmAssociations.getPrimaryJvmElement(member);
          if ((jvmElement instanceof JvmMember)) {
            boolean _isProcessed = context.isProcessed(((JvmMember)jvmElement));
            boolean _not = (!_isProcessed);
            if (_not) {
              if ((member instanceof XtendTypeDeclaration)) {
                IXtendOutlineContext _xifexpression = null;
                boolean _isShowInherited = context.isShowInherited();
                if (_isShowInherited) {
                  _xifexpression = context.newContext();
                } else {
                  _xifexpression = context;
                }
                this.buildXtendType(((XtendTypeDeclaration)member), _xifexpression);
              } else {
                if ((jvmElement instanceof JvmFeature)) {
                  boolean _skipFeature = this.skipFeature(((JvmFeature)jvmElement));
                  boolean _not_1 = (!_skipFeature);
                  if (_not_1) {
                    boolean _isDispatchRelated = this.isDispatchRelated(((JvmFeature)jvmElement));
                    if (_isDispatchRelated) {
                      this.buildDispatchers(inferredType, baseType, context);
                    } else {
                      final IXtendOutlineContext featureContext = this.buildFeature(inferredType, ((JvmFeature)jvmElement), member, context);
                      this.buildLocalClasses(((JvmFeature)jvmElement), featureContext);
                    }
                  }
                }
              }
              context.markAsProcessed(((JvmMember)jvmElement));
            }
          }
        }
      }
    }
    boolean _isShowInherited = context.isShowInherited();
    if (_isShowInherited) {
      this.buildInheritedMembers(inferredType, context);
    }
  }
  
  protected void buildLocalClasses(final JvmFeature jvmFeature, final IXtendOutlineContext context) {
    EList<JvmGenericType> _localClasses = jvmFeature.getLocalClasses();
    boolean _isEmpty = _localClasses.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<JvmGenericType> _localClasses_1 = jvmFeature.getLocalClasses();
      for (final JvmGenericType jvmGenericType : _localClasses_1) {
        {
          final IXtendOutlineContext typeContext = context.newContext();
          Set<EObject> _sourceElements = this._iXtendJvmAssociations.getSourceElements(jvmGenericType);
          for (final EObject sourceElement : _sourceElements) {
            this.buildType(sourceElement, typeContext);
          }
        }
      }
    }
  }
  
  protected void buildDispatchers(final JvmDeclaredType inferredType, final JvmDeclaredType baseType, final IXtendOutlineContext context) {
    Iterable<JvmOperation> _declaredOperations = inferredType.getDeclaredOperations();
    final Function1<JvmOperation, Boolean> _function = new Function1<JvmOperation, Boolean>() {
      @Override
      public Boolean apply(final JvmOperation it) {
        return Boolean.valueOf(XtendOutlineSourceTreeBuilder.this.dispatchHelper.isDispatcherFunction(it));
      }
    };
    Iterable<JvmOperation> _filter = IterableExtensions.<JvmOperation>filter(_declaredOperations, _function);
    for (final JvmOperation dispatcher : _filter) {
      {
        final List<JvmOperation> dispatchCases = this.getDispatchCases(dispatcher, baseType, context);
        IXtendOutlineContext _buildDispatcherNode = this.xtendOutlineNodeBuilder.buildDispatcherNode(baseType, dispatcher, dispatchCases, context);
        final IXtendOutlineContext dispatcherContext = _buildDispatcherNode.markAsProcessed(dispatcher);
        for (final JvmOperation dispatchCase : dispatchCases) {
          EObject _elvis = null;
          XtendFunction _xtendFunction = this._iXtendJvmAssociations.getXtendFunction(dispatchCase);
          if (_xtendFunction != null) {
            _elvis = _xtendFunction;
          } else {
            _elvis = dispatchCase;
          }
          IXtendOutlineContext _buildFeature = this.buildFeature(baseType, dispatchCase, _elvis, dispatcherContext);
          _buildFeature.markAsProcessed(dispatchCase);
        }
      }
    }
  }
  
  protected List<JvmOperation> getDispatchCases(final JvmOperation dispatcher, final JvmDeclaredType baseType, final IXtendOutlineContext context) {
    List<JvmOperation> _xifexpression = null;
    boolean _isShowInherited = context.isShowInherited();
    if (_isShowInherited) {
      _xifexpression = this.dispatchHelper.getAllDispatchCases(dispatcher);
    } else {
      List<JvmOperation> _localDispatchCases = this.dispatchHelper.getLocalDispatchCases(dispatcher);
      final Comparator<JvmOperation> _function = new Comparator<JvmOperation>() {
        @Override
        public int compare(final JvmOperation o1, final JvmOperation o2) {
          EList<JvmMember> _members = baseType.getMembers();
          int _indexOf = _members.indexOf(o1);
          EList<JvmMember> _members_1 = baseType.getMembers();
          int _indexOf_1 = _members_1.indexOf(o2);
          return (_indexOf - _indexOf_1);
        }
      };
      _xifexpression = IterableExtensions.<JvmOperation>sortWith(_localDispatchCases, _function);
    }
    return _xifexpression;
  }
  
  protected boolean isDispatchRelated(final JvmFeature feature) {
    boolean _xifexpression = false;
    if ((feature instanceof JvmOperation)) {
      boolean _or = false;
      boolean _isDispatcherFunction = this.dispatchHelper.isDispatcherFunction(((JvmOperation)feature));
      if (_isDispatcherFunction) {
        _or = true;
      } else {
        boolean _isDispatchFunction = this.dispatchHelper.isDispatchFunction(((JvmOperation)feature));
        _or = _isDispatchFunction;
      }
      _xifexpression = _or;
    }
    return _xifexpression;
  }
  
  @Override
  protected void buildType(final EObject someType, final IXtendOutlineContext context) {
    if ((someType instanceof XtendTypeDeclaration)) {
      this.buildXtendType(((XtendTypeDeclaration)someType), context);
    }
  }
  
  public void build(final EObject xtendType, final IXtendOutlineContext context) {
    if (xtendType instanceof XtendTypeDeclaration) {
      _build((XtendTypeDeclaration)xtendType, context);
      return;
    } else if (xtendType instanceof XtendFile) {
      _build((XtendFile)xtendType, context);
      return;
    } else if (xtendType != null) {
      _build(xtendType, context);
      return;
    } else if (xtendType == null) {
      _build((Void)null, context);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(xtendType, context).toString());
    }
  }
}
