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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.idea.config.XtendLibraryConfigurator;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.idea.document.DocumentUtils;
import org.eclipse.xtext.idea.intentions.AbstractIssueIntentionAction;
import org.eclipse.xtext.idea.intentions.IdeaIntentionsProvider;
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
      final PsiElement psiElement = this._xtextPsiExtensions.findEObjectAssociatedPsiElement(file, (this.getIssue().getOffset()).intValue());
      if ((psiElement == null)) {
        return;
      }
      final XtendTypeDeclaration clazz = EcoreUtil2.<XtendTypeDeclaration>getContainerOfType(this._xtextPsiExtensions.findEObject(psiElement), XtendTypeDeclaration.class);
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
        editor.getDocument().insertString(insertOffset, toInsert);
        docMnr.commitDocument(editor.getDocument());
        docMnr.doPostponedOperationsAndUnblockDocument(editor.getDocument());
        CodeStyleManager _instance = CodeStyleManager.getInstance(project);
        int _length = toInsert.length();
        int _plus = (insertOffset + _length);
        TextRange _textRange = new TextRange(insertOffset, _plus);
        _instance.adjustLineIndent(file, _textRange);
        this._documentUtils.updateImportSection(editor.getDocument(), importSection);
        docMnr.commitDocument(editor.getDocument());
      }
    }
    
    public abstract String getMembersToBeInserted(final RewritableImportSection section, final JvmGenericType type);
    
    protected ArrayList<String> getParameters(final IResolvedExecutable executable, final RewritableImportSection importSection) {
      final ArrayList<String> result = CollectionLiterals.<String>newArrayList();
      for (int i = 0; (i < executable.getDeclaration().getParameters().size()); i++) {
        StringConcatenation _builder = new StringConcatenation();
        String _importableString = this._documentUtils.toImportableString(executable.getResolvedParameterTypes().get(i), importSection);
        _builder.append(_importableString);
        _builder.append(" ");
        String _simpleName = executable.getDeclaration().getParameters().get(i).getSimpleName();
        _builder.append(_simpleName);
        result.add(_builder.toString());
      }
      return result;
    }
    
    public int findInsertionOffSet(final XtendTypeDeclaration class1, final Editor editor) {
      final XtendMember last = IterableExtensions.<XtendMember>last(class1.getMembers());
      if ((last != null)) {
        final ICompositeNode n = NodeModelUtils.getNode(last);
        int _totalOffset = n.getTotalOffset();
        int _totalLength = n.getTotalLength();
        return (_totalOffset + _totalLength);
      } else {
        final ICompositeNode n_1 = NodeModelUtils.getNode(class1);
        final Function1<INode, Boolean> _function = (INode it) -> {
          String _text = it.getText();
          return Boolean.valueOf(Objects.equal(_text, "{"));
        };
        final INode openingBracket = IterableExtensions.<INode>findFirst(n_1.getAsTreeIterable(), _function);
        if ((openingBracket != null)) {
          int _offset = openingBracket.getOffset();
          return (_offset + 1);
        }
      }
      return editor.getDocument().getText().lastIndexOf("}");
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
      final Function1<IResolvedOperation, Boolean> _function = (IResolvedOperation it) -> {
        return Boolean.valueOf(it.getDeclaration().isAbstract());
      };
      final Iterable<IResolvedOperation> abstractMethods = IterableExtensions.<IResolvedOperation>filter(Iterables.<IResolvedOperation>filter(candidates, IResolvedOperation.class), _function);
      StringConcatenation _builder = new StringConcatenation();
      _builder.newLine();
      {
        for(final IResolvedOperation candidate : abstractMethods) {
          _builder.append("\t");
          _builder.newLine();
          _builder.append("\t");
          _builder.append("override ");
          final Function1<JvmTypeParameter, CharSequence> _function_1 = (JvmTypeParameter it) -> {
            return it.getName();
          };
          String _join = IterableExtensions.<JvmTypeParameter>join(candidate.getTypeParameters(), "<", ",", "> ", _function_1);
          _builder.append(_join, "\t");
          String _simpleName = candidate.getDeclaration().getSimpleName();
          _builder.append(_simpleName, "\t");
          _builder.append("(");
          String _join_1 = IterableExtensions.join(this.getParameters(candidate, importSection), ", ");
          _builder.append(_join_1, "\t");
          _builder.append(") ");
          final Function1<JvmTypeReference, CharSequence> _function_2 = (JvmTypeReference it) -> {
            return this._documentUtils.toImportableString(it, importSection);
          };
          String _join_2 = IterableExtensions.<JvmTypeReference>join(candidate.getDeclaration().getExceptions(), "throws ", ", ", " ", _function_2);
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
          String _join = IterableExtensions.join(this.getParameters(candidate, importSection), ", ");
          _builder.append(_join, "\t");
          _builder.append(") ");
          final Function1<JvmTypeReference, CharSequence> _function = (JvmTypeReference it) -> {
            return this._documentUtils.toImportableString(it, importSection);
          };
          String _join_1 = IterableExtensions.<JvmTypeReference>join(candidate.getDeclaration().getExceptions(), "throws ", ", ", " ", _function);
          _builder.append(_join_1, "\t");
          _builder.append("{");
          _builder.newLineIfNotEmpty();
          _builder.append("\t");
          _builder.append("\t");
          _builder.append("super(");
          final Function1<JvmFormalParameter, CharSequence> _function_1 = (JvmFormalParameter it) -> {
            return it.getName();
          };
          String _join_2 = IterableExtensions.<JvmFormalParameter>join(candidate.getDeclaration().getParameters(), ", ", _function_1);
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
    private XtendLibraryConfigurator libraryManager;
    
    public final static String TEXT = "Add Xtend runtime Library";
    
    @Override
    public String getText() {
      return XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction.TEXT;
    }
    
    @Override
    public void invoke(final Project project, final Editor editor, final PsiFile file) throws IncorrectOperationException {
      final Module module = ModuleUtil.findModuleForPsiElement(file);
      if ((module != null)) {
        final ModifiableRootModel model = ModuleRootManager.getInstance(module).getModifiableModel();
        this.libraryManager.ensureXtendLibAvailable(model, file);
        model.commit();
      }
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
      final Procedure1<XtendIntentionsProvider.InsertSuperConstructorsIntentionAction> _function = (XtendIntentionsProvider.InsertSuperConstructorsIntentionAction it) -> {
        it.setIssue(issue);
      };
      XtendIntentionsProvider.InsertSuperConstructorsIntentionAction _doubleArrow = ObjectExtensions.<XtendIntentionsProvider.InsertSuperConstructorsIntentionAction>operator_doubleArrow(_get, _function);
      anno.registerFix(_doubleArrow);
    } else {
      if ((Objects.equal(issue.getCode(), IssueCodes.CLASS_MUST_BE_ABSTRACT) || 
        Objects.equal(issue.getCode(), IssueCodes.ANONYMOUS_CLASS_MISSING_MEMBERS))) {
        XtendIntentionsProvider.InsertXtendMethodsIntentionAction _get_1 = this.insertXtendMethodsIntentionActionProvider.get();
        final Procedure1<XtendIntentionsProvider.InsertXtendMethodsIntentionAction> _function_1 = (XtendIntentionsProvider.InsertXtendMethodsIntentionAction it) -> {
          it.setIssue(issue);
        };
        XtendIntentionsProvider.InsertXtendMethodsIntentionAction _doubleArrow_1 = ObjectExtensions.<XtendIntentionsProvider.InsertXtendMethodsIntentionAction>operator_doubleArrow(_get_1, _function_1);
        anno.registerFix(_doubleArrow_1);
      } else {
        String _code_1 = issue.getCode();
        boolean _equals_1 = Objects.equal(_code_1, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
        if (_equals_1) {
          XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction _get_2 = this.addXtendLibToClassPathIntentionAction.get();
          final Procedure1<XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction> _function_2 = (XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction it) -> {
            it.setIssue(issue);
          };
          XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction _doubleArrow_2 = ObjectExtensions.<XtendIntentionsProvider.AddXtendLibToClassPathIntentionAction>operator_doubleArrow(_get_2, _function_2);
          anno.registerFix(_doubleArrow_2);
        }
      }
    }
  }
}
