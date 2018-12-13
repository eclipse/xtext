/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package observables;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import observables.Observable;

@Observable
@SuppressWarnings("all")
public class ObservableBean {
  private String firstName;
  
  private String lastName;
  
  public String getFirstName() {
    return this.firstName;
  }
  
  public void setFirstName(final String firstName) {
    String _oldValue = this.firstName;
    this.firstName = firstName;
    _propertyChangeSupport.firePropertyChange("firstName", _oldValue, firstName);
  }
  
  public String getLastName() {
    return this.lastName;
  }
  
  public void setLastName(final String lastName) {
    String _oldValue = this.lastName;
    this.lastName = lastName;
    _propertyChangeSupport.firePropertyChange("lastName", _oldValue, lastName);
  }
  
  private PropertyChangeSupport _propertyChangeSupport = new PropertyChangeSupport(this);
  
  public void addPropertyChangeListener(final PropertyChangeListener listener) {
    this._propertyChangeSupport.addPropertyChangeListener(listener);
  }
  
  public void removePropertyChangeListener(final PropertyChangeListener listener) {
    this._propertyChangeSupport.removePropertyChangeListener(listener);
  }
}
