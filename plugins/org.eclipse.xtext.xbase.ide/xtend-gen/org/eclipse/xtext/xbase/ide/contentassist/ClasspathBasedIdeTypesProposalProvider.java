/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistEntry;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalPriorities;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.ide.contentassist.IIdeTypesProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.XbaseIdeContentProposalPriorities;
import org.eclipse.xtext.xbase.ide.types.ClasspathScanner;
import org.eclipse.xtext.xbase.ide.types.ClasspathTypeDescriptor;
import org.eclipse.xtext.xbase.ide.types.ITypeDescriptor;
import org.eclipse.xtext.xbase.imports.IImportsConfiguration;
import org.eclipse.xtext.xbase.imports.ImportSectionRegionUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xtype.XImportDeclaration;
import org.eclipse.xtext.xtype.XImportSection;
import org.eclipse.xtext.xtype.XtypePackage;
import org.objectweb.asm.Opcodes;

@SuppressWarnings("all")
public class ClasspathBasedIdeTypesProposalProvider implements IIdeTypesProposalProvider {
  @Inject
  private ClassLoader classLoader;
  
  @Inject
  private ClasspathScanner classpathScanner;
  
  @Inject
  private IdeContentProposalPriorities proposalPriorities;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  @Inject
  private IImportsConfiguration importsConfiguration;
  
  @Inject
  private ImportSectionRegionUtil importSectionRegionUtil;
  
  @Override
  public void createTypeProposals(final EReference reference, final ContentAssistContext context, final Predicate<ITypeDescriptor> filter, final IIdeContentProposalAcceptor acceptor) {
    ITextRegion importSectionRegion = null;
    XImportSection importSection = null;
    boolean _isImportDeclaration = this.isImportDeclaration(reference, context);
    boolean _not = (!_isImportDeclaration);
    if (_not) {
      XtextResource _resource = context.getResource();
      XImportSection _importSection = this.importsConfiguration.getImportSection(_resource);
      importSection = _importSection;
      XtextResource _resource_1 = context.getResource();
      ITextRegion _computeRegion = this.importSectionRegionUtil.computeRegion(_resource_1);
      importSectionRegion = _computeRegion;
    }
    Iterable<ClasspathTypeDescriptor> _typeDescriptors = this.getTypeDescriptors(context);
    for (final ClasspathTypeDescriptor typeDesc : _typeDescriptors) {
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
  
  protected Iterable<ClasspathTypeDescriptor> getTypeDescriptors(final ContentAssistContext context) {
    final Iterable<ClasspathTypeDescriptor> bootClasspath = this.classpathScanner.getBootClasspathDescriptors(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java")));
    ClassLoader _classLoader = this.getClassLoader(context);
    List<String> _emptyList = Collections.<String>emptyList();
    final Iterable<ClasspathTypeDescriptor> appClasspath = this.classpathScanner.getDescriptors(_classLoader, _emptyList);
    return Iterables.<ClasspathTypeDescriptor>concat(bootClasspath, appClasspath);
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
  
  protected boolean canPropose(final ITypeDescriptor typeDesc, final ContentAssistContext context, final Predicate<ITypeDescriptor> filter) {
    boolean _xblockexpression = false;
    {
      final String prefix = context.getPrefix();
      boolean _and = false;
      boolean _and_1 = false;
      String _simpleName = typeDesc.getSimpleName();
      int _length = prefix.length();
      boolean _regionMatches = _simpleName.regionMatches(true, 0, prefix, 0, _length);
      if (!_regionMatches) {
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
  
  protected ContentAssistEntry createProposal(final EReference reference, final ITypeDescriptor typeDesc, final ContentAssistContext context, final XImportSection importSection, final ITextRegion importSectionRegion) {
    ContentAssistEntry _contentAssistEntry = new ContentAssistEntry();
    final Procedure1<ContentAssistEntry> _function = new Procedure1<ContentAssistEntry>() {
      @Override
      public void apply(final ContentAssistEntry it) {
        String _prefix = context.getPrefix();
        it.setPrefix(_prefix);
        QualifiedName _qualifiedName = typeDesc.getQualifiedName();
        final String qualifiedName = ClasspathBasedIdeTypesProposalProvider.this.qualifiedNameConverter.toString(_qualifiedName);
        boolean _isImportDeclaration = ClasspathBasedIdeTypesProposalProvider.this.isImportDeclaration(reference, context);
        if (_isImportDeclaration) {
          it.setProposal(qualifiedName);
          String _simpleName = typeDesc.getSimpleName();
          it.setLabel(_simpleName);
          String _proposal = it.getProposal();
          it.setDescription(_proposal);
        } else {
          String _simpleName_1 = typeDesc.getSimpleName();
          it.setProposal(_simpleName_1);
          it.setDescription(qualifiedName);
          boolean _and = false;
          if (!(importSectionRegion != null)) {
            _and = false;
          } else {
            boolean _isImportDeclarationRequired = ClasspathBasedIdeTypesProposalProvider.this.isImportDeclarationRequired(typeDesc, qualifiedName, context, importSection);
            _and = _isImportDeclarationRequired;
          }
          if (_and) {
            ClasspathBasedIdeTypesProposalProvider.this.addImportDeclaration(it, importSectionRegion, typeDesc, qualifiedName, context);
          }
        }
      }
    };
    return ObjectExtensions.<ContentAssistEntry>operator_doubleArrow(_contentAssistEntry, _function);
  }
  
  protected boolean isImportDeclaration(final EReference reference, final ContentAssistContext context) {
    return Objects.equal(reference, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE);
  }
  
  protected boolean isImportDeclarationRequired(final ITypeDescriptor typeDesc, final String qualifiedName, final ContentAssistContext context, final XImportSection importSection) {
    boolean _and = false;
    boolean _and_1 = false;
    String _name = typeDesc.getName();
    boolean _startsWith = _name.startsWith("java.lang");
    if (!_startsWith) {
      _and_1 = false;
    } else {
      String _name_1 = typeDesc.getName();
      int _lastIndexOf = _name_1.lastIndexOf(".");
      boolean _equals = (_lastIndexOf == 9);
      _and_1 = _equals;
    }
    boolean _not = (!_and_1);
    if (!_not) {
      _and = false;
    } else {
      boolean _or = false;
      if ((importSection == null)) {
        _or = true;
      } else {
        EList<XImportDeclaration> _importDeclarations = importSection.getImportDeclarations();
        final Function1<XImportDeclaration, Boolean> _function = new Function1<XImportDeclaration, Boolean>() {
          @Override
          public Boolean apply(final XImportDeclaration it) {
            JvmDeclaredType _importedType = it.getImportedType();
            String _qualifiedName = null;
            if (_importedType!=null) {
              _qualifiedName=_importedType.getQualifiedName();
            }
            return Boolean.valueOf(Objects.equal(_qualifiedName, qualifiedName));
          }
        };
        boolean _exists = IterableExtensions.<XImportDeclaration>exists(_importDeclarations, _function);
        boolean _not_1 = (!_exists);
        _or = _not_1;
      }
      _and = _or;
    }
    return _and;
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
