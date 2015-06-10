package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemAccessRequest implements Runnable {
  private final URI uri;
  
  private final Runnable runMe;
  
  /**
   * @since 2.9
   */
  @FinalFieldsConstructor
  public FileSystemAccessRequest(final URI uri, final Runnable runMe) {
    super();
    this.uri = uri;
    this.runMe = runMe;
  }
  
  /**
   * @since 2.8
   */
  @Pure
  public URI getUri() {
    return this.uri;
  }
  
  /**
   * @since 2.9
   */
  @Override
  public void run() {
    this.runMe.run();
  }
}
