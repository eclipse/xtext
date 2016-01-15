package org.eclipse.xpect.tests.text;

import java.util.List;
import org.eclipse.xpect.text.GenericTokenizer;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class GenericTokenizerTest {
  @Test
  public void testSimple() {
    this.operator_tripleEquals(
      "aa| |12| |+|-|\r\n |AbCd", "aa 12 +-\r\n AbCd");
  }
  
  @Test
  public void testWord() {
    this.operator_tripleEquals(
      "ab123cd456| |456|ab345", "ab123cd456 456ab345");
  }
  
  @Test
  public void testSymbols() {
    this.operator_tripleEquals(
      ";|;|\'|\'|]|]|\\|<|<|>|>|?|?|:|:|\"|\"|}|}|{|{||||", ";;\'\']]\\<<>>??::\"\"}}{{||");
    this.operator_tripleEquals(
      "_|_|+|+|-|-|=|=|,|,|.|.|/|/|;|;", "__++--==,,..//;;");
    this.operator_tripleEquals(
      "!|!|@|@|#|#|$|$|%|%|^|^|&|&|*|*|(|(|)|)", "!!@@##$$%%^^&&**(())");
  }
  
  public void operator_tripleEquals(final Object o1, final Object o2) {
    GenericTokenizer _genericTokenizer = new GenericTokenizer();
    String _string = o2.toString();
    List<String> _apply = _genericTokenizer.apply(_string);
    final String tokenized = IterableExtensions.join(_apply, "|");
    String _string_1 = o1.toString();
    Assert.assertEquals(_string_1, tokenized);
  }
}
