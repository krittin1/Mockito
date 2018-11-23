package csku.mockitodemo.atm;

import java.util.Iterator;

public interface IDataService<E> {
    Iterator<E> getAllObjects();
}
