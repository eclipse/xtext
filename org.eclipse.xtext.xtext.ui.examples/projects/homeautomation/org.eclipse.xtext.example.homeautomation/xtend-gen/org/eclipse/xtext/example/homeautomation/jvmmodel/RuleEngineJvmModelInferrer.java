/**
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.jvmmodel;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.Scanner;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.ruleEngine.State;
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer;
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor;
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * <p>Infers a JVM model from the source model.</p>
 * 
 * <p>The JVM model should contain all elements that would appear in the Java code
 * which is generated from the source model. Other models link against the JVM model rather than the source model.</p>
 */
@SuppressWarnings("all")
public class RuleEngineJvmModelInferrer extends AbstractModelInferrer {
  /**
   * convenience API to build and initialize JVM types and their members.
   */
  @Inject
  @Extension
  private JvmTypesBuilder _jvmTypesBuilder;

  protected void _infer(final Model element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    final String className = StringExtensions.toFirstUpper(element.eResource().getURI().trimFileExtension().lastSegment());
    final Procedure1<JvmGenericType> _function = (JvmGenericType it) -> {
      Iterable<Rule> _filter = Iterables.<Rule>filter(element.getDeclarations(), Rule.class);
      for (final Rule device : _filter) {
        EList<JvmMember> _members = it.getMembers();
        final Procedure1<JvmOperation> _function_1 = (JvmOperation it_1) -> {
          it_1.setStatic(true);
          this._jvmTypesBuilder.setBody(it_1, device.getThenPart());
        };
        JvmOperation _method = this._jvmTypesBuilder.toMethod(device, RuleEngineJvmModelInferrer.getRuleMethodName(device), this._typeReferenceBuilder.typeRef(void.class), _function_1);
        this._jvmTypesBuilder.<JvmOperation>operator_add(_members, _method);
      }
      EList<JvmMember> _members_1 = it.getMembers();
      final Procedure1<JvmOperation> _function_2 = (JvmOperation it_1) -> {
        it_1.setStatic(true);
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(element, "event", this._typeReferenceBuilder.typeRef(Object.class));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            {
              Iterable<Device> _filter = Iterables.<Device>filter(element.getDeclarations(), Device.class);
              for(final Device device : _filter) {
                {
                  EList<State> _states = device.getStates();
                  for(final State state : _states) {
                    _builder.append("if (event == ");
                    String _qualifiedJavaName = RuleEngineJvmModelInferrer.this.getQualifiedJavaName(state);
                    _builder.append(_qualifiedJavaName);
                    _builder.append(") {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("System.out.println(\"");
                    String _name = device.getName();
                    _builder.append(_name, "\t");
                    _builder.append(" is now ");
                    String _name_1 = state.getName();
                    _builder.append(_name_1, "\t");
                    _builder.append("!\");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("}");
                    _builder.newLine();
                  }
                }
              }
            }
            {
              Iterable<Rule> _filter_1 = Iterables.<Rule>filter(element.getDeclarations(), Rule.class);
              for(final Rule rule : _filter_1) {
                _builder.append("if (event == ");
                String _qualifiedJavaName_1 = RuleEngineJvmModelInferrer.this.getQualifiedJavaName(rule.getDeviceState());
                _builder.append(_qualifiedJavaName_1);
                _builder.append(") {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                String _ruleMethodName = RuleEngineJvmModelInferrer.getRuleMethodName(rule);
                _builder.append(_ruleMethodName, "\t");
                _builder.append("();");
                _builder.newLineIfNotEmpty();
                _builder.append("}");
                _builder.newLine();
              }
            }
          }
        };
        this._jvmTypesBuilder.setBody(it_1, _client);
      };
      JvmOperation _method_1 = this._jvmTypesBuilder.toMethod(element, "fire", this._typeReferenceBuilder.typeRef(void.class), _function_2);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_1, _method_1);
      EList<JvmMember> _members_2 = it.getMembers();
      final Procedure1<JvmOperation> _function_3 = (JvmOperation it_1) -> {
        it_1.setStatic(true);
        EList<JvmFormalParameter> _parameters = it_1.getParameters();
        JvmFormalParameter _parameter = this._jvmTypesBuilder.toParameter(element, "args", this._jvmTypesBuilder.addArrayTypeDimension(this._typeReferenceBuilder.typeRef(String.class)));
        this._jvmTypesBuilder.<JvmFormalParameter>operator_add(_parameters, _parameter);
        StringConcatenationClient _client = new StringConcatenationClient() {
          @Override
          protected void appendTo(StringConcatenationClient.TargetStringConcatenation _builder) {
            _builder.append(Scanner.class);
            _builder.append(" scanner = new Scanner(System.in);");
            _builder.newLineIfNotEmpty();
            _builder.append("System.out.println(\"Welcome home!\");");
            _builder.newLine();
            _builder.append("System.out.println(\"Available commands : \");");
            _builder.newLine();
            {
              Iterable<Device> _filter = Iterables.<Device>filter(element.getDeclarations(), Device.class);
              for(final Device device : _filter) {
                {
                  EList<State> _states = device.getStates();
                  for(final State state : _states) {
                    _builder.append("System.out.println(\"  ");
                    String _name = device.getName();
                    _builder.append(_name);
                    _builder.append(" ");
                    String _name_1 = state.getName();
                    _builder.append(_name_1);
                    _builder.append("\" );");
                    _builder.newLineIfNotEmpty();
                  }
                }
              }
            }
            _builder.append("System.out.println(\"Have fun!\");");
            _builder.newLine();
            _builder.append("while(true) {");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("String command = scanner.next();");
            _builder.newLine();
            {
              Iterable<Device> _filter_1 = Iterables.<Device>filter(element.getDeclarations(), Device.class);
              for(final Device device_1 : _filter_1) {
                _builder.append("\t");
                _builder.append("if (command.equalsIgnoreCase(\"");
                String _name_2 = device_1.getName();
                _builder.append(_name_2, "\t");
                _builder.append("\")) {");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("String secondaryCommand = scanner.next();");
                _builder.newLine();
                {
                  EList<State> _states_1 = device_1.getStates();
                  for(final State state_1 : _states_1) {
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("if (secondaryCommand.equalsIgnoreCase(\"");
                    String _name_3 = state_1.getName();
                    _builder.append(_name_3, "\t\t");
                    _builder.append("\")) {");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("fire(");
                    String _qualifiedJavaName = RuleEngineJvmModelInferrer.this.getQualifiedJavaName(state_1);
                    _builder.append(_qualifiedJavaName, "\t\t\t");
                    _builder.append(");");
                    _builder.newLineIfNotEmpty();
                    _builder.append("\t");
                    _builder.append("\t");
                    _builder.append("} else ");
                    _builder.newLine();
                  }
                }
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("{");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("\t\t");
                _builder.append("System.out.println(\"");
                String _name_4 = device_1.getName();
                _builder.append(_name_4, "\t\t\t");
                _builder.append(" can only have the following states: ");
                final Function1<State, String> _function = (State it_2) -> {
                  return it_2.getName();
                };
                String _join = IterableExtensions.join(ListExtensions.<State, String>map(device_1.getStates(), _function), ",");
                _builder.append(_join, "\t\t\t");
                _builder.append(".\");");
                _builder.newLineIfNotEmpty();
                _builder.append("\t");
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
                _builder.append("\t");
                _builder.append("}");
                _builder.newLine();
              }
            }
            _builder.append("\t");
            _builder.append("if (command.equalsIgnoreCase(\"bye\")) {");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("System.out.println(\"Ciao!\");");
            _builder.newLine();
            _builder.append("\t\t");
            _builder.append("break;");
            _builder.newLine();
            _builder.append("\t");
            _builder.append("}");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        };
        this._jvmTypesBuilder.setBody(it_1, _client);
      };
      JvmOperation _method_2 = this._jvmTypesBuilder.toMethod(element, "main", this._typeReferenceBuilder.typeRef(void.class), _function_3);
      this._jvmTypesBuilder.<JvmOperation>operator_add(_members_2, _method_2);
    };
    acceptor.<JvmGenericType>accept(this._jvmTypesBuilder.toClass(element, className), _function);
    Iterable<Device> _filter = Iterables.<Device>filter(element.getDeclarations(), Device.class);
    for (final Device device : _filter) {
      final Procedure1<JvmEnumerationType> _function_1 = (JvmEnumerationType it) -> {
      };
      final Procedure1<JvmEnumerationType> _function_2 = (JvmEnumerationType it) -> {
        EList<State> _states = device.getStates();
        for (final State state : _states) {
          EList<JvmMember> _members = it.getMembers();
          final Procedure1<JvmEnumerationLiteral> _function_3 = (JvmEnumerationLiteral it_1) -> {
            it_1.setVisibility(JvmVisibility.PUBLIC);
          };
          JvmEnumerationLiteral _enumerationLiteral = this._jvmTypesBuilder.toEnumerationLiteral(state, state.getName(), _function_3);
          this._jvmTypesBuilder.<JvmEnumerationLiteral>operator_add(_members, _enumerationLiteral);
        }
      };
      acceptor.<JvmEnumerationType>accept(this._jvmTypesBuilder.toEnumerationType(device, device.getName(), _function_1), _function_2);
    }
  }

  private String getQualifiedJavaName(final State state) {
    EObject _eContainer = state.eContainer();
    String _name = ((Device) _eContainer).getName();
    String _plus = (_name + ".");
    String _name_1 = state.getName();
    return (_plus + _name_1);
  }

  public static String getRuleMethodName(final Rule rule) {
    String _description = rule.getDescription();
    String _replaceAll = null;
    if (_description!=null) {
      _replaceAll=_description.replaceAll("\\W", "_");
    }
    return ("execute" + _replaceAll);
  }

  public void infer(final EObject element, final IJvmDeclaredTypeAcceptor acceptor, final boolean isPreIndexingPhase) {
    if (element instanceof Model) {
      _infer((Model)element, acceptor, isPreIndexingPhase);
      return;
    } else if (element != null) {
      _infer(element, acceptor, isPreIndexingPhase);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(element, acceptor, isPreIndexingPhase).toString());
    }
  }
}
