/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.common.outline;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineNodeBuilder;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineTreeBuilder;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedField;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.override.ResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractXtendOutlineTreeBuilder implements IXtendOutlineTreeBuilder {
  @Inject
  @Extension
  private JvmTypeExtensions _jvmTypeExtensions;
  
  @Inject
  private CommonTypeComputationServices services;
  
  @Inject
  @Extension
  protected IXtendJvmAssociations _iXtendJvmAssociations;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  @Extension
  protected IXtendOutlineNodeBuilder xtendOutlineNodeBuilder;
  
  protected void _build(final Void modelElement, final IXtendOutlineContext context) {
  }
  
  protected void _build(final EObject modelElement, final IXtendOutlineContext context) {
    EList<EObject> _eContents = modelElement.eContents();
    final Procedure1<EObject> _function = new Procedure1<EObject>() {
      @Override
      public void apply(final EObject it) {
        AbstractXtendOutlineTreeBuilder.this.xtendOutlineNodeBuilder.buildEObjectNode(it, context);
      }
    };
    IterableExtensions.<EObject>forEach(_eContents, _function);
  }
  
  protected void buildPackageAndImportSection(final XtendFile xtendFile, final IXtendOutlineContext context) {
    String _package = xtendFile.getPackage();
    boolean _notEquals = (!Objects.equal(_package, null));
    if (_notEquals) {
      this.xtendOutlineNodeBuilder.buildPackageNode(xtendFile, context);
    }
    boolean _and = false;
    XImportSection _importSection = xtendFile.getImportSection();
    boolean _notEquals_1 = (!Objects.equal(_importSection, null));
    if (!_notEquals_1) {
      _and = false;
    } else {
      XImportSection _importSection_1 = xtendFile.getImportSection();
      EList<XImportDeclaration> _importDeclarations = _importSection_1.getImportDeclarations();
      boolean _isEmpty = _importDeclarations.isEmpty();
      boolean _not = (!_isEmpty);
      _and = _not;
    }
    if (_and) {
      this.xtendOutlineNodeBuilder.buildImportSectionNode(xtendFile, context);
    }
  }
  
  protected void buildInheritedMembers(final JvmDeclaredType inferredType, final IXtendOutlineContext context) {
    Resource _eResource = inferredType.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(this.services, _resourceSet);
    final LightweightTypeReference typeReference = owner.toLightweightTypeReference(inferredType);
    final List<LightweightTypeReference> superTypes = typeReference.getAllSuperTypes();
    IXtendOutlineContext superTypeContext = context;
    for (final LightweightTypeReference superTypeRef : superTypes) {
      {
        IXtendOutlineContext _increaseInheritanceDepth = superTypeContext.increaseInheritanceDepth();
        superTypeContext = _increaseInheritanceDepth;
        final ResolvedFeatures resolvedFeatures = new ResolvedFeatures(superTypeRef);
        List<IResolvedField> _declaredFields = resolvedFeatures.getDeclaredFields();
        for (final IResolvedField jvmField : _declaredFields) {
          JvmField _declaration = jvmField.getDeclaration();
          boolean _skipFeature = this.skipFeature(_declaration);
          boolean _not = (!_skipFeature);
          if (_not) {
            this.xtendOutlineNodeBuilder.buildResolvedFeatureNode(inferredType, jvmField, superTypeContext);
          }
        }
        List<IResolvedConstructor> _declaredConstructors = resolvedFeatures.getDeclaredConstructors();
        for (final IResolvedConstructor constructor : _declaredConstructors) {
          JvmConstructor _declaration_1 = constructor.getDeclaration();
          boolean _skipFeature_1 = this.skipFeature(_declaration_1);
          boolean _not_1 = (!_skipFeature_1);
          if (_not_1) {
            this.xtendOutlineNodeBuilder.buildResolvedFeatureNode(inferredType, constructor, superTypeContext);
          }
        }
        List<IResolvedOperation> _declaredOperations = resolvedFeatures.getDeclaredOperations();
        for (final IResolvedOperation operation : _declaredOperations) {
          boolean _and = false;
          JvmOperation _declaration_2 = operation.getDeclaration();
          boolean _skipFeature_2 = this.skipFeature(_declaration_2);
          boolean _not_2 = (!_skipFeature_2);
          if (!_not_2) {
            _and = false;
          } else {
            JvmOperation _declaration_3 = operation.getDeclaration();
            boolean _isProcessed = superTypeContext.isProcessed(_declaration_3);
            boolean _not_3 = (!_isProcessed);
            _and = _not_3;
          }
          if (_and) {
            this.xtendOutlineNodeBuilder.buildResolvedFeatureNode(inferredType, operation, superTypeContext);
          }
        }
        final JvmType declaredType = superTypeRef.getType();
        if ((declaredType instanceof JvmDeclaredType)) {
          final IXtendOutlineContext nestedTypeContext = superTypeContext.hideInherited();
          EList<JvmMember> _members = ((JvmDeclaredType)declaredType).getMembers();
          Iterable<JvmDeclaredType> _filter = Iterables.<JvmDeclaredType>filter(_members, JvmDeclaredType.class);
          final Procedure1<JvmDeclaredType> _function = new Procedure1<JvmDeclaredType>() {
            @Override
            public void apply(final JvmDeclaredType it) {
              AbstractXtendOutlineTreeBuilder.this.buildJvmType(it, nestedTypeContext);
            }
          };
          IterableExtensions.<JvmDeclaredType>forEach(_filter, _function);
        }
      }
    }
  }
  
  protected boolean skipFeature(final JvmFeature feature) {
    boolean _xifexpression = false;
    if ((feature instanceof JvmConstructor)) {
      boolean _or = false;
      JvmDeclaredType _declaringType = ((JvmConstructor)feature).getDeclaringType();
      boolean _isLocal = _declaringType.isLocal();
      if (_isLocal) {
        _or = true;
      } else {
        boolean _isSingleSyntheticDefaultConstructor = this._jvmTypeExtensions.isSingleSyntheticDefaultConstructor(((JvmConstructor)feature));
        _or = _isSingleSyntheticDefaultConstructor;
      }
      _xifexpression = _or;
    }
    return _xifexpression;
  }
  
  protected void buildJvmType(final JvmDeclaredType typeElement, final IXtendOutlineContext context) {
    final IXtendOutlineContext jvmTypeContext = this.xtendOutlineNodeBuilder.buildXtendNode(typeElement, context);
    boolean _isProcessed = jvmTypeContext.isProcessed(typeElement);
    boolean _not = (!_isProcessed);
    if (_not) {
      jvmTypeContext.markAsProcessed(typeElement);
      this.buildMembers(typeElement, typeElement, jvmTypeContext);
    }
  }
  
  protected void buildMembers(final JvmDeclaredType inferredType, final JvmDeclaredType baseType, @Extension final IXtendOutlineContext context) {
    EList<JvmMember> _members = inferredType.getMembers();
    for (final JvmMember member : _members) {
      boolean _isProcessed = context.isProcessed(member);
      boolean _not = (!_isProcessed);
      if (_not) {
        if ((member instanceof JvmDeclaredType)) {
          boolean _isShowInherited = context.isShowInherited();
          if (_isShowInherited) {
            final IXtendOutlineContext typeContext = context.newContext();
            final EObject sourceElement = this._iXtendJvmAssociations.getPrimarySourceElement(member);
            if ((sourceElement instanceof XtendTypeDeclaration)) {
              this.buildType(sourceElement, typeContext);
            } else {
              this.buildJvmType(((JvmDeclaredType)member), typeContext);
            }
          } else {
            this.buildJvmType(((JvmDeclaredType)member), context);
          }
        } else {
          if ((member instanceof JvmFeature)) {
            boolean _skipFeature = this.skipFeature(((JvmFeature)member));
            boolean _not_1 = (!_skipFeature);
            if (_not_1) {
              final IXtendOutlineContext featureContext = this.buildFeature(baseType, ((JvmFeature)member), member, context);
              EList<JvmGenericType> _localClasses = ((JvmFeature)member).getLocalClasses();
              final Procedure1<JvmGenericType> _function = new Procedure1<JvmGenericType>() {
                @Override
                public void apply(final JvmGenericType it) {
                  IXtendOutlineContext _newContext = featureContext.newContext();
                  AbstractXtendOutlineTreeBuilder.this.buildJvmType(it, _newContext);
                }
              };
              IterableExtensions.<JvmGenericType>forEach(_localClasses, _function);
            }
          }
        }
        context.markAsProcessed(member);
      }
    }
    boolean _isShowInherited_1 = context.isShowInherited();
    if (_isShowInherited_1) {
      this.buildInheritedMembers(inferredType, context);
    }
  }
  
  protected IXtendOutlineContext buildFeature(final JvmDeclaredType inferredType, final JvmFeature jvmFeature, final EObject semanticFeature, final IXtendOutlineContext context) {
    IXtendOutlineContext _xifexpression = null;
    boolean _isSynthetic = this._jvmTypeExtensions.isSynthetic(jvmFeature);
    boolean _not = (!_isSynthetic);
    if (_not) {
      _xifexpression = this.xtendOutlineNodeBuilder.buildFeatureNode(inferredType, semanticFeature, context);
    }
    return _xifexpression;
  }
  
  protected abstract void buildType(final EObject someType, final IXtendOutlineContext context);
  
  public void build(final EObject modelElement, final IXtendOutlineContext context) {
    if (modelElement != null) {
      _build(modelElement, context);
      return;
    } else if (modelElement == null) {
      _build((Void)null, context);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(modelElement, context).toString());
    }
  }
  
  public void setXtendOutlineNodeBuilder(final IXtendOutlineNodeBuilder xtendOutlineNodeBuilder) {
    this.xtendOutlineNodeBuilder = xtendOutlineNodeBuilder;
  }
}
