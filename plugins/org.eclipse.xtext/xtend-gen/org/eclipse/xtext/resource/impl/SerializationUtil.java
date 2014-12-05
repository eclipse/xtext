/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource.impl;

import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
class SerializationUtil {
  public static URI readURI(final ObjectInput in) {
    try {
      String _readUTF = in.readUTF();
      return URI.createURI(_readUTF);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void writeURI(final ObjectOutput out, final URI uri) {
    try {
      String _string = uri.toString();
      out.writeUTF(_string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
