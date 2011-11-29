package org.eclipse.xtext.example.fowlerdsl.generator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Command;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Event;
import org.eclipse.xtext.example.fowlerdsl.statemachine.State;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Transition;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class StatemachineGenerator implements IGenerator {
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    String _className = this.className(resource);
    String _operator_plus = StringExtensions.operator_plus(_className, ".java");
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    CharSequence _javaCode = this.toJavaCode(((Statemachine) _head));
    fsa.generateFile(_operator_plus, _javaCode);
  }
  
  public String className(final Resource res) {
      URI _uRI = res.getURI();
      String _lastSegment = _uRI.lastSegment();
      String name = _lastSegment;
      int _indexOf = name.indexOf(".");
      String _substring = name.substring(0, _indexOf);
      return _substring;
  }
  
  public CharSequence toJavaCode(final Statemachine sm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.io.BufferedReader;");
    _builder.newLine();
    _builder.append("import java.io.IOException;");
    _builder.newLine();
    _builder.append("import java.io.InputStreamReader;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    Resource _eResource = sm.eResource();
    String _className = this.className(_eResource);
    _builder.append(_className, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("new ");
    Resource _eResource_1 = sm.eResource();
    String _className_1 = this.className(_eResource_1);
    _builder.append(_className_1, "		");
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
        _builder.append(_declareCommand, "	");
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
    EList<State> _states = sm.getStates();
    State _head = IterableExtensions.<State>head(_states);
    String _name = _head.getName();
    _builder.append(_name, "		");
    _builder.append("\";");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("String lastEvent = null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("while (true) {");
    _builder.newLine();
    {
      EList<State> _states_1 = sm.getStates();
      for(final State state : _states_1) {
        _builder.append("\t\t\t");
        CharSequence _generateCode = this.generateCode(state);
        _builder.append(_generateCode, "			");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      EList<Event> _resetEvents = sm.getResetEvents();
      for(final Event resetEvent : _resetEvents) {
        _builder.append("\t\t\t");
        _builder.append("if (\"");
        String _name_1 = resetEvent.getName();
        _builder.append(_name_1, "			");
        _builder.append("\".equals(lastEvent)) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("System.out.println(\"Resetting state machine.\");");
        _builder.newLine();
        _builder.append("\t\t\t");
        _builder.append("\t");
        _builder.append("currentState = \"");
        EList<State> _states_2 = sm.getStates();
        State _head_1 = IterableExtensions.<State>head(_states_2);
        String _name_2 = _head_1.getName();
        _builder.append(_name_2, "				");
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
  
  public CharSequence declareCommand(final Command command) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("protected void do");
    String _name = command.getName();
    String _firstUpper = StringExtensions.toFirstUpper(_name);
    _builder.append(_firstUpper, "");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("System.out.println(\"Executing command ");
    String _name_1 = command.getName();
    _builder.append(_name_1, "	");
    _builder.append(" (");
    String _code = command.getCode();
    _builder.append(_code, "	");
    _builder.append(")\");");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateCode(final State state) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (currentState.equals(\"");
    String _name = state.getName();
    _builder.append(_name, "");
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
        String _name_1 = c.getName();
        String _firstUpper = StringExtensions.toFirstUpper(_name_1);
        _builder.append(_firstUpper, "		");
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
    String _name_2 = state.getName();
    _builder.append(_name_2, "	");
    _builder.append("\'. Possible events are [");
    EList<Transition> _transitions = state.getTransitions();
    final Function1<Transition,String> _function = new Function1<Transition,String>() {
        public String apply(final Transition t) {
          Event _event = t.getEvent();
          String _name = _event.getName();
          return _name;
        }
      };
    List<String> _map = ListExtensions.<Transition, String>map(_transitions, _function);
    String _join = IterableExtensions.join(_map, ", ");
    _builder.append(_join, "	");
    _builder.append("].\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("lastEvent = receiveEvent();");
    _builder.newLine();
    {
      EList<Transition> _transitions_1 = state.getTransitions();
      for(final Transition t : _transitions_1) {
        _builder.append("\t");
        _builder.append("if (\"");
        Event _event = t.getEvent();
        String _name_3 = _event.getName();
        _builder.append(_name_3, "	");
        _builder.append("\".equals(lastEvent)) {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("currentState = \"");
        State _state = t.getState();
        String _name_4 = _state.getName();
        _builder.append(_name_4, "		");
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
