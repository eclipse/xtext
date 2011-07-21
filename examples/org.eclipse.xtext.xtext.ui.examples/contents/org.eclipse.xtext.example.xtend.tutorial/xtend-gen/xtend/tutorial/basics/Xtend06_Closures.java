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
  
  public ArrayList<Object> personsToString(final List<Person> persons, final Function1<Person,String> toString) {
    {
      ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
      final ArrayList<Object> result = _newArrayList;
      for (final Person p : persons) {
        String _apply = toString.apply(p);
        CollectionExtensions.<Object>operator_add(result, _apply);
      }
      return result;
    }
  }
  
  public void closures_02(final List<Person> persons) {
    final Function2<Person,Person,Integer> _function = new Function2<Person,Person,Integer>() {
        public Integer apply(final Person a , final Person b) {
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