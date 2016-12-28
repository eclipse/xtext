/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.javaconverter;

/**
 * @author dhuebner - Initial contribution and API
 */
/* @TestDecorator */@SuppressWarnings("all")
public class IdeaJavaConverterTest /* implements AbstractModelTestCase  */{
  /* @FinalFieldsConstructor
   */private static class Delegate /* implements JavaConverterTest  */{
    private final /* ModelChecker */Object modelChecker;
    
    @Override
    public Object file(final String code, final boolean validate) {
      throw new Error("Unresolved compilation problems:"
        + "\nThe method getFileName(String) is undefined"
        + "\nThe field IdeaJavaConverterTest.Delegate.modelChecker refers to the missing type ModelChecker"
        + "\ncheckModel cannot be resolved");
    }
  }
  
  /* @Inject
   */private /* JavaConverter */Object converter;
  
  public IdeaJavaConverterTest(final /* LanguageFileType */Object fileType) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super(LanguageFileType) is undefined");
  }
  
  private IdeaJavaConverterTest.Delegate delegate;
  
  public IdeaJavaConverterTest() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super(Object) is undefined"
      + "\nThe method or field XtendFileType is undefined"
      + "\nInvalid number of arguments. The constructor Delegate() is not applicable for the arguments (IdeaJavaConverterTest)"
      + "\nINSTANCE cannot be resolved");
  }
  
  @Override
  protected Object setUp() throws Exception {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field super is undefined"
      + "\nThe method or field xtextLanguage is undefined"
      + "\nThe method or field setUp is undefined for the type Delegate"
      + "\nsetUp cannot be resolved"
      + "\ninjectMembers cannot be resolved");
  }
  
  /* @Test
   */public void testSimpleCase() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myModule is undefined"
      + "\nThe method assertNotNull(Object) is undefined"
      + "\nThe method assertTrue(Object) is undefined"
      + "\nThe field IdeaJavaConverterTest.converter refers to the missing type JavaConverter"
      + "\naddFileToProject cannot be resolved"
      + "\ntoXtend cannot be resolved"
      + "\nvirtualFile cannot be resolved"
      + "\nnameWithoutExtension cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nproblems cannot be resolved"
      + "\nempty cannot be resolved");
  }
  
  /* @Test
   */public void testCollectJavaFilesInHandler() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field ConvertJavaCodeHandler is undefined"
      + "\nThe method assertTrue(Object) is undefined"
      + "\nThe method assertEquals(int, Object) is undefined"
      + "\naddFileToProject cannot be resolved"
      + "\naddFileToProject cannot be resolved"
      + "\naddFileToProject cannot be resolved"
      + "\ncollectJavaFiles cannot be resolved"
      + "\nparent cannot be resolved"
      + "\nparent cannot be resolved"
      + "\niterator cannot be resolved"
      + "\nhasNext cannot be resolved"
      + "\niterator cannot be resolved"
      + "\nsize cannot be resolved");
  }
}
