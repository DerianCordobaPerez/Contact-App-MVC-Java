package Interfaces;

import Models.User;

public interface IDataModel<T> {
    /**
     * @param modelReference
     * @return
     */
    boolean recordModelData(T modelReference);

    /**
     * @param user
     * @param modelReference
     * @return
     */
    default boolean recordModelData(User user, T modelReference) { return false; }

    /**
     * @param modelReference
     * @return
     */
    boolean updateModelData(T modelReference);

    /**
     * @param modelReference
     * @return
     */
    boolean deleteModelData(T modelReference);

    /**
     * @param modelreference
     * @return
     */
    T getModelData(T modelreference);

    /**
     * @return
     */
    int getTotalClass();
}
