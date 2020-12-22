package org.larnak.Tempsdor.exception;

public class ElementNotFoundException extends  Exception{

    private final int id;
    private final Class<?> clazz;

    public ElementNotFoundException(int id, Class<?> clazz) {
        super("Element with id " + id + " from " + clazz.getSimpleName() + " not found");
        this.id = id;
        this.clazz = clazz;
    }
}
