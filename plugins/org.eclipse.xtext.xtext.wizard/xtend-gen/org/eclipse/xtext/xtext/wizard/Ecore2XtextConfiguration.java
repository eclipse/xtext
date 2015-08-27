package org.eclipse.xtext.xtext.wizard;

import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xtext.wizard.EPackageInfo;

@Accessors
@SuppressWarnings("all")
public class Ecore2XtextConfiguration {
  private final Set<EPackageInfo> ePackageInfos = CollectionLiterals.<EPackageInfo>newHashSet();
  
  private EPackageInfo defaultEPackageInfo;
  
  private EClass rootElementClass;
  
  @Pure
  public Set<EPackageInfo> getEPackageInfos() {
    return this.ePackageInfos;
  }
  
  @Pure
  public EPackageInfo getDefaultEPackageInfo() {
    return this.defaultEPackageInfo;
  }
  
  public void setDefaultEPackageInfo(final EPackageInfo defaultEPackageInfo) {
    this.defaultEPackageInfo = defaultEPackageInfo;
  }
  
  @Pure
  public EClass getRootElementClass() {
    return this.rootElementClass;
  }
  
  public void setRootElementClass(final EClass rootElementClass) {
    this.rootElementClass = rootElementClass;
  }
}
