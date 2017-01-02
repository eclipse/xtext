/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.config;

import org.eclipse.xtend.idea.LightXtendTest;

/**
 * @author dhuebner - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtendLibraryManagerTest extends LightXtendTest {
  /* @Inject
   */private /* XtendLibraryConfigurator */Object manager;
  
  private /*  */Object libraryAdder;
  
  @Override
  protected Object setUp() throws Exception {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method setUp() is undefined for the type LightXtendTest"
      + "\nThe method or field ModuleRootModificationUtil is undefined"
      + "\nThe field XtendLibraryManagerTest.libraryAdder refers to the missing type Object"
      + "\nThe field XtendLibraryManagerTest.manager refers to the missing type XtendLibraryConfigurator"
      + "\nupdateModel cannot be resolved"
      + "\nensureXtendLibAvailable cannot be resolved");
  }
  
  @Override
  protected Object configureModule(final /* Module */Object module, final /* ModifiableRootModel */Object model, final /* ContentEntry */Object contentEntry) {
    return null;
  }
  
  public void testNoLibErrors() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method configureByText(String) is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\ncheckHighlighting cannot be resolved");
  }
  
  public void testLibAdded() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myModule is undefined"
      + "\nThe method configureByText(String) is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe field XtendLibraryManagerTest.libraryAdder refers to the missing type Object"
      + "\napply cannot be resolved"
      + "\ncheckHighlighting cannot be resolved");
  }
  
  public void testXtendLibMissingIntention() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field XtendIntentionsProvider is undefined"
      + "\nThe method assertIntentionApplication(String, String) from the type XtendLibraryManagerTest refers to the missing type Object"
      + "\nAddXtendLibToClassPathIntentionAction cannot be resolved"
      + "\nTEXT cannot be resolved");
  }
  
  public Object assertIntentionApplication(final String intentionId, final String source) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method configureByText(String) is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field CommandProcessor is undefined"
      + "\nThe method getProject() is undefined"
      + "\nThe method or field ApplicationManager is undefined"
      + "\nThe method or field editor is undefined"
      + "\nThe method or field PsiDocumentManager is undefined"
      + "\nThe method getProject() is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nfindSingleIntention cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\nexecuteCommand cannot be resolved"
      + "\napplication cannot be resolved"
      + "\nrunWriteAction cannot be resolved"
      + "\ninvoke cannot be resolved"
      + "\nproject cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\ncommitAllDocuments cannot be resolved"
      + "\ncheckHighlighting cannot be resolved");
  }
  
  public void testLibNotAddedTwice() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myModule is undefined"
      + "\nThe method or field myModule is undefined"
      + "\nThe method or field ModuleRootManager is undefined"
      + "\nThe method or field myModule is undefined"
      + "\nThe method or field presentableName is undefined"
      + "\nThe method or field XtendLibraryDescription is undefined"
      + "\nThe method assertEquals(String, int, Object) is undefined"
      + "\nThe method configureByText(String) is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe field XtendLibraryManagerTest.libraryAdder refers to the missing type Object"
      + "\nThe field XtendLibraryManagerTest.libraryAdder refers to the missing type Object"
      + "\napply cannot be resolved"
      + "\napply cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\ngetOrderEntries cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nstartsWith cannot be resolved"
      + "\nXTEND_LIBRARY_NAME cannot be resolved"
      + "\nsize cannot be resolved"
      + "\ncheckHighlighting cannot be resolved");
  }
}
