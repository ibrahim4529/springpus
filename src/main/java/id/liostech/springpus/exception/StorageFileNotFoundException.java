package id.liostech.springpus.exception;

import java.net.MalformedURLException;

public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message, MalformedURLException e) {
        super(message, e);
    }

    public StorageFileNotFoundException(String message) {
        super(message);
    }
}
