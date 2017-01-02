/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.macro;

import java.io.IOException;

/**
 * @author kosyakov - Initial contribution and API
 */
/* @TestDecorator */@SuppressWarnings("all")
public class IdeaFileSystemTest /* implements PsiTestCase  */{
  /* @FinalFieldsConstructor
   */private static class Delegate /* implements JavaIoFileSystemTest  */{
    private final IdeaFileSystemTest _ideaFileSystemTest;
    
    public void setFileSystemSupport(final /* MutableFileSystemSupport */Object fileSystemSupport) {
      throw new Error("Unresolved compilation problems:"
        + "\nThe method fs(MutableFileSystemSupport) is undefined");
    }
    
    @Override
    protected Object createProject(final String name) {
      throw new Error("Unresolved compilation problems:"
        + "\nThe method createModule(String) is undefined");
    }
    
    @Override
    public Object assertToURI(final /* Path */Object file, final String expectedContent) {
      throw new Error("Unresolved compilation problems:"
        + "\nThe method or field VirtualFileBasedUriHandler is undefined"
        + "\nThe method or field resourceSet is undefined"
        + "\nThe method or field super is undefined"
        + "\nfind cannot be resolved"
        + "\nflushToDisk cannot be resolved"
        + "\nassertToURI cannot be resolved");
    }
  }
  
  /* @Inject
   */private /* IdeaResourceSetProvider */Object ideaResourceSetProvider;
  
  /* @Inject
   */private /* Provider<IdeaFileSystemSupport> */Object fileSystemSupportProvider;
  
  private final IdeaFileSystemTest.Delegate delegate /* Skipped initializer because of errors */;
  
  private /* XtextResourceSet */Object resourceSet;
  
  @Override
  protected void setUp() throws Exception {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field super is undefined"
      + "\nThe method or field XtendLanguage is undefined"
      + "\nThe method or field module is undefined"
      + "\nThe field IdeaFileSystemTest.resourceSet refers to the missing type XtextResourceSet"
      + "\nThe field IdeaFileSystemTest.ideaResourceSetProvider refers to the missing type IdeaResourceSetProvider"
      + "\nThe field IdeaFileSystemTest.fileSystemSupportProvider refers to the missing type Provider"
      + "\nThe field IdeaFileSystemTest.resourceSet refers to the missing type XtextResourceSet"
      + "\nThe method setFileSystemSupport(MutableFileSystemSupport) from the type IdeaFileSystemTest.Delegate refers to the missing type MutableFileSystemSupport"
      + "\nsetUp cannot be resolved"
      + "\nINSTANCE cannot be resolved"
      + "\ninjectMembers cannot be resolved"
      + "\nget cannot be resolved"
      + "\nget cannot be resolved"
      + "\ncontext cannot be resolved");
  }
  
  @Override
  protected Object createMainModule() throws IOException {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method createModule(String) from the type IdeaFileSystemTest refers to the missing type Object");
  }
  
  @Override
  protected Object createModule(final String moduleName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field super is undefined"
      + "\nThe method createChildDirectory(Object, String) is undefined"
      + "\nThe method or field project is undefined"
      + "\nThe method createChildDirectory(Object, String) is undefined"
      + "\ncreateModule cannot be resolved"
      + "\nbaseDir cannot be resolved"
      + "\nupdateModel cannot be resolved"
      + "\naddContentEntry cannot be resolved"
      + "\naddSourceFolder cannot be resolved");
  }
}
