package org.eclipse.xtext.ui.core.editor.info;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.ui.core.util.ResourceUtil;

public class ResourceWorkingCopyFileEditorInput extends FileEditorInput {

	private Resource resource;

	public ResourceWorkingCopyFileEditorInput(Resource resource) throws IllegalArgumentException, IOException {
		super(createFileProxy(resource));
		this.resource = resource;
	}

	public Resource getResource() {
		return resource;
	}

	static IFile createFileProxy(final Resource resource) throws IllegalArgumentException, IOException {
		return (IFile) Proxy.newProxyInstance(ResourceWorkingCopyFileEditorInput.class.getClassLoader(), new Class<?>[] { IFile.class },
				new ResourceWorkingCopyFileInvocationHandler(resource));
	}
	
	static class ResourceWorkingCopyFileInvocationHandler implements InvocationHandler {

		private byte[] buffer;
		private IFile file;
//		private String debug;

		public ResourceWorkingCopyFileInvocationHandler(Resource resource) throws IOException {
			file = ResourceUtil.getFile(resource);
			boolean isModified = resource.isModified();
			ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
			OutputStream outputStream = new BufferedOutputStream(outputBuffer);
			try {
				resource.save(outputStream, null);
			} finally {
				outputStream.close();
				resource.setModified(isModified);
			}
			buffer = outputBuffer.toByteArray();
//			debug = new String(buffer);
		}

		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//			System.out.println(method.getName());
			if(method.getName().equals("getContents")) {
				return new ByteArrayInputStream(buffer);
			}
			if(method.getName().equals("equals")) {
				return proxy == args[0] || file == args[0] || file.equals(args[0]);
			}
			if(method.getName().equals("isConflicting")) {
				return proxy == args[0] || file == args[0];
			}
			return method.invoke(file, args);
		}
		
	}
}
