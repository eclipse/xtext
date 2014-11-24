package org.eclipse.xtext.idea.containers;

import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.idea.resource.AbstractScopeBasedSelectable;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ResolveScopeBasedContainer extends AbstractScopeBasedSelectable implements IContainer {
  public IResourceDescription getResourceDescription(final URI uri) {
    throw new Error("Unresolved compilation problems:"
      + "\n!= cannot be resolved");
  }
  
  public int getResourceDescriptionCount() {
    Integer _xblockexpression = null;
    {
      final int[] counter = { 0 };
      final Function1<Collection<VirtualFile>, Boolean> _function = new Function1<Collection<VirtualFile>, Boolean>() {
        public Boolean apply(final Collection<VirtualFile> files) {
          boolean _xblockexpression = false;
          {
            int _get = counter[0];
            int _size = files.size();
            int _plus = (_get + _size);
            counter[0] = _plus;
            _xblockexpression = true;
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      this.processFiles(_function);
      _xblockexpression = IterableExtensions.<Integer>head(((Iterable<Integer>)Conversions.doWrapArray(counter)));
    }
    return (_xblockexpression).intValue();
  }
  
  public boolean hasResourceDescription(final URI uri) {
    throw new Error("Unresolved compilation problems:"
      + "\n!= cannot be resolved");
  }
  
  public void setScope(final /* GlobalSearchScope */Object resolveScope) {
    super.setScope(resolveScope);
  }
}
