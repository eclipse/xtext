/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.generator;

import com.google.common.collect.Iterables;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;
import org.eclipse.xtext.web.example.statemachine.statemachine.Transition;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class StatemachineGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    EList<EObject> _contents = resource.getContents();
    Iterable<Statemachine> _filter = Iterables.<Statemachine>filter(_contents, Statemachine.class);
    final Statemachine statemachine = IterableExtensions.<Statemachine>head(_filter);
    if ((statemachine != null)) {
      CharSequence _generateHtml = this.generateHtml(statemachine);
      fsa.generateFile("/DEFAULT_ARTIFACT", _generateHtml);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("This is an additional generator artifact.");
      fsa.generateFile("/hidden.txt", _builder);
    }
  }
  
  private CharSequence generateHtml(final Statemachine statemachine) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<!DOCTYPE html>");
    _builder.newLine();
    _builder.append("<html>");
    _builder.newLine();
    _builder.append("<head>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<meta http-equiv=\"Content-Language\" content=\"en-us\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<title>State Machine Overview</title>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"/style.css\" />");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<style>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(".signal {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("color: #383;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("font-weight: bold;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append(".state {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("color: #338;");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("font-weight: bold;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</style>");
    _builder.newLine();
    _builder.append("</head>");
    _builder.newLine();
    _builder.append("<body>");
    _builder.newLine();
    _builder.append("<div class=\"text-container\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<h2>Signals</h2>");
    _builder.newLine();
    {
      EList<Signal> _signals = statemachine.getSignals();
      final Function1<Signal, String> _function = new Function1<Signal, String>() {
        @Override
        public String apply(final Signal it) {
          return it.getName();
        }
      };
      List<Signal> _sortBy = IterableExtensions.<Signal, String>sortBy(_signals, _function);
      for(final Signal signal : _sortBy) {
        _builder.append("\t");
        _builder.append("<span class=\"signal\">");
        String _name = signal.getName();
        _builder.append(_name, "\t");
        _builder.append("</span> (");
        {
          if ((signal instanceof InputSignal)) {
            _builder.append("input");
          } else {
            _builder.append("output");
          }
        }
        _builder.append(")</br>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("<h2>States</h2>");
    _builder.newLine();
    {
      EList<State> _states = statemachine.getStates();
      final Function1<State, String> _function_1 = new Function1<State, String>() {
        @Override
        public String apply(final State it) {
          return it.getName();
        }
      };
      List<State> _sortBy_1 = IterableExtensions.<State, String>sortBy(_states, _function_1);
      for(final State state : _sortBy_1) {
        _builder.append("\t");
        _builder.append("<span class=\"state\">");
        String _name_1 = state.getName();
        _builder.append(_name_1, "\t");
        _builder.append("</span> &ndash; transitions: ");
        {
          EList<Transition> _transitions = state.getTransitions();
          boolean _isEmpty = _transitions.isEmpty();
          if (_isEmpty) {
            _builder.append("NONE");
          } else {
            {
              EList<Transition> _transitions_1 = state.getTransitions();
              boolean _hasElements = false;
              for(final Transition transition : _transitions_1) {
                if (!_hasElements) {
                  _hasElements = true;
                } else {
                  _builder.appendImmediate(", ", "\t");
                }
                State _state = transition.getState();
                String _name_2 = _state.getName();
                _builder.append(_name_2, "\t");
              }
            }
          }
        }
        _builder.append("</br>");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("</div>");
    _builder.newLine();
    _builder.append("</body>");
    _builder.newLine();
    _builder.append("</html>");
    _builder.newLine();
    return _builder;
  }
}
