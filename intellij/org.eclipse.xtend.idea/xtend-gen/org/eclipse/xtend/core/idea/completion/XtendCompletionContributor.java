/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.completion;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.codeInsight.completion.InsertHandler;
import com.intellij.codeInsight.completion.InsertionContext;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.editor.RangeMarker;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.openapi.editor.ScrollingModel;
import com.intellij.openapi.editor.SelectionModel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.tree.TokenSet;
import com.intellij.util.ProcessingContext;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.core.idea.completion.AbstractXtendCompletionContributor;
import org.eclipse.xtend.core.idea.editorActions.XtendTokenSetProvider;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmExecutable;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.idea.document.DocumentUtils;
import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;
import org.eclipse.xtext.psi.XtextPsiExtensions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.ide.contentassist.OverrideProposalUtil;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedConstructor;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedExecutable;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class XtendCompletionContributor extends AbstractXtendCompletionContributor {
  @Inject
  @Extension
  private XtextPsiExtensions _xtextPsiExtensions;
  
  @Inject
  private XtendTokenSetProvider tokenSetProvider;
  
  @Inject
  private IJvmModelAssociations jvmModelAssociations;
  
  @Inject
  private OverrideProposalUtil overrideProposalUtil;
  
  @Inject
  private RewritableImportSection.Factory importSectionfactory;
  
  @Inject
  @Extension
  private DocumentUtils documentUtils;
  
  public XtendCompletionContributor() {
    this(XtendLanguage.INSTANCE);
  }
  
  public XtendCompletionContributor(final AbstractXtextLanguage lang) {
    super(lang);
    this.completeAbstractSuperMethods();
    this.completeFrenchQuote();
  }
  
  protected void completeFrenchQuote() {
    TokenSet _richStringLiteralTokens = this.tokenSetProvider.getRichStringLiteralTokens();
    final CompletionProvider<CompletionParameters> _function = new CompletionProvider<CompletionParameters>() {
      @Override
      protected void addCompletions(final CompletionParameters $0, final ProcessingContext $1, final CompletionResultSet $2) {
        LookupElementBuilder _create = LookupElementBuilder.create("«");
        final InsertHandler<LookupElement> _function = new InsertHandler<LookupElement>() {
          @Override
          public void handleInsert(final InsertionContext context, final LookupElement item) {
            Editor _editor = context.getEditor();
            EditorModificationUtil.insertStringAtCaret(_editor, "»", false, false);
          }
        };
        LookupElementBuilder _withInsertHandler = _create.withInsertHandler(_function);
        XtendCompletionContributor.this._completionExtensions.operator_add($2, _withInsertHandler);
      }
    };
    this.extend(
      CompletionType.BASIC, 
      new TokenSet[] { _richStringLiteralTokens }, _function);
  }
  
  protected void completeAbstractSuperMethods() {
    final CompletionProvider<CompletionParameters> _function = new CompletionProvider<CompletionParameters>() {
      @Override
      protected void addCompletions(final CompletionParameters $0, final ProcessingContext $1, final CompletionResultSet $2) {
        final PsiElement psiElement = $0.getPosition();
        EObject _findEObject = XtendCompletionContributor.this._xtextPsiExtensions.findEObject(psiElement);
        XtendTypeDeclaration _containerOfType = null;
        if (_findEObject!=null) {
          _containerOfType=EcoreUtil2.<XtendTypeDeclaration>getContainerOfType(_findEObject, XtendTypeDeclaration.class);
        }
        final XtendTypeDeclaration clazz = _containerOfType;
        boolean _equals = Objects.equal(clazz, null);
        if (_equals) {
          return;
        }
        final EObject jvmType = XtendCompletionContributor.this.jvmModelAssociations.getPrimaryJvmElement(clazz);
        if ((jvmType instanceof JvmGenericType)) {
          boolean _isAnonymous = clazz.isAnonymous();
          final List<IResolvedExecutable> candidates = XtendCompletionContributor.this.overrideProposalUtil.getImplementationCandidates(((JvmDeclaredType)jvmType), _isAnonymous);
          for (final IResolvedExecutable candidate : candidates) {
            if ((candidate instanceof IResolvedOperation)) {
              final InsertHandler<LookupElement> _function = new InsertHandler<LookupElement>() {
                @Override
                public void handleInsert(final InsertionContext context, final LookupElement item) {
                  Document _document = context.getDocument();
                  int _startOffset = context.getStartOffset();
                  int _tailOffset = context.getTailOffset();
                  _document.deleteString(_startOffset, _tailOffset);
                  context.commitDocument();
                  Resource _eResource = clazz.eResource();
                  final RewritableImportSection importSection = XtendCompletionContributor.this.importSectionfactory.parse(((XtextResource) _eResource));
                  StringConcatenation _builder = new StringConcatenation();
                  _builder.append("override ");
                  List<JvmTypeParameter> _typeParameters = ((IResolvedOperation)candidate).getTypeParameters();
                  final Function1<JvmTypeParameter, CharSequence> _function = new Function1<JvmTypeParameter, CharSequence>() {
                    @Override
                    public CharSequence apply(final JvmTypeParameter it) {
                      return it.getName();
                    }
                  };
                  String _join = IterableExtensions.<JvmTypeParameter>join(_typeParameters, "<", ",", "> ", _function);
                  _builder.append(_join, "");
                  JvmOperation _declaration = ((IResolvedOperation)candidate).getDeclaration();
                  String _simpleName = _declaration.getSimpleName();
                  _builder.append(_simpleName, "");
                  _builder.append("(");
                  ArrayList<String> _parameterText = XtendCompletionContributor.this.getParameterText(candidate, importSection);
                  String _join_1 = IterableExtensions.join(_parameterText, ", ");
                  _builder.append(_join_1, "");
                  _builder.append(") ");
                  JvmOperation _declaration_1 = ((IResolvedOperation)candidate).getDeclaration();
                  EList<JvmTypeReference> _exceptions = _declaration_1.getExceptions();
                  final Function1<JvmTypeReference, CharSequence> _function_1 = new Function1<JvmTypeReference, CharSequence>() {
                    @Override
                    public CharSequence apply(final JvmTypeReference it) {
                      return XtendCompletionContributor.this.documentUtils.toImportableString(it, importSection);
                    }
                  };
                  String _join_2 = IterableExtensions.<JvmTypeReference>join(_exceptions, "throws ", ", ", " ", _function_1);
                  _builder.append(_join_2, "");
                  _builder.append("{");
                  _builder.newLineIfNotEmpty();
                  _builder.append("\t");
                  _builder.append(XtendCompletionContributor.START_SELECTION_MARKER, "\t");
                  _builder.append("throw new UnsupportedOperationException()");
                  _builder.append(XtendCompletionContributor.END_SELECTION_MARKER, "\t");
                  _builder.newLineIfNotEmpty();
                  _builder.append("}");
                  _builder.newLine();
                  XtendCompletionContributor.this.insertAndAdjust(context, _builder.toString());
                  Document _document_1 = context.getDocument();
                  XtendCompletionContributor.this.documentUtils.updateImportSection(_document_1, importSection);
                }
              };
              LookupElementBuilder _createOverrideMethodElement = XtendCompletionContributor.this.createOverrideMethodElement(((IResolvedOperation)candidate), _function);
              $2.addElement(_createOverrideMethodElement);
            } else {
              if ((candidate instanceof IResolvedConstructor)) {
                final InsertHandler<LookupElement> _function_1 = new InsertHandler<LookupElement>() {
                  @Override
                  public void handleInsert(final InsertionContext context, final LookupElement item) {
                    Document _document = context.getDocument();
                    int _startOffset = context.getStartOffset();
                    int _tailOffset = context.getTailOffset();
                    _document.deleteString(_startOffset, _tailOffset);
                    context.commitDocument();
                    Resource _eResource = clazz.eResource();
                    final RewritableImportSection importSection = XtendCompletionContributor.this.importSectionfactory.parse(((XtextResource) _eResource));
                    StringConcatenation _builder = new StringConcatenation();
                    _builder.append("new (");
                    ArrayList<String> _parameterText = XtendCompletionContributor.this.getParameterText(candidate, importSection);
                    String _join = IterableExtensions.join(_parameterText, ", ");
                    _builder.append(_join, "");
                    _builder.append(") ");
                    JvmConstructor _declaration = ((IResolvedConstructor)candidate).getDeclaration();
                    EList<JvmTypeReference> _exceptions = _declaration.getExceptions();
                    final Function1<JvmTypeReference, CharSequence> _function = new Function1<JvmTypeReference, CharSequence>() {
                      @Override
                      public CharSequence apply(final JvmTypeReference it) {
                        return XtendCompletionContributor.this.documentUtils.toImportableString(it, importSection);
                      }
                    };
                    String _join_1 = IterableExtensions.<JvmTypeReference>join(_exceptions, "throws ", ", ", " ", _function);
                    _builder.append(_join_1, "");
                    _builder.append("{");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("super(");
                    JvmConstructor _declaration_1 = ((IResolvedConstructor)candidate).getDeclaration();
                    EList<JvmFormalParameter> _parameters = _declaration_1.getParameters();
                    final Function1<JvmFormalParameter, CharSequence> _function_1 = new Function1<JvmFormalParameter, CharSequence>() {
                      @Override
                      public CharSequence apply(final JvmFormalParameter it) {
                        return it.getName();
                      }
                    };
                    String _join_2 = IterableExtensions.<JvmFormalParameter>join(_parameters, ", ", _function_1);
                    _builder.append(_join_2, "\t");
                    _builder.append(")");
                    _builder.append(XtendCompletionContributor.SELECTION_MARKER, "\t");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                    XtendCompletionContributor.this.insertAndAdjust(context, _builder.toString());
                    Document _document_1 = context.getDocument();
                    XtendCompletionContributor.this.documentUtils.updateImportSection(_document_1, importSection);
                  }
                };
                LookupElementBuilder _createOverrideConstructorElement = XtendCompletionContributor.this.createOverrideConstructorElement(((IResolvedConstructor)candidate), _function_1);
                $2.addElement(_createOverrideConstructorElement);
              }
            }
          }
        }
      }
    };
    this.extend(
      CompletionType.BASIC, 
      XtendPackage.Literals.XTEND_TYPE_DECLARATION__MEMBERS, _function);
  }
  
  private final static String START_SELECTION_MARKER = "<START_SELECTION>";
  
  private final static String END_SELECTION_MARKER = "<END_SELECTION>";
  
  private final static String SELECTION_MARKER = "<CURSOR>";
  
  protected void insertAndAdjust(final InsertionContext context, final String toInsert) {
    final int startIndex = toInsert.indexOf(XtendCompletionContributor.START_SELECTION_MARKER);
    String cleanedText = toInsert.replace(XtendCompletionContributor.START_SELECTION_MARKER, "");
    final int endIndex = cleanedText.indexOf(XtendCompletionContributor.END_SELECTION_MARKER);
    String _replace = cleanedText.replace(XtendCompletionContributor.END_SELECTION_MARKER, "");
    cleanedText = _replace;
    final int cursorIndex = cleanedText.indexOf(XtendCompletionContributor.SELECTION_MARKER);
    String _replace_1 = cleanedText.replace(XtendCompletionContributor.SELECTION_MARKER, "");
    cleanedText = _replace_1;
    int _xifexpression = (int) 0;
    if ((cursorIndex != (-1))) {
      _xifexpression = cursorIndex;
    } else {
      _xifexpression = startIndex;
    }
    final int start = _xifexpression;
    int _xifexpression_1 = (int) 0;
    if ((cursorIndex != (-1))) {
      _xifexpression_1 = cursorIndex;
    } else {
      _xifexpression_1 = endIndex;
    }
    final int end = _xifexpression_1;
    Document _document = context.getDocument();
    int _startOffset = context.getStartOffset();
    _document.insertString(_startOffset, cleanedText);
    Document _document_1 = context.getDocument();
    int _startOffset_1 = context.getStartOffset();
    int _startOffset_2 = context.getStartOffset();
    int _length = cleanedText.length();
    int _plus = (_startOffset_2 + _length);
    RangeMarker fullChange = _document_1.createRangeMarker(_startOffset_1, _plus);
    final Editor editor = context.getEditor();
    CaretModel _caretModel = editor.getCaretModel();
    int _startOffset_3 = fullChange.getStartOffset();
    int _min = Math.min(start, end);
    int _plus_1 = (_startOffset_3 + _min);
    _caretModel.moveToOffset(_plus_1);
    ScrollingModel _scrollingModel = editor.getScrollingModel();
    _scrollingModel.scrollToCaret(ScrollType.RELATIVE);
    if ((start < end)) {
      SelectionModel _selectionModel = editor.getSelectionModel();
      int _startOffset_4 = fullChange.getStartOffset();
      int _plus_2 = (_startOffset_4 + start);
      int _startOffset_5 = fullChange.getStartOffset();
      int _plus_3 = (_startOffset_5 + end);
      _selectionModel.setSelection(_plus_2, _plus_3);
    }
    context.commitDocument();
    Project _project = context.getProject();
    PsiDocumentManager _instance = PsiDocumentManager.getInstance(_project);
    Document _document_2 = context.getDocument();
    _instance.doPostponedOperationsAndUnblockDocument(_document_2);
    boolean _isValid = fullChange.isValid();
    if (_isValid) {
      Project _project_1 = context.getProject();
      CodeStyleManager _instance_1 = CodeStyleManager.getInstance(_project_1);
      PsiFile _file = context.getFile();
      int _startOffset_6 = fullChange.getStartOffset();
      int _endOffset = fullChange.getEndOffset();
      TextRange _textRange = new TextRange(_startOffset_6, _endOffset);
      _instance_1.adjustLineIndent(_file, _textRange);
    }
  }
  
  protected ArrayList<String> getParameterText(final IResolvedExecutable executable, final RewritableImportSection importSection) {
    final ArrayList<String> result = CollectionLiterals.<String>newArrayList();
    for (int i = 0; (i < executable.getDeclaration().getParameters().size()); i++) {
      StringConcatenation _builder = new StringConcatenation();
      List<LightweightTypeReference> _resolvedParameterTypes = executable.getResolvedParameterTypes();
      LightweightTypeReference _get = _resolvedParameterTypes.get(i);
      String _importableString = this.documentUtils.toImportableString(_get, importSection);
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
  
  protected LookupElementBuilder createOverrideMethodElement(final IResolvedOperation prototype, final InsertHandler<LookupElement> insertHandler) {
    JvmOperation _declaration = prototype.getDeclaration();
    String methodName = _declaration.getSimpleName();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("override ");
    _builder.append(methodName, "");
    _builder.append("(");
    List<LightweightTypeReference> _resolvedParameterTypes = prototype.getResolvedParameterTypes();
    final Function1<LightweightTypeReference, CharSequence> _function = new Function1<LightweightTypeReference, CharSequence>() {
      @Override
      public CharSequence apply(final LightweightTypeReference it) {
        return it.getHumanReadableName();
      }
    };
    String _join = IterableExtensions.<LightweightTypeReference>join(_resolvedParameterTypes, ",", _function);
    _builder.append(_join, "");
    _builder.append(")");
    String signature = _builder.toString();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("override ");
    _builder_1.append(signature, "");
    String overrideSignature = _builder_1.toString();
    LookupElementBuilder _create = LookupElementBuilder.create(prototype, signature);
    LookupElementBuilder _withLookupString = _create.withLookupString(methodName);
    LookupElementBuilder _withLookupString_1 = _withLookupString.withLookupString(overrideSignature);
    LookupElementBuilder _withInsertHandler = _withLookupString_1.withInsertHandler(insertHandler);
    LookupElementBuilder _appendTailText = _withInsertHandler.appendTailText(" {...}", true);
    LightweightTypeReference _resolvedDeclarator = prototype.getResolvedDeclarator();
    String _humanReadableName = _resolvedDeclarator.getHumanReadableName();
    LookupElementBuilder _withTypeText = _appendTailText.withTypeText(_humanReadableName);
    LookupElementBuilder element = _withTypeText.withIcon(AllIcons.Nodes.Method);
    return element;
  }
  
  protected LookupElementBuilder createOverrideConstructorElement(final IResolvedConstructor prototype, final InsertHandler<LookupElement> insertHandler) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("new (");
    List<LightweightTypeReference> _resolvedParameterTypes = prototype.getResolvedParameterTypes();
    final Function1<LightweightTypeReference, CharSequence> _function = new Function1<LightweightTypeReference, CharSequence>() {
      @Override
      public CharSequence apply(final LightweightTypeReference it) {
        return it.getHumanReadableName();
      }
    };
    String _join = IterableExtensions.<LightweightTypeReference>join(_resolvedParameterTypes, ",", _function);
    _builder.append(_join, "");
    _builder.append(")");
    String signature = _builder.toString();
    LookupElementBuilder _create = LookupElementBuilder.create(prototype, signature);
    LookupElementBuilder _withLookupString = _create.withLookupString(signature);
    LookupElementBuilder _withInsertHandler = _withLookupString.withInsertHandler(insertHandler);
    LookupElementBuilder _appendTailText = _withInsertHandler.appendTailText(" {...}", true);
    LightweightTypeReference _resolvedDeclarator = prototype.getResolvedDeclarator();
    String _humanReadableName = _resolvedDeclarator.getHumanReadableName();
    LookupElementBuilder _withTypeText = _appendTailText.withTypeText(_humanReadableName);
    LookupElementBuilder element = _withTypeText.withIcon(AllIcons.Nodes.Method);
    return element;
  }
}
