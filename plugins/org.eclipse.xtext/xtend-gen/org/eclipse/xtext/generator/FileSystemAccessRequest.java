package org.eclipse.xtext.generator;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemAccessRequest {
  public IResourceDescription.Delta delta;
  
  public Procedure0 procedure;
  
  public Function0<?> function;
  
  public volatile boolean completed;
  
  public volatile Throwable throwable;
  
  public volatile Object result;
}
