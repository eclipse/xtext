/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.idea.navigation;

import org.eclipse.xtend.idea.LightXtendTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class IdeaTraceTest extends LightXtendTest {
  /* @Inject
   */private /* TraceRegionSerializer */Object bareTraceReader;
  
  /* @Inject
   */private /* ITraceForVirtualFileProvider */Object traceProvider;
  
  public void testTraceFileContents() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method assertTrue(Object) is undefined"
      + "\nThe method or field VfsUtil is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method assertTrue(Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe field IdeaTraceTest.bareTraceReader refers to the missing type TraceRegionSerializer"
      + "\naddFileToProject cannot be resolved"
      + "\nfindFileInTempDir cannot be resolved"
      + "\nexists cannot be resolved"
      + "\nloadText cannot be resolved"
      + "\nfindFileInTempDir cannot be resolved"
      + "\nexists cannot be resolved"
      + "\nreadTraceRegionFrom cannot be resolved"
      + "\ncontentsToByteArray cannot be resolved"
      + "\nassociatedSrcRelativePath cannot be resolved"
      + "\ntoString cannot be resolved");
  }
  
  public void testNoTraceFile() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nVirtualFileInProject cannot be resolved."
      + "\nThe method or field PsiUtil is undefined"
      + "\nThe method assertNull(Object) is undefined"
      + "\nThe field IdeaTraceTest.traceProvider refers to the missing type ITraceForVirtualFileProvider"
      + "\naddFileToProject cannot be resolved"
      + "\ngetTraceToSource cannot be resolved"
      + "\ngetVirtualFile cannot be resolved"
      + "\nproject cannot be resolved");
  }
  
  public void testTraceToTarget() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nVirtualFileInProject cannot be resolved."
      + "\nTextRegion cannot be resolved."
      + "\nThe method assertNull(Object) is undefined"
      + "\nTextRegion cannot be resolved."
      + "\nThe method assertNotNull(Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe method assertEquals(String, Object) is undefined"
      + "\nThe field IdeaTraceTest.traceProvider refers to the missing type ITraceForVirtualFileProvider"
      + "\naddFileToProject cannot be resolved"
      + "\nvirtualFile cannot be resolved"
      + "\ngetTraceToTarget cannot be resolved"
      + "\nproject cannot be resolved"
      + "\ngetBestAssociatedLocation cannot be resolved"
      + "\ngetBestAssociatedLocation cannot be resolved"
      + "\nsrcRelativeResourceURI cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\nabsoluteResourceURI cannot be resolved"
      + "\ntoString cannot be resolved");
  }
  
  /* @Ignore
   */public void _testTraceToTargetForPsiFile() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method assertNotEmpty(Object) is undefined"
      + "\nThe field IdeaTraceTest.traceProvider refers to the missing type ITraceForVirtualFileProvider"
      + "\naddFileToProject cannot be resolved"
      + "\ngetGeneratedElements cannot be resolved");
  }
  
  public void testTraceToSource() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\nVirtualFileInProject cannot be resolved."
      + "\nThe method or field project is undefined"
      + "\nTextRegion cannot be resolved."
      + "\nThe method assertNotNull(Object) is undefined"
      + "\nThe field IdeaTraceTest.traceProvider refers to the missing type ITraceForVirtualFileProvider"
      + "\naddFileToProject cannot be resolved"
      + "\nfindFileInTempDir cannot be resolved"
      + "\ngetTraceToSource cannot be resolved"
      + "\ngetBestAssociatedLocation cannot be resolved");
  }
  
  public void testTraceForJar_01() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field JarFileSystem is undefined"
      + "\nVirtualFileInProject cannot be resolved."
      + "\nThe method or field project is undefined"
      + "\nThe method assertNotNull(Object) is undefined"
      + "\nThe method assertTrue(Object) is undefined"
      + "\nThe method getVirtualFile(String) from the type IdeaTraceTest refers to the missing type VirtualFile"
      + "\nThe method getVirtualFile(String) from the type IdeaTraceTest refers to the missing type VirtualFile"
      + "\nThe method addLibrary(Module, VirtualFile, VirtualFile) from the type IdeaTraceTest refers to the missing type Object"
      + "\nThe field IdeaTraceTest.traceProvider refers to the missing type ITraceForVirtualFileProvider"
      + "\nmodule cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\ngetJarRootForLocalFile cannot be resolved"
      + "\nfindFileByRelativePath cannot be resolved"
      + "\ngetTraceToSource cannot be resolved"
      + "\nallAssociatedLocations cannot be resolved"
      + "\nforEach cannot be resolved"
      + "\nabsoluteResourceURI cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\nendsWith cannot be resolved");
  }
  
  public void testTraceForJar_02() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field myFixture is undefined"
      + "\nThe method or field JarFileSystem is undefined"
      + "\nVirtualFileInProject cannot be resolved."
      + "\nThe method or field project is undefined"
      + "\nThe method assertNull(Object) is undefined"
      + "\nThe method getVirtualFile(String) from the type IdeaTraceTest refers to the missing type VirtualFile"
      + "\nThe method getVirtualFile(String) from the type IdeaTraceTest refers to the missing type VirtualFile"
      + "\nThe method addLibrary(Module, VirtualFile, VirtualFile) from the type IdeaTraceTest refers to the missing type Object"
      + "\nThe field IdeaTraceTest.traceProvider refers to the missing type ITraceForVirtualFileProvider"
      + "\nmodule cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\ngetJarRootForLocalFile cannot be resolved"
      + "\nfindFileByRelativePath cannot be resolved"
      + "\ngetTraceToTarget cannot be resolved");
  }
  
  public Object addLibrary(final /* Module */Object module, final /* VirtualFile */Object bin, final /* VirtualFile */Object src) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field LibrariesContainerFactory is undefined"
      + "\nThe method or field project is undefined"
      + "\nThe method or field ApplicationManager is undefined"
      + "\nThe method or field LibrariesContainer is undefined"
      + "\nThe method or field ModuleRootManager is undefined"
      + "\nThe method or field Disposer is undefined"
      + "\nThe method or field myFixture is undefined"
      + "\ncreateContainer cannot be resolved"
      + "\napplication cannot be resolved"
      + "\nrunWriteAction cannot be resolved"
      + "\ncreateLibrary cannot be resolved"
      + "\nLibraryLevel cannot be resolved"
      + "\nGLOBAL cannot be resolved"
      + "\ngetInstance cannot be resolved"
      + "\nmodifiableModel cannot be resolved"
      + "\naddLibraryEntry cannot be resolved"
      + "\nregister cannot be resolved"
      + "\nmodule cannot be resolved"
      + "\ndispose cannot be resolved");
  }
  
  protected /* VirtualFile */Object getVirtualFile(final String fileNameInPackage) {
    throw new Error("Unresolved compilation problems:"
      + "\n+ cannot be resolved."
      + "\nThe method or field class is undefined"
      + "\nThe method or field class is undefined"
      + "\nThe method or field VirtualFileManager is undefined"
      + "\nThe method or field VfsUtilCore is undefined"
      + "\npackage cannot be resolved"
      + "\nname cannot be resolved"
      + "\nreplace cannot be resolved"
      + "\n+ cannot be resolved"
      + "\n+ cannot be resolved"
      + "\ngetResource cannot be resolved"
      + "\ninstance cannot be resolved"
      + "\nfindFileByUrl cannot be resolved"
      + "\nconvertFromUrl cannot be resolved");
  }
}
