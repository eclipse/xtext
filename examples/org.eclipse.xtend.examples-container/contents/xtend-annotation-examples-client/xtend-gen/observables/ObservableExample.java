/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package observables;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import observables.ObservableBean;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class ObservableExample {
  public static void main(final String[] args) {
    ObservableBean _observableBean = new ObservableBean();
    final Procedure1<ObservableBean> _function = new Procedure1<ObservableBean>() {
      @Override
      public void apply(final ObservableBean it) {
        final PropertyChangeListener _function = new PropertyChangeListener() {
          @Override
          public void propertyChange(final PropertyChangeEvent it) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("property ");
            String _propertyName = it.getPropertyName();
            _builder.append(_propertyName, "");
            _builder.append(" changed from ");
            Object _oldValue = it.getOldValue();
            _builder.append(_oldValue, "");
            _builder.append(" to ");
            Object _newValue = it.getNewValue();
            _builder.append(_newValue, "");
            InputOutput.<String>println(_builder.toString());
          }
        };
        it.addPropertyChangeListener(_function);
        it.setFirstName("Max");
        it.setLastName("Mustermann");
        it.setFirstName("John");
        it.setLastName("Doe");
      }
    };
    ObjectExtensions.<ObservableBean>operator_doubleArrow(_observableBean, _function);
  }
}
