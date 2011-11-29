package xtend.tutorial.basics;

import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xtend05_Loops {
  /**
   * For expressions are just like in Java. The only difference is
   * that they are expressions (of type 'void') and that type
   * inference is supported.
   */
  public void forLoop(final List<String> strings) {
      for (final String s : strings) {
        String _operator_plus = StringExtensions.operator_plus("Hi ", s);
        InputOutput.<String>println(_operator_plus);
      }
      for (final String s_1 : strings) {
        String _operator_plus_1 = StringExtensions.operator_plus("Hi ", s_1);
        InputOutput.<String>println(_operator_plus_1);
      }
  }
  
  /**
   * There is nothing special about the while loop expect that again
   * it is an expression of type 'void'.
   */
  public void whileLoop(final List<String> strings) {
      Iterator<String> _iterator = strings.iterator();
      final Iterator<String> iter = _iterator;
      boolean _hasNext = iter.hasNext();
      boolean _while = _hasNext;
      while (_while) {
        String _next = iter.next();
        String _operator_plus = StringExtensions.operator_plus("Hi ", _next);
        InputOutput.<String>println(_operator_plus);
        boolean _hasNext_1 = iter.hasNext();
        _while = _hasNext_1;
      }
  }
}
