package org.eclipse.xtext.xtext.ui.wizard.project;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.ui.util.IProjectFactoryContributor;

/**
 * Default implemetation of org.eclipse.xtext.ui.util.IProjectFactoryContributor
 * @author Dennis Huebner - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("all")
public class DefaultProjectFactoryContributor implements IProjectFactoryContributor {
  public void contributeFiles(final IProject project, final IProjectFactoryContributor.IFileCreator fileWriter) {
  }
  
  protected IFile writeToFile(final CharSequence chrSeq, final IProjectFactoryContributor.IFileCreator fCreator, final String fileName) {
    return fCreator.writeToFile(chrSeq, fileName);
  }
}
