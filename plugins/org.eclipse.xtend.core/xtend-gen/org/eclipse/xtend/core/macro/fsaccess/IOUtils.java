package org.eclipse.xtend.core.macro.fsaccess;

import com.google.common.io.Closeables;
import java.io.Closeable;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class IOUtils {
  public static <T extends Object, C extends Closeable> T tryWith(final Function0<? extends C> provider, final Function1<? super C,? extends T> consumer) {
    C closeable = ((C) null);
    try {
      C _apply = provider.apply();
      closeable = _apply;
      return consumer.apply(closeable);
    } finally {
      Closeables.closeQuietly(closeable);
    }
  }
  
  public static <C extends Closeable> void tryWith(final Function0<? extends C> provider, final Procedure1<? super C> consumer) {
    C closeable = ((C) null);
    try {
      C _apply = provider.apply();
      closeable = _apply;
      consumer.apply(closeable);
    } finally {
      Closeables.closeQuietly(closeable);
    }
  }
}
