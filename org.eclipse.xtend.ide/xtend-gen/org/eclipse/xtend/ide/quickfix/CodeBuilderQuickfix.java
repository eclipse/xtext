/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.quickfix;

import com.google.inject.Inject;
import java.util.function.Consumer;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
import org.eclipse.xtext.xbase.lib.Exceptions;
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
      if (builder instanceof ICodeBuilder.Xtend) {
        _matched=true;
        _switchResult = this.getXtendModification(((ICodeBuilder.Xtend)builder));
      }
      if (!_matched) {
        if (builder instanceof ICodeBuilder.Java) {
          _matched=true;
          _switchResult = this.getJavaModification(((ICodeBuilder.Java)builder));
        }
      }
      final IModification modification = _switchResult;
      acceptor.accept(issue, label, builder.getPreview(), builder.getImage(), modification);
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

  protected int getTypeIndentation(final XtextResource resource, final IXtextDocument document, final XtendTypeDeclaration xtendClass) {
    final EObject object = resource.getEObject(EcoreUtil.getURI(xtendClass).fragment());
    if ((object != null)) {
      final ICompositeNode node = NodeModelUtils.findActualNodeFor(object);
      if ((node != null)) {
        return this.appendableFactory.getIndentationLevelAtOffset(node.getOffset(), document, resource);
      }
    }
    return 0;
  }

  protected IModification getXtendModification(final ICodeBuilder.Xtend builder) {
    final IModification _function = (IModificationContext it) -> {
      final XtendTypeDeclaration xtendClass = builder.getXtendType();
      final IEditorPart editor = this.editorOpener.open(EcoreUtil.getURI(xtendClass), false);
      if ((!(editor instanceof XtextEditor))) {
        return;
      }
      final XtextEditor xtextEditor = ((XtextEditor) editor);
      final IXtextDocument document = xtextEditor.getDocument();
      final Wrapper<Integer> wrapper = Wrapper.<Integer>forType(Integer.class);
      final IUnitOfWork<ReplacingAppendable, XtextResource> _function_1 = (XtextResource resource) -> {
        ReplacingAppendable _xblockexpression = null;
        {
          int offset = builder.getInsertOffset(resource);
          wrapper.set(Integer.valueOf(offset));
          final int typeIndentation = this.getTypeIndentation(resource, document, xtendClass);
          DocumentSourceAppender.Factory.OptionalParameters _optionalParameters = new DocumentSourceAppender.Factory.OptionalParameters();
          final Procedure1<DocumentSourceAppender.Factory.OptionalParameters> _function_2 = (DocumentSourceAppender.Factory.OptionalParameters it_1) -> {
            int _indentationLevel = builder.getIndentationLevel();
            int _plus = (_indentationLevel + typeIndentation);
            it_1.baseIndentationLevel = _plus;
            it_1.ensureEmptyLinesAround = true;
          };
          DocumentSourceAppender.Factory.OptionalParameters _doubleArrow = ObjectExtensions.<DocumentSourceAppender.Factory.OptionalParameters>operator_doubleArrow(_optionalParameters, _function_2);
          _xblockexpression = this.appendableFactory.create(document, resource, offset, 0, _doubleArrow);
        }
        return _xblockexpression;
      };
      final ReplacingAppendable appendable = document.<ReplacingAppendable>readOnly(_function_1);
      Integer offset = wrapper.get();
      builder.build(appendable);
      appendable.commitChanges();
      xtextEditor.setHighlightRange(((offset).intValue() + 1), appendable.length(), true);
    };
    return _function;
  }

  protected IModification getJavaModification(final ICodeBuilder.Java builder) {
    final IModification _function = (IModificationContext it) -> {
      final IType type = builder.getIType();
      char _charAt = ".".charAt(0);
      final ImportManager importManager = new ImportManager(true, _charAt);
      final StringBuilderBasedAppendable content = new StringBuilderBasedAppendable(importManager);
      builder.build(content);
      final Consumer<String> _function_1 = (String it_1) -> {
        try {
          ICompilationUnit _compilationUnit = type.getCompilationUnit();
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          _compilationUnit.createImport(it_1, null, _nullProgressMonitor);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      importManager.getImports().forEach(_function_1);
      Object _switchResult = null;
      boolean _matched = false;
      if (builder instanceof JavaFieldBuilder) {
        _matched=true;
        String _string = content.toString();
        NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
        _switchResult = type.createField(_string, null, true, _nullProgressMonitor);
      }
      if (!_matched) {
        if (builder instanceof JavaConstructorBuilder) {
          _matched=true;
          String _string = content.toString();
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          _switchResult = type.createMethod(_string, null, true, _nullProgressMonitor);
        }
      }
      if (!_matched) {
        if (builder instanceof JavaMethodBuilder) {
          _matched=true;
          String _string = content.toString();
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          _switchResult = type.createMethod(_string, null, true, _nullProgressMonitor);
        }
      }
      if (!_matched) {
        _switchResult = null;
      }
      final Object element = ((Object)_switchResult);
      if ((element != null)) {
        JdtHyperlink _jdtHyperlink = new JdtHyperlink();
        final Procedure1<JdtHyperlink> _function_2 = (JdtHyperlink it_1) -> {
          it_1.setJavaElement(((IMember)element));
          it_1.open();
        };
        ObjectExtensions.<JdtHyperlink>operator_doubleArrow(_jdtHyperlink, _function_2);
      }
    };
    return _function;
  }
}
