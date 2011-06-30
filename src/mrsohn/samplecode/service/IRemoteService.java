package mrsohn.samplecode.service;

public interface IRemoteService {
	
	String Stub = null;
	void registerCallback(IRemoteService cb);
	void unregisterCallback(IRemoteService cb);
	String onService(int msg);
}
