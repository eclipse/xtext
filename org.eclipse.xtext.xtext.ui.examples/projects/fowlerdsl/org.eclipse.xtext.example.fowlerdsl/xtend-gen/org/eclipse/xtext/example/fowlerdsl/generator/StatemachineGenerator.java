/**
 * Copyright (c) 2011, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.fowlerdsl.generator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Command;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Event;
import org.eclipse.xtext.example.fowlerdsl.statemachine.State;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Transition;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class StatemachineGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    String _className = this.className(resource);
    String _plus = (_className + ".java");
    EObject _head = IterableExtensions.<EObject>head(resource.getContents());
    fsa.generateFile(_plus, this.toJavaCode(((Statemachine) _head)));
  }

  protected String className(final Resource res) {
    String name = res.getURI().lastSegment();
    return StringExtensions.toFirstUpper(name.substring(0, name.indexOf(".")));
  }

  protected CharSequence toJavaCode(final Statemachine sm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.BufferedReader;");
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.append("import java.io.InputStreamReader;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _className = this.className(sm.eResource());
    _builder.append(_className);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ");
    String _className_1 = this.className(sm.eResource());
    _builder.append(_className_1, "\t\t");
    _builder.append("().run();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    {
      EList<Command> _commands = sm.getCommands();
      for(final Command c : _commands) {
        _builder.append("\t");
        CharSequence _declareCommand = this.declareCommand(c);
        _builder.append(_declareCommand, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("protected void run() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("boolean executeActions = true;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("String currentState = \"");
    State _head = IterableExtensions.<State>head(sm.getStates());
    String _name = null;
    if (_head!=null) {
      _name=_head.getName();
    }
    _builder.append(_name, "\t\t");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("String lastEvent = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("while (true) {");
    _builder.newLine();
    {
      EList<State> _states = sm.getStates();
      for(final State state : _states) {
        _builder.append("\t\t\t");
        CharSequence _generateCode = this.generateCode(state);
        _builder.append(_generateCode, "\t\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Event> _resetEvents = sm.getResetEvents();
      for(final Event resetEvent : _resetEvents) {
        _builder.append("\t\t\t");
        _builder.append("if (\"");
        String _name_1 = resetEvent.getName();
        _builder.append(_name_1, "\t\t\t");
        _builder.append("\".equals(lastEvent)) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("System.out.println(\"Resetting state machine.\");");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("currentState = \"");
        State _head_1 = IterableExtensions.<State>head(sm.getStates());
        String _name_2 = null;
        if (_head_1!=null) {
          _name_2=_head_1.getName();
        }
        _builder.append(_name_2, "\t\t\t\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("executeActions = true;");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("\t\t\t");
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
    _builder.append("private String receiveEvent() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.flush();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("BufferedReader br = new BufferedReader(new InputStreamReader(System.in));");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return br.readLine();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} catch (IOException ioe) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("System.out.println(\"Problem reading input\");");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return \"\";");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence declareCommand(final Command command) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void do");
    String _firstUpper = StringExtensions.toFirstUpper(command.getName());
    _builder.append(_firstUpper);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("System.out.println(\"Executing command ");
    String _name = command.getName();
    _builder.append(_name, "\t");
    _builder.append(" (");
    String _code = command.getCode();
    _builder.append(_code, "\t");
    _builder.append(")\");");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  protected CharSequence generateCode(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (currentState.equals(\"");
    String _name = state.getName();
    _builder.append(_name);
    _builder.append("\")) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if (executeActions) {");
    _builder.newLine();
    {
      EList<Command> _actions = state.getActions();
      for(final Command c : _actions) {
        _builder.append("\t\t");
        _builder.append("do");
        String _firstUpper = StringExtensions.toFirstUpper(c.getName());
        _builder.append(_firstUpper, "\t\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.append("executeActions = false;");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("System.out.println(\"Your are now in state \'");
    String _name_1 = state.getName();
    _builder.append(_name_1, "\t");
    _builder.append("\'. Possible events are [");
    final Function1<Transition, String> _function = (Transition t) -> {
      return t.getEvent().getName();
    };
    String _join = IterableExtensions.join(ListExtensions.<Transition, String>map(state.getTransitions(), _function), ", ");
    _builder.append(_join, "\t");
    _builder.append("].\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("lastEvent = receiveEvent();");
    _builder.newLine();
    {
      EList<Transition> _transitions = state.getTransitions();
      for(final Transition t : _transitions) {
        _builder.append("\t");
        _builder.append("if (\"");
        String _name_2 = t.getEvent().getName();
        _builder.append(_name_2, "\t");
        _builder.append("\".equals(lastEvent)) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("currentState = \"");
        String _name_3 = t.getState().getName();
        _builder.append(_name_3, "\t\t");
        _builder.append("\";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("executeActions = true;");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
