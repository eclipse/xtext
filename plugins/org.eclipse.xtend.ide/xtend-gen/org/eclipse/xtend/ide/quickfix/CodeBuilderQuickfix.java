/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.quickfix;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IAnnotatable;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Java;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder.Xtend;
import org.eclipse.xtend.ide.codebuilder.JavaConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaMethodBuilder;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable.Factory;

/**
 * Creates quickfixes using {@link ICodeBuilder}s.
 * 
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial implementation and API
 */
@SuppressWarnings("all")
public class CodeBuilderQuickfix {
  @Inject
  private IURIEditorOpener editorOpener;
  
  @Inject
  private Factory appendableFactory;
  
  public void addQuickfix(final ICodeBuilder builder, final String label, final Issue issue, final IssueResolutionAcceptor acceptor) {
    IModification _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (builder instanceof Xtend) {
        final Xtend _xtend = (Xtend)builder;
        _matched=true;
        IModification _xtendModification = this.getXtendModification(_xtend);
        _switchResult = _xtendModification;
      }
    }
    if (!_matched) {
      if (builder instanceof Java) {
        final Java _java = (Java)builder;
        _matched=true;
        IModification _javaModification = this.getJavaModification(_java);
        _switchResult = _javaModification;
      }
    }
    final IModification modification = _switchResult;
    String _preview = builder.preview();
    String _image = this.getImage(builder);
    acceptor.accept(issue, label, _preview, _image, modification);
  }
  
  protected String getImage(final ICodeBuilder builder) {
    String _switchResult = null;
    JvmVisibility _visibility = builder.getVisibility();
    final JvmVisibility _switchValue = _visibility;
    boolean _matched = false;
    if (!_matched) {
      if (Objects.equal(_switchValue,JvmVisibility.PRIVATE)) {
        _matched=true;
        _switchResult = "fix_private_obj.gif";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,JvmVisibility.PUBLIC)) {
        _matched=true;
        _switchResult = "fix_public_obj.gif";
      }
    }
    if (!_matched) {
      if (Objects.equal(_switchValue,JvmVisibility.PROTECTED)) {
        _matched=true;
        _switchResult = "fix_protected_obj.gif";
      }
    }
    if (!_matched) {
      _switchResult = "fix_default_obj.gif";
    }
    return _switchResult;
  }
  
  protected boolean isXtendSource(final ICodeBuilder builder) {
    Object _ownerSource = builder.getOwnerSource();
    return (_ownerSource instanceof XtendClass);
  }
  
  protected IModification getXtendModification(final Xtend builder) {
    final Procedure1<IModificationContext> _function = new Procedure1<IModificationContext>() {
        public void apply(final IModificationContext it) {
          try {
            final XtendClass xtendClass = builder.getXtendClass();
            URI _uRI = EcoreUtil.getURI(xtendClass);
            final IEditorPart editor = CodeBuilderQuickfix.this.editorOpener.open(_uRI, false);
            boolean _not = (!(editor instanceof XtextEditor));
            if (_not) {
              return;
            }
            final XtextEditor xtextEditor = ((XtextEditor) editor);
            final IXtextDocument document = xtextEditor.getDocument();
            int offset = builder.getInsertOffset();
            final ReplacingAppendable appendable = CodeBuilderQuickfix.this.appendableFactory.get(document, xtendClass, offset, 0, 1, true);
            builder.build(appendable);
            appendable.commitChanges();
            int _plus = (offset + 1);
            int _length = appendable.length();
            xtextEditor.setHighlightRange(_plus, _length, true);
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    return new IModification() {
        public void apply(IModificationContext context) {
          _function.apply(context);
        }
    };
  }
  
  protected IModification getJavaModification(final Java builder) {
    final Procedure1<IModificationContext> _function = new Procedure1<IModificationContext>() {
        public void apply(final IModificationContext it) {
          try {
            final IType type = builder.getIType();
            char _charAt = ".".charAt(0);
            ImportManager _importManager = new ImportManager(true, _charAt);
            final ImportManager importManager = _importManager;
            StringBuilderBasedAppendable _stringBuilderBasedAppendable = new StringBuilderBasedAppendable(importManager);
            final StringBuilderBasedAppendable content = _stringBuilderBasedAppendable;
            builder.build(content);
            List<String> _imports = importManager.getImports();
            final Procedure1<String> _function = new Procedure1<String>() {
                public void apply(final String it) {
                  try {
                    ICompilationUnit _compilationUnit = type.getCompilationUnit();
                    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
                    _compilationUnit.createImport(it, null, _nullProgressMonitor);
                  } catch (Exception _e) {
                    throw Exceptions.sneakyThrow(_e);
                  }
                }
              };
            IterableExtensions.<String>forEach(_imports, _function);
            Object _switchResult = null;
            boolean _matched = false;
            if (!_matched) {
              if (builder instanceof JavaFieldBuilder) {
                final JavaFieldBuilder _javaFieldBuilder = (JavaFieldBuilder)builder;
                _matched=true;
                String _string = content.toString();
                NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
                IField _createField = type.createField(_string, null, true, _nullProgressMonitor);
                _switchResult = _createField;
              }
            }
            if (!_matched) {
              if (builder instanceof JavaConstructorBuilder) {
                final JavaConstructorBuilder _javaConstructorBuilder = (JavaConstructorBuilder)builder;
                _matched=true;
                String _string = content.toString();
                NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
                IMethod _createMethod = type.createMethod(_string, null, true, _nullProgressMonitor);
                _switchResult = _createMethod;
              }
            }
            if (!_matched) {
              if (builder instanceof JavaMethodBuilder) {
                final JavaMethodBuilder _javaMethodBuilder = (JavaMethodBuilder)builder;
                _matched=true;
                String _string = content.toString();
                NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
                IMethod _createMethod = type.createMethod(_string, null, true, _nullProgressMonitor);
                _switchResult = _createMethod;
              }
            }
            if (!_matched) {
              _switchResult = null;
            }
            final Object element = _switchResult;
            boolean _notEquals = ObjectExtensions.operator_notEquals(((IAnnotatable)element), null);
            if (_notEquals) {
              JdtHyperlink _jdtHyperlink = new JdtHyperlink();
              final Procedure1<JdtHyperlink> _function_1 = new Procedure1<JdtHyperlink>() {
                  public void apply(final JdtHyperlink it) {
                    it.setJavaElement(((IMember)element));
                    it.open();
                  }
                };
              ObjectExtensions.<JdtHyperlink>operator_doubleArrow(_jdtHyperlink, _function_1);
            }
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    return new IModification() {
        public void apply(IModificationContext context) {
          _function.apply(context);
        }
    };
  }
}
