/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.formatting2;

import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Condition;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;
import org.eclipse.xtext.web.example.statemachine.statemachine.Transition;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractFormatter2 {
  protected void _format(final Statemachine statemachine, @Extension final IFormattableDocument document) {
    EList<Signal> _signals = statemachine.getSignals();
    for (final Signal signal : _signals) {
      this.format(signal, document);
    }
    EList<State> _states = statemachine.getStates();
    for (final State state : _states) {
      this.format(state, document);
    }
  }
  
  protected void _format(final Signal signal, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<Signal>prepend(signal, _function);
  }
  
  protected void _format(final State state, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.setNewLines(1, 1, 2);
      }
    };
    document.<State>prepend(state, _function);
    ISemanticRegionsFinder _regionFor = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword = _regionFor.keyword("end");
    final Procedure1<IHiddenRegionFormatter> _function_1 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.prepend(_keyword, _function_1);
    ISemanticRegionsFinder _regionFor_1 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_1 = _regionFor_1.keyword("state");
    ISemanticRegionsFinder _regionFor_2 = this.textRegionExtensions.regionFor(state);
    ISemanticRegion _keyword_2 = _regionFor_2.keyword("end");
    Pair<ISemanticRegion, ISemanticRegion> _mappedTo = Pair.<ISemanticRegion, ISemanticRegion>of(_keyword_1, _keyword_2);
    final Procedure1<IHiddenRegionFormatter> _function_2 = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.indent();
      }
    };
    document.<ISemanticRegion, ISemanticRegion>interior(_mappedTo, _function_2);
    EList<Command> _commands = state.getCommands();
    for (final Command command : _commands) {
      this.format(command, document);
    }
    EList<Transition> _transitions = state.getTransitions();
    for (final Transition transition : _transitions) {
      this.format(transition, document);
    }
  }
  
  protected void _format(final Command command, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<Command>prepend(command, _function);
  }
  
  protected void _format(final Transition transition, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = new Procedure1<IHiddenRegionFormatter>() {
      @Override
      public void apply(final IHiddenRegionFormatter it) {
        it.newLine();
      }
    };
    document.<Transition>prepend(transition, _function);
    Condition _condition = transition.getCondition();
    this.format(_condition, document);
  }
  
  protected void _format(final Condition condition, @Extension final IFormattableDocument document) {
    EList<Event> _events = condition.getEvents();
    for (final Event event : _events) {
      this.format(event, document);
    }
  }
  
  public void format(final Object command, final IFormattableDocument document) {
    if (command instanceof XtextResource) {
      _format((XtextResource)command, document);
      return;
    } else if (command instanceof Command) {
      _format((Command)command, document);
      return;
    } else if (command instanceof Condition) {
      _format((Condition)command, document);
      return;
    } else if (command instanceof Signal) {
      _format((Signal)command, document);
      return;
    } else if (command instanceof State) {
      _format((State)command, document);
      return;
    } else if (command instanceof Statemachine) {
      _format((Statemachine)command, document);
      return;
    } else if (command instanceof Transition) {
      _format((Transition)command, document);
      return;
    } else if (command instanceof EObject) {
      _format((EObject)command, document);
      return;
    } else if (command == null) {
      _format((Void)null, document);
      return;
    } else if (command != null) {
      _format(command, document);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(command, document).toString());
    }
  }
}
