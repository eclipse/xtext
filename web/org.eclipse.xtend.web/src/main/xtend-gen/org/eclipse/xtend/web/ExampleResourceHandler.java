package org.eclipse.xtend.web;

import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.web.server.model.IWebResourceSetProvider;
import org.eclipse.xtext.web.server.model.IXtextWebDocument;
import org.eclipse.xtext.web.server.model.XtextWebDocument;
import org.eclipse.xtext.web.server.persistence.IServerResourceHandler;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Pair;

@SuppressWarnings("all")
public class ExampleResourceHandler implements IServerResourceHandler {
  @Inject
  private IWebResourceSetProvider resourceSetProvider;
  
  @Inject
  private Provider<XtextWebDocument> documentProvider;
  
  @Inject
  private IEncodingProvider encodingProvider;
  
  private final Map<String, String> examples = new Function0<Map<String, String>>() {
    public Map<String, String> apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Example {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var greeting = \"hello world!\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def sayHello() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(greeting)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("example.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Example {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("java.xtend", _builder_1.toString());
      return Collections.<String, String>unmodifiableMap(CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1));
    }
  }.apply();
  
  @Override
  public XtextWebDocument get(final String resourceId) throws IOException {
    final XtextWebDocument result = this.documentProvider.get();
    final ResourceSet resourceSet = this.resourceSetProvider.get(resourceId);
    URI _createURI = URI.createURI(resourceId);
    Resource _createResource = resourceSet.createResource(_createURI);
    final XtextResource resource = ((XtextResource) _createResource);
    result.setInput(resource, resourceId);
    String _elvis = null;
    String _get = this.examples.get(resourceId);
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = "";
    }
    result.setText(_elvis);
    return result;
  }
  
  @Override
  public void put(final IXtextWebDocument document) throws IOException {
    try {
      try {
        XtextResource _resource = document.getResource();
        final URI uri = _resource.getURI();
        String _fileExtension = uri.fileExtension();
        boolean _equals = _fileExtension.equals("xtend");
        if (_equals) {
          return;
        }
        XtextResource _resource_1 = document.getResource();
        ResourceSet _resourceSet = _resource_1.getResourceSet();
        URIConverter _uRIConverter = _resourceSet.getURIConverter();
        final OutputStream outputStream = _uRIConverter.createOutputStream(uri);
        String _encoding = this.encodingProvider.getEncoding(uri);
        final OutputStreamWriter writer = new OutputStreamWriter(outputStream, _encoding);
        String _text = document.getText();
        writer.write(_text);
        writer.close();
      } catch (final Throwable _t) {
        if (_t instanceof WrappedException) {
          final WrappedException exception = (WrappedException)_t;
          throw exception.getCause();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
