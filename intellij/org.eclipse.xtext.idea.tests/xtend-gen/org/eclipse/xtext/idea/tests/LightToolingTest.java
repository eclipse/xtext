package org.eclipse.xtext.idea.tests;

import com.google.common.base.Objects;
import com.intellij.codeInsight.CodeInsightSettings;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.ide.highlighter.HighlighterFactory;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.editor.markup.TextAttributes;
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
import com.intellij.testFramework.LightProjectDescriptor;
import com.intellij.testFramework.fixtures.JavaCodeInsightTestFixture;
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase;
import java.util.List;
import junit.framework.TestCase;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.junit4.internal.LineDelimiters;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class LightToolingTest extends LightCodeInsightFixtureTestCase {
  private final LanguageFileType fileType;
  
  @Extension
  protected JavaCodeInsightTestFixture myFixture;
  
  public LightToolingTest(final LanguageFileType fileType) {
    this.fileType = fileType;
    IXtextLanguage _xtextLanguage = this.getXtextLanguage();
    _xtextLanguage.injectMembers(this);
  }
  
  protected void setUp() throws Exception {
    super.setUp();
    this.myFixture = super.myFixture;
    CodeInsightSettings _instance = CodeInsightSettings.getInstance();
    _instance.AUTOCOMPLETE_ON_CODE_COMPLETION = false;
  }
  
  protected void tearDown() throws Exception {
    CodeInsightSettings _instance = CodeInsightSettings.getInstance();
    _instance.AUTOCOMPLETE_ON_CODE_COMPLETION = true;
    super.tearDown();
  }
  
  protected final IXtextLanguage getXtextLanguage() {
    Language _language = this.fileType.getLanguage();
    return ((IXtextLanguage) _language);
  }
  
  protected LightProjectDescriptor getProjectDescriptor() {
    return new LightProjectDescriptor() {
      public void configureModule(final Module module, final ModifiableRootModel model, final ContentEntry contentEntry) {
        final LanguageLevelModuleExtension languageLevelModuleExtension = model.<LanguageLevelModuleExtension>getModuleExtension(LanguageLevelModuleExtension.class);
        boolean _notEquals = (!Objects.equal(languageLevelModuleExtension, null));
        if (_notEquals) {
          LanguageLevel _languageLevel = LightToolingTest.this.getLanguageLevel();
          languageLevelModuleExtension.setLanguageLevel(_languageLevel);
        }
        LightToolingTest.this.configureModule(module, model, contentEntry);
      }
      
      public ModuleType<?> getModuleType() {
        return StdModuleTypes.JAVA;
      }
      
      public Sdk getSdk() {
        return LightToolingTest.this.getSdk();
      }
    };
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
          final TextAttributes textAttributes = highlights.getTextAttributes();
          int end = highlights.getEnd();
          while (((!highlights.atEnd()) && Objects.equal(highlights.getTextAttributes(), textAttributes))) {
            {
              int _end = highlights.getEnd();
              end = _end;
              highlights.advance();
            }
          }
          StringConcatenation _builder = new StringConcatenation();
          _builder.append(start, "");
          _builder.append("-");
          _builder.append(end, "");
          _builder.append(":");
          _builder.append(textAttributes, "");
          compactHighlights.append(_builder);
          compactHighlights.append("\n");
        }
      }
      _xblockexpression = compactHighlights.toString();
    }
    return _xblockexpression;
  }
  
  protected BaseXtextFile getXtextFile() {
    PsiFile _file = this.myFixture.getFile();
    return ((BaseXtextFile) _file);
  }
}
