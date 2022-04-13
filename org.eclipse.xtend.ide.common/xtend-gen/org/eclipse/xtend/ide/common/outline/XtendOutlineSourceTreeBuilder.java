/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.common.outline;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.jvmmodel.DispatchHelper;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
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
    final Consumer<XtendTypeDeclaration> _function = (XtendTypeDeclaration it) -> {
      this.buildXtendType(it, context);
    };
    xtendFile.getXtendTypes().forEach(_function);
  }

  protected void _build(final XtendTypeDeclaration xtendType, final IXtendOutlineContext context) {
    this.buildMembers(xtendType, this._iXtendJvmAssociations.getInferredType(xtendType), context);
  }

  protected void buildXtendType(final XtendTypeDeclaration xtendType, final IXtendOutlineContext context) {
    final JvmDeclaredType inferredType = this._iXtendJvmAssociations.getInferredType(xtendType);
    final IXtendOutlineContext xtendTypeContext = this.xtendOutlineNodeBuilder.buildXtendNode(xtendType, context).markAsProcessed(inferredType);
    this.buildMembers(xtendType, inferredType, xtendTypeContext);
  }

  protected void buildMembers(final XtendTypeDeclaration xtendType, final JvmDeclaredType inferredType, final IXtendOutlineContext context) {
    if ((inferredType != null)) {
      final IXtendOutlineContext membersContext = context.newContext();
      this.buildMembers(xtendType, inferredType, inferredType, membersContext);
    } else {
      final Consumer<XtendMember> _function = (XtendMember it) -> {
        this.xtendOutlineNodeBuilder.buildEObjectNode(it, context);
      };
      xtendType.getMembers().forEach(_function);
    }
  }

  protected void buildMembers(final XtendTypeDeclaration xtendType, final JvmDeclaredType inferredType, final JvmDeclaredType baseType, @Extension final IXtendOutlineContext context) {
    if ((xtendType != null)) {
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
    boolean _isEmpty = jvmFeature.getLocalClasses().isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      EList<JvmGenericType> _localClasses = jvmFeature.getLocalClasses();
      for (final JvmGenericType jvmGenericType : _localClasses) {
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
    final Function1<JvmOperation, Boolean> _function = (JvmOperation it) -> {
      return Boolean.valueOf(this.dispatchHelper.isDispatcherFunction(it));
    };
    Iterable<JvmOperation> _filter = IterableExtensions.<JvmOperation>filter(inferredType.getDeclaredOperations(), _function);
    for (final JvmOperation dispatcher : _filter) {
      {
        final List<JvmOperation> dispatchCases = this.getDispatchCases(dispatcher, baseType, context);
        final IXtendOutlineContext dispatcherContext = this.xtendOutlineNodeBuilder.buildDispatcherNode(baseType, dispatcher, dispatchCases, context).markAsProcessed(dispatcher);
        for (final JvmOperation dispatchCase : dispatchCases) {
          EObject _elvis = null;
          XtendFunction _xtendFunction = this._iXtendJvmAssociations.getXtendFunction(dispatchCase);
          if (_xtendFunction != null) {
            _elvis = _xtendFunction;
          } else {
            _elvis = dispatchCase;
          }
          this.buildFeature(baseType, dispatchCase, _elvis, dispatcherContext).markAsProcessed(dispatchCase);
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
      final Comparator<JvmOperation> _function = (JvmOperation o1, JvmOperation o2) -> {
        int _indexOf = baseType.getMembers().indexOf(o1);
        int _indexOf_1 = baseType.getMembers().indexOf(o2);
        return (_indexOf - _indexOf_1);
      };
      _xifexpression = IterableExtensions.<JvmOperation>sortWith(this.dispatchHelper.getLocalDispatchCases(dispatcher), _function);
    }
    return _xifexpression;
  }

  protected boolean isDispatchRelated(final JvmFeature feature) {
    boolean _xifexpression = false;
    if ((feature instanceof JvmOperation)) {
      _xifexpression = (this.dispatchHelper.isDispatcherFunction(((JvmOperation)feature)) || this.dispatchHelper.isDispatchFunction(((JvmOperation)feature)));
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
