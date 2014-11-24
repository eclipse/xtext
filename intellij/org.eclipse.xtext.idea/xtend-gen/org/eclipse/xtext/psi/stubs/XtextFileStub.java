package org.eclipse.xtext.psi.stubs;

import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubs.ExportedObject;
import org.eclipse.xtext.psi.stubs.XtextFileElementType;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class XtextFileStub<T extends BaseXtextFile> /* implements PsiFileStubImpl<T>, PsiFileStub<T>  */{
  @Accessors
  private URI uri;
  
  @Accessors
  private List<ExportedObject> exportedObjects;
  
  private final XtextFileElementType<?> type;
  
  public XtextFileStub(final T file, final XtextFileElementType<?> type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super is undefined for the type XtextFileStub");
  }
  
  public XtextFileElementType<?> getType() {
    return this.type;
  }
  
  @Pure
  public URI getUri() {
    return this.uri;
  }
  
  public void setUri(final URI uri) {
    this.uri = uri;
  }
  
  @Pure
  public List<ExportedObject> getExportedObjects() {
    return this.exportedObjects;
  }
  
  public void setExportedObjects(final List<ExportedObject> exportedObjects) {
    this.exportedObjects = exportedObjects;
  }
}
