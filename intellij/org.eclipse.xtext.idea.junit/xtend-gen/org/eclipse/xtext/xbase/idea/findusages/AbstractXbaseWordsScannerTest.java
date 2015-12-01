package org.eclipse.xtext.xbase.idea.findusages;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.cacheBuilder.WordOccurrence;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.testFramework.UsefulTestCase;
import com.intellij.util.Processor;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Set;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.idea.findusages.WordsScannerProvider;
import org.eclipse.xtext.idea.tests.LightToolingTest;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

@SuppressWarnings("all")
public abstract class AbstractXbaseWordsScannerTest extends LightToolingTest {
  @Inject
  private OperatorMapping operatorMapping;
  
  @Inject
  private WordsScannerProvider wordsScannerProvider;
  
  public AbstractXbaseWordsScannerTest(final LanguageFileType fileType) {
    super(fileType);
  }
  
  public void testProcessWords_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("value");
    this.assertWords(_builder, "value");
  }
  
  public void testProcessWords_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("1");
    this.assertWords(_builder, "1");
  }
  
  public void testProcessWords_03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("*");
    this.assertWords(_builder, "*");
  }
  
  public void testProcessWords_04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("value * 1");
    this.assertWords(_builder, "value", "*", "1");
  }
  
  public void testProcessOperator_01() {
    final Set<QualifiedName> operators = this.operatorMapping.getOperators();
    String _join = IterableExtensions.join(operators, " ");
    final Function1<QualifiedName, String> _function = new Function1<QualifiedName, String>() {
      @Override
      public String apply(final QualifiedName it) {
        return it.toString();
      }
    };
    Iterable<String> _map = IterableExtensions.<QualifiedName, String>map(operators, _function);
    this.assertWords(_join, ((String[])Conversions.unwrapArray(_map, String.class)));
  }
  
  public void testProcessOperator_02() {
    final Set<QualifiedName> operators = this.operatorMapping.getOperators();
    final LinkedList<String> expectedWords = CollectionLiterals.<String>newLinkedList();
    expectedWords.add("before");
    for (final QualifiedName operator : operators) {
      {
        String _string = operator.toString();
        expectedWords.add(_string);
        QualifiedName _last = IterableExtensions.<QualifiedName>last(operators);
        boolean _notEquals = (!Objects.equal(operator, _last));
        if (_notEquals) {
          expectedWords.add("foo");
          expectedWords.add("bar");
        }
      }
    }
    expectedWords.add("after");
    final Function1<QualifiedName, CharSequence> _function = new Function1<QualifiedName, CharSequence>() {
      @Override
      public CharSequence apply(final QualifiedName it) {
        return it.toString();
      }
    };
    String _join = IterableExtensions.<QualifiedName>join(operators, "before ", " foo bar ", " after", _function);
    this.assertWords(_join, ((String[])Conversions.unwrapArray(expectedWords, String.class)));
  }
  
  public void testProcessCompoundOperators() {
    final Set<QualifiedName> operators = this.operatorMapping.getCompoundOperators();
    String _join = IterableExtensions.join(operators, " ");
    final Function1<QualifiedName, String> _function = new Function1<QualifiedName, String>() {
      @Override
      public String apply(final QualifiedName it) {
        return it.toString();
      }
    };
    Iterable<String> _map = IterableExtensions.<QualifiedName, String>map(operators, _function);
    this.assertWords(_join, ((String[])Conversions.unwrapArray(_map, String.class)));
  }
  
  protected void assertWords(final CharSequence text, final String... expectedWords) {
    final Collection<String> words = CollectionLiterals.<String>newLinkedList();
    final WordsScanner wordsScanner = this.wordsScannerProvider.get();
    final Processor<WordOccurrence> _function = new Processor<WordOccurrence>() {
      @Override
      public boolean process(final WordOccurrence it) {
        CharSequence _baseText = it.getBaseText();
        int _start = it.getStart();
        int _end = it.getEnd();
        CharSequence _subSequence = _baseText.subSequence(_start, _end);
        String _string = _subSequence.toString();
        return words.add(_string);
      }
    };
    wordsScanner.processWords(text, _function);
    String _string = text.toString();
    UsefulTestCase.<String>assertOrderedEquals(_string, words, expectedWords);
  }
}
