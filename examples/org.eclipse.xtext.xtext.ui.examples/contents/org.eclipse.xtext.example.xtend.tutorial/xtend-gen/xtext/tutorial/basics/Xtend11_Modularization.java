package xtext.tutorial.basics;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import junit.framework.Assert;
import junit.framework.TestCase;
import xtext.tutorial.basics.Xtend11_Modularization;
import xtext.tutorial.basics.Xtend11_PersonExtensions;
import xtext.tutorial.util.Person;
import xtext.tutorial.util.XtendModule;

@SuppressWarnings("all")
public class Xtend11_Modularization extends TestCase {
  @Inject private Xtend11_PersonExtensions xtend11_PersonExtensions;
  
  public void testExtensions() {
    {
      Injector _createInjector = Guice.createInjector();
      final Xtend11_Modularization typeConverted_this = (Xtend11_Modularization)this;
      _createInjector.injectMembers(typeConverted_this);
      Person _person = new Person("Joe", "Developer");
      String _fullName = this.xtend11_PersonExtensions.fullName(_person);
      Assert.assertEquals("Joe Developer", _fullName);
      XtendModule _xtendModule = new XtendModule();
      Injector _createInjector_1 = Guice.createInjector(_xtendModule);
      final Xtend11_Modularization typeConverted_this_1 = (Xtend11_Modularization)this;
      _createInjector_1.injectMembers(typeConverted_this_1);
      Person _person_1 = new Person("Joe", "Developer");
      String _fullName_1 = this.xtend11_PersonExtensions.fullName(_person_1);
      Assert.assertEquals("Developer, Joe", _fullName_1);
    }
  }
}