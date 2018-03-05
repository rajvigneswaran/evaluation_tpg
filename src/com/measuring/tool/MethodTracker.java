/**
 * 
 */
package com.measuring.tool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Rajvigneswaran
 */
public class MethodTracker {
	private void methodA() {
		System.out.println("Method A.");
	}

	private boolean methodB(boolean flag) {
		return flag;
	}

	private String methodC() {
		return "Method C.";
	}

	/**
	 * @param args
	 * @throws InvocationTargetException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException {

		System.out.println(methodInvoke("methodA", null));
		System.out.println(methodInvoke("methodB", new Class[] { boolean.class }));
		System.out.println(methodInvoke("methodC", null));
	}

	@SuppressWarnings("unused")
	public static long methodInvoke(final String methodName, final Class<?>[] arguments)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {

		Class<?> mtClass = Class.forName(MethodTracker.class.getCanonicalName());
		Object object = mtClass.newInstance();
		long start = System.currentTimeMillis();
		Method method = MethodTracker.class.getDeclaredMethod(methodName, arguments);
		method.invoke(object, arguments); // pass arguments
		return System.currentTimeMillis() - start;
	}

}
