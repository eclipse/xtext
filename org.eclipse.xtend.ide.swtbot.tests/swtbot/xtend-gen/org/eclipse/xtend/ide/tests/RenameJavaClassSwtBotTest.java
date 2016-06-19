/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests;

import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend.ide.tests.AbstractRefactoringSwtBotTest;
import org.eclipse.xtend.ide.tests.ParameterizedSWTBotRunner;
import org.eclipse.xtend.ide.tests.RefactoringTestParameters;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@RunWith(ParameterizedSWTBotRunner.class)
@SuppressWarnings("all")
public class RenameJavaClassSwtBotTest extends AbstractRefactoringSwtBotTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    RefactoringTestParameters _refactoringTestParameters = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(true);
      it.setUsePreview(false);
    };
    RefactoringTestParameters _doubleArrow = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters, _function);
    return Collections.<Object[]>unmodifiableList(CollectionLiterals.<Object[]>newArrayList(new Object[] { _doubleArrow }));
  }
  
  public RenameJavaClassSwtBotTest(final RefactoringTestParameters testParams) {
    super(testParams);
  }
  
  @Test
  public void renameJavaClass() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nnewXtendEditor cannot be resolved"
      + "\nnewJavaEditor cannot be resolved"
      + "\nrenameInJavaEditor cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ndirty cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ndirty cannot be resolved"
      + "\ntitle cannot be resolved");
  }
  
  @Test
  public void renameJavaClassXtendReference() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nnewJavaEditor cannot be resolved"
      + "\nnewXtendEditor cannot be resolved"
      + "\nrenameInXtendEditor cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ndirty cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ndirty cannot be resolved"
      + "\ntitle cannot be resolved");
  }
}
