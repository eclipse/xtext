/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.resource;

import com.google.inject.ImplementedBy;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(IMimeTypeProvider.DefaultImpl.class)
@SuppressWarnings("all")
public interface IMimeTypeProvider {
  public static class DefaultImpl implements IMimeTypeProvider {
    @Override
    public List<String> getMimeTypes() {
      return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
    }
  }
  
  public abstract List<String> getMimeTypes();
}
