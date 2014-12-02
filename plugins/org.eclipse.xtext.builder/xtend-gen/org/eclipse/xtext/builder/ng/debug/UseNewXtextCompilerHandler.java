/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.ng.debug;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.xtext.builder.ng.BuilderSwitch;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class UseNewXtextCompilerHandler extends AbstractHandler {
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    Object _xblockexpression = null;
    {
      boolean _isSelected = UseNewXtextCompilerHandler.isSelected(event);
      BuilderSwitch.setUseNewCompiler(_isSelected);
      _xblockexpression = null;
    }
    return _xblockexpression;
  }
  
  private static boolean isSelected(final ExecutionEvent event) {
    Object _trigger = event.getTrigger();
    return ((ToolItem) ((Event) _trigger).widget).getSelection();
  }
}
