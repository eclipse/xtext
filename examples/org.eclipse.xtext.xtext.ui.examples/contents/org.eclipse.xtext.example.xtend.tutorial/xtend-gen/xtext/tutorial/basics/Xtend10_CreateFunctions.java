package xtext.tutorial.basics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import junit.framework.Assert;
import junit.framework.TestCase;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import xtext.tutorial.util.Person;

@SuppressWarnings("all")
public class Xtend10_CreateFunctions extends TestCase {
  
  public void testCreateFunctions() {
    {
      Pair<String,String> _operator_mappedTo = ObjectExtensions.<String, String>operator_mappedTo("Joe", "Developer");
      Pair<String,String> _operator_mappedTo_1 = ObjectExtensions.<String, String>operator_mappedTo("Darcy", "Smith");
      HashSet<Pair<String,String>> _newHashSet = CollectionLiterals.<Pair<String,String>>newHashSet(_operator_mappedTo_1);
      Person _newPerson = this.newPerson(_operator_mappedTo, _newHashSet);
      final Person person = _newPerson;
      Set<Person> _friends = person.getFriends();
      Person _head = IterableExtensions.<Person>head(_friends);
      String _forename = _head.getForename();
      Assert.assertEquals("Darcy", _forename);
      Set<Person> _friends_1 = person.getFriends();
      Person _head_1 = IterableExtensions.<Person>head(_friends_1);
      Set<Person> _friends_2 = _head_1.getFriends();
      Person _head_2 = IterableExtensions.<Person>head(_friends_2);
      String _forename_1 = _head_2.getForename();
      Assert.assertEquals("Joe", _forename_1);
      final Person typeConverted_person = (Person)person;
      Set<Person> _friends_3 = person.getFriends();
      Person _head_3 = IterableExtensions.<Person>head(_friends_3);
      Set<Person> _friends_4 = _head_3.getFriends();
      Person _head_4 = IterableExtensions.<Person>head(_friends_4);
      Assert.assertSame(typeConverted_person, _head_4);
    }
  }
  
  private final HashMap<ArrayList<?>,Person> _createCache_newPerson = new HashMap<ArrayList<?>,Person>();
  
  public Person newPerson(final Pair<String,String> name, final Set<Pair<String,String>> friends) {
    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(name, friends);
    Person _this;
    synchronized (_createCache_newPerson) {
      if (_createCache_newPerson.containsKey(_cacheKey)) {
        return _createCache_newPerson.get(_cacheKey);
      }
      String _key = name.getKey();
      String _value = name.getValue();
      Person _person = new Person(_key, _value);
      _this = _person;
      _createCache_newPerson.put(_cacheKey, _this);
    }
    final Set<Pair<String,String>> typeConverted_friends = (Set<Pair<String,String>>)friends;
    final Function1<Pair<String,String>,Person> _function = new Function1<Pair<String,String>,Person>() {
        public Person apply(Pair<String,String> pair) {
          HashSet<Pair<String,String>> _newHashSet = CollectionLiterals.<Pair<String,String>>newHashSet(name);
          Person _newPerson = Xtend10_CreateFunctions.this.newPerson(pair, _newHashSet);
          return _newPerson;
        }
      };
    Iterable<Person> _map = IterableExtensions.<Pair<String,String>, Person>map(typeConverted_friends, _function);
    Set<Person> _set = IterableExtensions.<Person>toSet(_map);
    _this.setFriends(_set);
    return _this;
  }
}