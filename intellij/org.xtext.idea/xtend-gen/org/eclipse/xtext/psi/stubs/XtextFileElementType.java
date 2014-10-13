package org.eclipse.xtext.psi.stubs;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.intellij.lang.Language;
import com.intellij.psi.StubBuilder;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.PsiFileStub;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubIndexKey;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.psi.tree.IStubFileElementType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.idea.types.stubindex.JvmDeclaredTypeShortNameIndex;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.psi.stubs.ExportedObject;
import org.eclipse.xtext.psi.stubs.XtextFileStub;
import org.eclipse.xtext.psi.stubs.XtextStubBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class XtextFileElementType<T extends XtextFileStub<?>> extends IStubFileElementType<T> {
  @Inject
  private Provider<XtextStubBuilder> xtextStubBuilderProvider;
  
  @Inject
  private ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex;
  
  @Inject
  private JvmDeclaredTypeShortNameIndex jvmDeclaredTypeShortNameIndex;
  
  public XtextFileElementType(final Language language) {
    super(language);
    if ((language instanceof IXtextLanguage)) {
      ((IXtextLanguage)language).injectMembers(this);
    }
  }
  
  public String getExternalId() {
    return "xtext.file";
  }
  
  public StubBuilder getBuilder() {
    return this.xtextStubBuilderProvider.get();
  }
  
  public void serialize(final T stub, final StubOutputStream it) throws IOException {
    URI _uri = stub.getUri();
    this.writeURI(it, _uri);
    List<ExportedObject> _exportedObjects = stub.getExportedObjects();
    this.writeExportedObjects(it, _exportedObjects);
  }
  
  protected void writeExportedObjects(final StubOutputStream it, final List<ExportedObject> exportedObjects) throws IOException {
    int _size = exportedObjects.size();
    it.writeInt(_size);
    for (final ExportedObject exportedObject : exportedObjects) {
      {
        QualifiedName _qualifiedName = exportedObject.getQualifiedName();
        this.writeQualifiedName(it, _qualifiedName);
        EClass _eClass = exportedObject.getEClass();
        this.writeEClass(it, _eClass);
        URI _eObjectURI = exportedObject.getEObjectURI();
        this.writeURI(it, _eObjectURI);
      }
    }
  }
  
  protected void writeQualifiedName(final StubOutputStream it, final QualifiedName qualifiedName) {
    try {
      int _segmentCount = qualifiedName.getSegmentCount();
      it.writeInt(_segmentCount);
      List<String> _segments = qualifiedName.getSegments();
      for (final String segment : _segments) {
        it.writeUTF(segment);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void writeEClass(final StubOutputStream it, final EClass type) {
    try {
      EPackage _ePackage = type.getEPackage();
      String _nsURI = _ePackage.getNsURI();
      it.writeUTF(_nsURI);
      String _name = type.getName();
      it.writeUTF(_name);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void writeURI(final StubOutputStream it, final URI uri) {
    try {
      String _string = uri.toString();
      it.writeUTF(_string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public T deserialize(final StubInputStream it, final StubElement parentStub) throws IOException {
    T _xblockexpression = null;
    {
      final XtextFileStub<BaseXtextFile> stub = new XtextFileStub<BaseXtextFile>(null, this);
      URI _readURI = this.readURI(it);
      stub.setUri(_readURI);
      ArrayList<ExportedObject> _readExportedObjects = this.readExportedObjects(it);
      stub.setExportedObjects(_readExportedObjects);
      _xblockexpression = ((T) stub);
    }
    return _xblockexpression;
  }
  
  protected ArrayList<ExportedObject> readExportedObjects(final StubInputStream it) throws IOException {
    ArrayList<ExportedObject> _xblockexpression = null;
    {
      final ArrayList<ExportedObject> exportedObjects = CollectionLiterals.<ExportedObject>newArrayList();
      final int count = it.readInt();
      for (int i = 0; (i < count); i++) {
        {
          final QualifiedName qualifiedName = this.readQualifiedName(it);
          final EClass EClass = this.readEClass(it);
          final URI EObjectURI = this.readURI(it);
          ExportedObject _exportedObject = new ExportedObject(qualifiedName, EClass, EObjectURI);
          exportedObjects.add(_exportedObject);
        }
      }
      _xblockexpression = exportedObjects;
    }
    return _xblockexpression;
  }
  
  protected QualifiedName readQualifiedName(final StubInputStream it) {
    try {
      QualifiedName _xblockexpression = null;
      {
        final int segmentCount = it.readInt();
        final ArrayList<String> segments = CollectionLiterals.<String>newArrayList();
        for (int i = 0; (i < segmentCount); i++) {
          String _readUTF = it.readUTF();
          segments.add(_readUTF);
        }
        _xblockexpression = QualifiedName.create(segments);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected EClass readEClass(final StubInputStream it) {
    try {
      EClass _xblockexpression = null;
      {
        final String packageURI = it.readUTF();
        final EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(packageURI);
        String _readUTF = it.readUTF();
        EClassifier _eClassifier = ePackage.getEClassifier(_readUTF);
        _xblockexpression = ((EClass) _eClassifier);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected URI readURI(final StubInputStream it) {
    try {
      String _readUTF = it.readUTF();
      return URI.createURI(_readUTF);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void indexStub(final PsiFileStub stub, @Extension final IndexSink sink) {
    if ((stub instanceof XtextFileStub<?>)) {
      List<ExportedObject> _exportedObjects = ((XtextFileStub<?>)stub).getExportedObjects();
      for (final ExportedObject exportedObject : _exportedObjects) {
        {
          StubIndexKey<String, BaseXtextFile> _key = this.exportedObjectQualifiedNameIndex.getKey();
          QualifiedName _qualifiedName = exportedObject.getQualifiedName();
          String _string = _qualifiedName.toString();
          sink.<BaseXtextFile, String>occurrence(_key, _string);
          EClass _eClass = exportedObject.getEClass();
          boolean _isAssignableFrom = EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_DECLARED_TYPE, _eClass);
          if (_isAssignableFrom) {
            StubIndexKey<String, BaseXtextFile> _key_1 = this.jvmDeclaredTypeShortNameIndex.getKey();
            QualifiedName _qualifiedName_1 = exportedObject.getQualifiedName();
            String _lastSegment = _qualifiedName_1.getLastSegment();
            sink.<BaseXtextFile, String>occurrence(_key_1, _lastSegment);
          }
        }
      }
    }
  }
  
  public void indexStub(final T stub, final IndexSink sink) {
    this.indexStub(((PsiFileStub<?>) stub), sink);
  }
}
