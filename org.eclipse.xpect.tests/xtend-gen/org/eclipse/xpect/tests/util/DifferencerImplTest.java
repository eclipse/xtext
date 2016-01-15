package org.eclipse.xpect.tests.util;

import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.eclipse.xpect.util.DifferencerImpl;
import org.eclipse.xpect.util.IDifferencer;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class DifferencerImplTest {
  private String diff(final List<String> left, final List<String> right) {
    DifferencerImpl _differencerImpl = new DifferencerImpl();
    final IDifferencer.ISimilarityFunction<String> _function = new IDifferencer.ISimilarityFunction<String>() {
      @Override
      public float similarity(final String s1, final String s2) {
        char[] _charArray = s1.toCharArray();
        final Set<Character> set1 = IterableExtensions.<Character>toSet(((Iterable<Character>)Conversions.doWrapArray(_charArray)));
        char[] _charArray_1 = s2.toCharArray();
        final Set<Character> set2 = IterableExtensions.<Character>toSet(((Iterable<Character>)Conversions.doWrapArray(_charArray_1)));
        Sets.SetView<Character> _intersection = Sets.<Character>intersection(set1, set2);
        int _size = _intersection.size();
        final float overlap = ((float) _size);
        int _size_1 = set1.size();
        int _size_2 = set2.size();
        int _max = Math.max(_size_1, _size_2);
        final float size = ((float) _max);
        return (1 - (overlap / size));
      }
    };
    final List<IDifferencer.Match> diff = _differencerImpl.<String>diff(left, right, _function);
    return IterableExtensions.join(diff, "\n");
  }
  
  @Test
  public void testOneMatch() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[0==0]");
    _builder.newLine();
    String _diff = this.diff(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A")));
    this.operator_tripleEquals(_builder.toString(), _diff);
  }
  
  @Test
  public void testTwoMatches() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[0==0]");
    _builder.newLine();
    _builder.append("[1==1]");
    _builder.newLine();
    String _diff = this.diff(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B")));
    this.operator_tripleEquals(_builder.toString(), _diff);
  }
  
  @Test
  public void testThreeMatches() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[0==0]");
    _builder.newLine();
    _builder.append("[1==1]");
    _builder.newLine();
    _builder.append("[2==2]");
    _builder.newLine();
    String _diff = this.diff(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B", "C")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B", "C")));
    this.operator_tripleEquals(_builder.toString(), _diff);
  }
  
  @Test
  public void testInsertRightBeginning() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[---0]");
    _builder.newLine();
    _builder.append("[0==1]");
    _builder.newLine();
    _builder.append("[1==2]");
    _builder.newLine();
    String _diff = this.diff(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("B", "C")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B", "C")));
    this.operator_tripleEquals(_builder.toString(), _diff);
  }
  
  @Test
  public void testInsertRightMiddle() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[0==0]");
    _builder.newLine();
    _builder.append("[---1]");
    _builder.newLine();
    _builder.append("[1==2]");
    _builder.newLine();
    String _diff = this.diff(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "C")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B", "C")));
    this.operator_tripleEquals(_builder.toString(), _diff);
  }
  
  @Test
  public void testInsertRightEnd() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[0==0]");
    _builder.newLine();
    _builder.append("[1==1]");
    _builder.newLine();
    _builder.append("[---2]");
    _builder.newLine();
    String _diff = this.diff(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B", "C")));
    this.operator_tripleEquals(_builder.toString(), _diff);
  }
  
  @Test
  @Ignore
  public void testRemoveMiddle() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("[0==0]");
    _builder.newLine();
    _builder.append("[1---]");
    _builder.newLine();
    _builder.append("[2---]");
    _builder.newLine();
    _builder.append("[3---]");
    _builder.newLine();
    _builder.append("[4==1]");
    _builder.newLine();
    String _diff = this.diff(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "B", "B", "B", "C")), Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("A", "C")));
    this.operator_tripleEquals(_builder.toString(), _diff);
  }
  
  public void operator_tripleEquals(final Object o1, final Object o2) {
    String _string = o1.toString();
    String _trim = _string.trim();
    String _string_1 = o2.toString();
    String _trim_1 = _string_1.trim();
    Assert.assertEquals(_trim, _trim_1);
  }
}
