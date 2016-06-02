package org.eclipse.xpect.tests.text;

import java.util.Collections;
import java.util.List;
import org.eclipse.xpect.tests.text.TextDiffConfig;
import org.eclipse.xpect.text.ITextDifferencer;
import org.eclipse.xpect.text.TextDiffToString;
import org.eclipse.xpect.text.TextDifferencer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class TextDifferencerTest {
  @Test
  @Ignore
  public void testEqual() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("abc");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testDiffSL() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "d", "c"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("| a[b|d]c");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testRemoveSL() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "c"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("| a[b|]c");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testAddSL() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "c"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b", "c"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("| a[|b]c");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testDiffSLEnd() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "c"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("| a[b|c]");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testRemoveSLEnd() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("| a[b|]");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testAddSLEnd() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "b"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("| a[|b]");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testDiffML() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a\n", "b\n", "c\n"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a\n", "d\n", "c\n"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  ");
    _builder.append("a");
    _builder.newLine();
    _builder.append("- b");
    _builder.newLine();
    _builder.append("+ d");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("c");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testRemoveML() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a\n", "b\n", "c\n"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a\n", "c\n"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  ");
    _builder.append("a");
    _builder.newLine();
    _builder.append("- b");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("c");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testAddML() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a\n", "c\n"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a\n", "b\n", "c\n"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("  ");
    _builder.append("a");
    _builder.newLine();
    _builder.append("+ b");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("c");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  @Ignore
  public void testWhitespace() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "  ", "b"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "    ", "b"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("a  b");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testWhitespaceDiff() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "  ", "b", "   ", "c"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "    ", "c"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("| a  [b|]   c");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  @Test
  public void testWhitespaceDiff2() {
    final List<String> left = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "  ", "b", "   ", "c", "    ", "d"));
    final List<String> right = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "     ", "d"));
    String _diff = this.diff(left, right);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("| a  [b   c|]    d");
    _builder.newLine();
    this.operator_tripleEquals(_diff, _builder);
  }
  
  public String diff(final List<String> left, final List<String> right) {
    TextDiffToString _textDiffToString = new TextDiffToString();
    TextDiffToString _setAllowSingleLineDiff = _textDiffToString.setAllowSingleLineDiff(false);
    final TextDiffToString toStr = _setAllowSingleLineDiff.setAllowSingleSegmentDiff(false);
    TextDifferencer _textDifferencer = new TextDifferencer();
    TextDiffConfig _textDiffConfig = new TextDiffConfig();
    final ITextDifferencer.ITextDiff diff = _textDifferencer.<String>diff(left, right, _textDiffConfig);
    return toStr.apply(diff);
  }
  
  public void operator_tripleEquals(final Object o1, final Object o2) {
    String _string = o2.toString();
    String _trim = _string.trim();
    String _string_1 = o1.toString();
    String _trim_1 = _string_1.trim();
    Assert.assertEquals(_trim, _trim_1);
  }
}
