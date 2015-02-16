package org.eclipse.xtext.generator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Anton Kosyakov
 * @since 2.7
 */
@SuppressWarnings("all")
public class FileSystemAccessRequest {
  private final URI uri;
  
  private final Procedure0 procedure;
  
  /**
   * @since 2.8
   */
  @FinalFieldsConstructor
  public FileSystemAccessRequest(final URI uri, final Procedure0 procedure) {
    super();
    this.uri = uri;
    this.procedure = procedure;
  }
  
  /**
   * @since 2.8
   */
  @Pure
  public URI getUri() {
    return this.uri;
  }
  
  /**
   * @since 2.8
   */
  @Pure
  public Procedure0 getProcedure() {
    return this.procedure;
  }
}
