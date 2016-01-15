package org.eclipse.xpect.tests.text;

import java.util.Collections;
import org.eclipse.xpect.text.ITextDifferencer;
import org.eclipse.xpect.text.StringEndsSimilarityFunction;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class TextDiffConfig implements ITextDifferencer.ITextDiffConfig<String> {
  @Override
  public boolean isHidden(final String token, final String segment) {
    char[] _charArray = token.toCharArray();
    final Function1<Character, Boolean> _function = new Function1<Character, Boolean>() {
      @Override
      public Boolean apply(final Character it) {
        return Boolean.valueOf(Character.isWhitespace((it).charValue()));
      }
    };
    return IterableExtensions.<Character>forall(((Iterable<Character>)Conversions.doWrapArray(_charArray)), _function);
  }
  
  @Override
  public Iterable<String> toSegments(final String token) {
    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(token));
  }
  
  @Override
  public float similarity(final ITextDifferencer.ISegment object1, final ITextDifferencer.ISegment object2) {
    StringEndsSimilarityFunction _stringEndsSimilarityFunction = new StringEndsSimilarityFunction();
    String _string = object1.toString();
    String _string_1 = object2.toString();
    return _stringEndsSimilarityFunction.similarity(_string, _string_1);
  }
}
