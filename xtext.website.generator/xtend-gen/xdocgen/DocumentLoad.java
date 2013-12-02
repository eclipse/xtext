package xdocgen;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.mwe.PathTraverser;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xdoc.xdoc.Document;

@SuppressWarnings("all")
public class DocumentLoad {
  @Inject
  private Provider<XtextResourceSet> provider;
  
  private final boolean validate = false;
  
  public Document loadDocument(final String... baseDirs) {
    final XtextResourceSet rs = this.provider.get();
    PathTraverser _pathTraverser = new PathTraverser();
    final Predicate<URI> _function = new Predicate<URI>() {
      public boolean apply(final URI it) {
        String _fileExtension = it.fileExtension();
        boolean _equals = Objects.equal(_fileExtension, "xdoc");
        return _equals;
      }
    };
    Multimap<String,URI> _resolvePathes = _pathTraverser.resolvePathes(((List<String>)Conversions.doWrapArray(baseDirs)), _function);
    final Collection<URI> uris = _resolvePathes.values();
    Collection<URI> _xtendFiles = this.getXtendFiles();
    Iterable<URI> _plus = Iterables.<URI>concat(uris, _xtendFiles);
    for (final URI uri : _plus) {
      {
        InputOutput.<String>println(("Loading " + uri));
        rs.getResource(uri, true);
      }
    }
    if (this.validate) {
      EcoreUtil2.resolveAll(rs);
      EList<Resource> _resources = rs.getResources();
      final Function1<Resource,List<Issue>> _function_1 = new Function1<Resource,List<Issue>>() {
        public List<Issue> apply(final Resource it) {
          List<Issue> _switchResult = null;
          boolean _matched = false;
          if (!_matched) {
            if (it instanceof XtextResource) {
              _matched=true;
              List<Issue> _xblockexpression = null;
              {
                IResourceServiceProvider _resourceServiceProvider = ((XtextResource)it).getResourceServiceProvider();
                final IResourceValidator validator = _resourceServiceProvider.getResourceValidator();
                List<Issue> _validate = validator.validate(it, CheckMode.ALL, null);
                _xblockexpression = (_validate);
              }
              _switchResult = _xblockexpression;
            }
          }
          if (!_matched) {
            List<Issue> _emptyList = CollectionLiterals.<Issue>emptyList();
            _switchResult = _emptyList;
          }
          return _switchResult;
        }
      };
      List<List<Issue>> _map = ListExtensions.<Resource, List<Issue>>map(_resources, _function_1);
      final Iterable<Issue> issues = Iterables.<Issue>concat(_map);
      final Function1<Issue,Boolean> _function_2 = new Function1<Issue,Boolean>() {
        public Boolean apply(final Issue i) {
          Severity _severity = i.getSeverity();
          boolean _equals = Objects.equal(_severity, Severity.ERROR);
          return Boolean.valueOf(_equals);
        }
      };
      boolean _exists = IterableExtensions.<Issue>exists(issues, _function_2);
      if (_exists) {
        final Function1<Issue,String> _function_3 = new Function1<Issue,String>() {
          public String apply(final Issue it) {
            String _string = it.toString();
            String _plus = ("\n\t" + _string);
            return _plus;
          }
        };
        Iterable<String> _map_1 = IterableExtensions.<Issue, String>map(issues, _function_3);
        String _join = IterableExtensions.join(_map_1);
        IllegalStateException _illegalStateException = new IllegalStateException(_join);
        throw _illegalStateException;
      } else {
        boolean _isEmpty = IterableExtensions.isEmpty(issues);
        boolean _not = (!_isEmpty);
        if (_not) {
          final Function1<Issue,String> _function_4 = new Function1<Issue,String>() {
            public String apply(final Issue it) {
              String _string = it.toString();
              return _string;
            }
          };
          Iterable<String> _map_2 = IterableExtensions.<Issue, String>map(issues, _function_4);
          String _join_1 = IterableExtensions.join(_map_2, "\n");
          InputOutput.<String>println(_join_1);
        }
      }
    }
    TreeIterator<Notifier> _allContents = rs.getAllContents();
    Iterator<Document> _filter = Iterators.<Document>filter(_allContents, Document.class);
    final List<Document> docs = IteratorExtensions.<Document>toList(_filter);
    return IterableExtensions.<Document>head(docs);
  }
  
  protected Collection<URI> getXtendFiles() {
    Collection<URI> _xblockexpression = null;
    {
      final String classPath = System.getProperty("java.class.path");
      final String separator = System.getProperty("path.separator");
      final String[] entries = classPath.split(separator);
      PathTraverser _pathTraverser = new PathTraverser();
      final Predicate<URI> _function = new Predicate<URI>() {
        public boolean apply(final URI it) {
          String _fileExtension = it.fileExtension();
          boolean _equals = Objects.equal(_fileExtension, "xtend");
          return _equals;
        }
      };
      Multimap<String,URI> _resolvePathes = _pathTraverser.resolvePathes(((List<String>)Conversions.doWrapArray(entries)), _function);
      Collection<URI> _values = _resolvePathes.values();
      _xblockexpression = (_values);
    }
    return _xblockexpression;
  }
}
