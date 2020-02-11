/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.descriptions.ClasspathScanner;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalCreator;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.ide.contentassist.IIdeTypesProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeContentProposalPriorities;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.imports.ImportSectionRegionUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class ClasspathBasedIdeTypesProposalProvider implements IIdeTypesProposalProvider {
  @Inject
  private ClassLoader classLoader;
  
  @Inject
  private ClasspathScanner classpathScanner;
  
  @Inject
  private IdeContentProposalCreator proposalCreator;
  
  @Inject
  private IdeContentProposalPriorities proposalPriorities;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  private IImportsConfiguration importsConfiguration;
  
  @Inject
  private ImportSectionRegionUtil importSectionRegionUtil;
  
  @Override
  public void createTypeProposals(final EReference reference, final ContentAssistContext context, final Predicate<? super ITypeDescriptor> filter, final IIdeContentProposalAcceptor acceptor) {
    ITextRegion importSectionRegion = null;
    XImportSection importSection = null;
    boolean _isImportDeclaration = this.isImportDeclaration(reference, context);
    boolean _not = (!_isImportDeclaration);
    if (_not) {
      importSection = this.importsConfiguration.getImportSection(context.getResource());
      importSectionRegion = this.importSectionRegionUtil.computeRegion(context.getResource());
    }
    Iterable<ITypeDescriptor> _typeDescriptors = this.getTypeDescriptors(context);
    for (final ITypeDescriptor typeDesc : _typeDescriptors) {
      {
        boolean _canAcceptMoreProposals = acceptor.canAcceptMoreProposals();
        boolean _not_1 = (!_canAcceptMoreProposals);
        if (_not_1) {
          return;
        }
        boolean _canPropose = this.canPropose(typeDesc, context, filter);
        if (_canPropose) {
          final ContentAssistEntry entry = this.createProposal(reference, typeDesc, context, importSection, importSectionRegion);
          final int priority = ((XbaseIdeContentProposalPriorities) this.proposalPriorities).getTypeRefPriority(typeDesc, entry);
          acceptor.accept(entry, priority);
        }
      }
    }
  }
  
  protected Iterable<ITypeDescriptor> getTypeDescriptors(final ContentAssistContext context) {
    final Iterable<ITypeDescriptor> bootClasspath = this.classpathScanner.getBootClasspathDescriptors(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java")));
    final Iterable<ITypeDescriptor> appClasspath = this.classpathScanner.getDescriptors(this.getClassLoader(context), Collections.<String>emptyList());
    return Iterables.<ITypeDescriptor>concat(bootClasspath, appClasspath);
  }
  
  protected ClassLoader getClassLoader(final ContentAssistContext context) {
    final ResourceSet resourceSet = context.getResource().getResourceSet();
    if ((resourceSet instanceof XtextResourceSet)) {
      final Object ctx = ((XtextResourceSet)resourceSet).getClasspathURIContext();
      if ((ctx != null)) {
        if ((ctx instanceof Class<?>)) {
          return ((Class<?>)ctx).getClassLoader();
        }
        if ((ctx instanceof ClassLoader)) {
          return ((ClassLoader)ctx);
        }
        return ctx.getClass().getClassLoader();
      }
    }
    return this.classLoader;
  }
  
  protected boolean canPropose(final ITypeDescriptor typeDesc, final ContentAssistContext context, final Predicate<? super ITypeDescriptor> filter) {
    return (this.isVisible(typeDesc, context) && filter.apply(typeDesc));
  }
  
  protected boolean isVisible(final ITypeDescriptor typeDesc, final ContentAssistContext context) {
    return Modifier.isPublic(typeDesc.getModifiers());
  }
  
  protected ContentAssistEntry createProposal(final EReference reference, final ITypeDescriptor typeDesc, final ContentAssistContext context, final XImportSection importSection, final ITextRegion importSectionRegion) {
    ContentAssistEntry _xblockexpression = null;
    {
      final boolean importDecl = this.isImportDeclaration(reference, context);
      final String qualifiedName = this.qualifiedNameConverter.toString(typeDesc.getQualifiedName());
      String _xifexpression = null;
      if (importDecl) {
        _xifexpression = qualifiedName;
      } else {
        _xifexpression = typeDesc.getSimpleName();
      }
      final String proposal = _xifexpression;
      final Procedure1<ContentAssistEntry> _function = (ContentAssistEntry it) -> {
        it.setKind(ContentAssistEntry.KIND_REFERENCE);
        if (importDecl) {
          it.setLabel(typeDesc.getSimpleName());
          it.setDescription(proposal);
        } else {
          it.setDescription(qualifiedName);
          if (((importSectionRegion != null) && this.isImportDeclarationRequired(typeDesc, qualifiedName, context, importSection))) {
            this.addImportDeclaration(it, importSectionRegion, typeDesc, qualifiedName, context);
          }
        }
      };
      _xblockexpression = this.proposalCreator.createProposal(proposal, context, _function);
    }
    return _xblockexpression;
  }
  
  protected boolean isImportDeclaration(final EReference reference, final ContentAssistContext context) {
    return Objects.equal(reference, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE);
  }
  
  protected boolean isImportDeclarationRequired(final ITypeDescriptor typeDesc, final String qualifiedName, final ContentAssistContext context, final XImportSection importSection) {
    return ((!(typeDesc.getName().startsWith("java.lang") && (typeDesc.getName().lastIndexOf(".") == 9))) && ((importSection == null) || (!IterableExtensions.<XImportDeclaration>exists(importSection.getImportDeclarations(), ((Function1<XImportDeclaration, Boolean>) (XImportDeclaration it) -> {
      JvmDeclaredType _importedType = it.getImportedType();
      String _qualifiedName = null;
      if (_importedType!=null) {
        _qualifiedName=_importedType.getQualifiedName();
      }
      return Boolean.valueOf(Objects.equal(_qualifiedName, qualifiedName));
    })))));
  }
  
  protected boolean addImportDeclaration(final ContentAssistEntry entry, final ITextRegion importSectionRegion, final ITypeDescriptor typeDesc, final String qualifiedName, final ContentAssistContext context) {
    boolean _xblockexpression = false;
    {
      int _offset = importSectionRegion.getOffset();
      int _length = importSectionRegion.getLength();
      final int insertionOffset = (_offset + _length);
      final String declaration = ("\nimport " + qualifiedName);
      ArrayList<ReplaceRegion> _textReplacements = entry.getTextReplacements();
      ReplaceRegion _replaceRegion = new ReplaceRegion(insertionOffset, 0, declaration);
      _xblockexpression = _textReplacements.add(_replaceRegion);
    }
    return _xblockexpression;
  }
}
