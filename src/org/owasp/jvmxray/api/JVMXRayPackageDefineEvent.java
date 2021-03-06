package org.owasp.jvmxray.api;

import org.owasp.jvmxray.api.NullSecurityManager.Callstack;
import org.owasp.jvmxray.api.NullSecurityManager.Events;

public class JVMXRayPackageDefineEvent extends JVMXRayBaseEvent {

	private static final String format = "pkg=%s";
	
	public JVMXRayPackageDefineEvent(StackTraceElement[] stacktrace, Callstack callstackopt, Object[] parameters) {
		super(Events.PACKAGE_DEFINE, stacktrace, callstackopt, parameters);
	}

	public String getPackageName() {
		Object[] obj = getParameters();
		String name = (String)obj[0];
		return name;
	}
	
	public String getStringFormat() {
		return format;
	}
	
	public Object[] getStringArgs() {
		return new Object[] {getPackageName()};
	}


}
