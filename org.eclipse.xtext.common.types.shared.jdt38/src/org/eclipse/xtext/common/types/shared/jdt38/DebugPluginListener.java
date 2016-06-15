package org.eclipse.xtext.common.types.shared.jdt38;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.jdt.debug.core.IJavaStackFrame;
import org.eclipse.jdt.debug.core.IJavaThread;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;

@Singleton
public class DebugPluginListener implements IDebugEventSetListener {

	private static Logger log = Logger.getLogger(DebugPluginListener.class);

	public DebugPluginListener() {
		DebugPlugin.getDefault().addDebugEventListener(this);
	}

	private IJavaThread lastThread;

	private IStackFrame lastFrame;

	public void handleDebugEvents(DebugEvent[] events) {
		for (DebugEvent event : events) {
			Object source = event.getSource();
			if (source instanceof IJavaThread)
				synchronized (this) {
					lastThread = (IJavaThread) source;
				}
			else if (source instanceof IStackFrame)
				synchronized (this) {
					lastFrame = (IStackFrame) source;
				}
			else if (source instanceof IDebugTarget)
				synchronized (this) {
					if (event.getKind() == DebugEvent.TERMINATE) {
						if (lastThread != null && lastThread.getDebugTarget() == source)
							lastThread = null;
						if (lastFrame != null && lastFrame.getDebugTarget() == source)
							lastFrame = null;
					}
				}
		}
	}

	public String findXtextSourceFileNameForClassFile(String simpleFileName) {
		if (!simpleFileName.endsWith(".class"))
			return null;
		String typename = simpleFileName.substring(0, simpleFileName.length() - ".class".length());
		synchronized (this) {
			try {
				List<IStackFrame> frames = Lists.newArrayList();
				if (lastFrame != null)
					frames.add(lastFrame);
				if (lastThread != null)
					frames.addAll(Lists.newArrayList(lastThread.getStackFrames()));
				for (IStackFrame frame : frames)
					if (frame instanceof IJavaStackFrame) {
						IJavaStackFrame jsf = (IJavaStackFrame) frame;
						String simpleName = Strings.lastToken(jsf.getDeclaringTypeName(), ".");
						if (simpleName.equals(typename))
							return jsf.getSourceName();
					}
			} catch (DebugException e) {
				log.error(e.getMessage(), e);
			}
			return null;
		}

	}

}
