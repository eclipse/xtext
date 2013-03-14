package bootstrap;

import bootstrap.TargetPathAdapter;
import bootstrap.XdocExtensions;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xdoc.xdoc.AbstractSection;
import org.eclipse.xtext.xdoc.xdoc.Document;
import org.eclipse.xtext.xdoc.xdoc.Identifiable;

@SuppressWarnings("all")
public class TargetPaths {
  @Inject
  @Extension
  private XdocExtensions _xdocExtensions;
  
  public boolean splitAt(final Document document, final Function1<? super AbstractSection,? extends Boolean> predicate, final String prefix) {
    boolean _xblockexpression = false;
    {
      TargetPathAdapter _targetPathAdapter = new TargetPathAdapter();
      final TargetPathAdapter adapter = _targetPathAdapter;
      this.traverseChildren(document, adapter, prefix, "", predicate);
      Resource _eResource = document.eResource();
      ResourceSet _resourceSet = _eResource.getResourceSet();
      EList<Adapter> _eAdapters = _resourceSet.eAdapters();
      boolean _add = _eAdapters.add(adapter);
      _xblockexpression = (_add);
    }
    return _xblockexpression;
  }
  
  public String getTargetPath(final Identifiable element) {
    String _elvis = null;
    TargetPathAdapter _targetPathAdapter = this.getTargetPathAdapter(element);
    Map<Identifiable,String> _targetPaths = _targetPathAdapter==null?(Map<Identifiable,String>)null:_targetPathAdapter.targetPaths;
    String _get = _targetPaths==null?(String)null:_targetPaths.get(element);
    if (_get != null) {
      _elvis = _get;
    } else {
      _elvis = ObjectExtensions.<String>operator_elvis(_get, "");
    }
    return _elvis;
  }
  
  public boolean isTargetRootElement(final AbstractSection element) {
    boolean _xblockexpression = false;
    {
      TargetPathAdapter _targetPathAdapter = this.getTargetPathAdapter(element);
      final List<AbstractSection> targetFileRoots = _targetPathAdapter==null?(List<AbstractSection>)null:_targetPathAdapter.targetFileRoots;
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(targetFileRoots, null));
      if (_notEquals) {
        boolean _contains = targetFileRoots.contains(element);
        _xifexpression = _contains;
      } else {
        _xifexpression = (element instanceof Document);
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  public List<? extends AbstractSection> getTargetRoots(final Document document) {
    List<? extends AbstractSection> _elvis = null;
    TargetPathAdapter _targetPathAdapter = this.getTargetPathAdapter(document);
    List<AbstractSection> _targetFileRoots = _targetPathAdapter==null?(List<AbstractSection>)null:_targetPathAdapter.targetFileRoots;
    if (_targetFileRoots != null) {
      _elvis = _targetFileRoots;
    } else {
      ArrayList<Document> _newArrayList = CollectionLiterals.<Document>newArrayList(document);
      _elvis = ObjectExtensions.<List<? extends AbstractSection>>operator_elvis(_targetFileRoots, _newArrayList);
    }
    return _elvis;
  }
  
  protected Object traverseChildren(final Identifiable element, final TargetPathAdapter adapter, final String prefix, final String parentPath, final Function1<? super AbstractSection,? extends Boolean> predicate) {
    String thisPath = parentPath;
    if ((element instanceof AbstractSection)) {
      final AbstractSection resolved = this._xdocExtensions.resolve(((AbstractSection) element));
      boolean _notEquals = (!Objects.equal(resolved, element));
      if (_notEquals) {
        return this.traverseChildren(resolved, adapter, prefix, parentPath, predicate);
      }
      Boolean _apply = predicate.apply(((AbstractSection) element));
      if ((_apply).booleanValue()) {
        String _xifexpression = null;
        boolean _isEmpty = adapter.targetFileRoots.isEmpty();
        if (_isEmpty) {
          String _plus = (prefix + ".html");
          _xifexpression = _plus;
        } else {
          int _size = adapter.targetFileRoots.size();
          String _plus_1 = (prefix + Integer.valueOf(_size));
          String _plus_2 = (_plus_1 + ".html");
          _xifexpression = _plus_2;
        }
        thisPath = _xifexpression;
        adapter.targetFileRoots.add(((AbstractSection) element));
      }
    }
    adapter.targetPaths.put(element, thisPath);
    EList<EObject> _eContents = element.eContents();
    Iterable<Identifiable> _filter = Iterables.<Identifiable>filter(_eContents, Identifiable.class);
    for (final Identifiable child : _filter) {
      this.traverseChildren(child, adapter, prefix, thisPath, predicate);
    }
    return null;
  }
  
  protected TargetPathAdapter getTargetPathAdapter(final Identifiable element) {
    Resource _eResource = element==null?(Resource)null:element.eResource();
    ResourceSet _resourceSet = _eResource==null?(ResourceSet)null:_eResource.getResourceSet();
    EList<Adapter> _eAdapters = _resourceSet==null?(EList<Adapter>)null:_resourceSet.eAdapters();
    Iterable<TargetPathAdapter> _filter = _eAdapters==null?(Iterable<TargetPathAdapter>)null:Iterables.<TargetPathAdapter>filter(_eAdapters, TargetPathAdapter.class);
    TargetPathAdapter _head = _filter==null?(TargetPathAdapter)null:IterableExtensions.<TargetPathAdapter>head(_filter);
    return _head;
  }
}
