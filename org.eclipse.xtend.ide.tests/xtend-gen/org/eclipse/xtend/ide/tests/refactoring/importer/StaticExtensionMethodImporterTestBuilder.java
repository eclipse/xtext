/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.refactoring.importer;

import com.google.inject.Inject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtend.ide.refactoring.importer.StaticExtensionMethodImporter;
import org.eclipse.xtend.ide.tests.refactoring.importer.StaticMethodImporterTestBuilder;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Usage is:
 * 
 * <pre>
 * 'test.Test.xtend'.create('''
 *      package test
 * 
 *      import test.other.Other
 * 
 *      class Test {
 *          def test() {
 *              Other.doSo|mething('test')
 *          }
 *      }
 * ''').assertResult('''
 *      package test
 * 
 *      import static extension test.other.Other.doSomething
 * 
 *      class Test {
 *          def test() {
 *              'test'.doSomething()
 *          }
 *      }
 * ''')
 * </pre>
 * 
 * | or <|> are used to mark the selection in the document.
 * 
 * @author vivien.jovet - Initial contribution and API
 */
@SuppressWarnings("all")
public class StaticExtensionMethodImporterTestBuilder extends StaticMethodImporterTestBuilder {
  @Inject
  @Extension
  private StaticExtensionMethodImporter staticExtensionMethodImporter;
  
  @Override
  protected boolean doImportStaticMethod(final IXtextDocument document, final int caretOffset) {
    TextSelection _textSelection = new TextSelection(caretOffset, 1);
    return this.staticExtensionMethodImporter.importStaticMethod(document, _textSelection);
  }
}
