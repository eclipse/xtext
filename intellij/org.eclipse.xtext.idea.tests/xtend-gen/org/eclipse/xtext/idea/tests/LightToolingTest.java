/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.tests;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.codeInsight.CodeInsightSettings;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.facet.Facet;
import com.intellij.facet.FacetConfiguration;
import com.intellij.facet.FacetManager;
import com.intellij.facet.FacetType;
import com.intellij.facet.FacetTypeRegistry;
import com.intellij.formatting.Block;
import com.intellij.formatting.FormattingModel;
import com.intellij.formatting.FormattingModelBuilder;
import com.intellij.formatting.FormattingModelDumper;
import com.intellij.ide.highlighter.HighlighterFactory;
import com.intellij.ide.structureView.newStructureView.StructureViewComponent;
import com.intellij.ide.util.treeView.AbstractTreeStructure;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageFormatting;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleType;
import com.intellij.openapi.module.StdModuleTypes;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.projectRoots.impl.JavaAwareProjectJdkTableImpl;
import com.intellij.openapi.roots.ContentEntry;
import com.intellij.openapi.roots.LanguageLevelModuleExtension;
import com.intellij.openapi.roots.ModifiableRootModel;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.pom.java.LanguageLevel;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsManager;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.tree.IElementType;
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.PlatformTestUtil;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import com.intellij.util.Consumer;
import com.intellij.util.ui.tree.TreeUtil;
import java.util.List;
import javax.swing.JTree;
import junit.framework.TestCase;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.idea.build.XtextAutoBuilderComponent;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.parser.TokenTypeProvider;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LightToolingTest extends LightCodeInsightFixtureTestCase {
  @Inject
  @Extension
  private TokenTypeProvider tokenTypeProvider;
  
  @Inject
  @Extension
  private AbstractAntlrTokenToAttributeIdMapper tokenToAttributeIdMapper;
  
  @Accessors
  private final LanguageFileType fileType;
  
  public LightToolingTest(final LanguageFileType fileType) {
    XtextAutoBuilderComponent.TEST_MODE = true;
    this.fileType = fileType;
  }
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    IXtextLanguage _xtextLanguage = this.getXtextLanguage();
    _xtextLanguage.injectMembers(this);
    CodeInsightSettings _instance = CodeInsightSettings.getInstance();
    _instance.AUTOCOMPLETE_ON_CODE_COMPLETION = false;
    CodeStyleSettings _codeStyleSettings = this.getCodeStyleSettings();
    CommonCodeStyleSettings.IndentOptions _indentOptions = _codeStyleSettings.getIndentOptions();
    _indentOptions.USE_TAB_CHARACTER = true;
  }
  
  @Override
  protected void tearDown() throws Exception {
    CodeInsightSettings _instance = CodeInsightSettings.getInstance();
    _instance.AUTOCOMPLETE_ON_CODE_COMPLETION = true;
    super.tearDown();
  }
  
  protected final IXtextLanguage getXtextLanguage() {
    Language _language = this.fileType.getLanguage();
    return ((IXtextLanguage) _language);
  }
  
  @Override
  protected LightProjectDescriptor getProjectDescriptor() {
    return new LightProjectDescriptor() {
      @Override
      public void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
        final LanguageLevelModuleExtension languageLevelModuleExtension = model.<LanguageLevelModuleExtension>getModuleExtension(LanguageLevelModuleExtension.class);
        boolean _notEquals = (!Objects.equal(languageLevelModuleExtension, null));
        if (_notEquals) {
          LanguageLevel _languageLevel = LightToolingTest.this.getLanguageLevel();
          languageLevelModuleExtension.setLanguageLevel(_languageLevel);
        }
        Language _language = LightToolingTest.this.fileType.getLanguage();
        String _iD = _language.getID();
        LightToolingTest.addFacetToModule(module, _iD);
        LightToolingTest.this.configureModule(module, model, contentEntry);
      }
      
      @Override
      public ModuleType<?> getModuleType() {
        return StdModuleTypes.JAVA;
      }
      
      @Override
      public Sdk getSdk() {
        return LightToolingTest.this.getSdk();
      }
    };
  }
  
  public static void addFacetToModule(final Module module, final String languageId) {
    final FacetManager mnr = FacetManager.getInstance(module);
    FacetTypeRegistry _instance = FacetTypeRegistry.getInstance();
    FacetType[] _facetTypes = _instance.getFacetTypes();
    final Function1<FacetType, Boolean> _function = new Function1<FacetType, Boolean>() {
      @Override
      public Boolean apply(final FacetType it) {
        String _stringId = it.getStringId();
        return Boolean.valueOf(Objects.equal(_stringId, languageId));
      }
    };
    final FacetType facetType = IterableExtensions.<FacetType>findFirst(((Iterable<FacetType>)Conversions.doWrapArray(_facetTypes)), _function);
    Application _application = ApplicationManager.getApplication();
    final Runnable _function_1 = new Runnable() {
      @Override
      public void run() {
        String _defaultFacetName = facetType.getDefaultFacetName();
        mnr.<Facet, FacetConfiguration>addFacet(facetType, _defaultFacetName, null);
        return;
      }
    };
    _application.runWriteAction(_function_1);
  }
  
  protected Sdk getSdk() {
    JavaAwareProjectJdkTableImpl _instanceEx = JavaAwareProjectJdkTableImpl.getInstanceEx();
    return _instanceEx.getInternalJdk();
  }
  
  protected LanguageLevel getLanguageLevel() {
    return LanguageLevel.JDK_1_6;
  }
  
  protected void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
  }
  
  protected PsiFile configureByText(final String code) {
    String _unix = LineDelimiters.toUnix(code);
    return this.myFixture.configureByText(this.fileType, _unix);
  }
  
  protected void configureByText(final String path, final String code) {
    String _defaultExtension = this.fileType.getDefaultExtension();
    String _plus = ((path + ".") + _defaultExtension);
    String _unix = LineDelimiters.toUnix(code);
    final PsiFile psiFile = this.myFixture.addFileToProject(_plus, _unix);
    VirtualFile _virtualFile = psiFile.getVirtualFile();
    this.myFixture.configureFromExistingVirtualFile(_virtualFile);
  }
  
  protected LookupElement[] complete(final String text) {
    LookupElement[] _xblockexpression = null;
    {
      this.configureByText(text);
      _xblockexpression = this.myFixture.completeBasic();
    }
    return _xblockexpression;
  }
  
  protected void assertLookupStrings(final String... items) {
    List<String> _list = IterableExtensions.<String>toList(((Iterable<String>)Conversions.doWrapArray(items)));
    List<String> _lookupElementStrings = this.myFixture.getLookupElementStrings();
    TestCase.assertEquals(_list, _lookupElementStrings);
  }
  
  protected void assertHighlights(final String lineDelimitedHighlights) {
    final String expectedHighlights = LineDelimiters.toUnix(lineDelimitedHighlights);
    Project _project = this.getProject();
    PsiFile _file = this.myFixture.getFile();
    VirtualFile _virtualFile = _file.getVirtualFile();
    EditorHighlighter _createHighlighter = HighlighterFactory.createHighlighter(_project, _virtualFile);
    final Procedure1<EditorHighlighter> _function = new Procedure1<EditorHighlighter>() {
      @Override
      public void apply(final EditorHighlighter it) {
        Editor _editor = LightToolingTest.this.myFixture.getEditor();
        Document _document = _editor.getDocument();
        String _text = _document.getText();
        it.setText(_text);
        Editor _editor_1 = LightToolingTest.this.myFixture.getEditor();
        EditorColorsScheme _colorsScheme = _editor_1.getColorsScheme();
        it.setColorScheme(_colorsScheme);
      }
    };
    final EditorHighlighter highlighter = ObjectExtensions.<EditorHighlighter>operator_doubleArrow(_createHighlighter, _function);
    final HighlighterIterator highlights = highlighter.createIterator(0);
    final String actualHighlights = this.compactHighlights(highlights);
    TestCase.assertEquals(expectedHighlights, actualHighlights);
  }
  
  protected String compactHighlights(final HighlighterIterator highlights) {
    String _xblockexpression = null;
    {
      final StringBuilder compactHighlights = new StringBuilder();
      while ((!highlights.atEnd())) {
        {
          final int start = highlights.getStart();
          final IElementType tokenType = highlights.getTokenType();
          int end = highlights.getEnd();
          while (((!highlights.atEnd()) && Objects.equal(highlights.getTokenType(), tokenType))) {
            {
              int _end = highlights.getEnd();
              end = _end;
              highlights.advance();
            }
          }
          String _xtextStyle = this.getXtextStyle(tokenType);
          boolean _notEquals = (!Objects.equal(_xtextStyle, HighlightingStyles.DEFAULT_ID));
          if (_notEquals) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append(start, "");
            _builder.append("-");
            _builder.append(end, "");
            _builder.append(":");
            String _xtextStyle_1 = this.getXtextStyle(tokenType);
            _builder.append(_xtextStyle_1, "");
            compactHighlights.append(_builder);
            compactHighlights.append("\n");
          }
        }
      }
      _xblockexpression = compactHighlights.toString();
    }
    return _xblockexpression;
  }
  
  protected String getXtextStyle(final IElementType tokenType) {
    int _antlrType = this.tokenTypeProvider.getAntlrType(tokenType);
    return this.tokenToAttributeIdMapper.getId(_antlrType);
  }
  
  protected BaseXtextFile getXtextFile() {
    PsiFile _file = this.myFixture.getFile();
    return ((BaseXtextFile) _file);
  }
  
  protected void testStructureView(final String model, final String expected) {
    final Consumer<StructureViewComponent> _function = new Consumer<StructureViewComponent>() {
      @Override
      public void consume(final StructureViewComponent component) {
        LightToolingTest.this.assertTreeStructure(component, expected);
      }
    };
    this.testStructureView(model, _function);
  }
  
  protected void assertTreeStructure(final StructureViewComponent component, final String expected) {
    JTree _tree = component.getTree();
    TreeUtil.expandAll(_tree);
    AbstractTreeStructure _treeStructure = component.getTreeStructure();
    PlatformTestUtil.assertTreeStructureEquals(_treeStructure, expected);
  }
  
  protected void testStructureView(final String model, final Consumer<StructureViewComponent> consumer) {
    this.myFixture.configureByText(this.fileType, model);
    this.testStructureView(consumer);
  }
  
  protected void testStructureView(final Consumer<StructureViewComponent> consumer) {
    this.myFixture.testStructureView(consumer);
  }
  
  protected CodeStyleSettings getCodeStyleSettings() {
    Project _project = this.getProject();
    return CodeStyleSettingsManager.getSettings(_project);
  }
  
  protected String dumpFormattingModel() {
    String _xblockexpression = null;
    {
      PsiFile _file = this.getFile();
      final FormattingModelBuilder formattingModelBuilder = LanguageFormatting.INSTANCE.forContext(_file);
      PsiFile _file_1 = this.getFile();
      CodeStyleSettings _codeStyleSettings = this.getCodeStyleSettings();
      FormattingModel _createModel = formattingModelBuilder.createModel(_file_1, _codeStyleSettings);
      final Block block = _createModel.getRootBlock();
      final StringBuilder builder = new StringBuilder();
      FormattingModelDumper.dumpFormattingModel(block, 0, builder);
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
  
  @Pure
  public LanguageFileType getFileType() {
    return this.fileType;
  }
}
