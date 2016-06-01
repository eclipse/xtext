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
public class RenameXtendClassSwtBotTest extends AbstractRefactoringSwtBotTest {
  @Parameterized.Parameters(name = "{0}")
  public static Collection<Object[]> data() {
    RefactoringTestParameters _refactoringTestParameters = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(true);
      it.setUsePreview(false);
    };
    RefactoringTestParameters _doubleArrow = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters, _function);
    RefactoringTestParameters _refactoringTestParameters_1 = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function_1 = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(false);
      it.setUsePreview(false);
    };
    RefactoringTestParameters _doubleArrow_1 = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters_1, _function_1);
    RefactoringTestParameters _refactoringTestParameters_2 = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function_2 = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(true);
      it.setUsePreview(true);
    };
    RefactoringTestParameters _doubleArrow_2 = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters_2, _function_2);
    RefactoringTestParameters _refactoringTestParameters_3 = new RefactoringTestParameters();
    final Procedure1<RefactoringTestParameters> _function_3 = (RefactoringTestParameters it) -> {
      it.setUseInlineRefactoring(false);
      it.setUsePreview(true);
    };
    RefactoringTestParameters _doubleArrow_3 = ObjectExtensions.<RefactoringTestParameters>operator_doubleArrow(_refactoringTestParameters_3, _function_3);
    return Collections.<Object[]>unmodifiableList(CollectionLiterals.<Object[]>newArrayList(new Object[] { _doubleArrow }, new Object[] { _doubleArrow_1 }, new Object[] { _doubleArrow_2 }, new Object[] { _doubleArrow_3 }));
  }
  
  public RenameXtendClassSwtBotTest(final RefactoringTestParameters testParams) {
    super(testParams);
  }
  
  @Test
  public void renameXtendClass() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nnewXtendEditor cannot be resolved"
      + "\nnewXtendEditor cannot be resolved"
      + "\nrenameInXtendEditor cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ntitle cannot be resolved");
  }
  
  @Test
  public void renameXtendClassReference() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nnewXtendEditor cannot be resolved"
      + "\nnewXtendEditor cannot be resolved"
      + "\nrenameInXtendEditor cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ntitle cannot be resolved");
  }
  
  @Test
  public void renameXtendClassWithAA() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getBot() from the type AbstractRefactoringSwtBotTest refers to the missing type SWTWorkbenchBot"
      + "\nnewXtendEditor cannot be resolved"
      + "\nrenameInXtendEditor cannot be resolved"
      + "\ntext cannot be resolved"
      + "\ntitle cannot be resolved");
  }
}
