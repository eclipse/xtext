/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.icons.AllIcons;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.newStructureView.TreeActionsOwner;
import com.intellij.navigation.ItemPresentation;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.idea.structureview.IntellijXtendOutlineContext;
import org.eclipse.xtend.core.idea.structureview.XtendEObjectTreeElement;
import org.eclipse.xtend.core.idea.structureview.XtendFeatureTreeElement;
import org.eclipse.xtend.core.idea.structureview.XtendShowInheritedNodeProvider;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineContext;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineNodeBuilder;
import org.eclipse.xtend.ide.common.outline.IXtendOutlineTreeBuilder;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.idea.structureview.DefaultStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.EObjectTreeElement;
import org.eclipse.xtext.idea.structureview.EStructuralFeatureTreeElement;
import org.eclipse.xtext.idea.structureview.XtextFileTreeElement;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypeExtensions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeature;
import org.eclipse.xtext.xtype.XtypePackage;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendStructureViewTreeElementProvider extends DefaultStructureViewTreeElementProvider implements IXtendOutlineNodeBuilder {
  @Accessors
  private TreeActionsOwner treeActionsOwner;
  
  @Accessors
  private IXtendOutlineTreeBuilder xtendOutlineTreeBuilder;
  
  @Inject
  @Extension
  private JvmTypeExtensions jvmTypeExtensions;
  
  @Inject
  private Provider<XtendEObjectTreeElement> xtendEObjectTreeElementProvider;
  
  @Inject
  private Provider<XtendFeatureTreeElement> xtendFeatureTreeElementProvider;
  
  @Override
  protected void _buildChildren(final XtextFileTreeElement xtextFileTreeElement) {
    EObject _head = IterableExtensions.<EObject>head(xtextFileTreeElement.getElement().getResource().getContents());
    IntellijXtendOutlineContext _intellijXtendOutlineContext = new IntellijXtendOutlineContext();
    final Procedure1<IntellijXtendOutlineContext> _function = (IntellijXtendOutlineContext it) -> {
      it.setShowInherited(this.isShowInherited());
      it.setXtextFile(xtextFileTreeElement.getElement());
      it.setStructureViewTreeElement(xtextFileTreeElement);
    };
    IntellijXtendOutlineContext _doubleArrow = ObjectExtensions.<IntellijXtendOutlineContext>operator_doubleArrow(_intellijXtendOutlineContext, _function);
    this.xtendOutlineTreeBuilder.build(_head, _doubleArrow);
  }
  
  @Override
  protected void _buildChildren(final EObjectTreeElement objectTreeElement) {
    IntellijXtendOutlineContext _intellijXtendOutlineContext = new IntellijXtendOutlineContext();
    final Procedure1<IntellijXtendOutlineContext> _function = (IntellijXtendOutlineContext it) -> {
      it.setShowInherited(this.isShowInherited());
      it.setXtextFile(objectTreeElement.getXtextFile());
      it.setStructureViewTreeElement(objectTreeElement);
    };
    IntellijXtendOutlineContext _doubleArrow = ObjectExtensions.<IntellijXtendOutlineContext>operator_doubleArrow(_intellijXtendOutlineContext, _function);
    this.xtendOutlineTreeBuilder.build(
      objectTreeElement.getObject(), _doubleArrow);
  }
  
  protected boolean isShowInherited() {
    boolean _xblockexpression = false;
    {
      if ((this.treeActionsOwner == null)) {
        return false;
      }
      _xblockexpression = this.treeActionsOwner.isActionActive(XtendShowInheritedNodeProvider.ID);
    }
    return _xblockexpression;
  }
  
  @Override
  public IXtendOutlineContext buildEObjectNode(final EObject modelElement, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      _xblockexpression = intellijContext.withStructureViewTreeElement(
        this.createEObjectTreeElement(modelElement, intellijContext.getXtextFile()));
    }
    return _xblockexpression;
  }
  
  @Override
  public IXtendOutlineContext buildXtendNode(final EObject modelElement, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      _xblockexpression = intellijContext.withStructureViewTreeElement(
        this.createEObjectTreeElement(modelElement, intellijContext.getXtextFile()));
    }
    return _xblockexpression;
  }
  
  @Override
  public IXtendOutlineContext buildFeatureNode(final JvmDeclaredType inferredType, final EObject semanticFeature, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      _xblockexpression = intellijContext.withStructureViewTreeElement(
        this.createXtendFeatureTreeElement(semanticFeature, 
          true, 
          this.itemPresentationProvider.getItemPresentation(semanticFeature), intellijContext));
    }
    return _xblockexpression;
  }
  
  @Override
  public IXtendOutlineContext buildDispatcherNode(final JvmDeclaredType baseType, final JvmFeature dispatcher, final List<JvmOperation> dispatchCases, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      XtendFeatureTreeElement _createXtendFeatureTreeElement = this.createXtendFeatureTreeElement(dispatcher, 
        true, 
        this.itemPresentationProvider.getItemPresentation(dispatcher), intellijContext);
      final Procedure1<XtendFeatureTreeElement> _function = (XtendFeatureTreeElement it) -> {
        it.setDispatch(true);
      };
      XtendFeatureTreeElement _doubleArrow = ObjectExtensions.<XtendFeatureTreeElement>operator_doubleArrow(_createXtendFeatureTreeElement, _function);
      _xblockexpression = intellijContext.withStructureViewTreeElement(_doubleArrow);
    }
    return _xblockexpression;
  }
  
  @Override
  public IXtendOutlineContext buildPackageNode(final XtendFile xtendFile, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      PresentationData _presentationData = new PresentationData();
      final Procedure1<PresentationData> _function = (PresentationData it) -> {
        it.setIcon(AllIcons.Nodes.Package);
        it.setPresentableText(xtendFile.getPackage());
      };
      PresentationData _doubleArrow = ObjectExtensions.<PresentationData>operator_doubleArrow(_presentationData, _function);
      _xblockexpression = intellijContext.withStructureViewTreeElement(
        this.createEStructuralFeatureTreeElement(xtendFile, 
          XtendPackage.Literals.XTEND_FILE__PACKAGE, 
          intellijContext.getXtextFile(), 
          true, _doubleArrow));
    }
    return _xblockexpression;
  }
  
  @Override
  public IXtendOutlineContext buildImportSectionNode(final XtendFile xtendFile, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      _xblockexpression = intellijContext.withStructureViewTreeElement(
        this.createEStructuralFeatureTreeElement(xtendFile.getImportSection(), 
          XtypePackage.Literals.XIMPORT_SECTION__IMPORT_DECLARATIONS, 
          intellijContext.getXtextFile(), 
          false, 
          this.itemPresentationProvider.getItemPresentation(xtendFile.getImportSection())));
    }
    return _xblockexpression;
  }
  
  @Override
  public IXtendOutlineContext buildResolvedFeatureNode(final JvmDeclaredType inferredType, final IResolvedFeature resolvedFeature, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      _xblockexpression = intellijContext.withStructureViewTreeElement(
        this.createXtendFeatureTreeElement(resolvedFeature.getDeclaration(), 
          true, 
          this.itemPresentationProvider.getItemPresentation(resolvedFeature), intellijContext));
    }
    return _xblockexpression;
  }
  
  protected XtendFeatureTreeElement createXtendFeatureTreeElement(final EObject modelElement, final boolean leaf, final ItemPresentation presentation, final IntellijXtendOutlineContext context) {
    XtendFeatureTreeElement _configureTreeElement = this.<XtendFeatureTreeElement>configureTreeElement(this.xtendFeatureTreeElementProvider.get(), modelElement, leaf, presentation, context);
    final Procedure1<XtendFeatureTreeElement> _function = (XtendFeatureTreeElement it) -> {
      it.setSynthetic(this.isSynthetic(modelElement));
    };
    return ObjectExtensions.<XtendFeatureTreeElement>operator_doubleArrow(_configureTreeElement, _function);
  }
  
  protected XtendEObjectTreeElement createXtendEObjectTreeElement(final EObject modelElement, final boolean leaf, final ItemPresentation presentation, final IntellijXtendOutlineContext context) {
    return this.<XtendEObjectTreeElement>configureTreeElement(this.xtendEObjectTreeElementProvider.get(), modelElement, leaf, presentation, context);
  }
  
  protected <T extends XtendEObjectTreeElement> T configureTreeElement(final T objectTreeElement, final EObject modelElement, final boolean leaf, final ItemPresentation presentation, final IntellijXtendOutlineContext context) {
    T _xblockexpression = null;
    {
      objectTreeElement.setObject(modelElement);
      objectTreeElement.setXtextFile(context.getXtextFile());
      objectTreeElement.setLeaf(leaf);
      objectTreeElement.setItemPresentation(presentation);
      objectTreeElement.setStructureViewTreeElementProvider(this);
      objectTreeElement.setStatic(this.isStatic(modelElement));
      objectTreeElement.setInheritanceDepth(context.getInheritanceDepth());
      _xblockexpression = objectTreeElement;
    }
    return _xblockexpression;
  }
  
  protected boolean isSynthetic(final EObject modelElement) {
    boolean _xifexpression = false;
    if ((modelElement instanceof JvmIdentifiableElement)) {
      _xifexpression = this.jvmTypeExtensions.isSynthetic(((JvmIdentifiableElement)modelElement));
    }
    return _xifexpression;
  }
  
  protected boolean isStatic(final EObject modelElement) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (modelElement instanceof JvmFeature) {
      _matched=true;
      _switchResult = ((JvmFeature)modelElement).isStatic();
    }
    if (!_matched) {
      if (modelElement instanceof JvmDeclaredType) {
        _matched=true;
        _switchResult = ((JvmDeclaredType)modelElement).isStatic();
      }
    }
    if (!_matched) {
      if (modelElement instanceof XtendMember) {
        _matched=true;
        _switchResult = ((XtendMember)modelElement).isStatic();
      }
    }
    if (!_matched) {
      _switchResult = false;
    }
    return _switchResult;
  }
  
  @Override
  protected boolean isLeaf(final EObject modelElement) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (modelElement instanceof JvmDeclaredType) {
      _matched=true;
      _switchResult = ((JvmDeclaredType)modelElement).getMembers().isEmpty();
    }
    if (!_matched) {
      if (modelElement instanceof XtendTypeDeclaration) {
        _matched=true;
        _switchResult = ((XtendTypeDeclaration)modelElement).getMembers().isEmpty();
      }
    }
    if (!_matched) {
      _switchResult = super.isLeaf(modelElement);
    }
    return _switchResult;
  }
  
  public void buildChildren(final StructureViewTreeElement objectTreeElement) {
    if (objectTreeElement instanceof EObjectTreeElement) {
      _buildChildren((EObjectTreeElement)objectTreeElement);
      return;
    } else if (objectTreeElement instanceof EStructuralFeatureTreeElement) {
      _buildChildren((EStructuralFeatureTreeElement)objectTreeElement);
      return;
    } else if (objectTreeElement instanceof XtextFileTreeElement) {
      _buildChildren((XtextFileTreeElement)objectTreeElement);
      return;
    } else if (objectTreeElement != null) {
      _buildChildren(objectTreeElement);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(objectTreeElement).toString());
    }
  }
  
  @Pure
  public TreeActionsOwner getTreeActionsOwner() {
    return this.treeActionsOwner;
  }
  
  public void setTreeActionsOwner(final TreeActionsOwner treeActionsOwner) {
    this.treeActionsOwner = treeActionsOwner;
  }
  
  @Pure
  public IXtendOutlineTreeBuilder getXtendOutlineTreeBuilder() {
    return this.xtendOutlineTreeBuilder;
  }
  
  public void setXtendOutlineTreeBuilder(final IXtendOutlineTreeBuilder xtendOutlineTreeBuilder) {
    this.xtendOutlineTreeBuilder = xtendOutlineTreeBuilder;
  }
}
