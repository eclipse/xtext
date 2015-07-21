/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.formatting;

import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.SpacingBuilder;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public interface ModifiableBlock extends Block {
  public abstract void setIndent(final Indent indent);
  
  public abstract void setIncomplete(final Boolean incomplete);
  
  public abstract SpacingBuilder getSpacingBuilder();
  
  public abstract void setSpacingBuilder(final SpacingBuilder spacingBuilder);
  
  public abstract Block getParentBlock();
  
  public abstract void setParentBlock(final Block parentBlock);
}
