/**
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.fowlerdsl.formatting2;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Command;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Event;
import org.eclipse.xtext.example.fowlerdsl.statemachine.State;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine;
import org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Transition;
import org.eclipse.xtext.formatting2.AbstractFormatter2;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractFormatter2 {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  protected void _format(final Statemachine it, @Extension final IFormattableDocument document) {
    this.formatEvents(it, document);
    this.formatResetEvents(it, document);
    this.formatCommands(it, document);
    this.formatStates(it, document);
  }
  
  public void formatEvents(final Statemachine it, @Extension final IFormattableDocument document) {
    final ISemanticRegion begin = this.textRegionExtensions.regionFor(it).keyword("events");
    final ISemanticRegion end = this.textRegionExtensions.regionFor(it).keyword(this._statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_1_2());
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    document.append(begin, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
      it_1.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(begin, end, _function_1);
    final Consumer<Event> _function_2 = (Event it_1) -> {
      document.<Event>format(it_1);
    };
    it.getEvents().forEach(_function_2);
    if (((this.hasResetEvents(it) || this.hasCommands(it)) || this.hasStates(it))) {
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.append(end, _function_3);
    }
  }
  
  public void formatResetEvents(final Statemachine it, @Extension final IFormattableDocument document) {
    final ISemanticRegion begin = this.textRegionExtensions.regionFor(it).keyword("resetEvents");
    final ISemanticRegion end = this.textRegionExtensions.regionFor(it).keyword(this._statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_2_2());
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    document.append(begin, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
      it_1.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(begin, end, _function_1);
    final Procedure1<IHiddenRegionFormatter> _function_2 = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    document.append(this.textRegionExtensions.regionFor(it).assignment(this._statemachineGrammarAccess.getStatemachineAccess().getResetEventsAssignment_2_1()), _function_2);
    final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    document.prepend(end, _function_3);
    if ((this.hasCommands(it) || this.hasStates(it))) {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.append(end, _function_4);
    }
  }
  
  public void formatCommands(final Statemachine it, @Extension final IFormattableDocument document) {
    final ISemanticRegion begin = this.textRegionExtensions.regionFor(it).keyword("commands");
    ISemanticRegion end = this.textRegionExtensions.regionFor(it).keyword(this._statemachineGrammarAccess.getStatemachineAccess().getEndKeyword_3_2());
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    document.append(begin, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
      it_1.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(begin, end, _function_1);
    final Consumer<Command> _function_2 = (Command it_1) -> {
      document.<Command>format(it_1);
    };
    it.getCommands().forEach(_function_2);
    boolean _hasStates = this.hasStates(it);
    if (_hasStates) {
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.append(end, _function_3);
    }
  }
  
  public void formatStates(final Statemachine it, @Extension final IFormattableDocument document) {
    final Consumer<State> _function = (State it_1) -> {
      document.<State>format(it_1);
    };
    it.getStates().forEach(_function);
  }
  
  protected void _format(final Event event, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setSpace(this.additionalSpaces(event));
    };
    document.append(this.textRegionExtensions.regionFor(event).feature(StatemachinePackage.Literals.EVENT__NAME), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<Event>append(event, _function_1);
  }
  
  protected void _format(final Command command, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setSpace(this.additionalSpaces(command));
    };
    document.append(this.textRegionExtensions.regionFor(command).feature(StatemachinePackage.Literals.COMMAND__NAME), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<Command>append(command, _function_1);
  }
  
  protected void _format(final State it, @Extension final IFormattableDocument document) {
    final ISemanticRegion begin = this.textRegionExtensions.regionFor(it).feature(StatemachinePackage.Literals.STATE__NAME);
    ISemanticRegion end = this.textRegionExtensions.regionFor(it).keyword(this._statemachineGrammarAccess.getStateAccess().getEndKeyword_4());
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    document.append(begin, _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it_1) -> {
      it_1.indent();
    };
    document.<ISemanticRegion, ISemanticRegion>interior(begin, end, _function_1);
    this.formatActions(it, document);
    final Consumer<Transition> _function_2 = (Transition it_1) -> {
      document.<Transition>format(it_1);
    };
    it.getTransitions().forEach(_function_2);
    boolean _isLastState = this.isLastState(it);
    if (_isLastState) {
      final Procedure1<IHiddenRegionFormatter> _function_3 = (IHiddenRegionFormatter it_1) -> {
        it_1.newLine();
      };
      document.<State>append(it, _function_3);
    } else {
      final Procedure1<IHiddenRegionFormatter> _function_4 = (IHiddenRegionFormatter it_1) -> {
        it_1.setNewLines(2);
      };
      document.<State>append(it, _function_4);
    }
  }
  
  public ISemanticRegion formatActions(final State it, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it_1) -> {
      it_1.newLine();
    };
    return document.append(this.textRegionExtensions.regionFor(it).keyword("}"), _function);
  }
  
  protected void _format(final Transition transition, @Extension final IFormattableDocument document) {
    final Procedure1<IHiddenRegionFormatter> _function = (IHiddenRegionFormatter it) -> {
      it.setSpace(this.additionalSpaces(transition));
    };
    document.append(this.textRegionExtensions.regionFor(transition).assignment(this._statemachineGrammarAccess.getTransitionAccess().getEventAssignment_0()), _function);
    final Procedure1<IHiddenRegionFormatter> _function_1 = (IHiddenRegionFormatter it) -> {
      it.newLine();
    };
    document.<Transition>append(transition, _function_1);
  }
  
  private String additionalSpaces(final Event it) {
    String _xblockexpression = null;
    {
      EObject _eContainer = it.eContainer();
      final Statemachine statemachine = ((Statemachine) _eContainer);
      final Function1<Event, String> _function = (Event it_1) -> {
        return it_1.getName();
      };
      _xblockexpression = this.additionalSpaces(ListExtensions.<Event, String>map(statemachine.getEvents(), _function), it.getName());
    }
    return _xblockexpression;
  }
  
  private String additionalSpaces(final Command it) {
    String _xblockexpression = null;
    {
      EObject _eContainer = it.eContainer();
      final Statemachine statemachine = ((Statemachine) _eContainer);
      final Function1<Command, String> _function = (Command it_1) -> {
        return it_1.getName();
      };
      _xblockexpression = this.additionalSpaces(ListExtensions.<Command, String>map(statemachine.getCommands(), _function), it.getName());
    }
    return _xblockexpression;
  }
  
  private String additionalSpaces(final Transition it) {
    String _xblockexpression = null;
    {
      EObject _eContainer = it.eContainer();
      final State state = ((State) _eContainer);
      final Function1<Transition, String> _function = (Transition it_1) -> {
        return it_1.getEvent().getName();
      };
      _xblockexpression = this.additionalSpaces(ListExtensions.<Transition, String>map(state.getTransitions(), _function), it.getEvent().getName());
    }
    return _xblockexpression;
  }
  
  private String additionalSpaces(final List<String> it, final String name) {
    int _length = this.getLongestName(it).length();
    int _length_1 = name.length();
    int _minus = (_length - _length_1);
    int _plus = (_minus + 1);
    return Strings.repeat(" ", _plus);
  }
  
  private String getLongestName(final List<String> it) {
    final Function1<String, Integer> _function = (String it_1) -> {
      int _length = it_1.length();
      return Integer.valueOf((-_length));
    };
    return IterableExtensions.<String>head(IterableExtensions.<String, Integer>sortBy(it, _function));
  }
  
  private boolean hasResetEvents(final Statemachine it) {
    boolean _isEmpty = it.getResetEvents().isEmpty();
    return (!_isEmpty);
  }
  
  private boolean hasCommands(final Statemachine it) {
    boolean _isEmpty = it.getCommands().isEmpty();
    return (!_isEmpty);
  }
  
  private boolean hasStates(final Statemachine it) {
    boolean _isEmpty = it.getStates().isEmpty();
    return (!_isEmpty);
  }
  
  private boolean isLastState(final State it) {
    boolean _xblockexpression = false;
    {
      EObject _eContainer = it.eContainer();
      final Statemachine statemachine = ((Statemachine) _eContainer);
      State _last = IterableExtensions.<State>last(statemachine.getStates());
      _xblockexpression = Objects.equal(it, _last);
    }
    return _xblockexpression;
  }
  
  public void format(final Object command, final IFormattableDocument document) {
    if (command instanceof XtextResource) {
      _format((XtextResource)command, document);
      return;
    } else if (command instanceof Command) {
      _format((Command)command, document);
      return;
    } else if (command instanceof Event) {
      _format((Event)command, document);
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
