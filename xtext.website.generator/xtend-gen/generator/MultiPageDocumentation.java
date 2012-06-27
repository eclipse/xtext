package generator;

import bootstrap.TargetPaths;
import com.google.common.collect.Iterators;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.inject.Inject;
import com.google.inject.Injector;
import generator.DocumentationPage;
import generator.DocumentationSetup;
import generator.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Chapter;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.ImageRef;
import xdocgen.DocumentLoad;

@SuppressWarnings("all")
public class MultiPageDocumentation implements Resource {
  public MultiPageDocumentation() {
    DocumentationSetup _standaloneSetup = this.getStandaloneSetup();
    final Injector injector = _standaloneSetup.createInjectorAndDoEMFRegistration();
    injector.injectMembers(this);
    String _xdocDocumentRootFolder = this.getXdocDocumentRootFolder();
    Document _loadDocument = this.docLoader.loadDocument(_xdocDocumentRootFolder);
    this.doc = _loadDocument;
    final Function1<AbstractSection,Boolean> _function = new Function1<AbstractSection,Boolean>() {
        public Boolean apply(final AbstractSection it) {
          return Boolean.valueOf((it instanceof Chapter));
        }
      };
    this._targetPaths.splitAt(this.doc, _function, "documentation");
  }
  
  public DocumentationSetup getStandaloneSetup() {
    DocumentationSetup _documentationSetup = new DocumentationSetup();
    return _documentationSetup;
  }
  
  public String getXdocDocumentRootFolder() {
    return "../docs/org.eclipse.xtext.doc.xdoc/xdoc";
  }
  
  private final Document doc;
  
  @Inject
  private DocumentLoad docLoader;
  
  @Inject
  private TargetPaths _targetPaths;
  
  public void generateTo(final File targetDir) {
    List<? extends AbstractSection> _targetRoots = this._targetPaths.getTargetRoots(this.doc);
    for (final AbstractSection section : _targetRoots) {
      DocumentationPage _documentationPage = new DocumentationPage(this.doc, section);
      _documentationPage.generateTo(targetDir);
    }
    this.copyImages(this.doc, targetDir);
  }
  
  public void copyImages(final Document doc, final File targetDir) {
    org.eclipse.emf.ecore.resource.Resource _eResource = doc.eResource();
    ResourceSet _resourceSet = _eResource.getResourceSet();
    final TreeIterator<?> iter = EcoreUtil.getAllContents(_resourceSet, true);
    Iterator<ImageRef> _filter = Iterators.<ImageRef>filter(iter, ImageRef.class);
    final Procedure1<ImageRef> _function = new Procedure1<ImageRef>() {
        public void apply(final ImageRef it) {
          try {
            org.eclipse.emf.ecore.resource.Resource _eResource = it.eResource();
            URI _uRI = _eResource.getURI();
            URI _trimSegments = _uRI.trimSegments(1);
            String _fileString = _trimSegments.toFileString();
            String _path = it.getPath();
            File _file = new File(_fileString, _path);
            final File source = _file;
            boolean _exists = source.exists();
            boolean _not = (!_exists);
            if (_not) {
              String _canonicalPath = source.getCanonicalPath();
              String _plus = ("Referenced Image " + _canonicalPath);
              String _plus_1 = (_plus + " does not exist in ");
              org.eclipse.emf.ecore.resource.Resource _eResource_1 = it.eResource();
              URI _uRI_1 = _eResource_1.getURI();
              String _lastSegment = _uRI_1.lastSegment();
              String _plus_2 = (_plus_1 + _lastSegment);
              String _plus_3 = (_plus_2 + " line ");
              ICompositeNode _node = NodeModelUtils.getNode(it);
              int _startLine = _node.getStartLine();
              String _plus_4 = (_plus_3 + Integer.valueOf(_startLine));
              IllegalStateException _illegalStateException = new IllegalStateException(_plus_4);
              throw _illegalStateException;
            }
            String _path_1 = it.getPath();
            File _file_1 = new File(targetDir, _path_1);
            final File target = _file_1;
            String _canonicalPath_1 = target.getCanonicalPath();
            InputOutput.<String>println(_canonicalPath_1);
            InputSupplier<FileInputStream> _newInputStreamSupplier = Files.newInputStreamSupplier(source);
            Files.copy(_newInputStreamSupplier, target);
          } catch (Exception _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
    IteratorExtensions.<ImageRef>forEach(_filter, _function);
  }
}
