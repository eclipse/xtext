package xtend.tutorial.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import xtend.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend06_Closures {
  /**
   * Xbase (and so Xtend) supports closures.
   * A closure is very similar to Java's anonymous classes, but has a
   * much more convenient and readable syntax.
   */
  public ArrayList<Object> closures_01(final List<Person> persons) {
    final Function1<Person,String> _function = new Function1<Person,String>() {
        public String apply(final Person p) {
          String _name = p.getName();
          String _operator_plus = StringExtensions.operator_plus(_name, ", ");
          String _forename = p.getForename();
          String _operator_plus_1 = StringExtensions.operator_plus(_operator_plus, _forename);
          return _operator_plus_1;
        }
      };
    ArrayList<Object> _personsToString = this.personsToString(persons, _function);
    return _personsToString;
  }
  
  /**
   * A function accepting a closure
   *   (Person)=>String
   * is a synonym for
   *   org.eclipse.xtext.xbase.lib.Functions$Function1<Person,String>.
   * The general syntax is
   *   (typeParam1 ,... typeParamN) => returnType
   */
  public ArrayList<Object> personsToString(final List<Person> persons, final Function1<? super Person,? extends String> toString) {
      ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
      final ArrayList<Object> result = _newArrayList;
      for (final Person p : persons) {
        String _apply = toString.apply(p);
        CollectionExtensions.<String>operator_add(result, _apply);
      }
      return result;
  }
  
  /**
   * Xtend can coerce function types into any other type, as long as
   * such a type has only one method defined (in addition to the
   * methods inherited from 'java.lang.Object')
   * 
   * In the following example
   *   java.util.Collections#sort(List<T>, Comparator<T>)
   * is invoked with a closure as second parameter.
   * The closure is automatically converted to an instance of
   *   Comparator<Person>.
   * 
   * Note also that you have to put a closure into square brackets is
   * it isn't the only argument of a function call.
   */
  public void closures_02(final List<Person> persons) {
    final Function2<Person,Person,Integer> _function = new Function2<Person,Person,Integer>() {
        public Integer apply(final Person a, final Person b) {
          String _name = a.getName();
          String _name_1 = b.getName();
          int _compareTo = _name.compareTo(_name_1);
          return _compareTo;
        }
      };
    Collections.<Person>sort(persons, new Comparator<Person>() {
        public int compare(Person o1,Person o2) {
          return _function.apply(o1,o2);
        }
    });
  }
  
  /**
   * Sometimes one need to explicitly specify the parameter types,
   * because there is no context from which they could be inferred.
   */
  public Function1<String,String> closures_withoutTypeInference() {
    final Function1<String,String> _function = new Function1<String,String>() {
        public String apply(final String s) {
          String _upperCase = s.toUpperCase();
          return _upperCase;
        }
      };
    return _function;
  }
}
