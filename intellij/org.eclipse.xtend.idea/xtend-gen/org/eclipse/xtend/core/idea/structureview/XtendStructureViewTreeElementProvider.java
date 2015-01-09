/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.structureview;

import com.google.common.base.Objects;
import com.intellij.icons.AllIcons;
import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.newStructureView.TreeActionsOwner;
import com.intellij.navigation.ItemPresentation;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.idea.structureview.IntellijXtendOutlineContext;
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
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.idea.structureview.DefaultStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.EObjectTreeElement;
import org.eclipse.xtext.idea.structureview.EStructuralFeatureTreeElement;
import org.eclipse.xtext.idea.structureview.XtextFileTreeElement;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeature;
import org.eclipse.xtext.xtype.XImportSection;
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
  
  protected void _buildChildren(final XtextFileTreeElement xtextFileTreeElement) {
    BaseXtextFile _element = xtextFileTreeElement.getElement();
    Resource _resource = _element.getResource();
    EList<EObject> _contents = _resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    IntellijXtendOutlineContext _intellijXtendOutlineContext = new IntellijXtendOutlineContext();
    final Procedure1<IntellijXtendOutlineContext> _function = new Procedure1<IntellijXtendOutlineContext>() {
      public void apply(final IntellijXtendOutlineContext it) {
        boolean _isShowInherited = XtendStructureViewTreeElementProvider.this.isShowInherited();
        it.setShowInherited(_isShowInherited);
        BaseXtextFile _element = xtextFileTreeElement.getElement();
        it.setXtextFile(_element);
        it.setStructureViewTreeElement(xtextFileTreeElement);
      }
    };
    IntellijXtendOutlineContext _doubleArrow = ObjectExtensions.<IntellijXtendOutlineContext>operator_doubleArrow(_intellijXtendOutlineContext, _function);
    this.xtendOutlineTreeBuilder.build(_head, _doubleArrow);
  }
  
  protected boolean isShowInherited() {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(this.treeActionsOwner, null);
      if (_equals) {
        return false;
      }
      _xblockexpression = this.treeActionsOwner.isActionActive(XtendShowInheritedNodeProvider.ID);
    }
    return _xblockexpression;
  }
  
  public IXtendOutlineContext buildEObjectNode(final EObject modelElement, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      BaseXtextFile _xtextFile = intellijContext.getXtextFile();
      final EObjectTreeElement structureViewTreeElement = this.createEObjectTreeElement(modelElement, _xtextFile);
      _xblockexpression = intellijContext.withStructureViewTreeElement(structureViewTreeElement);
    }
    return _xblockexpression;
  }
  
  public IXtendOutlineContext buildXtendNode(final EObject modelElement, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      BaseXtextFile _xtextFile = intellijContext.getXtextFile();
      final EObjectTreeElement structureViewTreeElement = this.createEObjectTreeElement(modelElement, _xtextFile);
      _xblockexpression = intellijContext.withStructureViewTreeElement(structureViewTreeElement);
    }
    return _xblockexpression;
  }
  
  public IXtendOutlineContext buildFeatureNode(final JvmDeclaredType inferredType, final JvmFeature jvmFeature, final EObject modelElement, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      BaseXtextFile _xtextFile = intellijContext.getXtextFile();
      ItemPresentation _itemPresentation = this.itemPresentationProvider.getItemPresentation(jvmFeature);
      final EObjectTreeElement structureViewTreeElement = this.createEObjectTreeElement(jvmFeature, _xtextFile, true, _itemPresentation);
      _xblockexpression = intellijContext.withStructureViewTreeElement(structureViewTreeElement);
    }
    return _xblockexpression;
  }
  
  public IXtendOutlineContext buildDispatcherNode(final JvmDeclaredType baseType, final JvmFeature dispatcher, final List<JvmOperation> dispatchCases, final IXtendOutlineContext context) {
    return this.buildFeatureNode(baseType, dispatcher, dispatcher, context);
  }
  
  public IXtendOutlineContext buildPackageNode(final XtendFile xtendFile, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      BaseXtextFile _xtextFile = intellijContext.getXtextFile();
      PresentationData _presentationData = new PresentationData();
      final Procedure1<PresentationData> _function = new Procedure1<PresentationData>() {
        public void apply(final PresentationData it) {
          it.setIcon(AllIcons.Nodes.Package);
          String _package = xtendFile.getPackage();
          it.setPresentableText(_package);
        }
      };
      PresentationData _doubleArrow = ObjectExtensions.<PresentationData>operator_doubleArrow(_presentationData, _function);
      final EStructuralFeatureTreeElement structureViewTreeElement = this.createEStructuralFeatureTreeElement(xtendFile, 
        XtendPackage.Literals.XTEND_FILE__PACKAGE, _xtextFile, 
        true, _doubleArrow);
      _xblockexpression = intellijContext.withStructureViewTreeElement(structureViewTreeElement);
    }
    return _xblockexpression;
  }
  
  public IXtendOutlineContext buildImportSectionNode(final XtendFile xtendFile, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      XImportSection _importSection = xtendFile.getImportSection();
      BaseXtextFile _xtextFile = intellijContext.getXtextFile();
      XImportSection _importSection_1 = xtendFile.getImportSection();
      ItemPresentation _itemPresentation = this.itemPresentationProvider.getItemPresentation(_importSection_1);
      final EStructuralFeatureTreeElement structureViewTreeElement = this.createEStructuralFeatureTreeElement(_importSection, 
        XtypePackage.Literals.XIMPORT_SECTION__IMPORT_DECLARATIONS, _xtextFile, 
        false, _itemPresentation);
      _xblockexpression = intellijContext.withStructureViewTreeElement(structureViewTreeElement);
    }
    return _xblockexpression;
  }
  
  public IXtendOutlineContext buildResolvedFeatureNode(final JvmDeclaredType inferredType, final IResolvedFeature resolvedFeature, final IXtendOutlineContext context) {
    IntellijXtendOutlineContext _xblockexpression = null;
    {
      final IntellijXtendOutlineContext intellijContext = ((IntellijXtendOutlineContext) context);
      JvmFeature _declaration = resolvedFeature.getDeclaration();
      BaseXtextFile _xtextFile = intellijContext.getXtextFile();
      final EObjectTreeElement structureViewTreeElement = this.createEObjectTreeElement(_declaration, _xtextFile);
      _xblockexpression = intellijContext.withStructureViewTreeElement(structureViewTreeElement);
    }
    return _xblockexpression;
  }
  
  protected boolean isLeaf(final EObject modelElement) {
    boolean _switchResult = false;
    boolean _matched = false;
    if (!_matched) {
      if (modelElement instanceof JvmDeclaredType) {
        _matched=true;
        EList<JvmMember> _members = ((JvmDeclaredType)modelElement).getMembers();
        _switchResult = _members.isEmpty();
      }
    }
    if (!_matched) {
      if (modelElement instanceof XtendTypeDeclaration) {
        _matched=true;
        EList<XtendMember> _members = ((XtendTypeDeclaration)modelElement).getMembers();
        _switchResult = _members.isEmpty();
      }
    }
    if (!_matched) {
      _switchResult = super.isLeaf(modelElement);
    }
    return _switchResult;
  }
  
  public void buildChildren(final StructureViewTreeElement xtextFileTreeElement) {
    if (xtextFileTreeElement instanceof EObjectTreeElement) {
      _buildChildren((EObjectTreeElement)xtextFileTreeElement);
      return;
    } else if (xtextFileTreeElement instanceof EStructuralFeatureTreeElement) {
      _buildChildren((EStructuralFeatureTreeElement)xtextFileTreeElement);
      return;
    } else if (xtextFileTreeElement instanceof XtextFileTreeElement) {
      _buildChildren((XtextFileTreeElement)xtextFileTreeElement);
      return;
    } else if (xtextFileTreeElement != null) {
      _buildChildren(xtextFileTreeElement);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(xtextFileTreeElement).toString());
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
