package org.eclipse.xtext.idea.resource;

import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.psi.stubindex.ExportedObjectQualifiedNameIndex;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public abstract class AbstractScopeBasedSelectable extends AbstractCompoundSelectable {
  @Accessors({ AccessorType.PROTECTED_GETTER, AccessorType.PROTECTED_SETTER })
  private /* GlobalSearchScope */Object scope;
  
  @Inject
  private ExportedObjectQualifiedNameIndex exportedObjectQualifiedNameIndex;
  
  protected Iterable<? extends ISelectable> getSelectables() {
    return this.getResourceDescriptions();
  }
  
  public IResourceDescription getResourceDescription(final URI uri) {
    throw new Error("Unresolved compilation problems:"
      + "\n!= cannot be resolved");
  }
  
  public ArrayList<IResourceDescription> getResourceDescriptions() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PsiManager is undefined for the type AbstractScopeBasedSelectable"
      + "\nType mismatch: cannot convert implicit first argument from AbstractScopeBasedSelectable to URI"
      + "\ngetInstance cannot be resolved"
      + "\nproject cannot be resolved");
  }
  
  public boolean isEmpty() {
    Boolean _xblockexpression = null;
    {
      final boolean[] emptinessCheck = { true };
      final Function1<Collection<VirtualFile>, Boolean> _function = new Function1<Collection<VirtualFile>, Boolean>() {
        public Boolean apply(final Collection<VirtualFile> files) {
          boolean _xblockexpression = false;
          {
            boolean _isEmpty = files.isEmpty();
            if (_isEmpty) {
              return true;
            }
            emptinessCheck[0] = false;
            _xblockexpression = false;
          }
          return Boolean.valueOf(_xblockexpression);
        }
      };
      this.processFiles(_function);
      _xblockexpression = IterableExtensions.<Boolean>head(((Iterable<Boolean>)Conversions.doWrapArray(emptinessCheck)));
    }
    return (_xblockexpression).booleanValue();
  }
  
  public Iterable<IEObjectDescription> getExportedObjects(final EClass type, final QualifiedName qualifiedName, final boolean ignoreCase) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method get is undefined for the type AbstractScopeBasedSelectable"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nproject cannot be resolved"
      + "\nfold cannot be resolved");
  }
  
  protected Object findFile(final URI uri) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field FilenameIndex is undefined for the type AbstractScopeBasedSelectable"
      + "\ngetFilesByName cannot be resolved"
      + "\nproject cannot be resolved"
      + "\nfilter cannot be resolved"
      + "\nfindFirst cannot be resolved");
  }
  
  protected void processFiles(final /* Function1<? super Collection<VirtualFile>, ? extends Boolean> */Object acceptor) {
    throw new Error("Unresolved compilation problems:"
      + "\nFileType cannot be resolved to a type."
      + "\nThe method or field FileTypeIndex is undefined for the type AbstractScopeBasedSelectable"
      + "\ngetFiles cannot be resolved");
  }
  
  protected Object getXtextLanguageFilesTypes() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field FileBasedIndex is undefined for the type AbstractScopeBasedSelectable"
      + "\nThe method or field FileTypeIndex is undefined for the type AbstractScopeBasedSelectable"
      + "\ninstance cannot be resolved"
      + "\ngetAllKeys cannot be resolved"
      + "\nNAME cannot be resolved"
      + "\nproject cannot be resolved"
      + "\nfilter cannot be resolved");
  }
  
  protected boolean isXtextLanguage(final /* FileType */Object fileType) {
    throw new Error("Unresolved compilation problems:"
      + "\nLanguageFileType cannot be resolved to a type."
      + "\nlanguage cannot be resolved");
  }
  
  @Pure
  protected GlobalSearchScope getScope() {
    return this.scope;
  }
  
  protected void setScope(final GlobalSearchScope scope) {
    this.scope = scope;
  }
}
