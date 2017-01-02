/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.formatting2;

import com.google.inject.Inject;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Condition;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;
import org.eclipse.xtext.web.example.statemachine.statemachine.Transition;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  protected void _format(final Statemachine statemachine, @Extension final IFormattableDocument document) {
    EList<Signal> _signals = statemachine.getSignals();
    for (final Signal signal : _signals) {
      {
        this.format(signal, document);
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.setNewLines(1, 1, 2);
        };
        document.<Signal>append(signal, _function);
      }
    }
    EList<State> _states = statemachine.getStates();
    for (final State state : _states) {
      {
        this.format(state, document);
        final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
          it.setNewLines(1, 1, 2);
        };
        document.<State>append(state, _function);
      }
    }
  }
  
  protected void _format(final Signal signal, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(signal).keyword(this._statemachineGrammarAccess.getSignalAccess().getSignalKeyword_1()), _function), _function_1);
  }
  
  protected void _format(final State state, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(state).keyword(this._statemachineGrammarAccess.getStateAccess().getStateKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(
      document.append(this.textRegionExtensions.regionFor(state).assignment(this._statemachineGrammarAccess.getStateAccess().getNameAssignment_1()), _function_1), 
      this.textRegionExtensions.regionFor(state).keyword(this._statemachineGrammarAccess.getStateAccess().getEndKeyword_5()), _function_2);
    EList<Command> _commands = state.getCommands();
    for (final Command command : _commands) {
      {
        this.format(command, document);
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<Command>append(command, _function_3);
      }
    }
    EList<Transition> _transitions = state.getTransitions();
    for (final Transition transition : _transitions) {
      {
        this.format(transition, document);
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<Transition>append(transition, _function_3);
      }
    }
    EList<State> _nestedStates = state.getNestedStates();
    for (final State nestedState : _nestedStates) {
      {
        this.format(nestedState, document);
        final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it) -> {
          it.newLine();
        };
        document.<State>append(nestedState, _function_3);
      }
    }
  }
  
  protected void _format(final Command command, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(command).keyword(this._statemachineGrammarAccess.getCommandAccess().getSetKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(command).keyword(this._statemachineGrammarAccess.getCommandAccess().getEqualsSignKeyword_2()), _function_1), _function_2);
  }
  
  protected void _format(final Transition transition, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(this.textRegionExtensions.regionFor(transition).keyword(this._statemachineGrammarAccess.getTransitionAccess().getIfKeyword_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(transition).keyword(this._statemachineGrammarAccess.getTransitionAccess().getGotoKeyword_2()), _function_1), _function_2);
    Condition _condition = transition.getCondition();
    boolean _tripleNotEquals = (_condition != null);
    if (_tripleNotEquals) {
      this.format(transition.getCondition(), document);
    }
  }
  
  protected void _format(final Condition condition, @Extension final IFormattableDocument document) {
    final Consumer<ISemanticRegion> _function = (ISemanticRegion it) -> {
      final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
        it_1.oneSpace();
      };
      document.append(document.prepend(it, _function_1), _function_2);
    };
    this.textRegionExtensions.regionFor(condition).keywords(this._statemachineGrammarAccess.getConditionAccess().getAndKeyword_1_0()).forEach(_function);
    EList<Event> _events = condition.getEvents();
    for (final Event event : _events) {
      this.format(event, document);
    }
  }
  
  protected void _format(final Event event, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.oneSpace();
    };
    document.append(document.prepend(this.textRegionExtensions.regionFor(event).keyword(this._statemachineGrammarAccess.getEventAccess().getEqualsSignEqualsSignKeyword_1()), _function), _function_1);
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
    } else if (command instanceof Event) {
      _format((Event)command, document);
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
