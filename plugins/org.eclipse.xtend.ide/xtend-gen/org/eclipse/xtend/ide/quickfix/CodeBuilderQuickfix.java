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
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IType;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend.ide.codebuilder.ICodeBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaConstructorBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaFieldBuilder;
import org.eclipse.xtend.ide.codebuilder.JavaMethodBuilder;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.edit.IModification;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.ui.contentassist.ReplacingAppendable;
import org.eclipse.xtext.xbase.ui.document.DocumentSourceAppender;

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
  private ReplacingAppendable.Factory appendableFactory;
  
  public void addQuickfix(final ICodeBuilder builder, final String label, final Issue issue, final IssueResolutionAcceptor acceptor) {
    boolean _isValid = builder.isValid();
    if (_isValid) {
      IModification _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (builder instanceof ICodeBuilder.Xtend) {
          _matched=true;
          _switchResult = this.getXtendModification(((ICodeBuilder.Xtend)builder));
        }
      }
      if (!_matched) {
        if (builder instanceof ICodeBuilder.Java) {
          _matched=true;
          _switchResult = this.getJavaModification(((ICodeBuilder.Java)builder));
        }
      }
      final IModification modification = _switchResult;
      String _preview = builder.getPreview();
      String _image = builder.getImage();
      acceptor.accept(issue, label, _preview, _image, modification);
    }
  }
  
  protected String getImage(final ICodeBuilder builder) {
    String _switchResult = null;
    JvmVisibility _visibility = builder.getVisibility();
    if (_visibility != null) {
      switch (_visibility) {
        case PRIVATE:
          _switchResult = "fix_private_obj.gif";
          break;
        case PUBLIC:
          _switchResult = "fix_public_obj.gif";
          break;
        case PROTECTED:
          _switchResult = "fix_protected_obj.gif";
          break;
        default:
          _switchResult = "fix_default_obj.gif";
          break;
      }
    } else {
      _switchResult = "fix_default_obj.gif";
    }
    return _switchResult;
  }
  
  protected boolean isXtendSource(final ICodeBuilder builder) {
    Object _ownerSource = builder.getOwnerSource();
    return (_ownerSource instanceof XtendClass);
  }
  
  protected IModification getXtendModification(final ICodeBuilder.Xtend builder) {
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext it) throws Exception {
        final XtendTypeDeclaration xtendClass = builder.getXtendType();
        URI _uRI = EcoreUtil.getURI(xtendClass);
        final IEditorPart editor = CodeBuilderQuickfix.this.editorOpener.open(_uRI, false);
        if ((!(editor instanceof XtextEditor))) {
          return;
        }
        final XtextEditor xtextEditor = ((XtextEditor) editor);
        final IXtextDocument document = xtextEditor.getDocument();
        final Wrapper<Integer> wrapper = Wrapper.<Integer>forType(Integer.class);
        final IUnitOfWork<ReplacingAppendable, XtextResource> _function = new IUnitOfWork<ReplacingAppendable, XtextResource>() {
          @Override
          public ReplacingAppendable exec(final XtextResource resource) throws Exception {
            ReplacingAppendable _xblockexpression = null;
            {
              int offset = builder.getInsertOffset(resource);
              wrapper.set(Integer.valueOf(offset));
              DocumentSourceAppender.Factory.OptionalParameters _optionalParameters = new DocumentSourceAppender.Factory.OptionalParameters();
              final Procedure1<DocumentSourceAppender.Factory.OptionalParameters> _function = new Procedure1<DocumentSourceAppender.Factory.OptionalParameters>() {
                @Override
                public void apply(final DocumentSourceAppender.Factory.OptionalParameters it) {
                  int _indentationLevel = builder.getIndentationLevel();
                  it.baseIndentationLevel = _indentationLevel;
                  it.ensureEmptyLinesAround = true;
                }
              };
              DocumentSourceAppender.Factory.OptionalParameters _doubleArrow = ObjectExtensions.<DocumentSourceAppender.Factory.OptionalParameters>operator_doubleArrow(_optionalParameters, _function);
              _xblockexpression = CodeBuilderQuickfix.this.appendableFactory.create(document, resource, offset, 0, _doubleArrow);
            }
            return _xblockexpression;
          }
        };
        final ReplacingAppendable appendable = document.<ReplacingAppendable>readOnly(_function);
        Integer offset = wrapper.get();
        builder.build(appendable);
        appendable.commitChanges();
        int _length = appendable.length();
        xtextEditor.setHighlightRange(((offset).intValue() + 1), _length, true);
      }
    };
    return _function;
  }
  
  protected IModification getJavaModification(final ICodeBuilder.Java builder) {
    final IModification _function = new IModification() {
      @Override
      public void apply(final IModificationContext it) throws Exception {
        final IType type = builder.getIType();
        char _charAt = ".".charAt(0);
        final ImportManager importManager = new ImportManager(true, _charAt);
        final StringBuilderBasedAppendable content = new StringBuilderBasedAppendable(importManager);
        builder.build(content);
        List<String> _imports = importManager.getImports();
        for (final String it_1 : _imports) {
          ICompilationUnit _compilationUnit = type.getCompilationUnit();
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          _compilationUnit.createImport(it_1, null, _nullProgressMonitor);
        }
        Object _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (builder instanceof JavaFieldBuilder) {
            _matched=true;
            String _string = content.toString();
            NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
            _switchResult = type.createField(_string, null, true, _nullProgressMonitor_1);
          }
        }
        if (!_matched) {
          if (builder instanceof JavaConstructorBuilder) {
            _matched=true;
            String _string = content.toString();
            NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
            _switchResult = type.createMethod(_string, null, true, _nullProgressMonitor_1);
          }
        }
        if (!_matched) {
          if (builder instanceof JavaMethodBuilder) {
            _matched=true;
            String _string = content.toString();
            NullProgressMonitor _nullProgressMonitor_1 = new NullProgressMonitor();
            _switchResult = type.createMethod(_string, null, true, _nullProgressMonitor_1);
          }
        }
        if (!_matched) {
          _switchResult = null;
        }
        final Object element = ((Object)_switchResult);
        boolean _notEquals = (!Objects.equal(element, null));
        if (_notEquals) {
          JdtHyperlink _jdtHyperlink = new JdtHyperlink();
          final Procedure1<JdtHyperlink> _function = new Procedure1<JdtHyperlink>() {
            @Override
            public void apply(final JdtHyperlink it) {
              it.setJavaElement(((IMember)element));
              it.open();
            }
          };
          ObjectExtensions.<JdtHyperlink>operator_doubleArrow(_jdtHyperlink, _function);
        }
      }
    };
    return _function;
  }
}
