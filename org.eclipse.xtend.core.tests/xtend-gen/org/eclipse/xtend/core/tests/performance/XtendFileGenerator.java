package org.eclipse.xtend.core.tests.performance;

import java.util.Map;
import org.eclipse.xtend.core.tests.performance.GeneratorConfig;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class XtendFileGenerator {
  public CharSequence getContents(final GeneratorConfig conf) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(conf.packageName);
      boolean _not = (!_isNullOrEmpty);
      if (_not) {
        _builder.append("package ");
        _builder.append(conf.packageName, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("import java.util.Collections");
    _builder.newLine();
    _builder.append("import java.util.List");
    _builder.newLine();
    _builder.append("import org.junit.Assert");
    _builder.newLine();
    _builder.append("import xtend.tutorial.util.Amount");
    _builder.newLine();
    _builder.append("import xtend.tutorial.util.Circle");
    _builder.newLine();
    _builder.append("import xtend.tutorial.util.NetNode");
    _builder.newLine();
    _builder.append("import xtend.tutorial.util.Person");
    _builder.newLine();
    _builder.append("import xtend.tutorial.util.Rectangle");
    _builder.newLine();
    _builder.append("import xtend.tutorial.util.Shape");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static extension java.util.Collections.*");
    _builder.newLine();
    {
      for(final String staticImport : conf.staticImportTypes) {
        _builder.append("import static extension ");
        _builder.append(staticImport, "");
        _builder.append(".*");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("class ");
    _builder.append(conf.className, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    {
      for(final String injectedExt : conf.injectedExtensionTypes) {
        _builder.append("\t");
        _builder.append("@com.google.inject.Inject");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("extension ");
        _builder.append(injectedExt, "\t");
        _builder.append(" ext");
        int _indexOf = conf.injectedExtensionTypes.indexOf(injectedExt);
        _builder.append(_indexOf, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Xtend supports the Java syntax");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@com.google.inject.Inject");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("String ");
      }
    }
    _builder.append("simpleMethodCall_01(Object myObject) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("myObject.toString()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* if a method does not take arguments you can leave out the parenthesis");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("String ");
      }
    }
    _builder.append("simpleMethodCall_02(Object myObject) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("myObject.toString");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Static property or method access is done using th");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("void ");
      }
    }
    _builder.append("staticProperties() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("System::out.println(\"Hello World!\")");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("//Note: there is a preferred built in library for this");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(\"Hello World!\")");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* properties (i.e. getter and setter) can be accessed using the more readable property-syntax");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("String ");
      }
    }
    _builder.append("propertAccess(Person person) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("person.forename = \'Joe\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("person.name = \'Developer\'");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return person.forename+\" \"+person.name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Xtend supports operator overloading.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* An operator is just a mapping to a method with a special name (starting with the prefix \'operator_\') and the correct number of arguments.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* A table of supported operators and their precedence can be found in the Xbase language reference (see Help->Help Contents).");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* (Tip: Hover or use F3 over an operator to go to its declaration)");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("Amount ");
      }
    }
    _builder.append("operatorOverloading(Amount a, Amount b) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return (a + b) * 2");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Extension methods are a special Xtend feature.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* They allow for adding functions to existing types withot modifying them.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Local functions within Xtend classes can be used using the extension syntax by default.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("List<String> ");
      }
    }
    _builder.append("extensionMethods(String string) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("string.splitOnUnderscore");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("List<String> ");
      }
    }
    _builder.append("splitOnUnderscore(String s) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return s.split(\'_\')");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* If you put the keyword \'extension\' in a \'static\' import, the imported static functions");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* can be accessed using the extension syntax as well.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("List<String> ");
      }
    }
    _builder.append(" staticExtensionMethods(String string) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("\'foo\'.singletonList");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Xbase (and so soed Xtend) supports closures.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* A closure is very similar to Java\'s anonymous classes, but has ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* a much more convenient and readable syntax.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("List<String> ");
      }
    }
    _builder.append(" closures_01(List<Person> persons) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("persons.personsToString(");
    {
      if (conf.noTypeInference) {
        _builder.append("Person ");
      }
    }
    _builder.append("p | p.name+\", \"+p.forename )");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* a function accepting a closure");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* (Person)=>String is a synonym for org.eclipse.xtext.xbase.lib.Functions.Function1<Person,String>");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* The general syntax if");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* (typeParam1 ,... typeParamN) => returnType");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("List<String> ");
      }
    }
    _builder.append("personsToString(List<Person> persons, (Person)=>String toString) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("val result = ");
    {
      if (conf.noTypeInference) {
        _builder.append("<String> ");
      }
    }
    _builder.append("newArrayList()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("for (");
    {
      if (conf.noTypeInference) {
        _builder.append("Person ");
      }
    }
    _builder.append("p : persons) ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("result += toString.apply(p)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return result");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Xtend can coerce function types into any other type, ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* as long as such a type has only one method defined ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* (in addition to the methods inherited from java.lang.Object)");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* In the following example java.util.Collections#sort(List<T>, Comparator<T>) is invoked.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Where a closure is passed in as second parameter and automatically ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* converted to an instance of Comparator<Person>.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Note also that you have to put a closure into square brackets is it isn\'t the only argument to a function.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("void ");
      }
    }
    _builder.append("closures_02(List<Person> persons) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("// sort by name ");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Collections::sort(persons, [");
    {
      if (conf.noTypeInference) {
        _builder.append("Person ");
      }
    }
    _builder.append(" a,");
    {
      if (conf.noTypeInference) {
        _builder.append("Person ");
      }
    }
    _builder.append(" b | a.name.compareTo( b.name ) ] )");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* sometimes one need to explicitly specify the parameter types, ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* because there is no context to they can be inferred from. ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("(String)=>String ");
      }
    }
    _builder.append(" closures_withoutTypeInference() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("return [String s | s.toUpperCase]");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void testCreateFunctions() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ");
    {
      if (conf.noTypeInference) {
        _builder.append("NetNode ");
      }
    }
    _builder.append("nodeA = new NetNode()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("nodeA.name = \"A\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ");
    {
      if (conf.noTypeInference) {
        _builder.append("NetNode ");
      }
    }
    _builder.append("nodeB = new NetNode()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("nodeB.name = \"B\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ");
    {
      if (conf.noTypeInference) {
        _builder.append("NetNode ");
      }
    }
    _builder.append("nodeC = new NetNode()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("nodeC.name = \"C\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ");
    {
      if (conf.noTypeInference) {
        _builder.append("NetNode ");
      }
    }
    _builder.append("nodeD = new NetNode()");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("nodeD.name = \"D\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("nodeA.references = ");
    {
      if (conf.noTypeInference) {
        _builder.append("<NetNode>");
      }
    }
    _builder.append("newArrayList(nodeD,nodeC)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("nodeB.references = ");
    {
      if (conf.noTypeInference) {
        _builder.append("<NetNode>");
      }
    }
    _builder.append("newArrayList(nodeA,nodeB)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("nodeC.references = ");
    {
      if (conf.noTypeInference) {
        _builder.append("<NetNode>");
      }
    }
    _builder.append("newArrayList(nodeA,nodeB, nodeD)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("nodeD.references = ");
    {
      if (conf.noTypeInference) {
        _builder.append("<NetNode>");
      }
    }
    _builder.append("newArrayList(nodeB,nodeC)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("val ");
    {
      if (conf.noTypeInference) {
        _builder.append("NetNode ");
      }
    }
    _builder.append("copyOfNodeA = copyNet(nodeA)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("val ");
    {
      if (conf.noTypeInference) {
        _builder.append("NetNode ");
      }
    }
    _builder.append("copyOfNodeB = copyNet(nodeB)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Assert::assertNotSame(nodeA, copyOfNodeA)");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Assert::assertSame(copyOfNodeB.references.head, copyOfNodeA)\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Assert::assertSame(copyOfNodeB.references.tail.head, copyOfNodeB)\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* create a copy of the given NetNode");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* initializes the fields lazily");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def create result : new NetNode() copyNet(NetNode toCopy) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("result.name = toCopy.name");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("result.references = toCopy.references.map( ");
    {
      if (conf.noTypeInference) {
        _builder.append("NetNode ");
      }
    }
    _builder.append("node | node.copyNet)");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* if expressions look exactly like Java\'s if statements.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("int ");
      }
    }
    _builder.append("ifExpression(String param) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("if (param!=null) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("param.length");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("0");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ... but note that they are expression so they are more like Java\'s");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ternary operator.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("int ");
      }
    }
    _builder.append("ifExpression_01(String param) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("ifExpression(if (param==\'foo\') \'bar\' else \'baz\') ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ... but the else branch is optional and if not specified defaults to \'else null\'");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("int ");
      }
    }
    _builder.append("ifExpression_02(String param) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("ifExpression_01(if (param==\'bar\') \'foo\') ");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* The switch expression is very different to the one from Java");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* It supports dispatching over types, it has no fall through, and it uses a first match wins strategy.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("String ");
      }
    }
    _builder.append("switchExpression_01(Shape shape) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("switch (shape) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Circle \t: ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\'a circle : diameter=\'+shape.diameter");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Rectangle case shape.height == shape.width : ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\'a square : size=\'+shape.width");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("Rectangle : ");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("\'a rectangle : width=\'+shape.width+\', height=\'+shape.height");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* switch can also be used more traditionally (without any type guards)");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("String ");
      }
    }
    _builder.append("switchExpression_02(String value) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("switch(value) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case \'foo\' : \"it\'s foo\"");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("case \'bar\' : \'a bar\'");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("default : \"don\'t know\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def void testRichStrings() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("println(new Person(\"Joe\", \"Developer\").writeLetterTo)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Rich strings are a special feature for readable code concatenation.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* It supports a unique automatic indentation handling, which is also refelected tooling-wise");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* Note the indentation before the call to signature.");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("CharSequence ");
      }
    }
    _builder.append("writeLetterTo(Person p) ");
    String _TQ = this.TQ();
    _builder.append(_TQ, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Dear ");
    String _GO = this.GO();
    _builder.append(_GO, "\t\t");
    _builder.append("p.forename");
    String _GC = this.GC();
    _builder.append(_GC, "\t\t");
    _builder.append(",");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bla bla foo");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Yours sincerely,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("Joe Developer");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t\t");
    String _GO_1 = this.GO();
    _builder.append(_GO_1, "\t\t\t");
    _builder.append("signature");
    String _GC_1 = this.GC();
    _builder.append(_GC_1, "\t\t\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _TQ_1 = this.TQ();
    _builder.append(_TQ_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def ");
    {
      if (conf.noTypeInference) {
        _builder.append("CharSequence ");
      }
    }
    _builder.append("signature() ");
    String _TQ_2 = this.TQ();
    _builder.append(_TQ_2, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("Bla bla Foo Bar");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("(c) 2011 - all rights reserved");
    _builder.newLine();
    _builder.append("\t\t ");
    _builder.append("- note the multiline, and the correct indentation -");
    _builder.newLine();
    _builder.append("\t");
    String _TQ_3 = this.TQ();
    _builder.append(_TQ_3, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public String TQ() {
    return "\'\'\'";
  }
  
  public String GO() {
    return "«";
  }
  
  public String GC() {
    return "»";
  }
  
  public Map<String, ? extends CharSequence> getDependencies() {
    Pair<String, String> _amount = this.getAmount();
    Pair<String, String> _circle = this.getCircle();
    Pair<String, String> _netNode = this.getNetNode();
    Pair<String, String> _person = this.getPerson();
    Pair<String, String> _rectangle = this.getRectangle();
    Pair<String, String> _shape = this.getShape();
    return CollectionLiterals.<String, String>newHashMap(_amount, _circle, _netNode, _person, _rectangle, _shape);
  }
  
  public Pair<String, String> getAmount() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package xtend.tutorial.util;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.math.BigDecimal;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Amount {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("BigDecimal value");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(BigDecimal value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.value = value");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String value) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.value = new BigDecimal(value)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("override toString() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return value.setScale(2, BigDecimal::ROUND_HALF_UP).toString();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public Amount operator_plus(Amount other) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Amount(this.value.add(other.value));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public Amount operator_minus(Amount other) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Amount(this.value.subtract(other.value));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public Amount operator_multiply(int factor) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Amount(this.value.multiply(new BigDecimal(factor)));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public Amount operator_divide(int divisor) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new Amount(this.value.divide(new BigDecimal(divisor)));");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return Pair.<String, String>of("xtend/tutorial/util/Amount.xtend", _builder.toString());
  }
  
  public Pair<String, String> getCircle() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package xtend.tutorial.util;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Circle extends Shape {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int diameter;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(int diameter) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.diameter = diameter;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return Pair.<String, String>of("xtend/tutorial/util/Circle.xtend", _builder.toString());
  }
  
  public Pair<String, String> getNetNode() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package xtend.tutorial.util;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import static java.util.Collections.*;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class NetNode {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Iterable<NetNode> references = emptySet();");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public String getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public void setName(String name) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.name = name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public Iterable<NetNode> getReferences() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return references;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public void setReferences(Iterable<NetNode> references) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.references = references;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return Pair.<String, String>of("xtend/tutorial/util/NetNode.xtend", _builder.toString());
  }
  
  public Pair<String, String> getPerson() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package xtend.tutorial.util;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("import java.util.Set;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Person {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String forename;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private String name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private Set<Person> friends;");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(String forename, String name) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.forename = forename;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.name = name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new() {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public Set<Person> getFriends() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return friends;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public void setFriends(Set<Person> friends) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.friends = friends;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public String getForename() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return forename;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public void setForename(String forename) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.forename = forename;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public String getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("def public void setName(String name) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.name = name;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return Pair.<String, String>of("xtend/tutorial/util/Person.xtend", _builder.toString());
  }
  
  public Pair<String, String> getRectangle() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package xtend.tutorial.util;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Rectangle extends Shape {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int height;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public int width;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("new(int height, int width) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("super();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.height = height;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.width = width;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return Pair.<String, String>of("xtend/tutorial/util/Rectangle.xtend", _builder.toString());
  }
  
  public Pair<String, String> getShape() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package xtend.tutorial.util;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class Shape {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return Pair.<String, String>of("xtend/tutorial/util/Shape.xtend", _builder.toString());
  }
}
