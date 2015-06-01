/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.web.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.web.server.contentassist.ContentAssistResult;
import org.eclipse.xtext.web.server.contentassist.IWebContentProposaAcceptor;
import org.eclipse.xtext.web.server.contentassist.WebContentProposalPriorities;
import org.eclipse.xtext.xbase.imports.ImportSectionRegionUtil;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.web.contentassist.IWebTypesProposalProvider;
import org.eclipse.xtext.xbase.web.contentassist.XbaseWebContentProposalPriorities;
import org.eclipse.xtext.xbase.web.scoping.ClasspathScanner;
import org.eclipse.xtext.xbase.web.scoping.ClasspathTypeDescriptor;
import org.eclipse.xtext.xbase.web.scoping.ITypeDescriptor;
import org.eclipse.xtext.xtype.XtypePackage;
import org.objectweb.asm.Opcodes;

@SuppressWarnings("all")
public class ClasspathBasedWebTypesProposalProvider implements IWebTypesProposalProvider {
  @Inject
  private ClassLoader classLoader;
  
  @Inject
  private WebContentProposalPriorities proposalPriorities;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  private ImportSectionRegionUtil importSectionRegionUtil;
  
  @Override
  public void createTypeProposals(final EReference reference, final ContentAssistContext context, final Predicate<ITypeDescriptor> filter, final IWebContentProposaAcceptor acceptor) {
    ITextRegion _xifexpression = null;
    boolean _isImportDeclaration = this.isImportDeclaration(reference, context);
    boolean _not = (!_isImportDeclaration);
    if (_not) {
      XtextResource _resource = context.getResource();
      _xifexpression = this.importSectionRegionUtil.computeRegion(_resource);
    }
    final ITextRegion importSectionRegion = _xifexpression;
    int count = 0;
    Iterable<ClasspathTypeDescriptor> _typeDescriptors = this.getTypeDescriptors(context);
    for (final ClasspathTypeDescriptor typeDesc : _typeDescriptors) {
      boolean _canPropose = this.canPropose(typeDesc, context, filter, count);
      if (_canPropose) {
        final ContentAssistResult.Entry entry = this.createProposal(reference, typeDesc, context, importSectionRegion);
        final int priority = ((XbaseWebContentProposalPriorities) this.proposalPriorities).getTypeRefPriority(typeDesc, entry);
        acceptor.accept(entry, priority);
        count++;
      }
    }
  }
  
  protected Iterable<ClasspathTypeDescriptor> getTypeDescriptors(final ContentAssistContext context) {
    final ClassLoader classLoader = this.getClassLoader(context);
    final ClasspathScanner classpathScanner = ClasspathScanner.getInstance();
    Iterable<ClasspathTypeDescriptor> _bootClasspathDescriptors = classpathScanner.getBootClasspathDescriptors();
    Iterable<ClasspathTypeDescriptor> _descriptors = classpathScanner.getDescriptors(classLoader);
    return Iterables.<ClasspathTypeDescriptor>concat(_bootClasspathDescriptors, _descriptors);
  }
  
  protected ClassLoader getClassLoader(final ContentAssistContext context) {
    XtextResource _resource = context.getResource();
    final ResourceSet resourceSet = _resource.getResourceSet();
    if ((resourceSet instanceof XtextResourceSet)) {
      final Object ctx = ((XtextResourceSet)resourceSet).getClasspathURIContext();
      boolean _notEquals = (!Objects.equal(ctx, null));
      if (_notEquals) {
        if ((ctx instanceof Class<?>)) {
          return ((Class<?>)ctx).getClassLoader();
        }
        if ((ctx instanceof ClassLoader)) {
          return ((ClassLoader)ctx);
        }
        Class<?> _class = ctx.getClass();
        return _class.getClassLoader();
      }
    }
    return this.classLoader;
  }
  
  protected boolean canPropose(final ITypeDescriptor typeDesc, final ContentAssistContext context, final Predicate<ITypeDescriptor> filter, final int numberOfProposedTypes) {
    boolean _xblockexpression = false;
    {
      final String prefix = context.getPrefix();
      boolean _and = false;
      boolean _and_1 = false;
      boolean _and_2 = false;
      if (!(numberOfProposedTypes < 1000)) {
        _and_2 = false;
      } else {
        String _simpleName = typeDesc.getSimpleName();
        int _length = prefix.length();
        boolean _regionMatches = _simpleName.regionMatches(true, 0, prefix, 0, _length);
        _and_2 = _regionMatches;
      }
      if (!_and_2) {
        _and_1 = false;
      } else {
        boolean _isVisible = this.isVisible(typeDesc, context);
        _and_1 = _isVisible;
      }
      if (!_and_1) {
        _and = false;
      } else {
        boolean _apply = filter.apply(typeDesc);
        _and = _apply;
      }
      _xblockexpression = _and;
    }
    return _xblockexpression;
  }
  
  protected boolean isVisible(final ITypeDescriptor typeDesc, final ContentAssistContext context) {
    int _accessFlags = typeDesc.getAccessFlags();
    int _bitwiseAnd = (_accessFlags & Opcodes.ACC_PUBLIC);
    return (_bitwiseAnd != 0);
  }
  
  protected ContentAssistResult.Entry createProposal(final EReference reference, final ITypeDescriptor typeDesc, final ContentAssistContext context, final ITextRegion importSectionRegion) {
    String _prefix = context.getPrefix();
    ContentAssistResult.Entry _entry = new ContentAssistResult.Entry(_prefix);
    final Procedure1<ContentAssistResult.Entry> _function = new Procedure1<ContentAssistResult.Entry>() {
      @Override
      public void apply(final ContentAssistResult.Entry it) {
        boolean _isImportDeclaration = ClasspathBasedWebTypesProposalProvider.this.isImportDeclaration(reference, context);
        if (_isImportDeclaration) {
          QualifiedName _qualifiedName = typeDesc.getQualifiedName();
          String _string = ClasspathBasedWebTypesProposalProvider.this.qualifiedNameConverter.toString(_qualifiedName);
          it.setProposal(_string);
          String _simpleName = typeDesc.getSimpleName();
          it.setName(_simpleName);
          String _proposal = it.getProposal();
          it.setDescription(_proposal);
        } else {
          String _simpleName_1 = typeDesc.getSimpleName();
          it.setProposal(_simpleName_1);
          QualifiedName _qualifiedName_1 = typeDesc.getQualifiedName();
          String _string_1 = ClasspathBasedWebTypesProposalProvider.this.qualifiedNameConverter.toString(_qualifiedName_1);
          it.setDescription(_string_1);
          boolean _and = false;
          if (!(importSectionRegion != null)) {
            _and = false;
          } else {
            boolean _isImportDeclarationRequired = ClasspathBasedWebTypesProposalProvider.this.isImportDeclarationRequired(typeDesc, context);
            _and = _isImportDeclarationRequired;
          }
          if (_and) {
            ClasspathBasedWebTypesProposalProvider.this.addImportDeclaration(it, importSectionRegion, typeDesc, context);
          }
        }
      }
    };
    return ObjectExtensions.<ContentAssistResult.Entry>operator_doubleArrow(_entry, _function);
  }
  
  protected boolean isImportDeclaration(final EReference reference, final ContentAssistContext context) {
    return Objects.equal(reference, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE);
  }
  
  protected boolean isImportDeclarationRequired(final ITypeDescriptor typeDesc, final ContentAssistContext context) {
    boolean _and = false;
    String _name = typeDesc.getName();
    boolean _startsWith = _name.startsWith("java.lang");
    if (!_startsWith) {
      _and = false;
    } else {
      String _name_1 = typeDesc.getName();
      int _lastIndexOf = _name_1.lastIndexOf(".");
      boolean _equals = (_lastIndexOf == 9);
      _and = _equals;
    }
    return (!_and);
  }
  
  protected boolean addImportDeclaration(final ContentAssistResult.Entry entry, final ITextRegion importSectionRegion, final ITypeDescriptor typeDesc, final ContentAssistContext context) {
    boolean _xblockexpression = false;
    {
      int _offset = importSectionRegion.getOffset();
      int _length = importSectionRegion.getLength();
      final int insertionOffset = (_offset + _length);
      QualifiedName _qualifiedName = typeDesc.getQualifiedName();
      String _string = this.qualifiedNameConverter.toString(_qualifiedName);
      final String declaration = ("\nimport " + _string);
      ArrayList<ReplaceRegion> _textReplacements = entry.getTextReplacements();
      ReplaceRegion _replaceRegion = new ReplaceRegion(insertionOffset, 0, declaration);
      _xblockexpression = _textReplacements.add(_replaceRegion);
    }
    return _xblockexpression;
  }
}
