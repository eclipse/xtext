package org.eclipse.xtext.example.homeautomation.tests;

import com.google.common.collect.Iterables;
import java.io.StringWriter;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Declaration;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEngineFactory;
import org.eclipse.xtext.example.homeautomation.ruleEngine.State;
import org.eclipse.xtext.example.homeautomation.tests.RuleEngineInjectorProvider;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XVariableDeclaration;
import org.eclipse.xtext.xbase.XbaseFactory;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuleEngineInjectorProvider.class)
@SuppressWarnings("all")
public class SerializerTest extends Assert {
  @Inject
  private ISerializer serializer;
  
  @Extension
  private RuleEngineFactory _ruleEngineFactory = RuleEngineFactory.eINSTANCE;
  
  @Extension
  private XbaseFactory _xbaseFactory = XbaseFactory.eINSTANCE;
  
  @Inject
  private Provider<XtextResourceSet> rsProvider;
  
  @Test
  public void test() {
    try {
      final Model model = this._ruleEngineFactory.createModel();
      final XtextResourceSet rs = this.rsProvider.get();
      EList<Declaration> _declarations = model.getDeclarations();
      Device _createDevice = this._ruleEngineFactory.createDevice();
      final Procedure1<Device> _function = (Device it) -> {
        it.setName("Window");
        EList<State> _states = it.getStates();
        final Function1<String, State> _function_1 = (String s) -> {
          State _createState = this._ruleEngineFactory.createState();
          final Procedure1<State> _function_2 = (State it_1) -> {
            it_1.setName(s);
          };
          return ObjectExtensions.<State>operator_doubleArrow(_createState, _function_2);
        };
        List<State> _map = ListExtensions.<String, State>map(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("open", "closed")), _function_1);
        Iterables.<State>addAll(_states, _map);
      };
      Device _doubleArrow = ObjectExtensions.<Device>operator_doubleArrow(_createDevice, _function);
      _declarations.add(_doubleArrow);
      EList<Declaration> _declarations_1 = model.getDeclarations();
      Device _createDevice_1 = this._ruleEngineFactory.createDevice();
      final Procedure1<Device> _function_1 = (Device it) -> {
        it.setName("Heater");
        EList<State> _states = it.getStates();
        final Function1<String, State> _function_2 = (String s) -> {
          State _createState = this._ruleEngineFactory.createState();
          final Procedure1<State> _function_3 = (State it_1) -> {
            it_1.setName(s);
          };
          return ObjectExtensions.<State>operator_doubleArrow(_createState, _function_3);
        };
        List<State> _map = ListExtensions.<String, State>map(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("on", "off")), _function_2);
        Iterables.<State>addAll(_states, _map);
      };
      Device _doubleArrow_1 = ObjectExtensions.<Device>operator_doubleArrow(_createDevice_1, _function_1);
      _declarations_1.add(_doubleArrow_1);
      EList<Declaration> _declarations_2 = model.getDeclarations();
      Rule _createRule = this._ruleEngineFactory.createRule();
      final Procedure1<Rule> _function_2 = (Rule it) -> {
        it.setDescription("Save energy");
        Declaration _head = IterableExtensions.<Declaration>head(model.getDeclarations());
        it.setDeviceState(IterableExtensions.<State>head(((Device) _head).getStates()));
        XBlockExpression _createXBlockExpression = this._xbaseFactory.createXBlockExpression();
        final Procedure1<XBlockExpression> _function_3 = (XBlockExpression it_1) -> {
          EList<XExpression> _expressions = it_1.getExpressions();
          XVariableDeclaration _createXVariableDeclaration = this._xbaseFactory.createXVariableDeclaration();
          final Procedure1<XVariableDeclaration> _function_4 = (XVariableDeclaration it_2) -> {
            it_2.setName("msg");
            XStringLiteral _createXStringLiteral = this._xbaseFactory.createXStringLiteral();
            final Procedure1<XStringLiteral> _function_5 = (XStringLiteral it_3) -> {
              it_3.setValue("Another penny to the piggy bank!");
            };
            XStringLiteral _doubleArrow_2 = ObjectExtensions.<XStringLiteral>operator_doubleArrow(_createXStringLiteral, _function_5);
            it_2.setRight(_doubleArrow_2);
          };
          XVariableDeclaration _doubleArrow_2 = ObjectExtensions.<XVariableDeclaration>operator_doubleArrow(_createXVariableDeclaration, _function_4);
          _expressions.add(_doubleArrow_2);
          EList<XExpression> _expressions_1 = it_1.getExpressions();
          XVariableDeclaration _createXVariableDeclaration_1 = this._xbaseFactory.createXVariableDeclaration();
          final Procedure1<XVariableDeclaration> _function_5 = (XVariableDeclaration it_2) -> {
            it_2.setName("x");
            XNumberLiteral _createXNumberLiteral = this._xbaseFactory.createXNumberLiteral();
            final Procedure1<XNumberLiteral> _function_6 = (XNumberLiteral it_3) -> {
              it_3.setValue("1");
            };
            XNumberLiteral _doubleArrow_3 = ObjectExtensions.<XNumberLiteral>operator_doubleArrow(_createXNumberLiteral, _function_6);
            it_2.setRight(_doubleArrow_3);
          };
          XVariableDeclaration _doubleArrow_3 = ObjectExtensions.<XVariableDeclaration>operator_doubleArrow(_createXVariableDeclaration_1, _function_5);
          _expressions_1.add(_doubleArrow_3);
        };
        XBlockExpression _doubleArrow_2 = ObjectExtensions.<XBlockExpression>operator_doubleArrow(_createXBlockExpression, _function_3);
        it.setThenPart(_doubleArrow_2);
      };
      Rule _doubleArrow_2 = ObjectExtensions.<Rule>operator_doubleArrow(_createRule, _function_2);
      _declarations_2.add(_doubleArrow_2);
      final Resource resource = rs.createResource(URI.createURI("heater.rules"));
      EList<EObject> _contents = resource.getContents();
      _contents.add(model);
      final StringWriter sw = new StringWriter();
      this.serializer.serialize(model, sw, SaveOptions.newBuilder().format().getOptions());
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Device Window can be open, closed");
      _builder.newLine();
      _builder.append("Device Heater can be on, off");
      _builder.newLine();
      _builder.append("Rule \"Save energy\" when Window.open then");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val msg = \"Another penny to the piggy bank!\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val x = 1");
      _builder.newLine();
      Assert.assertEquals(_builder.toString(), sw.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
