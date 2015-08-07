/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.intentions;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.lang.annotation.Annotation;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.util.IncorrectOperationException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.idea.config.XtendLibraryManager;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.idea.document.DocumentUtils;
import org.eclipse.xtext.idea.intentions.AbstractIssueIntentionAction;
import org.eclipse.xtext.idea.intentions.IdeaIntentionsProvider;
import org.eclipse.xtext.nodemodel.BidiTreeIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.psi.XtextPsiExtensions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.ide.contentassist.OverrideProposalUtil;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendIntentionsProvider extends IdeaIntentionsProvider {
  public static abstract class AbstractMemberAddingIntentionAction extends AbstractIssueIntentionAction {
    @Inject
    protected OverrideProposalUtil overrideProposalUtil;
    
    @Inject
    protected RewritableImportSection.Factory importSectionfactory;
    
    @Inject
    @Extension
    protected XtextPsiExtensions _xtextPsiExtensions;
    
    @Inject
    protected XtendGrammarAccess grammarAccess;
    
    @Inject
    protected IJvmModelAssociations jvmModelAssociations;
    
    @Inject
    @Extension
    protected DocumentUtils _documentUtils;
    
    @Override
    public void invoke(final Project project, final Editor editor, final PsiFile file) throws IncorrectOperationException {
      Issue _issue = this.getIssue();
      Integer _offset = _issue.getOffset();
      final PsiElement psiElement = this._xtextPsiExtensions.findEObjectAssociatedPsiElement(file, (_offset).intValue());
      if ((psiElement == null)) {
        return;
      }
      EObject _findEObject = this._xtextPsiExtensions.findEObject(psiElement);
      final XtendTypeDeclaration clazz = EcoreUtil2.<XtendTypeDeclaration>getContainerOfType(_findEObject, XtendTypeDeclaration.class);
      if ((clazz == null)) {
        return;
      }
      final EObject jvmType = this.jvmModelAssociations.getPrimaryJvmElement(clazz);
      final PsiDocumentManager docMnr = PsiDocumentManager.getInstance(project);
      if ((jvmType instanceof JvmGenericType)) {
        final int insertOffset = this.findInsertionOffSet(clazz, editor);
        Resource _eResource = clazz.eResource();
        final RewritableImportSection importSection = this.importSectionfactory.parse(((XtextResource) _eResource));
        final String toInsert = this.getMembersToBeInserted(importSection, ((JvmGenericType)jvmType));
        Document _document = editor.getDocument();
        _document.insertString(insertOffset, toInsert);
        Document _document_1 = editor.getDocument();
        docMnr.commitDocument(_document_1);
        Document _document_2 = editor.getDocument();
        docMnr.doPostponedOperationsAndUnblockDocument(_document_2);
        CodeStyleManager _instance = CodeStyleManager.getInstance(project);
        int _length = toInsert.length();
        int _plus = (insertOffset + _length);
        TextRange _textRange = new TextRange(insertOffset, _plus);
        _instance.adjustLineIndent(file, _textRange);
        Document _document_3 = editor.getDocument();
        this._documentUtils.updateImportSection(_document_3, importSection);
        Document _document_4 = editor.getDocument();
        docMnr.commitDocument(_document_4);
      }
    }
    
    public abstract String getMembersToBeInserted(final RewritableImportSection section, final JvmGenericType type);
    
    protected ArrayList<String> getParameters(final IResolvedExecutable executable, final RewritableImportSection importSection) {
      final ArrayList<String> result = CollectionLiterals.<String>newArrayList();
      for (int i = 0; (i < executable.getDeclaration().getParameters().size()); i++) {
        StringConcatenation _builder = new StringConcatenation();
        List<LightweightTypeReference> _resolvedParameterTypes = executable.getResolvedParameterTypes();
        LightweightTypeReference _get = _resolvedParameterTypes.get(i);
        String _importableString = this._documentUtils.toImportableString(_get, importSection);
        _builder.append(_importableString, "");
        _builder.append(" ");
        JvmExecutable _declaration = executable.getDeclaration();
        EList<JvmFormalParameter> _parameters = _declaration.getParameters();
        JvmFormalParameter _get_1 = _parameters.get(i);
        String _simpleName = _get_1.getSimpleName();
        _builder.append(_simpleName, "");
        result.add(_builder.toString());
      }
      return result;
    }
    
    public int findInsertionOffSet(final XtendTypeDeclaration class1, final Editor editor) {
      EList<XtendMember> _members = class1.getMembers();
      final XtendMember last = IterableExtensions.<XtendMember>last(_members);
      boolean _notEquals = (!Objects.equal(last, null));
      if (_notEquals) {
        final ICompositeNode n = NodeModelUtils.getNode(last);
        int _totalOffset = n.getTotalOffset();
        int _totalLength = n.getTotalLength();
        return (_totalOffset + _totalLength);
      } else {
        final ICompositeNode n_1 = NodeModelUtils.getNode(class1);
        BidiTreeIterable<INode> _asTreeIterable = n_1.getAsTreeIterable();
        final Function1<INode, Boolean> _function = new Function1<INode, Boolean>() {
          @Override
          public Boolean apply(final INode it) {
            String _text = it.getText();
            return Boolean.valueOf(Objects.equal(_text, "{"));
          }
        };
        final INode openingBracket = IterableExtensions.<INode>findFirst(_asTreeIterable, _function);
        boolean _notEquals_1 = (!Objects.equal(openingBracket, null));
        if (_notEquals_1) {
          int _offset = openingBracket.getOffset();
          return (_offset + 1);
        }
      }
      Document _document = editor.getDocument();
      String _text = _document.getText();
      return _text.lastIndexOf("}");
    }
  }
  
  public static class InsertXtendMethodsIntentionAction extends XtendIntentionsProvider.AbstractMemberAddingIntentionAction {
    public final static String TEXT = "Implement methods";
    
    @Override
    public String getText() {
      return XtendIntentionsProvider.InsertXtendMethodsIntentionAction.TEXT;
    }
    
    @Override
    public String getMembersToBeInserted(final RewritableImportSection importSection, final JvmGenericType jvmType) {
      final List<IResolvedExecutable> candidates = this.overrideProposalUtil.getImplementationCandidates(jvmType, false);
      Iterable<IResolvedOperation> _filter = Iterables.<IResolvedOperation>filter(candidates, IResolvedOperation.class);
      final Function1<IResolvedOperation, Boolean> _function = new Function1<IResolvedOperation, Boolean>() {
        @Override
        public Boolean apply(final IResolvedOperation it) {
          JvmOperation _declaration = it.getDeclaration();
          return Boolean.valueOf(_declaration.isAbstract());
        }
      };
      final Iterable<IResolvedOperation> abstractMethods = IterableExtensions.<IResolvedOperation>filter(_filter, _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      {
        for(final IResolvedOperation candidate : abstractMethods) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("override ");
          List<JvmTypeParameter> _typeParameters = candidate.getTypeParameters();
          final Function1<JvmTypeParameter, CharSequence> _function_1 = new Function1<JvmTypeParameter, CharSequence>() {
            @Override
            public CharSequence apply(final JvmTypeParameter it) {
              return it.getName();
            }
          };
          String _join = IterableExtensions.<JvmTypeParameter>join(_typeParameters, "<", ",", "> ", _function_1);
          _builder.append(_join, "\t");
          JvmOperation _declaration = candidate.getDeclaration();
          String _simpleName = _declaration.getSimpleName();
          _builder.append(_simpleName, "\t");
          _builder.append("(");
          ArrayList<String> _parameters = this.getParameters(candidate, importSection);
          String _join_1 = IterableExtensions.join(_parameters, ", ");
          _builder.append(_join_1, "\t");
          _builder.append(") ");
          JvmOperation _declaration_1 = candidate.getDeclaration();
          EList<JvmTypeReference> _exceptions = _declaration_1.getExceptions();
          final Function1<JvmTypeReference, CharSequence> _function_2 = new Function1<JvmTypeReference, CharSequence>() {
            @Override
            public CharSequence apply(final JvmTypeReference it) {
              return InsertXtendMethodsIntentionAction.this._documentUtils.toImportableString(it, importSection);
            }
          };
          String _join_2 = IterableExtensions.<JvmTypeReference>join(_exceptions, "throws ", ", ", " ", _function_2);
          _builder.append(_join_2, "\t");
          _builder.append("{");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("throw new UnsupportedOperationException()");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      return _builder.toString();
    }
  }
  
  public static class InsertSuperConstructorsIntentionAction extends XtendIntentionsProvider.AbstractMemberAddingIntentionAction {
    public final static String TEXT = "Create constructors matching super";
    
    @Override
    public String getText() {
      return XtendIntentionsProvider.InsertSuperConstructorsIntentionAction.TEXT;
    }
    
    @Override
    public String getMembersToBeInserted(final RewritableImportSection importSection, final JvmGenericType jvmType) {
      final List<IResolvedExecutable> candidates = this.overrideProposalUtil.getImplementationCandidates(jvmType, false);
      final Iterable<IResolvedConstructor> constructors = Iterables.<IResolvedConstructor>filter(candidates, IResolvedConstructor.class);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      {
        for(final IResolvedConstructor candidate : constructors) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("new (");
          ArrayList<String> _parameters = this.getParameters(candidate, importSection);
          String _join = IterableExtensions.join(_parameters, ", ");
          _builder.append(_join, "\t");
          _builder.append(") ");
          JvmConstructor _declaration = candidate.getDeclaration();
          EList<JvmTypeReference> _exceptions = _declaration.getExceptions();
          final Function1<JvmTypeReference, CharSequence> _function = new Function1<JvmTypeReference, CharSequence>() {
            @Override
            public CharSequence apply(final JvmTypeReference it) {
              return InsertSuperConstructorsIntentionAction.this._documentUtils.toImportableString(it, importSection);
            }
          };
          String _join_1 = IterableExtensions.<JvmTypeReference>join(_exceptions, "throws ", ", ", " ", _function);
          _builder.append(_join_1, "\t");
          _builder.append("{");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(");
          JvmConstructor _declaration_1 = candidate.getDeclaration();
          EList<JvmFormalParameter> _parameters_1 = _declaration_1.getParameters();
          final Function1<JvmFormalParameter, CharSequence> _function_1 = new Function1<JvmFormalParameter, CharSequence>() {
            @Override
            public CharSequence apply(final JvmFormalParameter it) {
              return it.getName();
            }
          };
          String _join_2 = IterableExtensions.<JvmFormalParameter>join(_parameters_1, ", ", _function_1);
          _builder.append(_join_2, "\t\t");
          _builder.append(")");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("}");
          _builder.newLine();
        }
      }
      return _builder.toString();
    }
  }
  
  public static class AddXtendLibToClassPathIntentionAction extends AbstractIssueIntentionAction {
    @Inject
    private XtendLibraryManager libraryManager;
    
    public final static String TEXT = "Add Xtend library";
    
    @Override
    public String getText() {
      return XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction.TEXT;
    }
    
    @Override
    public void invoke(final Project project, final Editor editor, final PsiFile file) throws IncorrectOperationException {
      final Module module = ModuleUtil.findModuleForPsiElement(file);
      ModuleRootManager _instance = ModuleRootManager.getInstance(module);
      final ModifiableRootModel model = _instance.getModifiableModel();
      this.libraryManager.ensureXtendLibAvailable(model, module);
      model.commit();
    }
  }
  
  @Inject
  private Provider<XtendIntentionsProvider.InsertXtendMethodsIntentionAction> insertXtendMethodsIntentionActionProvider;
  
  @Inject
  private Provider<XtendIntentionsProvider.InsertSuperConstructorsIntentionAction> insertSuperConstructorsIntentionActionProvider;
  
  @Inject
  private Provider<XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction> addXtendLibToClassPathIntentionAction;
  
  @Override
  public void registerFixes(final Annotation anno, final Issue issue) {
    String _code = issue.getCode();
    boolean _equals = Objects.equal(_code, IssueCodes.MISSING_CONSTRUCTOR);
    if (_equals) {
      XtendIntentionsProvider.InsertSuperConstructorsIntentionAction _get = this.insertSuperConstructorsIntentionActionProvider.get();
      final Procedure1<XtendIntentionsProvider.InsertSuperConstructorsIntentionAction> _function = new Procedure1<XtendIntentionsProvider.InsertSuperConstructorsIntentionAction>() {
        @Override
        public void apply(final XtendIntentionsProvider.InsertSuperConstructorsIntentionAction it) {
          it.setIssue(issue);
        }
      };
      XtendIntentionsProvider.InsertSuperConstructorsIntentionAction _doubleArrow = ObjectExtensions.<XtendIntentionsProvider.InsertSuperConstructorsIntentionAction>operator_doubleArrow(_get, _function);
      anno.registerFix(_doubleArrow);
    } else {
      boolean _or = false;
      String _code_1 = issue.getCode();
      boolean _equals_1 = Objects.equal(_code_1, IssueCodes.CLASS_MUST_BE_ABSTRACT);
      if (_equals_1) {
        _or = true;
      } else {
        String _code_2 = issue.getCode();
        boolean _equals_2 = Objects.equal(_code_2, IssueCodes.ANONYMOUS_CLASS_MISSING_MEMBERS);
        _or = _equals_2;
      }
      if (_or) {
        XtendIntentionsProvider.InsertXtendMethodsIntentionAction _get_1 = this.insertXtendMethodsIntentionActionProvider.get();
        final Procedure1<XtendIntentionsProvider.InsertXtendMethodsIntentionAction> _function_1 = new Procedure1<XtendIntentionsProvider.InsertXtendMethodsIntentionAction>() {
          @Override
          public void apply(final XtendIntentionsProvider.InsertXtendMethodsIntentionAction it) {
            it.setIssue(issue);
          }
        };
        XtendIntentionsProvider.InsertXtendMethodsIntentionAction _doubleArrow_1 = ObjectExtensions.<XtendIntentionsProvider.InsertXtendMethodsIntentionAction>operator_doubleArrow(_get_1, _function_1);
        anno.registerFix(_doubleArrow_1);
      } else {
        String _code_3 = issue.getCode();
        boolean _equals_3 = Objects.equal(_code_3, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
        if (_equals_3) {
          XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction _get_2 = this.addXtendLibToClassPathIntentionAction.get();
          final Procedure1<XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction> _function_2 = new Procedure1<XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction>() {
            @Override
            public void apply(final XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction it) {
              it.setIssue(issue);
            }
          };
          XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction _doubleArrow_2 = ObjectExtensions.<XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction>operator_doubleArrow(_get_2, _function_2);
          anno.registerFix(_doubleArrow_2);
        }
      }
    }
  }
}
