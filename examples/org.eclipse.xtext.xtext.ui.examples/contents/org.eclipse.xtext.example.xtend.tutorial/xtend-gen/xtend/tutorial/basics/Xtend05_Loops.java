package xtend.tutorial.basics;

import java.util.Iterator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class Xtend05_Loops {
  
  public void forLoop(final List<String> strings) {
    {
      for (String s : strings) {
        final String typeConverted_s = (String)s;
        String _operator_plus = StringExtensions.operator_plus("Hi ", typeConverted_s);
        InputOutput.<String>println(_operator_plus);
      }
      for (String s_1 : strings) {
        final String typeConverted_s_1 = (String)s_1;
        String _operator_plus_1 = StringExtensions.operator_plus("Hi ", typeConverted_s_1);
        InputOutput.<String>println(_operator_plus_1);
      }
    }
  }
  
  public void whileLoop(final List<String> strings) {
    {
      Iterator<String> _iterator = strings.iterator();
      final Iterator<String> iter = _iterator;
      boolean _hasNext = iter.hasNext();
      Boolean _xwhileexpression = _hasNext;
      while (_xwhileexpression) {
        String _next = iter.next();
        String _operator_plus = StringExtensions.operator_plus("Hi ", _next);
        InputOutput.<String>println(_operator_plus);
        boolean _hasNext_1 = iter.hasNext();
        _xwhileexpression = _hasNext_1;
      }
    }
  }
}