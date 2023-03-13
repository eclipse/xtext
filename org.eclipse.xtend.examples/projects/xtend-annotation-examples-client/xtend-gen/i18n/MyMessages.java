/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package i18n;

import java.text.MessageFormat;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.InputOutput;

@Externalized
@SuppressWarnings("all")
public class MyMessages {
  public static void main(final String[] args) {
    StringConcatenation _builder = new StringConcatenation();
    String _GREETING = MyMessages.GREETING("World");
    _builder.append(_GREETING);
    _builder.newLineIfNotEmpty();
    Date _date = new Date();
    String _DATE_AND_LOCATION = MyMessages.DATE_AND_LOCATION(_date, "Kiel");
    _builder.append(_DATE_AND_LOCATION);
    _builder.newLineIfNotEmpty();
    InputOutput.<String>println(_builder.toString());
  }

  /**
   * Hello {0}!
   */
  public static String GREETING(final String arg0) {
    try {
    	String msg = RESOURCE_BUNDLE.getString("GREETING");
    	msg = MessageFormat.format(msg,arg0);
    	return msg;
    } catch (MissingResourceException e) {
    	// TODO error logging
    	return "Hello {0}!";
    }
  }

  /**
   * Today is {0,date} and you are in {1}
   */
  public static String DATE_AND_LOCATION(final Date arg0, final String arg1) {
    try {
    	String msg = RESOURCE_BUNDLE.getString("DATE_AND_LOCATION");
    	msg = MessageFormat.format(msg,arg0,arg1);
    	return msg;
    } catch (MissingResourceException e) {
    	// TODO error logging
    	return "Today is {0,date} and you are in {1}";
    }
  }

  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("i18n.MyMessages");
}
