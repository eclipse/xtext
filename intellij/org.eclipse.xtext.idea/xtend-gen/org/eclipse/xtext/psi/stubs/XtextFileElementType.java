package org.eclipse.xtext.psi.stubs;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.psi.stubs.ExportedObject;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.stubs.XtextStubBuilder;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class XtextFileElementType<T extends XtextFileStub<?>> /* implements IStubFileElementType<T>  */{
  @Inject
  private Provider<XtextStubBuilder> xtextStubBuilderProvider;
  
  @Inject
  private ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex;
  
  @Inject
  private JvmDeclaredTypeShortNameIndex jvmDeclaredTypeShortNameIndex;
  
  public XtextFileElementType(final /* Language */Object language) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super is undefined for the type XtextFileElementType"
      + "\ninjectMembers cannot be resolved");
  }
  
  public String getExternalId() {
    return "xtext.file";
  }
  
  public XtextStubBuilder getBuilder() {
    return this.xtextStubBuilderProvider.get();
  }
  
  public void serialize(final T stub, final /* StubOutputStream */Object it) throws IOException {
    URI _uri = stub.getUri();
    this.writeURI(this, _uri);
    List<ExportedObject> _exportedObjects = stub.getExportedObjects();
    this.writeExportedObjects(this, _exportedObjects);
  }
  
  protected void writeExportedObjects(final /* StubOutputStream */Object it, final List<ExportedObject> exportedObjects) throws IOException {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method writeInt is undefined for the type XtextFileElementType");
  }
  
  protected void writeQualifiedName(final /* StubOutputStream */Object it, final QualifiedName qualifiedName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method writeInt is undefined for the type XtextFileElementType"
      + "\nThe method writeUTF is undefined for the type XtextFileElementType");
  }
  
  protected Object writeEClass(final /* StubOutputStream */Object it, final EClass type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method writeUTF is undefined for the type XtextFileElementType"
      + "\nThe method writeUTF is undefined for the type XtextFileElementType");
  }
  
  protected Object writeURI(final /* StubOutputStream */Object it, final URI uri) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method writeUTF is undefined for the type XtextFileElementType");
  }
  
  public T deserialize(final /* StubInputStream */Object it, final /* StubElement */Object parentStub) throws IOException {
    T _xblockexpression = null;
    {
      final XtextFileStub<BaseXtextFile> stub = new XtextFileStub<BaseXtextFile>(null, this);
      URI _readURI = this.readURI(this);
      stub.setUri(_readURI);
      ArrayList<ExportedObject> _readExportedObjects = this.readExportedObjects(this);
      stub.setExportedObjects(_readExportedObjects);
      _xblockexpression = ((T) stub);
    }
    return _xblockexpression;
  }
  
  protected ArrayList<ExportedObject> readExportedObjects(final /* StubInputStream */Object it) throws IOException {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field readInt is undefined for the type XtextFileElementType");
  }
  
  protected QualifiedName readQualifiedName(final /* StubInputStream */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field readInt is undefined for the type XtextFileElementType"
      + "\nThe method or field readUTF is undefined for the type XtextFileElementType");
  }
  
  protected EClass readEClass(final /* StubInputStream */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field readUTF is undefined for the type XtextFileElementType"
      + "\nThe method or field readUTF is undefined for the type XtextFileElementType");
  }
  
  protected URI readURI(final /* StubInputStream */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field readUTF is undefined for the type XtextFileElementType");
  }
  
  public void indexStub(final /* PsiFileStub */Object stub, @Extension final /* IndexSink */Object sink) {
    throw new Error("Unresolved compilation problems:"
      + "\nexportedObjects cannot be resolved"
      + "\noccurrence cannot be resolved"
      + "\nqualifiedName cannot be resolved"
      + "\ntoString cannot be resolved"
      + "\nEClass cannot be resolved"
      + "\noccurrence cannot be resolved"
      + "\nqualifiedName cannot be resolved"
      + "\nlastSegment cannot be resolved");
  }
  
  public Object indexStub(final T stub, final /* IndexSink */Object sink) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiFileStub cannot be resolved to a type."
      + "\nindexStub cannot be resolved");
  }
}
