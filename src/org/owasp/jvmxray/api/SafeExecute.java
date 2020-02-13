package org.owasp.jvmxray.api;

/**
 * This class is a wrapper for executing operations with the context of the
 * NullSecurityManager.  It's purpose is to prevent stack overflows that may
 * occur when code executing within the context of the NullSecurityManager 
 * results in additional calls to the security manager.  
 * 
 * @author Milton Smith
 *
 */
public class SafeExecute {

//	private boolean bSupressRecursion = false;
	
	public SafeExecute() {
	}
	
	public synchronized void execute(NullSecurityManager sm) {
		
		try {
//			if( bSupressRecursion ) return;
//			bSupressRecursion = true;
			sm.setEnabled(false);
			work();
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
//			bSupressRecursion = false;
			sm.setEnabled(true);
		}
	}
	
	public void work() {
	}

}
