/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.imports;

import com.intellij.openapi.editor.Document;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.imports.RewritableImportSection;

/**
 * <p>
 * Create an instance of {@link RewritableImportSection} that can be used to rewrite {@link Document}.
 * </p>
 * 
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DocumentAwareRewritableImportSectionFactory extends RewritableImportSection.Factory {
  /**
   * <p>
   * A line separator in a document is always '\n'.
   * </p>
   */
  @Override
  protected String getLineSeparator(final XtextResource resource) {
    return "\n";
  }
}
